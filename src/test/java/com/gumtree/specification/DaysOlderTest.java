package com.gumtree.specification;

import com.gumtree.Contact;
import com.gumtree.util.ImmutableListCollector;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static com.gumtree.util.ImmutableListCollector.toImmutableList;
import static org.junit.Assert.assertEquals;

/**
 * Created by dgomez on 25/2/16.
 */
public class DaysOlderTest {

    private static List<Contact> fixture = Stream.of(
            new Contact("Domingo Gómez, Male, 29/03/83"),
            new Contact("Foo, Male, 01/01/00"),
            new Contact("Bar, Female, 31/12/99")).
            collect(toImmutableList());

    @Test
    public void findContactsInList(){
        assertEquals("Could not find Foo or Bar", new DaysOlder("Foo","Bar").eval(fixture).longValue(), 36524L);
    }

    @Test(expected = DaysOlder.AbsentContactException.class)
    public void contactNotInList(){
        new DaysOlder("X","Bar").eval(fixture);
    }
}
