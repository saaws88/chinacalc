package org.chinacalcweb.webgui.service.util;

public interface EmailService {

  void sendTemporaryPassword(String to, String password);

}