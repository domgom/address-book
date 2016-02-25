package com.gumtree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static com.gumtree.util.ImmutableListCollector.toImmutableList;

/**
 * Created by dgomez on 24/2/16.
 */
public class AddressBookReader {

    private static final Logger LOG = LoggerFactory.getLogger(AddressBookReader.class);

    private AddressBookReader(){
    }

    public static List<Contact> read(String path) {

        try (Stream<String> lines = getLines(path)) {

            return lines.map(Contact::new).collect(toImmutableList());

        } catch (IOException | URISyntaxException | NullPointerException e) {

            LOG.error("Address Book file not found", e);
            throw new AddressBookNotFound();
        }
    }

    private static Stream<String> getLines(String path) throws IOException, URISyntaxException {
        return Files.lines(Paths.get(ClassLoader.getSystemResource(path).toURI()));
    }

    public static class AddressBookNotFound extends RuntimeException {
    }

}
