package org.example;

import org.springframework.stereotype.Component;


//bean基本注解
@Component("componentTest")
public class ComponentTest {

    @Override
    public String toString() {
        return "ComponentTest";
    }
}
