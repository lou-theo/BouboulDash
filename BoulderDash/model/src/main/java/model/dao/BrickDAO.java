package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * <h1>The Class BrickDAO.</h1>
 *
 * @author Unchained Dragonfly
 * @version 1.0
 */
public class BrickDAO extends AbstractDAO {

	private static String sqlAllBricks = "{call findAllBricks(?)}";
	private static int codeColumnlndex = 1;
	private static int xColumnlndex = 2;
	private static int yColumnlndex = 3;

	/**
	 * Get all the map element in the form of bricks
	 * @param level
	 * @return all bricks of the specified level
	 * @throws SQLException
	 */
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
