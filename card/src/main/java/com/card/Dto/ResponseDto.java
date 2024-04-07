package com.card.Dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

@Schema(
        name = "Response",
        description = "To hold the HTTP responses"
)
public class ResponseDto {

    @Schema(
            description = "Status code hold the HTTP info"
    )
    private String statusCode;

    @Schema(

            description = "Status Message hold the message of the http response"
    )

    private String statusMsg;
}
