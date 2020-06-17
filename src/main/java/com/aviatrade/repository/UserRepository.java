package com.aviatrade.repository;

import com.aviatrade.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername (String username);

    User saveAndFlush(User user);
}
