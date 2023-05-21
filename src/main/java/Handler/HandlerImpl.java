package Handler;

import util.RollBack;
import util.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

/**
 * @auther 齿轮
 * @create 2023-05-21-22:37
 */
public class HandlerImpl implements Handler {
    Socket socket;
    RollBack rollBack;
    BufferedReader br;

    public HandlerImpl(Socket socket, RollBack rollBack, BufferedReader br) {
        this.socket = socket;
        this.rollBack = rollBack;
        this.br = br;
    }

    public void handle() throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            if (line.equals("OneLineMessage")) {
                OneLineMessage();
            }
        }
    }

    private void OneLineMessage() throws IOException {
        String line;
        String name = null;
        int count = 0;
        while ((line = br.readLine()) != null) {
            if (count == 0) {
                count++;
                name = line;
            } else if (count == 2 && "bye".equals(line)) {//接收完成，进行处理
                rollBack.Receive(name, Utils.builder.toString());
                Utils.builder = new StringBuilder();
                return;
            } else if (count == 1) {
                count++;
                Utils.builder.append(line);
            }
        }
    }
}
