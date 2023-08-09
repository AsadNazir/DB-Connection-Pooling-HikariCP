package org.example;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
public class DbPoolingHikariCP {
    static final String Url ="jdbc:mysql://localhost:3306/";
    static final String username = "root";
    static final String password = "root";
    private static final HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(Url + "web");
        config.setUsername(username);
        config.setPassword(password);
        config.setMaximumPoolSize(1);
        dataSource = new HikariDataSource(config);
    }

    public static DataSource getDataSource() {
        return dataSource;
    }




}
