package com.gumtree;

import org.junit.Test;

import java.time.format.DateTimeParseException;

import static org.junit.Assert.assertEquals;

/**
 * Created by dgomez on 25/2/16.
 */
public class ContactTest {

    @Test
    public void createContact(){
        Contact c = new Contact("Domingo Gómez, Male, 29/03/83");
        assertEquals("Name not parsed properly", "Domingo Gómez", c.getName());
    }

    @Test(expected = Contact.UnableToParseContactException.class)
    public void noSeparator(){
        new Contact("foobar");
    }

    @Test(expected = DateTimeParseException.class)
    public void unparsableDate(){
        new Contact("Domingo Gómez, Male, AA/BB/CC");
    }

    @Test(expected = Contact.UnableToParseContactException.class)
    public void tooManyColumns(){
        new Contact("Domingo Gómez, Male, 29/03/83, Spain");
    }
}
