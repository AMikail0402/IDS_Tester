package api;

import java.io.IOException;

import Request.Callback;
import okhttp3.OkHttpClient;
import util.DbServices;

public class Controller {

    public static Callback checkDbAvailability(OkHttpClient client) throws IOException{
                   return DbServices.checkDbAvailability(client);
    }

    public static Callback sendApi(OkHttpClient client) throws IOException{
        Callback cb = new Callback(0, null);
                for(int i=0; i<2;i++){
                    cb = DbServices.checkDbAvailability(client);
                    if(cb.getCode() != 200){
                        return new Callback(cb.getCode(), cb.getBody());
                    }
                }
        return new Callback(cb.getCode(), cb.getBody());
    }
 
    }

