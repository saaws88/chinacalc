package org.chinacalcweb.webgui.service.util;

public interface EmailService {

  public void sendTemporaryPassword(String to, String password);

}