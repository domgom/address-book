package com.gumtree;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by dgomez on 24/2/16.
 */
public class Contact {
    private static final String SEPARATOR = ", ";
    private static final int NUM_COLUMNS = 3;
    private static final String DATE_PATTERN = "dd/MM/yy";

    private String name;
    private Gender gender;
    private LocalDate date;

    private Contact(){
    }

    public Contact(String csv) {
        String[] chunks = csv.split(SEPARATOR);

        if(chunks.length != NUM_COLUMNS){
            throw new UnableToParseContactException();
        }

        name = chunks[0];
        gender = Gender.fromString(chunks[1]);
        date = LocalDate.parse(chunks[2], DateTimeFormatter.ofPattern(DATE_PATTERN));
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDate() {
        return date;
    }

    private class UnableToParseContactException extends RuntimeException{
    }
}
