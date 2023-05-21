package util;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther 齿轮
 * @create 2023-05-20-19:56
 */
public class TCPTransmitSend implements TransmitSend, Runnable {
    String goalName;
    String message;

    public TCPTransmitSend(String message, String goalName) {
        this.message = message;
        this.goalName = goalName;
    }

    @Override
    public void run() {
        sendMessage(goalName, message);
    }

    @Override
    public void sendMessage(String goalName, String message) {
        Utils.pw.println("OneLineMessage");
        Utils.pw.println(goalName);//第一行为目的用户
        Utils.pw.println(message);//之后的都是信息
        Utils.pw.println("bye");//代表发送结束
    }
}
