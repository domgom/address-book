package com.gumtree.specification;

import com.gumtree.Contact;
import com.gumtree.Gender;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static com.gumtree.util.ImmutableListCollector.toImmutableList;
import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;
import static org.junit.Assert.assertEquals;

/**
 * Created by dgomez on 25/2/16.
 */
public class OldestContactTest {

    private static List<Contact> fixture = Stream.of(
            new Contact("Domingo Gómez, Male, 29/03/83"),
            new Contact("Foo, Male, 01/01/00"),
            new Contact("Bar, Female, 31/12/99")).
            collect(toImmutableList());

    @Test
    public void ageCalculation(){
        assertEquals("Wrong age calculation", new OldestContact().eval(fixture).map(Contact::getName).get(), "Foo");
    }

    @Test
    public void ageCalculationOnEmptyList(){
        List<Contact> emptyContacts = unmodifiableList(emptyList());
        assertEquals("Age found in empty list", new OldestContact().eval(emptyContacts).isPresent(), false);
    }
}
