package utils;

import java.util.Random;

public class DataGenerator {
    public String generateRandomPhoneNumber(int length) {
        String chars = "0123456789";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return "62" + sb;
    }
}
