package com.example.email_config.controller;

import com.example.email_config.model.EmailConfig;
import com.example.email_config.service.IEmailConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailConfigController {
    @Autowired
    private IEmailConfigService emailConfigService;

    @GetMapping("/setting")
    public String showSetting(Model model) {
        EmailConfig emailConfig = emailConfigService.showEmailConfig();
        model.addAttribute("languages", new String[]{"English", "Vietnamese", "Chines", "Korean"});
        model.addAttribute("pageSize", new int[]{25, 30, 35, 40});
        model.addAttribute("emailConfig", emailConfig);
        return "/setting";
    }

    @GetMapping("/details")
    public String showDetails() {
        return "/details";
    }

    //C1: Lưu và hiển thị luôn trên trang setting:
    @PostMapping("/saveSetting")
    public String saveSetting(@ModelAttribute EmailConfig emailConfig) {
        emailConfigService.updateEmailConfig(emailConfig);
        return "redirect:/setting";
    }

//C2: Chuyển sang trang details:
//    @PostMapping("/saveSetting")
//    public String saveSetting(@ModelAttribute EmailConfig emailConfig, RedirectAttributes attributes ) {
//        emailConfigService.updateEmailConfig(emailConfig);
//        attributes.addFlashAttribute("emailConfig",emailConfig);
//        return "redirect:/details";
//    }
}
