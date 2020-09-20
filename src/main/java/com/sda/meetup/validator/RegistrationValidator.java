package com.sda.meetup.validator;

import com.sda.meetup.dto.RegistrationDto;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegistrationValidator implements Validator {

    private final String firstNameRegex = "^[A-Z]{1}[a-z]{2,}$";
    private final String lastNameRegex = "^[A-Z][a-z]{2,}(-[A-Z][a-z]{2,})?$";
    private final String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)\\S{8,}$";
    private final String passwordConfirmRegex = "^(?=.*[A-Z])(?=.*\\d)\\S{8,}$";
    private final String eMailRegex = "^[A-Za-z0-9]{1}[A-Za-z0-9\\-\\_\\.]+\\@[A-Za-z0-9\\.]+[.][a-z]+$";
    private final String eMailConfirmRegex = "^[A-Za-z0-9]{1}[A-Za-z0-9\\-\\_\\.]+\\@[A-Za-z0-9\\.]+[.][a-z]+$";

    public Map<String, String> validateUserRegistration(RegistrationDto registrationDto) {
        final Map<String, String> validatedMap = new HashMap<>();
        if (registrationDto.getFirstName() == null || !registrationDto.getFirstName().matches(firstNameRegex)) {
            validatedMap.put("firstNameValRes", "Imię jest wymagane. Przynajmniej 3 znaki oraz pierwsza duża, reszta małe");
        }
        if (registrationDto.getLastName() == null || !registrationDto.getLastName().matches(lastNameRegex)) {
            validatedMap.put("lastNameValRes", "Nazwisko jest wymagane. Przynajmniej 3 znaki oraz pierwsza duża, reszta małe" +
                    "    + dopuszczenie \"-\" i drugiego członu z dużej litery\n");
        }
        if (registrationDto.getEmail() == null || !registrationDto.getEmail().matches(eMailRegex)||!registrationDto.getConfirmEmail().matches(eMailConfirmRegex) ) {
            validatedMap.put("eMailValRes", "Zły format adresu email.");
        }
        if (!registrationDto.getEmail().equals(registrationDto.getConfirmEmail())) {
            validatedMap.put("eMailValRes", "Adresy email muszą być takie same");
        }

        if (registrationDto.getPassword() == null || !registrationDto.getPassword().matches(passwordRegex)|| !registrationDto.getConfirmPassword().matches(passwordConfirmRegex)) {
            validatedMap.put("passwordValRes", " Hasło jest wymagane. Musi zawierać od 10 do 20 znaków.\n" +
                    "    Minimum jedna duża, jedna mała litera i jedna cyfra.");
        }
        if (!registrationDto.getPassword().equals(registrationDto.getConfirmPassword())) {
            validatedMap.put("passwordValRes", " Hasła muszą być takie same.");
        }
        return validatedMap;

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return RegistrationDto.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        RegistrationDto registrationDto = (RegistrationDto)o;
        if (registrationDto.getFirstName() == null || !registrationDto.getFirstName().matches(firstNameRegex)) {
            errors.rejectValue("firstName", "Imię jest wymagane. Przynajmniej 3 znaki oraz pierwsza duża, reszta małe", "Imię jest wymagane. Przynajmniej 3 znaki oraz pierwsza duża, reszta małe");
        }
    }
}