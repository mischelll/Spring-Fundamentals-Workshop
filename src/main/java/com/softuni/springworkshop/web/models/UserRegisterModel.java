package com.softuni.springworkshop.web.models;

import lombok.*;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRegisterModel {
    @NonNull
    @Size(min = 3, max = 32, message = "Username must be between 3 and 32 characters")
    private String username;
    @NonNull
    @Email(message = "Please enter a valid email")
    private String email;
    @NonNull
    @Size(min = 8, max = 255, message = "Password must be between 8 and 255 characters")
    private String password;
    @NonNull
    @Size(min = 8, max = 255, message = "Please enter a valid password")
    private String confirmPassword;
    @NonNull
    @Pattern(regexp ="https://github.com/.+/.+",message = "Enter git address following this pattern")
    private String git;


}
