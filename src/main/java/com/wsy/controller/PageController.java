package com.wsy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wsy
 * Date: 2020/9/29
 * Time: 19:23
 * Description: No Description
 */
@Controller
public class PageController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/hello")
    public String toHello() {
        return "hello";
    }

    @RequestMapping("/login")
    public String toLogin() {
        return "login";
    }


}
