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
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/edit")
public class EditorNoteController {

    private static final Logger logger = LogManager.getLogger(EditorNoteController.class);

    @Autowired
    private NoteService repository;


    @GetMapping("{note}")
    public String editNote(@PathVariable Note note, @AuthenticationPrincipal User user, Map<String, Object> model) {
        model.put("user", user);
        if (note != null && note.getUserID().equals(user.getId())) {
            model.put("note", note);
        } else {
            logger.warn("another user tried to access");
            return "redirect:/main";
        }
        return "editorNote";
    }

    @PostMapping("{note}")
    public String editSaveNote(@PathVariable Note note, @AuthenticationPrincipal User user,
                               @RequestParam String header, @RequestParam String data,
                               Map<String, Object> model) {
        model.put("user", user);
        String message = null;
        if (note != null && note.getUserID().equals(user.getId())) {
            try {
                if (repository.getNote(header, user.getId()) == null || note.getId().equals(repository.getNote(header, user.getId()).getId())) {
                    note.setData(data);
                    note.setHeader(header);
                    repository.updateNote(note);
                } else {
                    logger.warn("redirect user");
                    model.put("message", String.valueOf(repository.getNote(header, user.getId()).getId()));
                    return "editorNote";
                }
            } catch (IllegalDataInputException e) {
                logger.error(e.getMessage());
            }
        } else {
            logger.warn("another user tried to access");
        }
        return "redirect:/main";
    }
}
