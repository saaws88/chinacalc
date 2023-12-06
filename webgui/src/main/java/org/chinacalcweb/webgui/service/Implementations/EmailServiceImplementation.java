package org.chinacalcweb.webgui.service.Implementations;

import org.chinacalcweb.webgui.service.EmailService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class EmailServiceImplementation implements EmailService {

  private JavaMailSender emailSender;

  @Override
  public void sendTemporaryPassword(String to, String password) {

    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom("info@nekot.site");
    message.setTo(to);
    message.setSubject("Регистрация на Chinacalc");
    message.setText("Ваш пароль для входа в Chinacalc " + password);
    emailSender.send(message);

  } 
  
}
