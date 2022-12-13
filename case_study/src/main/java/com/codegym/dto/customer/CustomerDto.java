package com.codegym.dto.customer;

import com.codegym.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class CustomerDto implements Validator {
    private int id;

    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Không được chứa số. Các ký tự đầu tiên mỗi từ phải viết hoa")
    private String name;

    @NotEmpty(message = "Không được để trống")
    private String dateOfBirth;

    private int gender;

    @NotEmpty(message = "Không được để trống")
    private String idCard;

    @NotEmpty(message = "Không được để trống")
    @Pattern(regexp = "^[0][9][0][0-9]{7}$", message = "Đúng định dạng: 090xxxxxxx")
    private String phoneNumber;

    @NotEmpty(message = "Không được để trống")
    @Email(message = "Đúng định dạng: abcde@gmail.com")
    private String email;

    @NotEmpty(message = "Không được để trống")
    private String address;

    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(int id, String name, String dateOfBirth, int gender, String idCard, String phoneNumber, String email, String address, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
    }

}
