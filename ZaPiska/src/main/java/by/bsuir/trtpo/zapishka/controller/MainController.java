package by.bsuir.trtpo.zapishka.controller;

import by.bsuir.trtpo.zapishka.bean.Note;
import by.bsuir.trtpo.zapishka.bean.User;
import by.bsuir.trtpo.zapishka.dao.UserDAO;
import by.bsuir.trtpo.zapishka.service.NoteService;
import by.bsuir.trtpo.zapishka.service.ServiceException;
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

    @Autowired
    private NoteService noteService;

    @Autowired
    private UserDAO repo;

    @GetMapping("/main")
    public String main(@AuthenticationPrincipal User user, Map<String, Object> model){
        List<Note> notes= null;
        try {
            notes = noteService.getAllNotesByUserID(user.getId());
        } catch (ServiceException e) {
            System.out.println(e.getMessage());;
        }

        System.out.println("everything is ok");

        model.put("notes", notes);

        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String username, @RequestParam String password, Map<String, Object> model ){

        Note note=new Note(user.getId(), username, password);

        try {
            noteService.addNote(note);
        } catch (ServiceException e) {
            System.out.println(e.getMessage());
        }

        List<Note> notes=noteService.getRepository().findAll();

        System.out.println("everything is ok");

        model.put("notes", notes);

        return "main";
    }
}
