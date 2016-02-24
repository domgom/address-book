package com.gumtree;

import java.util.Arrays;

/**
 * Created by dgomez on 24/2/16.
 */
public enum Gender {
    MALE("Male"), FEMALE("Female");

    private final String representation;

    Gender(String representation) {
        this.representation = representation;
    }

    public static Gender fromString(String representation) {

        return Arrays.stream(Gender.values()).
                filter(gender -> gender.representation.equals(representation)).
                findFirst().
                orElseThrow(IllegalArgumentException::new);
    }
}
