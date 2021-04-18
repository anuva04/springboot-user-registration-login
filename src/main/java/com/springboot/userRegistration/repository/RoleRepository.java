package com.springboot.userRegistration.repository;

import com.springboot.userRegistration.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer> {
    public Roles findByRole(String role);
}
