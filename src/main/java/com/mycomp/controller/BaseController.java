package com.mycomp.controller;


import com.mycomp.pojo.Greeting;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class BaseController {

    private static final String template = "GGG Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/ggg", method = RequestMethod.GET)
//    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
