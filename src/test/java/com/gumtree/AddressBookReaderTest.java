package com.gumtree;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by dgomez on 25/2/16.
 */
public class AddressBookReaderTest {

    @Test()
    public void existingFile(){
        List<Contact> contactList = AddressBookReader.read("AddressBookTest");
        assertEquals("AddressBookTest file has not Contact", 1, contactList.size());
    }

    @Test(expected = AddressBookReader.AddressBookNotFound.class)
    public void unexistingFile(){
        AddressBookReader.read("not a path");
    }
}
