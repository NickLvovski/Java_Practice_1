package org.ru.filatov.task1;

import org.apache.commons.lang3.math.NumberUtils;
import org.ru.filatov.task3.OfferStatistics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.UUID;

public class LeasingOfferService implements OfferService {
    private static final LeasingOfferService INSTANCE = new LeasingOfferService();

    private final OfferStatistics offerStatistics = new OfferStatistics();

    private LeasingOfferService(){
    }

    public static LeasingOfferService getInstance() {
        return INSTANCE;
    }

    @Override
    public Offer signNewOffer(final LocalDateTime startDate, final LocalDateTime endingDate, final Client client, final Stuff stuff) {
        final UUID id = UUID.randomUUID();
        final LocalDateTime signDate = LocalDateTime.now();
        final String serialNumber;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String readedLine;
            // А вообще serialNumber обычно как-то сам генерируется
            // редко, когда пользователи сами его вводят
            do {
                System.out.println("Серийный номер должен содержать 6 цифр.");
                System.out.print("Введите серийный номер контракта: ");
                readedLine = reader.readLine();
                // Что хорошего в том, что две проверки - в том, что нет break
                // Что плохого - то, что две проверки - а это может привести в ошибкам в коде
                // разработчик поменяет одно условие, забудет про другое
                if (readedLine.length() != 6 || !NumberUtils.isParsable(readedLine)) {
                    System.out.println("Неверный формат серийного номера!");
                }
            }
            while(readedLine.length() != 6 || !NumberUtils.isParsable(readedLine));
            serialNumber = readedLine;
        } catch (IOException e) {
            System.out.println("Ошибка IO");
            return null;
        }

        final Offer offer = new Offer(id, serialNumber, signDate, endingDate, startDate);

        offerStatistics.addOffer(offer);
        offerStatistics.addClientSurname(client);
        offerStatistics.addOfferByClient(client, offer);
        offerStatistics.addOfferByStuff(stuff, offer);

        return offer;
    }
}
