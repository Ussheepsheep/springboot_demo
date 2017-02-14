package com.githup.ussheepsheep.service;

import com.githup.ussheepsheep.domain.User;
import com.githup.ussheepsheep.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by daren on 2017/2/9.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public boolean login(String email, String password) {
        User user = userRepository.findFirstByEmail(email);
        if (user != null && password.equals(user.getPassword())) {
            stringRedisTemplate.opsForValue().set("email", email);
            return true;
        }
        return true;
    }

    @Transactional
    public boolean register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        return userRepository.save(user) != null;
    }
}
