package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ElementDAO extends AbstractDAO {

	private String sqlCode = "{call findCode(?))";
	private String sqlPermeability = "(call findPermeability(?))";
	private String sqlValue = "(call findValue(?))";
	private String sqlDrop = "(call findDrop(?))";
	
	private int codeColumnIndex;
	private int permeabilityColumnIndex;
	private int valueColumnIndex;
	private int dropColumnIndex;
	
	public char getCode(String name) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlCode);
		char code = ' ';
		callStatement.setString(1, name);

		 if (callStatement.execute()) {
	            final ResultSet result = callStatement.getResultSet();
	            if (result.first()) {
	                code = result.getString(codeColumnIndex).charAt(0);
	            }
	            result.close();
	        }
		
		return code;
	}
	
	public int getValue(String name) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlValue);
		int value = 0;
		callStatement.setString(1, name);

		 if (callStatement.execute()) {
	            final ResultSet result = callStatement.getResultSet();
	            if (result.first()) {
	                result.getInt(valueColumnIndex);
	            }
	            result.close();
	        }
		
		return value;
	}
	public boolean getDrop(String name) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlDrop);
		boolean drop = false;
		callStatement.setString(1, name);

		 if (callStatement.execute()) {
	            final ResultSet result = callStatement.getResultSet();
	            if (result.first()) {
	                result.getBoolean(dropColumnIndex);
	            }
	            result.close();
	        }
		
		return drop;
	}
	public Permeability getPermeability(String name) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlPermeability);
		Permeability permeability = null;
		callStatement.setString(1, name);

		 if (callStatement.execute()) {
	            final ResultSet result = callStatement.getResultSet();
	            if (result.first()) {
	                result.getString(permeabilityColumnIndex);
	            }
	            result.close();
	        }
		
		return permeability;
	}
}
