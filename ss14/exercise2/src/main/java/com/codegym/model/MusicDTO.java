package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class MusicDTO implements Validator {
    private int id;

    @NotEmpty(message = "Không được phép để trống")
    @Size(min = 0, max = 800, message = "Không vượt quá 800 ký tự")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    private String name;

    @NotEmpty(message = "Không được phép để trống")
    @Size(min = 0, max = 300, message = "Không vượt quá 300 ký tự")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    private String singer;

    @NotEmpty(message = "Không được phép để trống")
    @Size(min = 0, max = 1000, message = "Không vượt quá 1000 ký tự")
    @Pattern(regexp = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$", message = "Không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    private String category;

    public MusicDTO() {
    }

    public MusicDTO(int id, String name, String singer, String category) {
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
        MusicDTO musicDTO = (MusicDTO) target;
    }
}
