package com.fabiankevin.springbootcache.interactor;

import com.fabiankevin.springbootcache.model.User;

public interface GetUser {
    User execute(Long id);
}
