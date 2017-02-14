package com.githup.ussheepsheep.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by daren on 2016/9/12.
 */

@Data
@Table
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String email;

    @Column
    private String password;
}
