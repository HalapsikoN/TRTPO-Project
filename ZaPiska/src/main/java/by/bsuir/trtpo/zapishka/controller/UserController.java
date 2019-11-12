package by.bsuir.trtpo.zapishka.controller;

import by.bsuir.trtpo.zapishka.bean.Role;
import by.bsuir.trtpo.zapishka.bean.User;
import by.bsuir.trtpo.zapishka.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserDAO userRepo;

    @GetMapping("")
    public String userList(Map<String, Object> model){
        model.put("users", userRepo.findAll());
        return "userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Map<String, Object> model){
        model.put("user", user);
        model.put("role", Role.values());
        return "userEdit";
    }

    @PostMapping
    public String userSave(@RequestParam String username, @RequestParam Map<String, String> form,@RequestParam("userId") User user){
        user.setUsername(username);

        user.getRoles().clear();

        Set<String> roles=Arrays.stream(Role.values()).map(Role::name).collect(Collectors.toSet());
        for(String key:form.keySet()){
            if(roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepo.save(user);
        return "redirect:/user";
    }
}
