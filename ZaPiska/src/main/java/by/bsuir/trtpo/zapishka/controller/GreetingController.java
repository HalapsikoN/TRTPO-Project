package by.bsuir.trtpo.zapishka.controller;

import by.bsuir.trtpo.zapishka.dao.UserDAO;
import by.bsuir.trtpo.zapishka.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private UserDAO repo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }
}
