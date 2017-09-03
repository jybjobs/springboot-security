package com.yihecloud.controller;

import com.yihecloud.entity.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by jyb on 17-9-3.
 */

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String  index(Model model){
        Msg msg = new Msg("测试","测试内容","info");
        model.addAttribute("msg", msg);
        return "home";
    }

}
