package com.ocrms.ocrmsbca.service.role;

import com.ocrms.ocrmsbca.entity.role.Role;
import com.ocrms.ocrmsbca.service.GenericCrudServiceImpl;
import org.springframework.stereotype.Service;


@Service
public interface RoleService extends GenericCrudServiceImpl<Role,Long> {
}
