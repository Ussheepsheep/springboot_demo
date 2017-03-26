package com.githup.ussheepsheep.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Email;

/**
 * Created by daren on 2016/9/12.
 */

@Data
@ApiModel("用户")
public class User{

    @NotNull
    @JsonIgnore
    @ApiModelProperty("id")
    private Long id;

    @Email
    @NotNull
    @ApiModelProperty("email")
    private String email;

    @ApiModelProperty("用户昵称")
    private String nickname;

    @NotNull
    @ApiModelProperty("用户密码")
    private String password;

    @JsonIgnore
    @ApiModelProperty("创建时间")
    private Long createTime;
}
