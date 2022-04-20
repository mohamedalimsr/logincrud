package com.example.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserCService {
    @Autowired private UserCRepository repo ;

    public List<Crud> listAll(){
        return (List<Crud>) repo.findAll();
    }

    public void save(Crud user) {
        repo.save(user);
    }

    public Crud get(Integer id) throws UserNotFoundException {
        Optional<Crud> result = repo.findById(id);
        if (result.isPresent()){
            return result.get();
        }
        throw new UserNotFoundException("Could not found any users with ID" + id);
    }

    public void delete(Integer id) throws UserNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0) {
            throw new UserNotFoundException("Could not find any users with Id ");
        }
        repo.deleteById(id);
    }
}
