package org.church.our.loving.module.entity;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommonTO {
	private long id;
	private Timestamp createdDt;
	private String createdBy;
	private String updatedBy;
	private Timestamp updatedDt;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCreatedDt() {
		return createdDt.toString();
	}
	public void setCreatedDt(Timestamp createdDt) {
		this.createdDt = createdDt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdatedDt() {
		return updatedDt.toString();
	}
	public void setUpdatedDt(Timestamp updatedDt) {
		this.updatedDt = updatedDt;
	}
	@Override
	public String toString() {
		String result = "";
		Method[] methods = this.getClass().getMethods();
		List<String> fields = new ArrayList<String>();
		for(Field f: getClass().getDeclaredFields()) {
			fields.add(f.getName().toLowerCase());
		}
		for(Field f: this.getClass().getSuperclass().getDeclaredFields() ) {
			fields.add(f.getName().toLowerCase());
		}
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].getName().startsWith("get") && fields.contains( methods[i].getName().toLowerCase().replace("get", ""))) {
				try {
						Object[] args = new Object[0];
						Object invoke = methods[i].invoke(this, args);
						result += "| " + methods[i].getName() + "=" + invoke + "|";
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	public Map<String, Object> getPropertyValueMapping() {
		Map<String, Object> mapping = new HashMap<String, Object>();
		List<String> fieldList = new ArrayList<String>();
		Field[] fields = this.getClass().getDeclaredFields();
		try {
			for (int i = 0; i < fields.length; i++) {
				fieldList.add(fields[i].getName().toLowerCase());
			}
			Field[] parentFields = this.getClass().getSuperclass().getDeclaredFields();
			for (int i = 0; i < parentFields.length; i++) {
				fieldList.add(parentFields[i].getName().toLowerCase());
			}
			Method[] methods = this.getClass().getMethods();
			for (int i = 0; i < methods.length; i++) {
				Method method = methods[i];
				String methodName = method.getName();
				if (methodName.toLowerCase().startsWith("get")
						&& fieldList.contains(methodName.replace("get", "").toLowerCase())) {
					Object [] objects = new Object[1];
					Object returnVal = method.invoke(this, objects);
					mapping.put(methodName.replace("get", "").toLowerCase(), returnVal);
				}
			}
		} catch (Exception e) {
		}
		return mapping;
	}
}
