package lt.psp.validation.service;

import com.raimondsobolevskij.service.FormValidator;
import lt.psp.validation.exceptions.InvalidEmailException;
import lt.psp.validation.exceptions.InvalidPasswordException;
import lt.psp.validation.exceptions.InvalidPhoneNumberException;
import lt.psp.validation.model.User;
import lt.psp.validation.respository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final FormValidator formValidatorLT = new FormValidator();
    private final FormValidator formValidatorRU = new FormValidator();

    public UserService(UserRepository userRepository) {
        formValidatorRU.newValidationRule(12, '8',  "+7");
        this.userRepository = userRepository;
    }

    public int updateUser(User user) throws InvalidPhoneNumberException, InvalidPasswordException, InvalidEmailException {
        User user1 = userRepository.findByUserId(user.getUserId());
        checkFields(user);
        if (user1 == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            user1.setName(user.getName());
            user1.setEmail(user.getEmail());
            user1.setPassword(user.getPassword());
            user1.setPhoneNr(user.getPhoneNr());
            user1.setSurname(user.getSurname());
            user1.setAddress(user.getAddress());
            return userRepository.save(user1).getUserId();
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public int uploadUser(User user) throws InvalidEmailException, InvalidPhoneNumberException, InvalidPasswordException {
        checkFields(user);
        return userRepository.save(user).getUserId();
    }

    private void checkFields(User user) throws InvalidEmailException, InvalidPhoneNumberException, InvalidPasswordException {
        if (!formValidatorLT.validateEmail(user.getEmail())) {
            throw new InvalidEmailException("Invalid email address");
        }
        if (!formValidatorLT.validatePhoneNumber(user.getPhoneNr()) &&
                !formValidatorRU.validatePhoneNumber(user.getPhoneNr())) {
            throw new InvalidPhoneNumberException("Invalid phone number");
        }
        if (!formValidatorLT.validatePassword(user.getPassword())) {
            throw new InvalidPasswordException("Invalid password");
        }
    }
}
