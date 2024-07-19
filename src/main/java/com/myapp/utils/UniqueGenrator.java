package com.myapp.utils;

import java.util.Random;

public class UniqueGenrator {
	
	
	public static String getUniqueSting() {
		
		int length = 10;
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char c = characters.charAt(index);
            sb.append(c);
        }

        String randomString = sb.toString();
        return randomString;
		
	}

}
