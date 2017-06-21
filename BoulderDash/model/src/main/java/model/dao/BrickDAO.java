package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BrickDAO extends AbstractDAO {

	private static String sqlAllBricks = "{call findAllAbricks(?)}";
	private static int codeColumnlndex = 1;
	private static int xColumnlndex = 2;
	private static int yColumnlndex = 3;

	public static ArrayList<Brick> getAllbricks(int level) throws SQLException {
		ArrayList<Brick> bricks = new ArrayList<Brick>();
		CallableStatement callStatement = prepareCall(sqlAllBricks);
		callStatement.setInt(1, level);

		if (callStatement.execute()) {
			final ResultSet result = callStatement.getResultSet();

			for (boolean isResultLeft = result.first(); isResultLeft; isResultLeft = result.next()) {

				bricks.add(new Brick(result.getString(codeColumnlndex).charAt(0), result.getInt(xColumnlndex),
						result.getInt(yColumnlndex)));
			}
			result.close();

		}
		return bricks;
	}

}
