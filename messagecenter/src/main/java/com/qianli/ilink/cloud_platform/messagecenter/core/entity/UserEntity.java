//package com.qianli.ilink.cloud_platform.messagecenter.core.entity;
//
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//import lombok.Data;
//import org.hibernate.validator.constraints.Length;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.validation.constraints.NotBlank;
//
//@Data
//@ApiModel
//@Entity(name = "user")
//public class UserEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//
//    @ApiModelProperty(required = true,name = "用户名",value = "username")
//    @NotBlank(message = "username 不能为空")
//    @Length(max = 1,message = "username length not > 1")
//    private String username;
//    @ApiModelProperty(required = true,name = "密码",value = "password")
//    @NotBlank(message = "password 不能为空")
//    private String password;
//
//
//}
