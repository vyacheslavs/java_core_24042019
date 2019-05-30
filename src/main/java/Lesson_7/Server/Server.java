package Lesson_7.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {

    public Auth auth = new Auth();
    private Vector<ClientHandler> clients;
    final int PORT = 10000;

    public Server() {
        ServerSocket server = null;
        Socket socket = null;
        clients = new Vector<>();

        try {
            auth.connect();
            server = new ServerSocket(PORT);
            System.out.println("Server started");

            while (true) {
                socket = server.accept();
                System.out.println("new client accepted");
                subscribe(new ClientHandler(socket, this));
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

            auth.disconnect();
        }
    }

    public void subscribe(ClientHandler client) {
        clients.add(client);
    }

    public void unsubscribe(ClientHandler client) {
        clients.remove(client);
    }

    public void broadcastMsg(String msg) {
        for (ClientHandler o: clients) {
            o.sendMsg(msg);
        }
    }

    public void unicast(String nick, String msg) {

        // тут лучше всего использовать конечно какой нибудь
        // другой контейнер чтобы не искать клиента линейно
        // но Vector синхронизирован и просто так сейчас заменить его
        // накладно. Времени пока нет

        for (ClientHandler o: clients) {
            String n = o.getNick();
            if (n!=null && n.equals(nick)) {
                o.sendMsg(msg);
            }
        }
    }

    public boolean alreadyLoggedIn(String nick) {
        for (ClientHandler o: clients) {
            String n = o.getNick();
            if (n!=null && n.equals(nick))
                return true;
        }
        return false;
    }
}
