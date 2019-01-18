package com.githup.bigminions.repository;

import com.githup.bigminions.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by daren on 2017/2/14.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findFirstByEmail(String email);
}
