package com.sda.meetup.dto;



import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

/*@FieldMatch.List({
        @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
        @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
})*/
public class RegistrationDto {

    @NotEmpty(message = "")
    @Pattern(regexp = "^[A-Z]{1}[a-z]{2,}$", message = "First Name can not be blank and should contain at least 3 letters.")
    private String firstName;

    @NotEmpty(message = "")
    @Pattern(regexp = "^[A-Z][a-z]{2,}(-[A-Z][a-z]{2,})?$", message = "Last Name can not be blank and should contain at least 3 letters.")
    private String lastName;

    @NotEmpty(message = "")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)\\S{8,}$", message = "Password can not be blank and should contain at least 8 characters with capital one and at least one special sign.")
    private String password;

    @NotEmpty(message = "")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)\\S{8,}$", message = "Confirm Password can not be blank and should contain at least 8 characters with capital one and at least one special sign. It should be equal to password")
    private String confirmPassword;


    @Email
    @NotEmpty(message = "")
    @Pattern(regexp ="^[A-Za-z0-9]{1}[A-Za-z0-9\\-\\_\\.]+\\@[A-Za-z0-9\\.]+[.][a-z]+$", message = "Email can not be blank and should have mail format.")
    private String email;

    @Email
    @NotEmpty(message = "")
    @Pattern(regexp ="^[A-Za-z0-9]{1}[A-Za-z0-9\\-\\_\\.]+\\@[A-Za-z0-9\\.]+[.][a-z]+$", message = "Email confirm can not be blank and should have mail format. It should be equal to email.")
    private String confirmEmail;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }


}