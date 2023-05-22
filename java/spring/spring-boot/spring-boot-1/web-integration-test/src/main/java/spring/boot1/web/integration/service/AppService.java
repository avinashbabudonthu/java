package spring.boot1.web.integration.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import spring.boot1.web.integration.model.Student;
import spring.boot1.web.integration.repository.AppRepository;

import java.util.List;

@Slf4j
@Service
public class AppService {

    @Autowired
    private AppRepository appRepository;

    @Value("${app.name}")
    private String appName;

    public List<Student> findAllStudents(){
        log.info("appName={}", appName);
        return appRepository.findAllStudens();
    }

    public String getAppName(){
        return appName;
    }
}
