package com.example.mtp;


import com.example.mtp.packages.MTPPacket;
import com.example.mtp.packages.registration.MTPRegistrationError;
import com.example.mtp.packages.registration.MTPRegistrationRequest;
import com.example.mtp.packages.registration.MTPRegistrationSuccess;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

class MTP {

    private InetAddress ipTarget;
    private int port;
    private DatagramSocket socket;


    public MTP(InetAddress ipTarget, int port) {
        try {
            this.ipTarget = ipTarget;
            this.port = port;
            socket = new DatagramSocket();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void sendPacket(MTPPacket packet) {
        try {
            socket.send(new DatagramPacket(
                    packet.bytePacket,
                    packet.bytePacket.length,
                    ipTarget,
                    port
            ));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("packet = " + packet);
    }

    public MTPPacket receivePacket() {
        byte[] receiveBuff = new byte[32];
        try {
            socket.receive(new DatagramPacket(
                    receiveBuff,
                    receiveBuff.length
            ));

            PacketOperationCode type = PacketOperationCode.findByValue(receiveBuff[0]);
            if (type != null) {
                System.out.println("MTS.receivePacket");
                switch (type) {
                    case REQ_REGISTRAZIONE:
                        return new MTPRegistrationRequest(receiveBuff);
                    case REG_SUCCESS:
                        return new MTPRegistrationSuccess(receiveBuff);
                    case REG_ERROR:
                        return new MTPRegistrationError(receiveBuff);
                    default:
                        return null;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("receiveBuff = " + Arrays.toString(receiveBuff));
        return null;
    }
}