package org.ru.filatov.task1;

import java.time.LocalDateTime;

public interface OfferService {
    Offer signNewOffer(LocalDateTime startDate, LocalDateTime endingDate, Client client, Stuff stuff);
}
