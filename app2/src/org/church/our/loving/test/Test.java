package org.church.our.loving.test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import org.church.our.loving.module.entity.FinanceManagerTO;
import org.church.our.loving.module.services.FinanceManagerService;

public class Test {

	public static void main(String[] args) {
		testFinanceMange();
		testFinanceMange2();
	}

	private static void testFinanceMange() {
		FinanceManagerService service =  new FinanceManagerService();
		FinanceManagerTO to = new FinanceManagerTO();
		to.setCreatedBy("createdBy1");
		to.setCreatedDt(Timestamp.valueOf(LocalDateTime.now()));
		to.setShoppingComments("shoppingComments1");
		to.setShoppingCount(201.341);
		to.setShoppingItem("中文测试");
		to.setStatus("A1");
		to.setUpdatedBy("updatedBy1");
		to.setUpdatedDt(Timestamp.valueOf(LocalDateTime.now()));
		
		try {
			System.out.println(to.getPropertyValueMapping());
			service.logAccount(to);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} 
	private static void testFinanceMange2() {
		FinanceManagerService service =  new FinanceManagerService();
		try {
			service.queryAccount();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
