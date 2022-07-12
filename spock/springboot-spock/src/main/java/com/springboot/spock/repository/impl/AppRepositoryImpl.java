package com.springboot.spock.repository.impl;

import com.springboot.spock.repository.AppRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class AppRepositoryImpl implements AppRepository {

    @Override
    public List<Integer> findIntegerList(){
       return Arrays.asList(1,2,3,4,5);
    }

}
