package com.fabiankevin.springbootcache.interactor;

import com.fabiankevin.springbootcache.model.User;
import com.fabiankevin.springbootcache.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetUserImpl implements GetUser {
    private final UserRepository userRepository;

    @Override
    @Cacheable(value = "users")
    public User execute(Long id) {
        System.out.println(String.format("Get user by id %s", id));
        return userRepository.getOne(id);
    }
}
