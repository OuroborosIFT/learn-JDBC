package com.ars.db.contacts;

import com.ars.db.contacts.interaction.Interaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactMain {
    public static void main(String[] args) {
        SpringApplication.run(ContactMain.class, args);

	Interaction interact = new Interaction();

	interact.session();


    }
}
