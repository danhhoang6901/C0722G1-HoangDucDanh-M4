package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDTO implements Validator {
    private int id;

    @NotEmpty(message = "First Name không được để trống!")
    @Size(min = 5, max = 45, message = "First Name phải có độ dài hơn 5 chữ và nhỏ hơn 45")
    private String firstName;

    @NotEmpty(message = "Last Name không được để trống!")
    @Size(min = 5, max = 45, message = "Last Name phải có độ dài hơn 5 chữ và nhỏ hơn 45")
    private String lastName;

    @Pattern(regexp = "[0]\\d{9}", message = "Số điện thoại phải 10 số và không được nhập chữ")
    private String phoneNumber;

    @Min(value = 18, message = "Con nít biến")
    private int age;


    @Email(message = "Đúng định dạng: abcde@gmail.com")
    private String email;

    public UserDTO() {
    }

    public UserDTO(int id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO userDTO = (UserDTO) target;
    }
}
