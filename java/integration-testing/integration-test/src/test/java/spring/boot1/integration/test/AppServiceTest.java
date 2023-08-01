package spring.boot1.integration.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.boot1.mockito.App;
import spring.boot1.mockito.model.Student;
import spring.boot1.mockito.service.AppService;

import java.util.List;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class}, properties = {"app.name=integration-test"})
public class AppServiceTest {

    @Autowired
    private AppService appService;

    @Test
    public void findAllStudents(){
        List<Student> students = appService.findAllStudents();

        log.info("students={}", students);
    }
}
