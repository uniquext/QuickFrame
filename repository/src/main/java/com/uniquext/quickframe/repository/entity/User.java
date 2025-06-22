package com.uniquext.quickframe.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author uniquext
 * @since 2025-06-22 17:24:51
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -78512449563487329L;
    /**
     * ID
     */
    private Integer id;
    /**
     * 账号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 性别
     */
    private Integer gender;

}

