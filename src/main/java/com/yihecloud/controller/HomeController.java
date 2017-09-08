package com.yihecloud.controller;

import com.yihecloud.entity.Msg;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by jyb on 17-9-3.
 */

@Controller
public class HomeController {

    @ApiOperation(value = "进入home首页",notes ="" )
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String  index(Model model){
        Msg msg = new Msg("测试","测试内容","info");
        model.addAttribute("msg", msg);
        return "home";
    }

}
