package org.coretechies.logic;

import java.util.Random;

import static org.coretechies.ui.PasswordGeneratorUi.*;

public class GeneratePassword {


    public static String noticeCaseAndGenerate() {
        int value = textCount.getValue();
        boolean n1 = capitolLatter.isSelected();
        boolean n2 = number.isSelected();
        boolean n3 = specialChar.isSelected();
         if (n1 && n2 && n3) {
            String CHAR = "ABCDEFGHIJKLMNOPQRSTUVUXYZ1234567890abcdefghijklm-][|;'.:/?~!@£$%^&*()_{}<>nopqrstuvwxyz1234567890-][|;'.:/?~!@£$%^&*()_{}<>";
            generatePassword(value, CHAR);
            return generatePassword(value, CHAR);
        } else if (!n1 && !n2 && !n3) {
            String CHAR = "abcdefghijklmnopqrstuvwxyz";
            return generatePassword(value, CHAR);
        } else if (!n1 && !n2) {
            String CHAR = "abcdefghijklmnopqrstuvwxyz-][|;'.:/?~!@£$%^&*()_{}<>";
            return generatePassword(value, CHAR);
        } else if (!n1 && !n3) {
            String CHAR = "1234567890abcdefghijklmn1234567890opqrstuv1234567890wxyz12345678901234567890";
            return generatePassword(value, CHAR);
        } else if (!n1) {
            String CHAR = "abcdefghijklmnopqrstuvwxyz1234567890-][|;'.:/?~!@£$%^&*()_{}<>";
            return generatePassword(value, CHAR);
        } else if (!n2 && !n3) {
            String CHAR = "ABCDEFGHIJKLMNOPQRSTUVUXYZabcdefghijklmnopqrstuvwxyz";
            return generatePassword(value, CHAR);
        } else if (!n2) {
            String CHAR = "ABCDEFGHIJKLMNOPQRSTUVUXYZabcdefghijklmnopqrstuvwxyz-][|;'.:/?~!@£$%^&*()_{}<>";
            return generatePassword(value, CHAR);
        } else {
            String CHAR = "ABCDEFGHIJKLMN1234567890OPQRSTUVUXYZ1234567890abcdefghijklmnopqrstuvwxyz1234567890";
            return generatePassword(value, CHAR);
        }

    }
    public static String generatePassword(int length, String CHAR) {
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHAR.length());
            password.append(CHAR.charAt(index));

        }
        return password.toString();
    }
}