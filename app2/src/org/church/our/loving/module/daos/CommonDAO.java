package org.church.our.loving.module.daos;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

public class CommonDAO {
	public static Logger log = Logger.getLogger(CommonDAO.class);

	public static void freeResources(Statement statement, ResultSet rs) {

		if (null != statement) {
			try {
				statement.close();
				statement = null;
			} catch (SQLException e) {
				log.error(e.getMessage(), e);
			}
		}

		if (null != rs) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	public static void startTransaction(Connection conn) {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			log.error(e.getMessage(), e);

		}
	}

	public static void rollback(Connection conn) {
		try {
			conn.rollback();
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
		}
	}

	public static void commit(Connection conn) {
		try {
			conn.commit();
		} catch (SQLException e) {
			log.error(e.getMessage(), e);
		}
	}

	public static List<Map<String, Object>> doQuery(Connection connection, String sql, Object[] args) throws Exception {
		PreparedStatement statement = null;
		ResultSet rs = null;
		ResultSetMetaData metaData = null;
		List<String> columnNames = new ArrayList<String>();
		List<Map<String, Object>> resList = new ArrayList<Map<String, Object>>();
		try {
			if (null == connection) {
				throw new Exception("Cannot get DB connection.");
			}
			statement = connection.prepareStatement(sql);
			for (int i = 1; null != args && i <= args.length; i++) {
				statement.setObject(i, args[i - 1]);
			}
			log.info("************** Execute Query : " + statement);
			rs = statement.executeQuery();
			if (null != rs) {
				metaData = rs.getMetaData();
				if (null != metaData) {
					for (int i = 1; i <= metaData.getColumnCount(); i++) {
						columnNames.add(metaData.getColumnName(i));
					}
				}

				while (rs.next()) {
					Map<String, Object> rsMap = new HashMap<String, Object>();
					for (int i = 0; i < columnNames.size(); i++) {
						rsMap.put(columnNames.get(i).toUpperCase(), rs.getObject(columnNames.get(i)));
					}
					resList.add(rsMap);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new Exception(e);
		} finally {
			freeResources(statement, rs);
		}
		return resList;
	}

	public static synchronized int doUpdate(Connection connection, String sql, Object[] args) throws Exception {
		PreparedStatement statement = null;
		int result = 0;
		try {
			if (null == connection) {
				throw new Exception("Cannot get DB connection.");
			}
			statement = connection.prepareStatement(sql);
			for (int i = 1; null != args && i <= args.length; i++) {
				statement.setObject(i, args[i - 1]);
			}
			log.info("************** Execute Update : " + statement);
			result = statement.executeUpdate();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new Exception(e);
		} finally {
			freeResources(statement, null);
		}
		return result;
	}

	public static Long getID(Connection connection, String table) throws Exception {
		PreparedStatement statement = null;
		Long result = 0l;
		String sql = "select max(id)ID from " + table;
		try {
			if (null == connection) {
				throw new Exception("Cannot get DB connection.");
			}
			List<Map<String, Object>> rs = doQuery(connection, sql, null);
			if (rs != null) {
				result = (Long) rs.get(0).get("ID");
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new Exception(e);
		} finally {
			freeResources(statement, null);
		}
		return result;
	}

	public static List<Object> queryToOjbect(Class<? extends Object> to, List<Map<String, Object>> res)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Method[] methods = to.getMethods();
		List<Object> reslist = new ArrayList<Object>();
		for (Map<String, Object> map : res) {
			Object newInst = to.newInstance();
			for (int i = 0; i < methods.length; i++) {
				String methodName = methods[i].getName();
				if (methodName.toLowerCase().startsWith("set")) {
					String propertyName = methodName.replace("set", "").toUpperCase();
					if (map.containsKey(propertyName)) {
						Object value = map.get(propertyName);
						if (methods[i].getParameterTypes().length > 0) {
							String parameterType = methods[i].getParameterTypes()[0].getSimpleName();
							if (parameterType.equalsIgnoreCase("string")) {
								methods[i].invoke(newInst, (String) value);
							} else if (parameterType.equalsIgnoreCase("double")) {
								methods[i].invoke(newInst, (Double) value);
							} else if (parameterType.equalsIgnoreCase("timestamp")) {
								methods[i].invoke(newInst, Timestamp.valueOf((String) value));
							} else {
								methods[i].invoke(newInst, value);
							}
						}
					}
				}
			}
			reslist.add(newInst);
		}
		return reslist;
	}
}
