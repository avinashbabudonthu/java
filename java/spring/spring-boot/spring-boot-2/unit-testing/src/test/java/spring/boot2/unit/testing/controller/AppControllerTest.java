package spring.boot2.unit.testing.controller;

import org.junit.Test;
import org.junit.experimental.results.ResultMatchers;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import spring.boot2.unit.testing.service.AppService;

@RunWith(SpringRunner.class)
@WebMvcTest(AppController.class)
public class AppControllerTest {

    @Mock
    private MockMvc mockMvc;

    // create mock of bean
    @MockBean
    private AppService appService;

    /**
     * perform - to make rest api call
     * andExpect - to set expectation on response
     */
    @Test
    public void getNames(){
        /*mockMvc.perform("/names")
                .andExpect(ResultMatcher.matchAll(

                ));*/

        /*mockMvc.perform(post("/form"))
                  .andExpect(ResultMatcher.matchAll(
                          ResultMatchers.status().isOk(),
                      redirectedUrl("/person/1"),
	  	 model().size(1),
	       model().attributeExists("person"), flash().attributeCount(1),
	       flash().attribute("message", "success!"))
	    );*/
    }
}
