package com.emp.service;

import com.emp.model.Role;
import com.emp.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Developer PC on 10/30/2017.
 */
@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAll(){
        List<Role>roles = new ArrayList<>();
        roleRepository.findAll().forEach(roles::add);
        return roles;
    }

    public Role getRole(Integer id) {
        return roleRepository.findOne(id);
    }

    public void addRole(Role role){
        roleRepository.save(role);
    }

    public void delete(Integer id){
        roleRepository.delete(id);
    }
}
