package com.example.email_config.service;

import com.example.email_config.model.EmailConfig;

public interface IEmailConfigService {
    EmailConfig showEmailConfig();
    void updateEmailConfig(EmailConfig newEmailConfig);
}
