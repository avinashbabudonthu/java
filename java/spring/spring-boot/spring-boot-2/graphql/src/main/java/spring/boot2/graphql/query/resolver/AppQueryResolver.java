package spring.boot2.graphql.query.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import spring.boot2.graphql.model.Application;
import spring.boot2.graphql.service.AppService;

import java.util.List;

@Component
public class AppQueryResolver implements GraphQLQueryResolver {

    private AppService appService;

    public AppQueryResolver(AppService appService){
        this.appService = appService;
    }

    public List<Application> findAllApplications(){
        return appService.findAllApplications();
    }

    public Integer countAllApplications(){
        return appService.countAllApplications();
    }

}
