package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Music implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Không được phép để trống")
    @Size(min = 0, max = 800, message = "Không vượt quá 800 ký tự")
    @Pattern(regexp = "^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$", message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    private String name;

    @NotEmpty(message = "Không được phép để trống")
    @Size(min = 0, max = 300, message = "Không vượt quá 300 ký tự")
    @Pattern(regexp = "^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$", message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    private String singer;

    @NotEmpty(message = "Không được phép để trống")
    @Size(min = 0, max = 1000, message = "Không vượt quá 1000 ký tự")
    @Pattern(regexp = "^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$", message = "Ngoại trừ dấu phẩy “,” , các ký tự đặc biệt còn lại không được phép")
    private String category;

    public Music() {
    }

    public Music(int id, String name, String singer, String category) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
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

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Music music = (Music) target;
    }
}
