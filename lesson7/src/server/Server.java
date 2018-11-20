package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {
    private Vector<ClientHandler> clients;

    public Server() {
        AuthService.connect();
        clients = new Vector<>();
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8183);
            System.out.println("Сервер запущен!");

            while (true) {
                socket = server.accept();
                System.out.println("Клиент подключился");
//                clients.add(new ClientHandler(this, socket));
                new ClientHandler(this, socket);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            AuthService.disconnect();
        }
    }

    public void broadcastMsg(String msg, String nick) {
        String[] mas = msg.split("/w");
        boolean isNick = false;
        if(mas.length > 1){
            if(mas[1].equals(nick)){
                isNick = true;
            }
        }
        if(isNick){
            for (ClientHandler o : clients) {
                if(o.getNick().equals(nick)){
                    o.sendMsg("личное сообщение для " + nick +": "+msg);
                }
            }
        }else{
            for (ClientHandler o : clients) {
                    o.sendMsg(nick +": "+ msg);

            }
        }

    }

    public void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }

    public void unsubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }


}
