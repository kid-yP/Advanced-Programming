package SocketSumProduct;
import java.io.*;
import java.net.*;

class SharedResult {
    int sum;
    int product;
}

class SumThread extends Thread {
    int a, b;
    SharedResult result;

    SumThread(int a, int b, SharedResult result) {
        this.a = a;
        this.b = b;
        this.result = result;
    }

    public void run() {
        result.sum = a + b;
    }
}

class ProductThread extends Thread {
    int a, b;
    SharedResult result;

    ProductThread(int a, int b, SharedResult result) {
        this.a = a;
        this.b = b;
        this.result = result;
    }

    public void run() {
        result.product = a * b;
    }
}

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("Server started, waiting for client...");

        Socket socket = serverSocket.accept();
        System.out.println("Client connected.");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        int a = in.readInt();
        int b = in.readInt();

        SharedResult result = new SharedResult();

        SumThread sumThread = new SumThread(a, b, result);
        ProductThread prodThread = new ProductThread(a, b, result);

        sumThread.start();
        prodThread.start();

        try {
            sumThread.join();
            prodThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        out.writeInt(result.sum);
        out.writeInt(result.product);

        socket.close();
        serverSocket.close();
        System.out.println("Server closed.");
    }
}
