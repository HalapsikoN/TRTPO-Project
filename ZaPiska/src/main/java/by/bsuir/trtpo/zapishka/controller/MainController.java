package by.bsuir.trtpo.zapishka.controller;

import by.bsuir.trtpo.zapishka.bean.Note;
import by.bsuir.trtpo.zapishka.bean.User;
import by.bsuir.trtpo.zapishka.dao.UserDAO;
import by.bsuir.trtpo.zapishka.service.NoteService;
import by.bsuir.trtpo.zapishka.service.exception.AlreadyHadSuchNoteException;
import by.bsuir.trtpo.zapishka.service.exception.IllegalDataInputException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@Controller
public class MainController {

    private final static Logger logger= LogManager.getLogger(MainController.class);

    @Autowired
    private NoteService noteService;

    @Autowired
    private UserDAO repo;

    @GetMapping("/main")
    public String main(@AuthenticationPrincipal User user, Map<String, Object> model){
        List<Note> notes= null;
        try {
            notes = noteService.getAllNotesByUserID(user.getId());
        } catch (IllegalDataInputException e) {
            logger.error(e.getMessage());
        }

        model.put("notes", notes);

        return "main";
    }
}
