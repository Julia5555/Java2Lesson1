package client;

import java.io.*;
import java.net.Socket;

public class Client {
    Socket socket;
    DataInputStream in;
    DataOutputStream out;

    final String IP_ADDRES = "localhost";
    final int PORT = 8383;

    public Client() {
        try {
            socket = new Socket(IP_ADDRES, PORT);
            System.out.println("Start client...");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String str = null;

            while (true) {
                str = buff.readLine();
                out.writeUTF(str);
                out.flush();
                str = in.readUTF();
                System.out.println("Server text: " + str);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
