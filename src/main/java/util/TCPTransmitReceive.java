package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

/**
 * @auther 齿轮
 * @create 2023-05-20-23:31
 */
public class TCPTransmitReceive implements TransmitReceive, Runnable {
    Socket socket;
    RollBack rollBack;
    BufferedReader br;

    public TCPTransmitReceive(RollBack rollBack) {
        this.socket = Utils.clientSocket;
        this.br = Utils.br;
        this.rollBack = rollBack;
    }

    @Override
    public void run() {
        receive();
    }

    @Override
    public void receive() {
        try {
            String line;
            String name = null;
            int count = 0;
            while ((line = br.readLine()) != null) {
                if (count == 0) {
                    count++;
                    name = line;
                } else if ("bye".equals(line)) {//接收完成，进行处理
                    rollBack.Receive(name, Utils.builder.toString());
                    Utils.builder = new StringBuilder();
                } else {
                    Utils.builder.append(line + "\n");
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
