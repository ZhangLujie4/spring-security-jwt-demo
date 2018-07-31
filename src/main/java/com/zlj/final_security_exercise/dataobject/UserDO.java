package com.zlj.final_security_exercise.dataobject;

import lombok.Data;

import javax.persistence.*;

/**
 * @author tori
 * 2018/7/30 上午11:41
 */
@Entity
@Table(name = "user")
@Data
public class UserDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserRoleEnum role;

}
