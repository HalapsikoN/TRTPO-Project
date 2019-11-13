package by.bsuir.trtpo.zapishka.controller;

import by.bsuir.trtpo.zapishka.bean.Note;
import by.bsuir.trtpo.zapishka.bean.User;
import by.bsuir.trtpo.zapishka.service.NoteService;
import by.bsuir.trtpo.zapishka.service.exception.IllegalDataInputException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/delete")
public class DeleteNoteController {

    private static final Logger logger= LogManager.getLogger(DeleteNoteController.class);

    @Autowired
    private NoteService repository;

    @GetMapping("{note}")
    public String showDeletePage(@PathVariable Note note, @AuthenticationPrincipal User user,
                                 Map<String, Object> model){
        if(note!=null && note.getUserID().equals(user.getId())){
            model.put("note", note);
        }else {
            logger.warn("another user tried to access");
            return "redirect:/main";
        }
        return "deleteNote";
    }

    @PostMapping("{note}")
    public String deleteNote(@PathVariable Note note, @AuthenticationPrincipal User user,
                             Map<String, Object> model){
        if(note!=null && note.getUserID().equals(user.getId())){
            try {
                repository.deleteNote(note.getHeader());
            } catch (IllegalDataInputException e) {
                logger.error(e.getMessage());
            }
        }else{
            logger.warn("another user tried to access");
        }
        return "redirect:/main";
    }

}
