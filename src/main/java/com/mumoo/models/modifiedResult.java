package com.mumoo.models;

public class modifiedResult {

	private boolean result;
	private Object modifyObject;
	
	public modifiedResult(boolean result, Object modifyObject) {
		super();
		this.result = result;
		this.modifyObject = modifyObject;
	}
	
	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public Object getModifyObject() {
		return modifyObject;
	}

	public void setModifyObject(Object modifyObject) {
		this.modifyObject = modifyObject;
	}

}
