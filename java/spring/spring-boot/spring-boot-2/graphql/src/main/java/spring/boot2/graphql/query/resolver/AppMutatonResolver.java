package spring.boot2.graphql.query.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import spring.boot2.graphql.model.Application;
import spring.boot2.graphql.service.AppService;

@Component
public class AppMutatonResolver implements GraphQLMutationResolver {

    private AppService appService;

    public AppMutatonResolver(AppService appService){
        this.appService = appService;
    }

    public Application newApplication(String name, String owner, String description){
        return  appService.newApplication(name, owner, description);
    }

    public Boolean deleteApplication(Integer id){
        return appService.deleteApplication(id);
    }
}
