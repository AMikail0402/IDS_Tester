package ids.tester;


import java.io.IOException;

import org.junit.jupiter.api.Assertions;

import Enum.Address;
import Request.Callback;
import api.Controller;
import io.cucumber.java.Before;
import io.cucumber.java.de.*;
import okhttp3.OkHttpClient;

public class StepDefinitions {
    static OkHttpClient client;
    @Before
    public void setup(){
        this.client = new OkHttpClient(); 
    }
    @Dann("Drucke die Umgebungsvariable")
    public void printEnv(){
        System.out.println("////////////TEST");
        System.out.println("/////////////Adresse"+Address.ADDRESS.getAddress());
    }
     @Dann("Ueberpruefe die Verfuegbarkeit der Api")
    public void checkDb() throws IOException{
        Callback cb = Controller.checkDbAvailability(client);
        Assertions.assertEquals(200, cb.getCode(),cb.getBody());
    }
   
    @Dann("Sende Pakete an Nginx")
    public void packetsToNginx() throws IOException{
        Callback cb = Controller.sendNginx(client);
        Assertions.assertEquals(200, cb.getCode(),cb.getBody());
    }

}
