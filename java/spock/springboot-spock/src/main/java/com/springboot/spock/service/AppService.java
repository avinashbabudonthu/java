package com.springboot.spock.service;

import com.springboot.spock.repository.impl.AppRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppService {

    @Autowired
    private AppRepositoryImpl appRepository;

    public List<Integer> findNumbers() {
        return appRepository.findIntegerList();
    }
}
