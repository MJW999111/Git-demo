package com.gg.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    //这是登录验证的字段
    //@TableField(exist = false)  表示这个属性在表中不存在
    @TableField(exist = false)
    private String username;
    @TableField(exist = false)
    private String password;


    //数据库字段
    private Integer id;
    private String name;
    private String gender;
    private String email;
    private String age;
}
