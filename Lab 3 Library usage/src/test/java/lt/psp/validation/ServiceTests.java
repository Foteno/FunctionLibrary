package lt.psp.validation;

import lt.psp.validation.exceptions.InvalidEmailException;
import lt.psp.validation.exceptions.InvalidPasswordException;
import lt.psp.validation.exceptions.InvalidPhoneNumberException;
import lt.psp.validation.model.User;
import lt.psp.validation.respository.UserRepository;
import lt.psp.validation.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServiceTests {

    @Mock
    UserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    void testUploadPaskola() {
        User user = new User("Alan", "Walker", "862140881", "google@gmail.com", "Vilnius, Ukmerges g. 282", "Whales?123");
        user.setUserId(1);
        when(userRepository.save(Mockito.any(User.class)))
                .thenReturn(user);
        int userId = 0;
        try {
            userId = userService.uploadUser(user);
        } catch (InvalidEmailException | InvalidPasswordException | InvalidPhoneNumberException e) {
            System.out.println(e.getMessage());
            fail();
        }
        verify(userRepository).save(user);
        assertEquals(1, userId);
    }

    @Test
    void testGetAll() {
        List<User> user = new ArrayList<>(Arrays.asList(
                new User("Alan", "Walker", "862140881", "facebook@gmail.com", "Vilnius, Ukmerges g. 282", "Whales?123"),
                new User("John", "Walker", "862140881", "google@gmail.com", "Vilnius, Ukmerges g. 282", "Whales?123")
        ));
        when(userRepository.findAll()).thenReturn(user);
        List<User> userGet = userService.getAllUsers();
        verify(userRepository).findAll();
        assertEquals(2, userGet.size());
    }

    @Test
    void testUpdatePaskola() {
        User user = new User("Alan", "Walker", "862140881", "facebook@gmail.com", "Vilnius, Ukmerges g. 282", "Whales?123");
        User user1 = new User("John", "Walker", "862140881", "google@gmail.com", "Vilnius, Ukmerges g. 282", "Whales?123");
        user.setUserId(1);
        user1.setUserId(2);
        when(userRepository.findByUserId(Mockito.anyInt())).thenReturn(user);
        when(userRepository.save(Mockito.any(User.class))).thenReturn(user1);
        int userId = 0;
        try {
            userId = userService.updateUser(user1);
        } catch (InvalidEmailException | InvalidPasswordException | InvalidPhoneNumberException e) {
            System.out.println(e.getMessage());
            fail();
        }
        verify(userRepository).findByUserId(Mockito.anyInt());
        verify(userRepository).save(user);

        assertEquals(2, userId);
    }

    @Test
    void testDeletePaskola() {
        userService.deleteUser(Mockito.anyInt());
        verify(userRepository).deleteById(Mockito.anyInt());
    }
}
