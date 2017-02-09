package com.githup.ussheepsheep.web;

import com.githup.ussheepsheep.domain.User;
import com.githup.ussheepsheep.domain.form.LoginForm;
import com.githup.ussheepsheep.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by daren on 2016/9/12.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    static Map<Long, User> map = Collections.synchronizedMap(new HashMap<>());

    @Autowired
    private UserService userService;


    @ApiOperation(value = "获取用户列表", notes = "获取用户列表:")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        List<User> users = new ArrayList<>(map.values());
        return users;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id) {
        User user = map.get(id);
        return user;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user) {
        map.put(user.getId(), user);
        return "success";
    }

    @PostMapping(value = "/login")
    public String login(@RequestBody LoginForm loginForm) {
        userService.login(loginForm.getEmail(), loginForm.getPassword());
        return "success";
    }
}
