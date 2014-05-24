package com.mumoo.utility;

public class PagingUtil {

	public static int getOffSet(int page, int perPage, int totalAmount) throws Exception {
		int offSet =(page - 1) * perPage;
		
		if(offSet>totalAmount){
			
			throw new Exception("page = "+page+" out of range");
		}
		return offSet;
	}

}
