package com.example.email_config.repository;

import com.example.email_config.model.EmailConfig;
import org.springframework.stereotype.Repository;

@Repository
public class EmailConfigRepository implements IEmailConfigRepository {
    private static EmailConfig emailConfig = new EmailConfig("English", 25, true, "Thor");

    @Override
    public EmailConfig showEmailConfig() {
        return emailConfig;
    }

    @Override
    public void updateEmailConfig(EmailConfig newEmailConfig) {
        emailConfig.setLanguages(newEmailConfig.getLanguages());
        emailConfig.setPageSize(newEmailConfig.getPageSize());
        emailConfig.setSpamsFilter(newEmailConfig.getSpamsFilter());
        emailConfig.setSignature(newEmailConfig.getSignature());
    }
}
