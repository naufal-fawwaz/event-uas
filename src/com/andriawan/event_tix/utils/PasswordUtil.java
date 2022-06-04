package com.andriawan.event_tix.utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordUtil {
    
    private static final Random random = new SecureRandom();
    private static final String characters = "secure_characters";
    private static final int iterations = 10000;
    private static final int keyLength = 256;

    private static byte[] hash(char[] password, byte[] salt) {

        PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
        Arrays.fill(password, Character.MIN_VALUE);

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException exception) {
            throw new AssertionError("Error hashing password " + exception.getMessage());
        } finally {
            spec.clearPassword();
        }
    }

    public static String getSaltValue(int length) {
        String finalSalt = "";

        for (int i = 0; i < length; i++) {
            finalSalt += characters.charAt(random.nextInt(characters.length()));
        }

        return finalSalt;
    }

    public static String generateSecurePassword(String password, String salt) {
        String finalVal = "";

        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());

        finalVal += Base64.getEncoder().encodeToString(securePassword);

        return finalVal;
    }

    public static boolean verifyUserPass(String password, String securedPassword, String salt) {
        boolean isValid = false;

        String generatedSecurePassword = generateSecurePassword(password, salt);

        isValid = generatedSecurePassword.equalsIgnoreCase(securedPassword);

        return isValid;
    }
}
