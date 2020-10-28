package org.academiadecodigo.com;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostNameMain {

    public static void getHostIP(String [] websites) throws UnknownHostException {
        for (String s : websites) {
            System.out.println(InetAddress.getByName(s));
        }
    }

    public static void getReachability (String[] websites) throws IOException {
        for (String s : websites) {
            System.out.println(InetAddress.getByName(s).isReachable(100));
        }
    }


    public static void main(String[] args) throws IOException {

        String [] websites = {"www.google.pt", "www.academiadecodigo.org", "www.expresso.pt", "www.globo.com"};

        getHostIP(websites);
        getReachability(websites);

    }
}
