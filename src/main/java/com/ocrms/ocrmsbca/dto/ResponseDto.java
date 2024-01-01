package com.ocrms.ocrmsbca.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseDto {
    private boolean status;
    private String message;
}
