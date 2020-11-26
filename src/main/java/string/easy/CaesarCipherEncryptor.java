package string.easy;

import org.junit.Assert;
import org.junit.Test;

public class CaesarCipherEncryptor {
    public static String caesarCypherEncryptor(String str, int key) {
        StringBuilder sb = new StringBuilder(str.length());
        int newKey = key % 26;

        for (char letter : str.toCharArray()) {
            int newLetterCode = newKey + (int) letter;
            if (newLetterCode > 122) {
                newLetterCode = 96 + newLetterCode % 122;
            }
            sb.append((char) newLetterCode);
        }

        return sb.toString();
    }

    public static String caesarCypherEncryptorV2(String str, int key) {
        char[] newLetters = new char[str.length()];
        int newKey = key % 26;

        for (int i = 0; i < str.length(); i++) {
            newLetters[i] = getNewLetter(str.charAt(i), newKey);
        }

        return new String(newLetters);
    }

    private static char getNewLetter(char letter, int key) {
        int newLetterCode = (int) letter + key;
        if (newLetterCode <= 122) {
            return (char) newLetterCode;
        } else {
            return (char) (96 + newLetterCode % 122);
        }
    }

    @Test
    public void verify() {
        Assert.assertEquals("zab", caesarCypherEncryptor("xyz", 2));
        Assert.assertEquals("abc", caesarCypherEncryptor("abc", 52));
        Assert.assertEquals("fgh", caesarCypherEncryptor("abc", 57));
    }
}
