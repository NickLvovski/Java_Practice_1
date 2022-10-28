package org.ru.filatov.task3;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.ru.filatov.task1.Client;
import org.ru.filatov.task1.Offer;
import org.ru.filatov.task1.Stuff;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OfferStatistics {
    private final List<Offer> offers = new LinkedList<>();
    private final Map<Stuff, List<Offer>> offersByStuff = new HashMap<>();
    private final Map<Client, List<Offer>> offersByClients = new HashMap<>();
    private final Set<String> clientSurnames = new HashSet<>();

    // private OfferStatistics(){} // хороший ход для статических-утилитных классов

    public void addOffer(Offer offer){
        offers.add(offer);
    }

    public void addOfferByStuff(Stuff stuff, Offer offer) {
        List<Offer> offerList;
        if (offersByStuff.containsKey(stuff)) {
            offerList = offersByStuff.get(stuff);
        } else{
            offerList = new LinkedList<>();
        }
        offerList.add(offer);
        offersByStuff.put(stuff, offerList);
    }

    public void addOfferByClient(Client client, Offer offer){
        List<Offer> offerList;
        if(offersByClients.containsKey(client)){
            offerList = offersByClients.get(client);
        } else{
            offerList = new LinkedList<>();
        }
        offerList.add(offer);
        offersByClients.put(client, offerList);
    }

    public void addClientSurname(@NotNull Client client){
        clientSurnames.add(client.getSurname());
    }

    public List<Offer> getOffersByStuff(Stuff stuff){
        return offersByStuff.getOrDefault(stuff, null);
    }

    public List<Offer> getOffersByClient(Client client){
        return offersByClients.getOrDefault(client, null);
    }

    public String getClientSurnames(){
        return clientSurnames.toString();
    }

    @Nullable
    public Offer findBySerialNumber(String number){
        for (Offer offer: offers) {
            if (offer.getSerialNumber().equals(number)) return offer;
        }
        return null;
    }

    @Nullable
    public List<Offer> findByClientSurname(String surname){
        for (Client client: offersByClients.keySet()){
            if (surname.equals(client.getSurname())) {
                return offersByClients.get(client);
            }
        }
        return null;
    }

    public List<Offer> findByStuff(Stuff stuff){
        return offersByStuff.getOrDefault(stuff, null);
    }
}
