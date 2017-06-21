package model.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Permeability;

public class ElementDAO extends AbstractDAO {

	private static String sqlCode = "{call findCode(?)}";
	private static String sqlPermeability = "{call findPermeability(?)}";
	private static String sqlValue = "{call findValue(?)}";
	private static String sqlDrop = "{call findDrop(?)}";
	
	private static int codeColumnIndex = 1;
	private static int permeabilityColumnIndex = 1;
	private static int valueColumnIndex = 1;
	private static int dropColumnIndex = 1;
	
	public static char getCode(String name) throws SQLException {
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
	
	public static int getValue(String name) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlValue);
		int value = 0;
		callStatement.setString(1, name);

		 if (callStatement.execute()) {
	            final ResultSet result = callStatement.getResultSet();
	            if (result.first()) {
	            	value = result.getInt(valueColumnIndex);
	            }
	            result.close();
	        }
		
		return value;
	}
	public static boolean getDrop(String name) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlDrop);
		boolean drop = false;
		callStatement.setString(1, name);

		 if (callStatement.execute()) {
	            final ResultSet result = callStatement.getResultSet();
	            if (result.first()) {
	            	drop = result.getBoolean(dropColumnIndex);
	            }
	            result.close();
	        }
		
		return drop;
	}
	public static Permeability getPermeability(String name) throws SQLException {
		final CallableStatement callStatement = prepareCall(sqlPermeability);
		Permeability permeability = Permeability.PENETRABLE;
		callStatement.setString(1, name);

		 if (callStatement.execute()) {
	            final ResultSet result = callStatement.getResultSet();
	            if (result.first()) {
	                String permeable = result.getString(permeabilityColumnIndex);
	                
	                
	                if (permeable == "PENETRABLE") {
	                	permeability = Permeability.PENETRABLE;
	                } else if (permeable.equals("BREAKABLE")) {
	                	permeability = Permeability.BREAKABLE;
	                } else if (permeable.equals("PUSHABLE")) {
	                	permeability = Permeability.PUSHABLE;
	                } else if (permeable.equals("COLLECTABLE")) {
	                	permeability = Permeability.COLLECTABLE;
	                } else if (permeable.equals("SOLID")) {
	                	permeability = Permeability.SOLID;
	                } else if (permeable.equals("ENTRY")) {
	                	permeability = Permeability.ENTRY;
	                } else if (permeable.equals("UNBREAKABLE")) {
	                	permeability = Permeability.UNBREAKABLE;
	                } else if (permeable.equals("LIVING")) {
	                	permeability = Permeability.LIVING;
	                }
	            }
	            result.close();
	        }

		return permeability;
	}
}
