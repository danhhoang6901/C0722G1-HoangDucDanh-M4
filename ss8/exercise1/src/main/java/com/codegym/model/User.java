package com.codegym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Pattern(regexp = "\\w{5,10}[@][g][m][a][i][l][.][c][o][m]", message = "Đúng định dạng: abcde@gmail.com")
    private String email;

    public User() {
    }

    public User(int id, String firstName, String lastName, String phoneNumber, int age, String email) {
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
}
