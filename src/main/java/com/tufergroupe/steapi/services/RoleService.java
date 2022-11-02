package com.tufergroupe.steapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tufergroupe.steapi.model.Role;
import com.tufergroupe.steapi.repository.RoleRepository;

import lombok.Data;

@Data
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @Transactional(readOnly = true)
    public Optional<Role> getRole(final Long id) {
        return roleRepository.findById(id);
    }

    @Transactional(readOnly = true)
    public Iterable<Role> getRoles() {
        return roleRepository.findAll();
    }

    public void deleteRole(final Long id) {
        roleRepository.deleteById(id);
    }

    public Role saveRole(Role role) {
        Role savedSoute = roleRepository.save(role);
        return savedSoute;
    }
}
