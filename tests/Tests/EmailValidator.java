package Tests;

import Validators.Email;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidator {
    Email email;
    @BeforeEach
    void setUp() {
        email = new Email();
    }

    @Test
    void atSymbol_HasAtSymbol_True() {
        assertTrue(email.hasAtSymbol());
    }
    @Test
    void badSymbols_HasNotAllowedSymbols_False() {
        assertFalse(email.hasNotAllowedSymbols());
    }
    @Test
    void correctDomain_HasCorrectDomainAndTLD_True() {
        assertTrue(email.hasCorrectDomainAndTLD());
    }

}