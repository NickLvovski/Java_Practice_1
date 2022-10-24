package org.ru.filatov.task1;

import org.apache.commons.lang3.math.NumberUtils;

import java.time.LocalDateTime;
import java.util.UUID;

public class LeasingOfferService implements OfferService {
    private static final LeasingOfferService INSTANCE = new LeasingOfferService();
    private LeasingOfferService(){}

    public static LeasingOfferService getInstance() {
        return INSTANCE;
    }

    @Override
    public Offer signNewOffer(LocalDateTime startDate, LocalDateTime endingDate, Client client, Stuff stuff) {
        UUID id = UUID.randomUUID();
        LocalDateTime signDate = LocalDateTime.now();
        String serialNumber;

        do{
            System.out.println("Серийный номер должен содержать 6 цифр.");
            System.out.print("Введите серийный номер контракта: ");
            serialNumber = new java.util.Scanner(System.in).nextLine();
            if (serialNumber.length() != 6 || !NumberUtils.isParsable(serialNumber))
            {
                System.out.println("Неверный формат серийного номера!");
            }
        }
        while(serialNumber.length() != 6 || !NumberUtils.isParsable(serialNumber));

        return new Offer(id, serialNumber, signDate, endingDate, startDate);
    }
}
