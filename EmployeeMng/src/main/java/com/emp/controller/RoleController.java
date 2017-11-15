package com.emp.controller;

import com.emp.model.AjaxResponseBody;
import com.emp.model.Role;
import com.emp.repository.RoleRepository;
import com.emp.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Created by Developer PC on 10/30/2017.
 */
@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;

    @RequestMapping(value="/get-roles", method= RequestMethod.GET)
    public List<Role> getAll(){

        AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();
        List<Role> roles = roleService.getAll();

        return roles;
    }

    @RequestMapping(value="/add-role", method=RequestMethod.POST)
    public AjaxResponseBody addUser(@RequestBody Role role){
        AjaxResponseBody ajaxResponseBody = new AjaxResponseBody();
        roleService.addRole(role);
        ajaxResponseBody.setCode("201");
        ajaxResponseBody.setMsg("Saved");

        return ajaxResponseBody;
    }

    @RequestMapping(value="/role/{id}", method=RequestMethod.GET)
    public Role getRole(@PathVariable String id){
        return roleService.getRole(Integer.parseInt(id));
    }

}
