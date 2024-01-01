package com.ocrms.ocrmsbca.service.impl;

import com.ocrms.ocrmsbca.entity.role.Role;
import com.ocrms.ocrmsbca.repository.role.RoleRepository;
import com.ocrms.ocrmsbca.service.role.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;

    public RoleServiceImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Role save(Role role) {
        return repository.save(role);
    }

    @Override
    public List<Role> findAll() {
        return null;
    }

    @Override
    public Role findById(Long aLong) {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }
}
