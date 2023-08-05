package org.chinacalcweb.webgui.util;


import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;

public class PassGen {
    
    public static String generatePassayPassword() {
        
        PasswordGenerator pg = new PasswordGenerator();
        
        CharacterData lowerCaseChars = EnglishCharacterData.LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars,3);

        CharacterData upperCaseChars = EnglishCharacterData.UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCaseChars,3);

        CharacterData digitChars = EnglishCharacterData.Digit;
        CharacterRule digitCharsRule = new CharacterRule(digitChars, 2);


    
        String password = pg.generatePassword(8, lowerCaseRule, upperCaseRule, digitCharsRule);
        return password;
    }

}