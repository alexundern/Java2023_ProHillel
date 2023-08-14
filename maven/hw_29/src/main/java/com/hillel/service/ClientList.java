package com.hillel.service;

import java.util.ArrayList;
import java.util.List;

public class ClientList {
    public static final List<String> CLIENTS_LIST =
            List.of("Nina", "Charlotte", "Destin", "Ray", "Meliza", "Oliver", "James", "Emma", "William", "Liam");

    public static List<String> getList(List<String> clients, int countClients) {
        ArrayList<String> arrayList = new ArrayList<>(countClients);
        for (int i = 0; i < countClients; i++) {
            arrayList.add(clients.get((int) (Math.random() * clients.size())));
        }
        return arrayList;
    }

    public static String client(List<String> clients) {
        return clients.get((int) (Math.random() * clients.size()));
    }
}
