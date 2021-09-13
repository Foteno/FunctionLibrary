package Tests;

import Validators.Password;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PasswordChecker {

    Password password;
    char[] symbolArray;
    @BeforeEach
    void setup() {
        password = new Password("Labas!");
        symbolArray = new char[]{'?', '!', '.', ',', '@'};
    }
    @Test
    void passwordLength_NotShorterThanX_True() {
        assertTrue(password.compareLength(5));
    }
    @Test
    void uppercasePresence_HasUppercaseLetters_True() {
        assertTrue(password.hasUppercase());
    }
    @Test
    void specialSymbols_HasSpecialSymbols_True() {
        assertTrue(password.contains(symbolArray));
    }
}
