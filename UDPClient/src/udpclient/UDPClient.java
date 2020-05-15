/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author Yan
 */
public class UDPClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatagramSocket aSocket = null;
        try {
            aSocket = new DatagramSocket();
            String mens = args[0];
            byte[] m = mens.getBytes();
            InetAddress aHost = InetAddress.getByName("127.0.0.1");
            int serverPort = 7000;
            DatagramPacket request = new DatagramPacket(m, mens.length(), aHost, serverPort);
            aSocket.send(request);
        } catch (SocketException e) {
            System.out.println("Socket: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO: " + e.getMessage());
        } finally {
            if (aSocket != null) {
                aSocket.close();
            }
        }
    }

}
