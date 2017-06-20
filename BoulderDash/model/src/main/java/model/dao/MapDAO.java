package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapDAO extends AbstractDAO {

	private String sqlHeight = "{call findHeight(?))";
	private String sqlWidth = "(call findWidth(?))";
	private String sqlTimer = "(call findTimer(?))";
	private String sqlDiamondLeft = "(call findDiamondLeft(?))";
	private int heightColumnIndex;
	private int widthColumnIndex;
	private int TimerColumnIndex;
	private int diamondLeftColumnIndex;

	public int getHeight(int level) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlHeight);
		int height = 0;
		callStatement.setInt(1, level);

		 if (callStatement.execute()) {
	            final ResultSet result = callStatement.getResultSet();
	            if (result.first()) {
	                result.getInt(heightColumnIndex);
	            }
	            result.close();
	        }
		
		return height;
	}
	
	public int getWidth(int level) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlWidth);
		int width = 0;
		callStatement.setInt(1, level);

		 if (callStatement.execute()) {
	            final ResultSet result = callStatement.getResultSet();
	            if (result.first()) {
	                result.getInt(widthColumnIndex);
	            }
	            result.close();
	        }
		
		return width;
	}
	public int getTimer(int level) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlTimer);
		int timer = 0;
		callStatement.setInt(1, level);

		 if (callStatement.execute()) {
	            final ResultSet result = callStatement.getResultSet();
	            if (result.first()) {
	                result.getInt(TimerColumnIndex);
	            }
	            result.close();
	        }
		
		return timer;
	}
	public int getDiamondLeft(int level) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlDiamondLeft);
		int DiamondLeft = 0;
		callStatement.setInt(1, level);

		 if (callStatement.execute()) {
	            final ResultSet result = callStatement.getResultSet();
	            if (result.first()) {
	                result.getInt(diamondLeftColumnIndex);
	            }
	            result.close();
	        }
		
		return DiamondLeft;
	}

}
