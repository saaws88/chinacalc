package com.saaws88.chinacalc.infrastructure.controller.api.v1.message;

import com.saaws88.chinacalc.infrastructure.util.emailsender.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/message")
public class MessageControllerImplementation implements MessageController{
  
  EmailService emailService;

  @PostMapping("/test")
  public String sendEmail(@RequestParam String to) {

    emailService.sendTemporaryPassword(to, "Amogus");

    return "Message sent";

  }

}
