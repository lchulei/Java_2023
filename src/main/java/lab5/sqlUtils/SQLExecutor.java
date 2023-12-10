package lab5.sqlUtils;

import lab5.connection.BasicConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLExecutor {
    private String url;
    private String user;
    private String password;

    public SQLExecutor(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void executeQueryWithNoResult(String query) throws SQLException {
        BasicConnectionPool basicConnectionPool = BasicConnectionPool.create(url, user, password);
        Connection connection = basicConnectionPool.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(query);

        statement.close();
        connection.close();
    }
}
