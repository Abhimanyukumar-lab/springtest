package com.flight.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.flight.entity.AuthGroup;

public interface AuthGroupRepository<P> extends CrudRepository<AuthGroup, Long> {
    List<AuthGroup> findByUserName(String userName);
}