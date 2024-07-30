package com.ptvinh203.internbackend.payload.response;

import com.ptvinh203.internbackend.annotation.JsonSnakeCaseNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonSnakeCaseNaming
public class CredentialResponse {
    private String accessToken;
    private String refreshToken;
    private String type = "Bearer";
    private String expiredAt;
}
