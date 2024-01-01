package com.ocrms.ocrmsbca.service.admin;

import com.ocrms.ocrmsbca.dto.AdminDto;
import com.ocrms.ocrmsbca.service.GenericCrudServiceImpl;
import org.springframework.stereotype.Service;


@Service
public interface AdminService extends GenericCrudServiceImpl<AdminDto,Long> {
}
