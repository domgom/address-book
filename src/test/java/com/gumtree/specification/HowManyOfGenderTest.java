package com.gumtree.specification;

import com.gumtree.Contact;
import com.gumtree.Gender;
import com.gumtree.util.ImmutableListCollector;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static com.gumtree.util.ImmutableListCollector.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by dgomez on 25/2/16.
 */
public class HowManyOfGenderTest {

    private static List<Contact> fixture = Stream.of(
            new Contact("Domingo Gómez, Male, 29/03/83"),
            new Contact("Foo, Male, 01/01/00"),
            new Contact("Bar, Female, 31/12/99")).
            collect(toImmutableList());

    @Test
    public void genderCount(){
        assertEquals("Wrong number of males", new HowManyOfGender(Gender.MALE).eval(fixture).longValue(), 2L);
        assertEquals("Wrong number of females", new HowManyOfGender(Gender.FEMALE).eval(fixture).longValue(), 1L);
    }
}
