package util;

import java.io.IOException;

import Request.Callback;
import Enum.Address;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DbServices {
    static String address = Address.ADDRESS.getAddress();
    public static void main(String[] args) throws IOException{
        OkHttpClient client = new OkHttpClient();
        checkDbAvailability(client);
    }

    public static Callback checkDbAvailability(OkHttpClient client) throws IOException{
            Request request = new Request.Builder()
            .url("http://"+address+":3001/api/")
            .get()
            .addHeader("Content-Type", "application/json")
            .build();

            Response response = client.newCall(request).execute();
            int code = response.code();
            if(code == 200){
                return new Callback(code,"DB ist erreichbar");
            }
            else{
                return new Callback(code, "DB ist nicht erreichbar");
            }
    }

    public static Callback truncateDb(OkHttpClient client) throws IOException{
            Request request = new Request.Builder()
            .url("http://"+address+":3001/clean")
            .delete(null)
            .addHeader("User-Agent", "insomnia/2023.5.8")
            .build();

            Response response = client.newCall(request).execute();
            int code = response.code();
            if(code == 200){
                return new Callback(code,"Tabelle konnte gelöscht werden");
            }
            else{
                return new Callback(code, "Tabelle konte nicht geleert werden");
            }
    }

    public static Callback postEntryDb(OkHttpClient client) throws IOException{
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create("{\n\t\"cve\": \"CVE-2023-1237\",\n\t\"msg\": \"API-Test\",\n\t\"time\": \"420\",\n\t\"src_address\": \"Test-QuellAddresse\"\n}",mediaType);
            Request request = new Request.Builder()
            .url("http://"+address+":3001/api/users")
            .post(body)
            .addHeader("Content-Type", "application/json")
            .addHeader("User-Agent", "insomnia/2023.5.8")
            .build();

            Response response = client.newCall(request).execute();
            int code = response.code();
            if(code == 200){
                return new Callback(code,"Tabelleneintrag konnte erstellt werden");
            }
            else{
                return new Callback(code, "Tabelleneintrag konnte nicht erstellt werden");
            }
    }

    public static Callback sendNginx(OkHttpClient client) throws IOException{
        Request request = new Request.Builder()
            .url("http://"+address+":80")
            .get()
            .addHeader("Content-Type", "application/json")
            .build();

            Response response = client.newCall(request).execute();
            int code = response.code();
            if(code == 200){
                return new Callback(code,"Server konnte erreicht werden");
            }
            else{
                return new Callback(code, "Server konnte nicht erreicht werden");
            }
    }
}
