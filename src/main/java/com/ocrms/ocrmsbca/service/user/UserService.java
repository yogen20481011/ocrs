package com.ocrms.ocrmsbca.service.user;

import com.ocrms.ocrmsbca.dto.UserDto;
import com.ocrms.ocrmsbca.service.GenericCrudServiceImpl;
import org.springframework.stereotype.Service;


@Service
public interface UserService extends GenericCrudServiceImpl<UserDto,Long> {
}
