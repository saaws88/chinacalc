package com.saaws88.chinacalc.infrastructure.util.emailsender.implementation;

import com.saaws88.chinacalc.infrastructure.util.emailsender.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmailServiceImplementation implements EmailService {

  private JavaMailSender emailSender;

  private final String SENDER_EMAIL = "chinacalc-noreply@ne-kot.ru";

  @Override
  public void sendTemporaryPassword(String to, String password) {

    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(SENDER_EMAIL);
    message.setTo(to);
    message.setSubject("Регистрация на Chinacalc");
    message.setText("Ваш пароль для входа в Chinacalc " + password);
    emailSender.send(message);

  }

}
