package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapDAO extends AbstractDAO {

	private static String sqlHeight = "{call findHeight(?)}";
	private static String sqlWidth = "{call findWidth(?)}";
	private static String sqlTimer = "{call findTimer(?)}";
	private static String sqlDiamondLeft = "{call findDiamondToCollect(?)}";
	private static int heightColumnIndex = 1;
	private static int widthColumnIndex = 1;
	private static int TimerColumnIndex = 1;
	private static int diamondLeftColumnIndex = 1;

	public static int getHeight(int level) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlHeight);
		int height = 0;
		callStatement.setInt(1, level);

		if (callStatement.execute()) {
			ResultSet result = callStatement.getResultSet();
			if (result.first()) {
				height = result.getInt(heightColumnIndex);
			}
			result.close();
		}

		return height;
	}

	public static int getWidth(int level) throws SQLException {
		CallableStatement callStatement = prepareCall(sqlWidth);
		int width = 0;
		callStatement.setInt(1, level);

		if (callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			if (result.first()) {
				width = result.getInt(widthColumnIndex);
			}
			result.close();
		}

		return width;
	}

	public static int getTimer(int level) throws SQLException {
		CallableStatement callStatement = prepareCall(sqlTimer);
		int timer = 0;
		callStatement.setInt(1, level);

		if (callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			if (result.first()) {
				timer = result.getInt(TimerColumnIndex);
			}
			result.close();
		}

		return timer;
	}

	public static int getDiamondLeft(int level) throws SQLException {
		CallableStatement callStatement = prepareCall(sqlDiamondLeft);
		int DiamondLeft = 0;
		callStatement.setInt(1, level);

		if (callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();
			if (result.first()) {
				DiamondLeft = result.getInt(diamondLeftColumnIndex);
			}
			result.close();
		}

		return DiamondLeft;
	}

}
