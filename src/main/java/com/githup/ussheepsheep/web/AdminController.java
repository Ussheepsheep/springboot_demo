package com.githup.ussheepsheep.web;

import com.githup.ussheepsheep.domain.User;
import com.githup.ussheepsheep.domain.form.UserForm;
import org.springframework.web.bind.annotation.*;

/**
 * Created by daren on 2017/1/23.
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public User login(@RequestBody UserForm userForm) {
        System.out.println(">>>>");
        return new User();
    }
}
