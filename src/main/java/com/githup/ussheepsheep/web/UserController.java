package com.githup.ussheepsheep.web;

import com.githup.ussheepsheep.domain.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * Created by daren on 2016/9/12.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    static Map<String, User> map = Collections.synchronizedMap(new HashMap<>());


    @ApiOperation(value = "获取用户列表")
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers(){
        List<User> users = new ArrayList<>(map.values());
        return users;
    }

    @ApiOperation(value = "获取指定id的用户信息")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        User user = map.get(id);
        return user;
    }

    @ApiOperation(value = "添加新用户")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Object addUser(@RequestBody @Valid User user){
        user.setId(System.currentTimeMillis());
        if(map.get(user.getEmail()) != null){
            return "该邮箱被使用";
        }
        map.put(user.getEmail(), user);
        return user;
    }
}
