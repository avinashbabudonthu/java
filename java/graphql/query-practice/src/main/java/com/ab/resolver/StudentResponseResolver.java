package com.ab.resolver;

import com.ab.model.StudentResponse;
import com.ab.model.SubjectResponse;
import com.ab.util.Util;
import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

    public List<SubjectResponse> getSubjectResponses(StudentResponse studentResponse) {
        log.info("Fetching subject responses");
        List<SubjectResponse> subjectResponses = new ArrayList<>();
        for(int i = 0;i<10;i++){
            subjectResponses.add(SubjectResponse.builder()
                            .id(Util.FAKER.number().randomNumber())
                            .name(Util.FAKER.book().title())
                            .grade(Util.FAKER.number().randomDouble(2,1, 5))
                    .build());
        }

        log.info("Fetched subject responses");
        return subjectResponses;
    }
}