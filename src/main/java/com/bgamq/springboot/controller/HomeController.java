package com.bgamq.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/system/user")
    public String userList(){
        return "user";
    }

    @GetMapping("/system/role")
    public String roleList(){
        return "role";
    }

    @GetMapping("/system/menu")
    public String menuList(){
        return "menu";
    }

    @GetMapping("/order")
    public String orderList(){
        return "order";
    }
}
