package com.example.school.controllers;

import com.example.school.actions.UserAction;
import com.example.school.model.Role;
import com.example.school.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserAction userAction;

    @GetMapping
    public String userList(Model model) {
        Iterable<User> users = userAction.findAll();
        model.addAttribute("users", users);
        return "userList";
    }

      @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model){
        model.addAttribute("usr", user);
        model.addAttribute("roles", Role.values());
        return "userEdit";
    }

    @PostMapping
    public String userSave(
           // @RequestParam("id") User user,
           // @RequestParam String username,
           // @RequestParam Map<String, String> form
           @ModelAttribute("usr") User user,
           @ModelAttribute("roles") Model form
    ) {
//        Set<String> roles = Arrays.stream(Role.values())
//                .map(Role::name)
//                .collect(Collectors.toSet());
//        user.getRoles().clear();
//        for (String key : form.getAttribute(rl)) {
//            if (roles.contains(key)) {
//                user.getRoles().add(Role.valueOf(key));
//            }
//        }
        userAction.save(user);
        return "redirect:/user";
    }


}
