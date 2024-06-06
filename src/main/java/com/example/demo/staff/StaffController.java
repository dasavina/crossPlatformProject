package com.example.demo.staff;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class StaffController {

    @GetMapping
    public String projects(Model model) {
        return "staff/staff";
    }
}