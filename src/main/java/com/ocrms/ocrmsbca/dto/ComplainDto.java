package com.ocrms.ocrmsbca.dto;

import com.ocrms.ocrmsbca.Enum.EComplainStatus;
import com.ocrms.ocrmsbca.Enum.ECrimeType;
import com.ocrms.ocrmsbca.entity.user.User;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComplainDto {
    private Long id;
    private String address;
    private ECrimeType crime;
    private String crimeDate;
    private Date complainDate;
    private EComplainStatus complainStatus;
    private User user;
    private String description;
   /* private String photo;
    private MultipartFile multipartFile;*/
}
