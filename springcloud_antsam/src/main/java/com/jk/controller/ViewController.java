package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("show")
    public String show(){
        return "show";
    }

    @RequestMapping("showdialog")
    public String showdialog(){
        return "showdialog";
    }
}
