package org.ru.filatov.task3;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.ru.filatov.task1.Client;
import org.ru.filatov.task1.Offer;
import org.ru.filatov.task1.Stuff;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class OfferStatistics {
    private static final LinkedList<Offer> OFFERS = new LinkedList<>();
    private static final HashMap<Stuff, LinkedList<Offer>> OFFERS_BY_STUFF = new HashMap<>();
    private static final HashMap<Client, LinkedList<Offer>> OFFERS_BY_CLIENTS = new HashMap<>();
    private static final HashSet<String> CLIENT_SURNAMES = new HashSet<>();

    private OfferStatistics(){}

    public static void addOffer(Offer offer){
        OFFERS.add(offer);
    }

    public static void addOfferByStuff(Stuff stuff, Offer offer) {
        LinkedList<Offer> offerList;
        if (OFFERS_BY_STUFF.containsKey(stuff)) {
            offerList = OFFERS_BY_STUFF.get(stuff);
        } else{
            offerList = new LinkedList<>();
        }
        offerList.add(offer);
        OFFERS_BY_STUFF.put(stuff, offerList);
    }

    public static void addOfferByClient(Client client, Offer offer){
        LinkedList<Offer> offerList;
        if(OFFERS_BY_CLIENTS.containsKey(client)){
            offerList = OFFERS_BY_CLIENTS.get(client);
        } else{
            offerList = new LinkedList<>();
        }
        offerList.add(offer);
        OFFERS_BY_CLIENTS.put(client, offerList);
    }

    public static void addClientSurname(@NotNull Client client){
        CLIENT_SURNAMES.add(client.getSurname());
    }

    public static LinkedList<Offer> getOffersByStuff(Stuff stuff){
        return OFFERS_BY_STUFF.getOrDefault(stuff, null);
    }

    public static LinkedList<Offer> getOffersByClient(Client client){
        return OFFERS_BY_CLIENTS.getOrDefault(client, null);
    }

    public static String getClientSurnames(){
        return CLIENT_SURNAMES.toString();
    }

    @Nullable
    public static Offer findBySerialNumber(String number){
        for (Offer offer: OFFERS) {
            if (offer.getSerialNumber().equals(number)) return offer;
        }
        return null;
    }

    @Nullable
    public static LinkedList<Offer> findByClientSurname(String surname){
        for (Client client: OFFERS_BY_CLIENTS.keySet()){
            if (surname.equals(client.getSurname())) return OFFERS_BY_CLIENTS.get(client);
        }
        return null;
    }
    public static LinkedList<Offer> findByStuff(Stuff stuff){
        return OFFERS_BY_STUFF.getOrDefault(stuff, null);
    }
}
