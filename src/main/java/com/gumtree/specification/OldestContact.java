package com.gumtree.specification;

import com.gumtree.Contact;

import java.util.List;
import java.util.Optional;

/**
 * Created by dgomez on 24/2/16.
 */
public class OldestContact implements Specification<Contact, Optional<Contact>> {

    @Override
    public Optional<Contact> eval(List<Contact> contacts) {

        return contacts.stream().min((a, b) -> a.getDate().compareTo(b.getDate()));
    }
}
