package com.fabiankevin.springbootcache.service;

import com.fabiankevin.springbootcache.interactor.GetUser;
import com.fabiankevin.springbootcache.model.User;
import com.fabiankevin.springbootcache.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final CacheManager cacheManager;

    private final GetUser getUser;

    public User getUser(Long id){
        return getUser.execute(id);
    }

    @CachePut(value = "users", key = "#user.id")
    @CacheEvict(value = "allUsers", allEntries = true)
    public User create(User user){
        cacheManager.getCache("users").evict("all");
        user = userRepository.save(user);
        return user;
    }

    @CachePut(value = "users", key = "#newUser.id")
    @CacheEvict(value = "allUsers", allEntries = true)
    public User update(User newUser){


        User user = getUser.execute(newUser.getId());
        //updatable fields are name and birthday only
        user.setBirthDate( newUser.getBirthDate() );
        user.setName( newUser.getName() );

        return userRepository.save(user);
    }

    @Cacheable(value = "allUsers")
    public List<User> findAll() {
        System.out.println("Get all!");
        return userRepository.findAll();
    }
}
