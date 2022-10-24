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
    private static final LinkedList<Offer> offers = new LinkedList<>();
    private static final HashMap<Stuff, LinkedList<Offer>> offersByStuff = new HashMap<>();
    private static final HashMap<Client, LinkedList<Offer>> offersByClients = new HashMap<>();
    private static final HashSet<String> clientSurnames = new HashSet<>();

    private OfferStatistics(){}
    
    public static void addOffer(Offer offer){
        offers.add(offer);
    }

    public static void addOfferByStuff(Stuff stuff, Offer offer) {
        LinkedList<Offer> offerList;
        if (offersByStuff.containsKey(stuff)) {
            offerList = offersByStuff.get(stuff);
        } else{
             offerList = new LinkedList<>();
        }
        offerList.add(offer);
        offersByStuff.put(stuff, offerList);
    }

    public static void addOfferByClient(Client client, Offer offer){
        LinkedList<Offer> offerList;
        if(offersByClients.containsKey(client)){
            offerList = offersByClients.get(client);
        } else{
            offerList = new LinkedList<>();
        }
        offerList.add(offer);
        offersByClients.put(client, offerList);
    }

    public static void addClientSurname(@NotNull Client client){
        clientSurnames.add(client.getSurname());
    }

    public static LinkedList<Offer> getOffersByStuff(Stuff stuff){
        return offersByStuff.getOrDefault(stuff, null);
    }

    public static LinkedList<Offer> getOffersByClient(Client client){
        return offersByClients.getOrDefault(client, null);
    }

    public static String getClientSurnames(){
        return clientSurnames.toString();
    }

    @Nullable
    public static Offer findBySerialNumber(String number){
        for (Offer offer: offers) {
            if (offer.getSerialNumber().equals(number)) return offer;
        }
        return null;
    }

    @Nullable
    public static LinkedList<Offer> findByClientSurname(String surname){
        for (Client client: offersByClients.keySet()){
            if (surname.equals(client.getSurname())) return offersByClients.get(client);
        }
        return null;
    }
    public static LinkedList<Offer> findByStuff(Stuff stuff){
        return offersByStuff.getOrDefault(stuff, null);
    }
}
