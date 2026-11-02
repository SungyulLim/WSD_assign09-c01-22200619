package com.webservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record MemberRequest(
        @NotBlank @Size(max = 100) String name,
        @NotBlank @Size(max = 20) String studentId,
        @NotBlank @Size(max = 100) String department,
        @NotNull @Min(1) Integer grade,
        @NotBlank @Email @Size(max = 200) String email,
        @NotBlank @Size(max = 50) String role
) { }
