package spring.boot2.graphql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot2.graphql.model.Application;
import spring.boot2.graphql.repository.AppRepository;

import java.util.List;
import java.util.Random;

@Service
public class AppService {

    @Autowired
    private AppRepository appRepository;

    public List<Application> findAllApplications(){
        return appRepository.findAllApplications();
    }

    public Integer countAllApplications(){
        return appRepository.findAllApplications().size();
    }

    public Application newApplication(String name, String owner, String description){
        return Application.builder().id(new Random().nextInt()).name(name)
                .owner(owner).description(description).build();
    }

    public Boolean deleteApplication(Integer id){
        if(id>0){
            return Boolean.TRUE;
        }else{
            return Boolean.FALSE;
        }
    }

}
