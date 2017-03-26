package com.lesniewski.aop;

import org.springframework.stereotype.Component;

/**
 * Created by adrian on 25.03.17.
 */
@Component
public class SomeBean {

    public String someMethod(){
        return "some Value";
    }

    public void throwSomeException() {
        throw new RuntimeException();
    }
}
