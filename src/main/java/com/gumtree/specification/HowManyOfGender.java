package com.gumtree.specification;

import com.gumtree.Contact;
import com.gumtree.Gender;

import java.util.List;

/**
 * Created by dgomez on 24/2/16.
 */
public class HowManyOfGender implements Specification<Contact, Long> {

    private Gender gender;

    HowManyOfGender(Gender gender){
        this.gender = gender;
    }

    @Override
    public Long eval(List<Contact> contacts) {

        return contacts.stream().filter(contact -> gender.equals(contact.getGender())).count();
    }
}
