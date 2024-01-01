package com.ocrms.ocrmsbca.service.complain;

import com.ocrms.ocrmsbca.dto.ComplainDto;
import com.ocrms.ocrmsbca.service.GenericCrudServiceImpl;
import org.springframework.stereotype.Service;

@Service
public interface ComplainService extends GenericCrudServiceImpl<ComplainDto,Long> {
}
