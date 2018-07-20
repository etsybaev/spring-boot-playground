package com.mycomp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/keepalive")
public class KeepServerAliveController {

    //This is just an attempt to keep server alive. As hosting is free - it goes down after 30 minutes of inactivity.
    //So we will send some payload's useless requests just to keep it alive
    @RequestMapping(value = "/up", method = RequestMethod.GET)
    public ResponseEntity keppAive() {

        return new ResponseEntity(HttpStatus.OK);
    }
}
