package org.example;

import org.ru.filatov.task1.Client;
import org.ru.filatov.task2.CredentialsInput;
import org.ru.filatov.task2.CredentialsWriter;

public class Main {
    public static void main(String[] args) {
        //LeasingOfferService service = LeasingOfferService.getInstance();

        //Offer offer = service.signNewOffer(LocalDateTime.now(), LocalDateTime.now(), new Client(), new Stuff());
        Client client = CredentialsInput.input();
        CredentialsWriter.writeJSON(client);
    }
}