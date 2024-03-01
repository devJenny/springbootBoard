package com.example.springbootBoard.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class AddUserRequest {
    private String email;
    private String password;
}
