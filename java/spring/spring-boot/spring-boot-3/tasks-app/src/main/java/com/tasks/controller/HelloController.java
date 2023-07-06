package com.tasks.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.MediaType.TEXT_PLAIN_VALUE;

@Controller
public class HelloController {

    @GetMapping(value = "/hello2", produces = TEXT_PLAIN_VALUE)
    // use this annotation - controller returns String means spring mvc will look for view name. Rather than doing that and return response as text
    @ResponseBody
    public String hello2() {
        return "Hello World 2";
    }

    @GetMapping(value = "/hello2-html")
    @ResponseBody
    public String helloHtml() {
        return """
                <html>
                   <head>
                        <title>My html page</title>
                   </head>
                   <body>
                        My first html page
                   </body>
                </html>
                """;
    }

    @GetMapping(value = "/hello2-jsp")
    public String hello2Jsp() {
        return "sayHello";
    }

}