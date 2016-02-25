package com.gumtree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by dgomez on 25/2/16.
 */
public class GenderTest {

    @Test
    public void genderFromString(){
        assertEquals("Male not found in Gender enum", Gender.fromString("Male"), Gender.MALE);
        assertEquals("Female not found in Gender enum", Gender.fromString("Female"), Gender.FEMALE);
    }

    @Test(expected = IllegalArgumentException.class)
    public void maleWrongCaseGenderFromString(){
        Gender.fromString("MAle");
    }

    @Test(expected = IllegalArgumentException.class)
    public void genderNotEnumeratedFromString(){
        Gender.fromString("Hermaphrodite");
    }
}
