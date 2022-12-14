package com.unab.catvirtual.catvirtualg24.enitity;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

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
    private String cellPhone;
    private String email;
    private String password;
    private String role;
    private String gender;
}
