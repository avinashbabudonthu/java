package spring.boot2.unit.testing.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AppService {

    public List<String> getNames(){
        return Arrays.asList("jill", "jack", "jim");
    }

}