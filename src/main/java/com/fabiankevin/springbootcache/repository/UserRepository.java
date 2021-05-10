package com.fabiankevin.springbootcache.repository;

import com.fabiankevin.springbootcache.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
