package com.busanit501.SampleJSP_501.connectTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectDbTest {
    @Test
    public void test() {
        int v1 = 100;
        int v2 = 100;
        Assertions.assertEquals(v1, v2);
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
}
