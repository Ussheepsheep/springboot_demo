package com.githup.ussheepsheep.web;

import com.githup.ussheepsheep.domain.form.UserForm;
import com.githup.ussheepsheep.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by daren on 2016/9/12.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public String login(@RequestBody UserForm userForm) {
        userService.login(userForm.getEmail(), userForm.getPassword());
        return "success";
    }

    @PostMapping(value = "/register")
    public String register(@RequestBody UserForm userForm) {
        userService.register(userForm.getEmail(), userForm.getPassword());
        return "success";
    }
}
