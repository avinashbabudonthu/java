package com.ab.resolver;

import com.ab.model.StudentResponse;
import com.ab.model.SubjectResponse;
import com.ab.service.QueryService;
import com.ab.util.SubjectEnum;
import com.ab.util.Util;
import com.coxautodev.graphql.tools.GraphQLResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

    @Autowired
    private QueryService queryService;

    public List<SubjectResponse> subjectResponses(StudentResponse studentResponse) {
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

    public List<SubjectResponse> filteredSubjects(StudentResponse studentResponse,
                                                  SubjectEnum subjectEnum) {
        List<SubjectResponse> subjectResponses = queryService.findSubjects();
        List<SubjectResponse> filteredSubjectResponses = new ArrayList<>();
        for(SubjectResponse subjectResponse : subjectResponses) {
            if(null != subjectEnum && subjectResponse.getName().equalsIgnoreCase(subjectEnum.name())) {
                filteredSubjectResponses.add(subjectResponse);
            }
        }
        return filteredSubjectResponses;
    }

    public List<SubjectResponse> filteredSubjectsWithArray(StudentResponse studentResponse,
                                                  List<SubjectEnum> subjectEnumList) {
        List<SubjectResponse> subjectResponses = queryService.findSubjects();
        List<SubjectResponse> filteredSubjectResponses = new ArrayList<>();
        for(SubjectEnum subjectEnum : subjectEnumList) {
            for(SubjectResponse subjectResponse : subjectResponses) {
                if(null != subjectEnum && subjectResponse.getName().equalsIgnoreCase(subjectEnum.name())) {
                    filteredSubjectResponses.add(subjectResponse);
                }
            }
        }

        return filteredSubjectResponses;
    }
}