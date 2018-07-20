package com.mycomp.mock;


import com.mycomp.pojo.Greeting;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/greeting", method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }


//    @RequestMapping(value = "/{greeting}", method = RequestMethod.GET)
//    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name, @PathVariable("greeting") String s) {
//        return new Greeting(counter.incrementAndGet(),
//                String.format(template, name));
//    }
}
