package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String login( HttpSession session, String name,String password){
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(name,password));
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "redirect:/login.jsp";
        }
        return "redirect:/person/findAll";
    }
    @RequestMapping("/regis")
    public String regis(User user,String code,HttpSession session){
        String code1 = (String) session.getAttribute("Code");
        String s = UUID.randomUUID().toString();
        Md5Hash md5Hash=new Md5Hash(user.getPassword(),s);
        if (code.equals(code1)){
            user.setSalt(s);
            user.setStatus("y");
            user.setRegistertime(new Date());
            userService.regis(user);
            return "redirect:/login.jsp";
        }else {
            return "redirect:/login.jsp";
        }
    }

    @RequestMapping("/logout")
    public String logout(){
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.logout();
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/login.jsp";
        }
        return "redirect:/login.jsp";
    }
}
