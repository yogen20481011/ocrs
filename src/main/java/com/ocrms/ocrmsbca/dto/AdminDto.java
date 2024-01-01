package com.ocrms.ocrmsbca.dto;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminDto {
    private Long id;
    private String name;
    private String email;
    private String password;
}
