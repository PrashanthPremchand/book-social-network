package com.prashanth.book.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Map;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExceptionResponse {

    Integer businessErrorCode;
    String businessErrorDescription;
    String error;
    Set<String> validationErrors;
    Map<String, String> errors;

}
