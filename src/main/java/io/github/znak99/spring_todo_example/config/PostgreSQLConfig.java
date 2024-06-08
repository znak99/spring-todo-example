package io.github.znak99.spring_todo_example.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class PostgreSQLConfig implements ApplicationRunner {

    private final DataSource dataSource;
    private final JdbcTemplate jdbcTemplate;

    public PostgreSQLConfig(DataSource dataSource, JdbcTemplate jdbcTemplate) {
        this.dataSource = dataSource;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        try (Connection connection = dataSource.getConnection()) {
            System.out.println("log > dataSource Class > " + dataSource.getClass());
            System.out.println("log > URL > " + connection.getMetaData().getURL());
            System.out.println("log > username > " + connection.getMetaData().getUserName());

//            Statement statement = connection.createStatement();
//            String sql = "CREATE TABLE test(name VARCHAR(255))";
//            statement.executeUpdate(sql);
        }

//        jdbcTemplate.execute("INSERT INTO test VALUES ('test')");
    }
}
