package assignment;

import java.sql.*;
import java.util.*;


public class Task3 {

	public List<ReportEntry> fetchMonthlyReport(String accountId, int month, int year) throws SQLException {
		String sql = "SELECT * FROM report_entries WHERE account_id = ? AND MONTH(entry_date) = ? AND YEAR(entry_date) = ?";
		List<ReportEntry> entries = new ArrayList<>();

		// FIX: Implemented try-with-resources to ensure auto-closure of resources in
		// correct order (RS -> PS -> Conn)
		try (Connection conn = dataSource.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, accountId);
			ps.setInt(2, month);
			ps.setInt(3, year);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					entries.add(mapRow(rs));
				}
			}
		}
		return entries;
	}

}
