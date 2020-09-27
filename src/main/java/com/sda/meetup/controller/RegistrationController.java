package com.sda.meetup.controller;

import com.sda.meetup.dto.RegistrationDto;
import com.sda.meetup.entity.UserEntity;
import com.sda.meetup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    private UserService userService;

    @ModelAttribute("user")
    public RegistrationDto userRegistrationDto() {
        return new RegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid RegistrationDto userDto,
                                      BindingResult result){

        UserEntity existing = userService.findByEmail(userDto.getEmail());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()){
            return "registration";
        }

        userService.save(userDto);
        return "redirect:/login";
    }


    /*@PostMapping*/
/*    @ModelAttribute("user")
    public String loggedUser(UserRegistrationDto userDto) {
        User user = userService.findByEmail(userDto.getEmail());
        return user.getEmail();
    }*/
}
