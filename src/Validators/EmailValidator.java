package Validators;

public class Email {
    public boolean hasAtSymbol() {
        return false;
    }

    public boolean hasNotAllowedSymbols() {
        return true;
    }

    public boolean hasCorrectDomainAndTLD() {
        return false;
    }
}
