package spring.boot1.web.integration.controller;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import spring.boot1.web.integration.App;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {App.class}, properties = {"app.name=web integration test"}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AppControllerTest {


}
