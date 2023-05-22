package maven.git.commit.id.plugin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

@Slf4j
@RestController
public class AppController {

    @GetMapping(value = "/version", produces = MediaType.APPLICATION_JSON_VALUE)
    public String versionInformation(){
        return readGitProperties();
    }

    private String readGitProperties(){
        ClassLoader classLoader = getClass().getClassLoader();
        StringBuilder stringBuilder = new StringBuilder();
        try(InputStream inputStream = classLoader.getResourceAsStream("git.properties");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))){
            String line;
            while(null != (line=bufferedReader.readLine())){
                stringBuilder.append(line);
            }
        }catch (Exception e){
            log.error("Error reading git.properties", e);
        }

        return stringBuilder.toString();
    }
}
