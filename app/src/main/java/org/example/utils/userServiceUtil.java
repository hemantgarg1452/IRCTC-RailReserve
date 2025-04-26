package org.example.utils;

import org.mindrot.jbcrypt.BCrypt;

public class userServiceUtil {
    public static String hashPassword(String plainPassword){
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

    public static Boolean checkPassword(String plainPassword, String hashPassword){
        return BCrypt.checkpw(plainPassword, hashPassword);
    }
}
