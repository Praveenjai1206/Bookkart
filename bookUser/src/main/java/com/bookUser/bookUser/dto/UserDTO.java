package com.bookUser.bookUser.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;
@Data
public class UserDTO {

    private int userId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private LocalDateTime dateOfBirth;
    private Set<Integer> phoneNumbers;


}
