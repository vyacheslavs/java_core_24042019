package Lesson_7.Server;

import java.sql.*;

public class Auth {

    private Connection connection;
    private Statement statement;

    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:"+getClass().getResource("dbusers.db"));
            statement = connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }

    public String getNick(String login, String pass) {
        String sql = String.format("SELECT nickname FROM users WHERE login='%s' AND passw='%s'", login, pass);
        try {
            ResultSet rs = statement.executeQuery(sql);

            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String chatAuthenticate(String command) {
        String[] splited = command.split("\\s");
        if (splited.length<3)
            return null;
        return getNick(splited[1], splited[2]);
    }

    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
