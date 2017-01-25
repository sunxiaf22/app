package org.church.our.loving.module.services;

import java.util.*;

import org.church.our.loving.module.daos.CommonDAO;
import org.church.our.loving.module.entity.FinanceManagerTO;
import org.church.our.loving.test.DBConnection;

public class FinanceManagerService extends BaseServices {
	
	public void logAccount(FinanceManagerTO to) throws Exception {
		try {
			dbConnection = DBConnection.getConnection();
			String sql = "insert into tbl_shopping_mgr "
					+ "(shoppingItem,shoppingCount,shoppingComments,createdby,createddt,updatedby,updateddt,status) "
					+ " values (?,?,?,?,?,?,?,?);";
			Object[] args = {to.getShoppingItem(), to.getShoppingCount(), to.getShoppingComments(), to.getCreatedBy(), to.getCreatedDt(), to.getUpdatedBy()
					, to.getUpdatedDt(), "A"};
			CommonDAO.doUpdate(dbConnection, sql, args);
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnection.freeConnection(dbConnection);
		}
	}

	public void queryAccount() throws Exception {
		try {
			dbConnection = DBConnection.getConnection();
			 List<Map<String, Object>> resList = CommonDAO.doQuery(dbConnection, "select * from tbl_shopping_mgr", null);
			 List<Object>  res =  CommonDAO.queryToOjbect(FinanceManagerTO.class, resList);
			 System.out.println(res.size());
			 for (Object obj : res) {
				 FinanceManagerTO financeManagerTO = (FinanceManagerTO) obj;
				 System.out.println(financeManagerTO);
			}
			 
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnection.freeConnection(dbConnection);
		}
		
		
	}
}
