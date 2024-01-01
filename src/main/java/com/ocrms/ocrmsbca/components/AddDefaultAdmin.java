package com.ocrms.ocrmsbca.components;

import com.ocrms.ocrmsbca.entity.role.Role;
import com.ocrms.ocrmsbca.repository.role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class AddDefaultAdmin {
    @Autowired
    private RoleRepository roleRepository;
    @EventListener
    public void appReady(ApplicationReadyEvent event) {

        roleRepository.save(new Role(1L,"admin","admin@gmail.com","$2a$10$beUMhB2cw981iZtl3c5tbeNA60XGl/asbKYDqpaP0UDaLip81M4xi", "ROLE_ADMIN"));
    }
}
