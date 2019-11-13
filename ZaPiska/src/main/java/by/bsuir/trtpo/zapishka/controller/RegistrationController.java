package by.bsuir.trtpo.zapishka.controller;

import by.bsuir.trtpo.zapishka.bean.Role;
import by.bsuir.trtpo.zapishka.bean.User;
import by.bsuir.trtpo.zapishka.dao.UserDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {

    @Autowired
    private UserDAO userRepo;

    @GetMapping("/registration")
    public String registration(){
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map <String, Object> model){
        User userFromDb=userRepo.findByUsername(user.getUsername());

        System.out.println(user);

        if(userFromDb != null){
            model.put("message", "User exists!");
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));

        System.out.println(user);
        userRepo.save(user);

        return "redirect:/";
    }
}
