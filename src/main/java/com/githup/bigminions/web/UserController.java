package com.githup.bigminions.web;

import com.githup.bigminions.domain.form.UserForm;
import com.githup.bigminions.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        public ResponseEntity login (@RequestBody UserForm userForm){
            userService.login(userForm.getEmail(), userForm.getPassword());
            return ResponseEntity.ok().build();
        }

        @PostMapping(value = "/register")
        public ResponseEntity register (@RequestBody UserForm userForm){
            userService.register(userForm.getEmail(), userForm.getPassword());
            return ResponseEntity.ok().build();
        }
    }
