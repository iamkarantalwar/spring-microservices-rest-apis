package com.example.demo.seeders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.example.demo.models.ERole;
import com.example.demo.models.Role;
import com.example.demo.repository.RoleRepository;

@Component
public class DatabaseSeeder {
	@Autowired
    private RoleRepository roleRepository; 

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedUsersTable();
    }   

    private void seedUsersTable() {
//    	Role role = new Role();
//    	role.setId(1);
//    	role.setName(ERole.ROLE_USER);
//        this.roleRepository.save(role);
    }

}
