package spring.boot2.graphql.repository;

import org.springframework.stereotype.Repository;
import spring.boot2.graphql.model.Application;

import java.util.Arrays;
import java.util.List;

@Repository
public class AppRepository {

    public List<Application> findAllApplications(){
        Application application1 = Application.builder().id(1).name("jarvis").owner("avinash").description("Jarvis").build();
        Application application2 = Application.builder().id(1).name("cerebro").owner("avinash").description("Cerebro").build();
        Application application3 = Application.builder().id(1).name("remembral").owner("avinash").description("Remembral").build();

        List<Application> applicationList = Arrays.asList(application1, application2, application3);

        return applicationList;
    }
}
