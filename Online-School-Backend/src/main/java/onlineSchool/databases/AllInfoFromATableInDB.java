package onlineSchool.databases;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllInfoFromATableInDB {
    public List<Map<String, Object>> getTableData(String tableName) throws SQLException {
        String query = "SELECT * FROM " + tableName;
        List<Map<String, Object>> result = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/onlineschool", "Serhii Mashkovets",
                "Mashkovets");
             CallableStatement stmt = conn.prepareCall(query)) {
            ResultSet rs = stmt.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnLabel(i);
                    Object value = rs.getObject(i);
                    row.put(columnName, value);
                }
                result.add(row);
            }
        }
        return result;
    }

}
