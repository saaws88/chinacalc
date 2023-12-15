package org.chinacalcweb.webgui.controller.API_V1;

import org.chinacalcweb.webgui.service.util.EmailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/message")
public class MessageApiController {
  
  EmailService emailService;

  @PostMapping("/sendmessage")
  String sendEmail(@RequestParam String to) {

    emailService.sendTemporaryPassword(to, "Amogus");

    return "Message sent";

  }

}
