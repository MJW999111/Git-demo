package com.gg.controller;

import com.gg.bean.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.io.StringReader;

@Log4j2
@Controller
public class IndexController {


    //登录页
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {

        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {
        if (StringUtils.hasLength(user.getUsername()) && "123".equals(user.getPassword())) {
            //把登录成功的用户放进session域
            session.setAttribute("loginUser", user);
            /*登陆成功， 重定向到main页面  防止表单重复提交*/
            return "redirect:/main.html";
        } else {

            model.addAttribute("msg", "账号密码错误!");
            //回到登录页
            return "login";
        }

    }

    //    去main页面
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {

        log.info("当前方法是:{}","mainPage");

        //判断是否登录    拦截器，  过滤器.
      /*  Object loginUser = session.getAttribute("loginUser");

        if (loginUser != null) {
            return "main";
        } else {
            //回到登录页
            model.addAttribute("msg", "请登录！");
            return "login";
        }*/



        return "main";
    }
}
