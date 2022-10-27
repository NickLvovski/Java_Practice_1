package org.ru.filatov.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.ru.filatov.task1.Client;

import java.io.File;
import java.io.IOException;

public class CredentialsWriter {
    public static void writeJSON(Client client){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File("src/main/resources/client.json"), client);
        }
        catch (IOException e){
            System.out.println("IOException");
        }
    }
}
