package lt.psp.validation.controller;

import lombok.RequiredArgsConstructor;
import lt.psp.validation.exceptions.InvalidEmailException;
import lt.psp.validation.exceptions.InvalidPasswordException;
import lt.psp.validation.exceptions.InvalidPhoneNumberException;
import lt.psp.validation.model.User;
import lt.psp.validation.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("list-user")
    public String getUser(ModelMap modelMap) {
        modelMap.put("users", userService.getAllUsers());
        return "list-user";
    }

    @PostMapping("update/{id}")
    public String updateUser(@PathVariable("id") int id, @ModelAttribute("user") User user,
                             BindingResult bindingResult, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "add-user";
        }
        user.setUserId(id);

        try {
            userService.updateUser(user);
        } catch (InvalidEmailException | InvalidPasswordException | InvalidPhoneNumberException e) {
            httpSession.setAttribute("exception", e);
            return "redirect:/error";
        }

        return "redirect:/list-user";
    }

    @GetMapping("update/{id}")
    public String showUpdateUser(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "add-user";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/list-user";
    }

    @GetMapping("/add-user")
    public String showAddUser(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "add-user";
    }

    @PostMapping("/add-user")
    public String addUser(@ModelAttribute("user") User user,
                          BindingResult bindingResult, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            return "add-user";
        }
        try {
            userService.uploadUser(user);
        } catch (InvalidEmailException | InvalidPasswordException | InvalidPhoneNumberException e) {
            httpSession.setAttribute("exception", e);
            return "redirect:/error";
        }
        return "redirect:/list-user";
    }
}
