package com.gg.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gg.bean.User;
import com.gg.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.List;

@Controller
public class tableController {

    @Autowired
    private UserService userService;

    //根据id删除
    @GetMapping("/user/delete/{id}")
    public String delete(@PathVariable("id") int id,
                         @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                         RedirectAttributes ra){

        userService.removeById(id);
        ra.addAttribute("pn",pn);

        return "redirect:/editable_table";
    }


    @GetMapping("/basic_table")
    public String basic_table() {
        return "table/basic_table";
    }

    @GetMapping("/dynamic_table")
    public String dynamic_table(Model model) {
       /* //表格内容的遍历
        List<User> users = Arrays.asList(
                new User(1,"zhangsan1", "123"),
                new User(2,"zhangsan2", "123"),
                new User(3,"zhangsan3", "123"),
                new User(4,"zhangsan4", "123"),
                new User(5,"zhangsan5", "123"),
                new User(6,"zhangsan6", "123"),
                new User(7,"zhangsan7", "123"));
        model.addAttribute("users",users);*/
        //从数据库查询出来得数据
        List<User> list = userService.list();
        model.addAttribute("users", list);

        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table() {

        return "table/responsive_table";
    }

    @GetMapping("/pricing_table")
    public String pricing_table() {

        return "table/pricing_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(Model model,
                                 @RequestParam(value = "pn", defaultValue = "1") Integer pn) {
        //从数据库查询出来得数据
        List<User> list = userService.list();
//        model.addAttribute("users", list);
        //分页查询数据   pn表示:当前页  2表示:每页有几条数据
        Page<User> userPage = new Page<>(pn, 3);
        //分页查询的结果
        Page<User> page = userService.page(userPage);

        model.addAttribute("page",page);

        //获取记录
        List<User> records = page.getRecords();
        //获取当前页
        long current = page.getCurrent();
        //总页数
        long pages = page.getPages();
        //总记录数
        long total = page.getTotal();


        return "table/editable_table";
    }


}
