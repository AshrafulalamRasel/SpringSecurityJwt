package com.security.micro.demo.repository;


import com.security.micro.demo.domain.Role;
import com.security.micro.demo.domain.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // Optional<Role> findByName(RoleName roleName);
    Optional<Role> findByName(RoleName role);
}