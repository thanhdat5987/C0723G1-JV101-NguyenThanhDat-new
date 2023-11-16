package com.example.email_config.repository;

import com.example.email_config.model.EmailConfig;

import java.util.List;

public interface IEmailConfigRepository {
    EmailConfig showEmailConfig();
    void updateEmailConfig(EmailConfig newEmailConfig);
}
