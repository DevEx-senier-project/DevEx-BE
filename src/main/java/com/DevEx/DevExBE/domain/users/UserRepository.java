package com.DevEx.DevExBE.domain.users;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
    List<Users> findAll();
    Optional<Users> findById(Long id);
    Optional<Users> findByEmail(String email);

    boolean existsByEmail(String email);
}
