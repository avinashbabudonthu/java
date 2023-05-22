package spring.boot1.mockito.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;
import spring.boot1.mockito.repository.AppRepository;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
public class AppServiceTest {

    @InjectMocks
    private AppService appService;

    @Mock
    private AppRepository appRepository;

    @Test
    public void getAppName(){
        ReflectionTestUtils.setField(appService, "appName", "mockito testing");
        String appName = appService.getAppName();

        log.info("Testing appName={}", appName);
    }
}
