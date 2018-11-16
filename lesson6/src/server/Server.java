package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    DataInputStream in;
    DataOutputStream out;

    public Server() {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8383);
            System.out.println("Start server...");

            while (true) {
                socket = server.accept();
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

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
