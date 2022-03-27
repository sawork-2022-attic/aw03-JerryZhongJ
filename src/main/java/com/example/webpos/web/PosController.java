package com.example.webpos.web;

import com.example.webpos.biz.PosService;
import com.example.webpos.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PosController {

    private PosService posService;

    @Autowired
    public void setPosService(PosService posService) {
        this.posService = posService;
    }

    @GetMapping("/")
    public String pos(Model model) {
        model.addAttribute("products", posService.products());
        model.addAttribute("cart", posService.getCart());
        model.addAttribute("total", posService.total());
        return "index";
    }

    @GetMapping("/cartModify")
    public String modify(Model model, @RequestParam String action, @RequestParam(required = false) String id, @RequestParam(required = false, defaultValue = "1") int amount){
        switch(action) {
            case "add":
                posService.add(id, amount);
                break;
            case "remove":
                posService.remove(id, amount);
                break;
            case "empty":
                posService.empty();
                break;
            default:
        }
        return "redirect:/";
    }


}
