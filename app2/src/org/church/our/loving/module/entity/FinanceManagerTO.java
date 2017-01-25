package org.church.our.loving.module.entity;

public class FinanceManagerTO extends CommonTO {
	private String shoppingItem;
	private Double shoppingCount;
	private String shoppingComments;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getShoppingItem() {
		return shoppingItem;
	}

	public void setShoppingItem(String shoppingItem) {
		this.shoppingItem = shoppingItem;
	}

	public Double getShoppingCount() {
		return shoppingCount;
	}

	public void setShoppingCount(Double shoppingCount) {
		this.shoppingCount = shoppingCount;
	}

	public String getShoppingComments() {
		return shoppingComments;
	}

	public void setShoppingComments(String shoppingComments) {
		this.shoppingComments = shoppingComments;
	}

}
