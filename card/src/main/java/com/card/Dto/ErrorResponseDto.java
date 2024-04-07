package com.card.Dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor

@Schema(

        name = "Error Response",
        description = "Hold the error info"
)
public class ErrorResponseDto {


    @Schema(
            description = "API path hold the info of API path"
    )
    private String apiPath;
    @Schema(
            description = "Error code hold the info of error"
    )
    private HttpStatus errorCode;
    @Schema(
            description = "Error Message hold the actual info of the error"
    )
    private String errorMessage;
    @Schema(description = "Error time showing the error time")

    private LocalDateTime errorTime;

}
