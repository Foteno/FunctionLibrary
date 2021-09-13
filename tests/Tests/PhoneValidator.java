package Tests;

import Validators.Phone;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PhoneValidator {
    Phone phone;
    @BeforeEach
    void setUp() {
        phone = new Phone("866680452");
    }

    @Test
    void otherSymbols_SpecialSymbolsNotPresent_True() {
        assertTrue(phone.checkIfOnlyNumbers());
    }
    @Test
    void changePrefix_HasNationalPrefix_True() {
        assertTrue(phone.changePrefix());
    }
    @Test
    void russianPrefix_HasRussianPrefix_True() {
        assertTrue(phone.checkForeignPrefix("RU"));
    }
}