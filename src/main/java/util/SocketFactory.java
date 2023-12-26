package util;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;


public class SocketFactory extends javax.net.SocketFactory{

    private final InetAddress localHost;

    public SocketFactory(InetAddress localHost) {
        this.localHost = localHost;
    }

    @Override
    public Socket createSocket() throws IOException{
        String addr = this.localHost.toString().replace("/", "");
        System.out.println(addr);
        java.net.Socket s = javax.net.SocketFactory.getDefault().createSocket();
        s.bind(new InetSocketAddress(addr, 7543));
        return s;
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException, UnknownHostException {
         return javax.net.SocketFactory.getDefault().createSocket(host, port);
    }

    @Override
    public Socket createSocket(String host, int port, InetAddress localHost, int localPort) throws UnknownHostException, IOException{
           return javax.net.SocketFactory.getDefault().createSocket(host, port,localHost,localPort);
    }

    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
       return javax.net.SocketFactory.getDefault().createSocket(host, port);
    }

    @Override
    public Socket createSocket(InetAddress address, int port, InetAddress localAddress, int localPort)
            throws IOException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createSocket'");
    }

}
