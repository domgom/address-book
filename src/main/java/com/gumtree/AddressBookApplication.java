package com.gumtree;

import com.gumtree.specification.DaysOlderBillThanPaul;
import com.gumtree.specification.HowManyOfGenderMale;
import com.gumtree.specification.OldestContact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class AddressBookApplication {

    private static final Logger LOG = LoggerFactory.getLogger(AddressBookApplication.class);

    private static final String ADDRESS_BOOK_FILE = "AddressBook";
    private static final int ERROR_STATUS = 1;

    AddressBookApplication(){
        //Needed for Spring Boot
    }

    public static void main(String[] args) {

        try {
            SpringApplication.run(AddressBookApplication.class, args);

            List<Contact> contacts = AddressBookReader.read(ADDRESS_BOOK_FILE);

            LOG.info("1. There are {} males.", new HowManyOfGenderMale().eval(contacts));

            Optional<Contact> oldest = new OldestContact().eval(contacts);
            if(oldest.isPresent()) {
                LOG.info("2. The oldest person is {}.",oldest.get().getName());
            }

            LOG.info("3. Bill is {} days older than Paul.", new DaysOlderBillThanPaul().eval(contacts));

        } catch (RuntimeException anyException) {
            LOG.error("Runtime Exception: aborting execution", anyException);
            System.exit(ERROR_STATUS);
        }

    }
}
