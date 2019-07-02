package com.master.controller;

import com.master.domain.SysMeun;
import com.master.domain.SysRole;
import com.master.domain.SysUser;
import com.master.service.SysMeunService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.management.relation.Role;
import java.util.HashSet;
import java.util.Set;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Maxinrui
 * \* Date: 2019/6/12
 * \* Time: 17:05
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private SysMeunService sysMeunService;

    @RequestMapping("/")
    public String showIndex(Model model) {
        model.addAttribute("vo",this.sysMeunService.getMeuns());
        return "index";
    }

    @RequestMapping("login")
    public String showHome() {
        return "login";
    }

    @RequestMapping("blank")
    public String showBlank() {
        return "blank";
    }
    @RequestMapping("welcome")
    public String showWelcome() {
        return "welcome";
    }
}