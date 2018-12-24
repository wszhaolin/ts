package com.baizhi.controller;

import com.baizhi.entity.Tranpation;
import com.baizhi.service.TranpationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tranpation")
public class TranpationController {
    @Autowired
    private TranpationService tranpationService;
    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Tranpation> all = tranpationService.findAll();
        model.addAttribute("all",all);
        return "tranpation";
    }
    @RequestMapping("/insert")
    public String insert(Tranpation tranpation){
        tranpationService.insert(tranpation);
        return null;
    }
}
