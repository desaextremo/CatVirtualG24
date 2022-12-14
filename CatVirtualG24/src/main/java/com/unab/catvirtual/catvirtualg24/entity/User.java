package com.unab.catvirtual.catvirtualg24.entity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDate;

@Data
@Builder
public class User {
    @Id
    private String identification;
    private String fisrtName;
    private String lastName;
    private LocalDate birthDay;
    private String address;
    @Indexed(unique = true)
    private String cellPhone;
    @Indexed(unique = true)
    private String email;
    private String password;
    private String role;
    private String gender;
}
