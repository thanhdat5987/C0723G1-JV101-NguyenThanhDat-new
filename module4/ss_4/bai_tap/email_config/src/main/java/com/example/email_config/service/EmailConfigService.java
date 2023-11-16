package com.example.email_config.service;

import com.example.email_config.model.EmailConfig;
import com.example.email_config.repository.IEmailConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailConfigService implements IEmailConfigService{
    @Autowired
   private IEmailConfigRepository emailConfigRepository;
    @Override
    public EmailConfig showEmailConfig() {
        return emailConfigRepository.showEmailConfig();
    }

    @Override
    public void updateEmailConfig(EmailConfig newEmailConfig) {
        emailConfigRepository.updateEmailConfig(newEmailConfig);
    }



}
