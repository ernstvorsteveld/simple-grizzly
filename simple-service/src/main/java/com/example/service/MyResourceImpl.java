package com.example.service;

import com.example.contract.MyResource;
import com.example.domain.Person;
import org.springframework.stereotype.Component;

@Component
public class MyResourceImpl implements MyResource {

    @Override
    public String alive() {
        System.out.println(this.getClass().getName());
        return "I am running!";
    }

    @Override
    public String echo(String value) {
        return value;
    }

    @Override
    public Person person() {
        Person person = new Person("1", "username.1");
        return person;
    }
}
