package com.saaws88.chinacalc.infrastructure.util.emailsender;

public interface EmailService {

  void sendTemporaryPassword(String to, String password);

}