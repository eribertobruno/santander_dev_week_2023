package me.dio.santander_dev_week_2023.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import me.dio.santander_dev_week_2023.domain.model.User;
import me.dio.santander_dev_week_2023.domain.repository.UserRepository;
import me.dio.santander_dev_week_2023.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This Account Number already exist.");
        }
        // TODO Auto-generated method stub
        return userRepository.save(userToCreate);
    }

    @Override
    public User findById(Long id) {
        // TODO Auto-generated method stub
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

}
