package com.busanit501.SampleJSP_501.connectTest;

import com.busanit501.samplejsp_501.connectTest.samplejsp_501.todo.TodoVO;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;

public class ConnectDbTest {
    @Test
    public void test() {
        int v1 = 100;
        int v2 = 100;
        Assertions.assertEquals(v1, v2);
    }

    @Test
    public void test2() {
        //TodoVO todovo = new TodoVO();
        TodoVO todo = TodoVO.builder()
                .tno(100L)
                .title("제목100")
                .dueDate(LocalDate.now())
                .build();
        System.out.println(todo);
    }

    @Test
    public void connectTestDb() throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/webdb",
                "webuser",
                "webuser"
        );
        Assertions.assertNotNull(conn);
        conn.close();

    }
    @Test
    public void testHikariCP() throws Exception {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        config.setUsername("webuser");
        config.setPassword("webuser");

        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource dataSource = new HikariDataSource(config);
        Connection conn = dataSource.getConnection();

        System.out.println(conn);

        conn.close();
    }
}

