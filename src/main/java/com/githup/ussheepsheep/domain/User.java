package com.githup.ussheepsheep.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
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

    @JsonIgnore
    @ApiModelProperty("创建时间")
    private Long createTime;
}
