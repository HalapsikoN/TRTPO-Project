package by.bsuir.trtpo.zapishka.controller;

import by.bsuir.trtpo.zapishka.bean.Note;
import by.bsuir.trtpo.zapishka.bean.User;
import by.bsuir.trtpo.zapishka.service.NoteService;
import by.bsuir.trtpo.zapishka.service.exception.AlreadyHadSuchNoteException;
import by.bsuir.trtpo.zapishka.service.exception.IllegalDataInputException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/add")
public class AddNoteController {

    private static final Logger logger= LogManager.getLogger(AddNoteController.class);

    @Autowired
    private NoteService repository;


    @GetMapping
    public String addNote(Map<String, Object> model){

        return "addNote";
    }

    @PostMapping
    public String saveAddedNote(@AuthenticationPrincipal User user, @RequestParam String header,
                               @RequestParam String data, Map<String, Object> model) {
        Note note=new Note(user.getId(), header, data);

        try {
            repository.addNote(note);
        } catch (IllegalDataInputException e) {
            logger.error(e.getMessage());
        } catch (AlreadyHadSuchNoteException e) {
            logger.warn(e.getMessage());
            return "addNote";
        }

        return "redirect:/main";
    }
}
