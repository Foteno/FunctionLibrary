package Validators;

import java.util.Locale;

public class Password {
    String password;

    public Password(String password) {
        this.password = password;
    }

    public boolean compareLength(int minLength) {
        return false;
    }
    public boolean hasUppercase() {
        return false;
    }
    public boolean contains(char[] symbolArray) {
        return false;
    }
}
