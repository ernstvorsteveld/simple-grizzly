package nl.vorstdev.service;

import com.example.contract.MyResource;
import com.example.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyResourceImpl implements MyResource {

    private Logger logger = LoggerFactory.getLogger(MyResourceImpl.class);

    @Override
    public String alive() {
        logger.debug("Requesting alive.");
        return "I am running!";
    }

    @Override
    public String echo(String value) {
        logger.debug("Requsting echo for value: {}.", value);
        return value;
    }

    @Override
    public Person person() {
        logger.debug("Requesting object.");
        Person person = new Person("1", "username.1");
        return person;
    }
}
