package com.dhanavarshini.greenlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.dhanavarshini.greenlearn.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}