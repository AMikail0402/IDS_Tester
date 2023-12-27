package util;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class DbServices {
    
    public static void main(String[] args) throws IOException{
        OkHttpClient client = new OkHttpClient();
        checkDbAvailability(client);
    }

    public static void checkDbAvailability(OkHttpClient client) throws IOException{
            Request request = new Request.Builder()
            .url("http://localhost:3001/api/")
            .get()
            .addHeader("Content-Type", "application/json")
            .build();

            Response response = client.newCall(request).execute();
    }

    public static void truncateDb(OkHttpClient client) throws IOException{
            Request request = new Request.Builder()
            .url("http://localhost:3001/clean")
            .delete(null)
            .addHeader("User-Agent", "insomnia/2023.5.8")
            .build();

            Response response = client.newCall(request).execute();
    }

    public static void postEntryDb(OkHttpClient client) throws IOException{
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create("{\n\t\"cve\": \"CVE-2023-1237\",\n\t\"msg\": \"API-Test\",\n\t\"time\": \"420\",\n\t\"src_address\": \"Test-QuellAddresse\"\n}",mediaType);
            Request request = new Request.Builder()
            .url("http://localhost:3001/api/users")
            .post(body)
            .addHeader("Content-Type", "application/json")
            .addHeader("User-Agent", "insomnia/2023.5.8")
            .build();

            Response response = client.newCall(request).execute();
            System.out.println(response.code());
    }
}
