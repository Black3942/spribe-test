package com.example.spribeapitest.dto.request;

import com.example.spribeapitest.lib.FieldsValueMatch;
import com.example.spribeapitest.lib.ValidEmail;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@FieldsValueMatch(
        field = "password",
        fieldMatch = "repeatPassword",
        message = "Passwords do not match!"
)
@Getter
@RequiredArgsConstructor
public class UserRequestDto {
    @ValidEmail
    private String email;
    @Size(min = 8, max = 40)
    private String password;
    private String repeatPassword;
}
