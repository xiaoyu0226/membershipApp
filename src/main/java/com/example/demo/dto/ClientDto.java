package com.example.demo.dto;

import com.example.demo.model.Family;
import com.example.demo.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {

    private int id;
    private String firstname;
    private String lastname;
    private Date birthday;
    private String email;
    private String phone;
    private String address;
    private Boolean isActive;
    private User user;
    private int family_id;
    private String password;
}
