package org.church.our.loving.module.services;

import java.sql.Connection;

import org.apache.log4j.Logger;
import org.church.our.loving.module.daos.CommonDAO;
import org.church.our.loving.test.DBConnection;

public class BaseServices {
	public Logger log = Logger.getLogger(BaseServices.class);
	protected Connection dbConnection;
	
	protected Long getNewId(String tableName) throws Exception {
		Long newId = 0l;
		try {
			dbConnection = DBConnection.getConnection();
			newId = CommonDAO.getID(dbConnection, tableName) + 1;
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnection.freeConnection(dbConnection);
		}
		return newId;
	}
}
