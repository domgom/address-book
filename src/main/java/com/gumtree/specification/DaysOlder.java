package com.gumtree.specification;

import com.gumtree.Contact;

import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * Created by dgomez on 24/2/16.
 */
public class DaysOlder implements Specification<Contact, Long> {

    private final String firstName;
    private final String secondName;

    public DaysOlder(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    @Override
    public Long eval(List<Contact> contacts) {
        Contact first = findContactByName(firstName, contacts);
        Contact second = findContactByName(secondName, contacts);

        return DAYS.between(first.getDate(), second.getDate());
    }

    private Contact findContactByName(String name, List<Contact> contacts) {
        return contacts.stream().filter(c -> c.getName().startsWith(name)).
                findFirst().
                orElseThrow(AbsentContactException::new);
    }


    public static class AbsentContactException extends RuntimeException {
    }
}
