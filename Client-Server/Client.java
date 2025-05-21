package SocketSumProduct;
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);
        System.out.println("Connected to server.");

        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        int a = 7;
        int b = 3;
        out.writeInt(a);
        out.writeInt(b);

        int sum = in.readInt();
        int product = in.readInt();

        System.out.println("Received from server:");
        System.out.println("Sum = " + sum);
        System.out.println("Product = " + product);

        socket.close();
    }
}
