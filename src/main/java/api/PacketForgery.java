package api;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.net.ssl.SSLSocketFactory;
import util.SocketFactory;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PacketForgery {
    
    public static void main(String[] args) throws IOException{
        sendPacket();
    }
    public static void sendPacket() throws IOException{
        
            InetAddress address = InetAddress.getByName("192.168.56.1");
            javax.net.SocketFactory s = new SocketFactory(address);
            OkHttpClient client = new OkHttpClient().newBuilder().socketFactory(s).build();

            Request request = new Request.Builder()
            .url("http://192.168.56.102:80/")
            .get()
            .build();

            Response response = client.newCall(request).execute();
            System.out.println(response.code());

    }

}
