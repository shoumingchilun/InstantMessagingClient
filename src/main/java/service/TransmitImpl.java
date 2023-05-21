package service;

import util.*;

/**
 * @auther 齿轮
 * @create 2023-05-21-21:21
 */
public class TransmitImpl implements transmit {
    private RollBack rollBack;

    public TransmitImpl(RollBack rollBack) {
        this.rollBack = rollBack;
    }

    @Override
    public void init() {
        Utils.init();
    }

    @Override
    public void login(String name, String password) {
        ClientLoginImpl clientLogin = new ClientLoginImpl(name, password, rollBack);
        Thread thread = new Thread(clientLogin);
        thread.start();
    }

    @Override
    public void sendMessage(String name, String message) {
        TCPTransmitSend tcpTransmit = new TCPTransmitSend(message, name);
        Thread thread2 = new Thread(tcpTransmit);
        thread2.start();
    }
}
