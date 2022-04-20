package com.example.login;

import com.example.login.Crud;
import org.springframework.data.repository.CrudRepository;

public interface UserCRepository extends CrudRepository <Crud, Integer> {
    public Long countById(Integer id);
}
