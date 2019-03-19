package algorithms.leetCode.test.存在重复;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import algorithms.leetCode.存在重复.*;
/**
* @author gaochaochao
* @date 2019年1月20日 下午3:51:15
* @description
*/
@RunWith(Parameterized.class)
public class Solution1Test {
	private int[] nums;//数组
	private boolean expected_result;//期待结果
	public Solution1Test(int[] nums, boolean expected_result) {
		super();
		this.nums = nums;
		this.expected_result = expected_result;
	}
	@Parameters
	public static Collection<Object []> data() {
		return Arrays.asList(new Object [][]{
			{ new int[] {1,2,3,4,5,2},true },
			{ new int[] {1,2,3,4,5,6},false},
			{ new int[] {} ,false },
			{ new int[] {1} ,false }
			
		});
	}
	
	@Test
	public void Solution1TestContainsDuplicate() {
		boolean actual_result=Solution1.containsDuplicate(nums);
		assertEquals(expected_result,actual_result);
	}

}
