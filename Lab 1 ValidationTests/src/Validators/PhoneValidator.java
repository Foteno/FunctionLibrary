package Validators;

public class Phone {
    String number;
    public Phone(String number) {
        this.number = number;
    }

    public boolean checkIfOnlyNumbers() {
        return false;
    }

    public boolean changePrefix() {
        return false;
    }

    public boolean checkForeignPrefix(String country) {
        return false;
    }
}
