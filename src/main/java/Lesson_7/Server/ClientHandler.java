package Lesson_7.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;
    private Server server;
    private String nick;

    public String getNick() {
        return nick;
    }

    public ClientHandler(Socket socket, Server server) {
        try {
            this.socket = socket;
            this.server = server;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String str = in.readUTF();
                            if(str.equals("/end")) {
                                System.out.println("client exits...");
                                break;
                            }

                            if (str.startsWith("/auth")) {
                                String _nick = server.auth.chatAuthenticate(str);
                                if (_nick != null && !server.alreadyLoggedIn(_nick)) {
                                    nick = _nick;
                                    System.out.println("client successfully authentificated");
                                    sendMsg("/authok "+nick);
                                    continue;
                                } else {
                                    sendMsg("/authfail");
                                    continue;
                                }
                            }

                            if (str.startsWith("/w")) {

                                String[] cmd = str.split("\\s");
                                if (cmd.length>=3) {
                                    String _n = cmd[1];
                                    int p = str.indexOf(_n);
                                    String trueMsg = str.substring(p+_n.length()).trim();
                                    server.unicast(nick, nick+": "+trueMsg);
                                    server.unicast(_n, nick+": "+trueMsg);
                                    continue;
                                }
                            }


                            if (nick != null)
                                server.broadcastMsg(nick + ": " + str);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {

                        server.unsubscribe(ClientHandler.this);

                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        try {
                            socket.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
