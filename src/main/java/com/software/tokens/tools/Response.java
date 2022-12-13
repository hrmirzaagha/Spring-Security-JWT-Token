package com.software.tokens.tools;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {

    private LocalDate timeStamp;
    private HttpStatus httpStatus;
    private int statusCode;
    private String message;
    private String reason;
    private String developerMessage;
    private Map<?, ?> data;
}
