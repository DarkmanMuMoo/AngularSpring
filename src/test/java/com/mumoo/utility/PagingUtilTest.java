package com.mumoo.utility;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class PagingUtilTest {

	@Test
	public void testPage_1_TotalAmount_100_PerPage_10() throws Exception {
		int offSet = PagingUtil.getOffSet(1, 10, 100);
		Assert.assertEquals(offSet, 0);
	}

	@Test
	public void testPage_2_TotalAmount_100_PerPage_10() throws Exception {
		int offSet = PagingUtil.getOffSet(2, 10, 100);
		Assert.assertEquals(offSet, 10);

	}

	@Test
	public void testPage_3_TotalAmount_100_PerPage_10() throws Exception {
		int offSet = PagingUtil.getOffSet(3, 10, 100);
		Assert.assertEquals(offSet, 20);

	}

	@Test
	public void testPage_11_TotalAmount_101_PerPage_10() throws Exception {
		int offSet = PagingUtil.getOffSet(11, 10, 101);
		Assert.assertEquals(offSet, 100);

	}
	
	@Test(expected=Exception.class)
	public void testMustThrowPageOutOfRange() throws Exception {
		int offSet = PagingUtil.getOffSet(12, 10, 101);

	}
	

}
