package algorithms.leetCode.test.旋转数组;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;

import algorithm.leetCode.旋转数组.*;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


/**
* @author gaochaochao
* @date 2019年1月20日 下午12:35:44
* @description
*/
@RunWith(Parameterized.class)
public class Solution1Test {
	private int[] nums;//原数组
	private int k;//右移步数
	private int[] result_nums;//结果数组
	
	public Solution1Test(int[] nums, int k, int[] result_nums) {
		super();
		this.nums = nums;
		this.k = k;
		this.result_nums = result_nums;
	}
	
	@Parameters
	public static Collection<Object []> data() {
		return Arrays.asList(new Object [][]{
			//数组长度为奇数 ，k<half_len
			{ new int[] {1,2,3,4,5,6,7},2,new int[] {6,7,1,2,3,4,5} },
			//数组长度为奇数 ，k=half_len
			{ new int[] {1,2,3,4,5,6,7},3,new int[] {5,6,7,1,2,3,4} },
			//数组长度为奇数 ，k>half_len
			{ new int[] {1,2,3,4,5,6,7},4,new int[] {4,5,6,7,1,2,3} },
			//数组长度为偶数 ，k<half_len
			{ new int[] {1,2,3,4,5,6},2,new int[] {5,6,1,2,3,4} },
			//数组长度为偶数 ，k=half_len
			{ new int[] {1,2,3,4,5,6},3,new int[] {4,5,6,1,2,3} },
			//数组长度为偶数 ，k>half_len
			{ new int[] {1,2,3,4,5,6},4,new int[] {3,4,5,6,1,2} },
			//k=0
			{ new int[] {1,2,3,4,5,6},0,new int[] {1,2,3,4,5,6} },
			//k=len整数倍
			{ new int[] {1,2,3,4,5,6},6,new int[] {1,2,3,4,5,6} },
			//len=0
			{ new int[] {} ,6,new int[] {} },
			//len=1
			{ new int[] {1} ,6,new int[] {1} }
			
		});
	}
	

	@Test
	public void solution1TestRotate() {
		Solution1.rotate(nums, k); //原地旋转
		assertArrayEquals(result_nums, nums);//expected_result,actual_result
	}
	
	@Test
	public void solution2TestRotate() {
		Solution2.rotate(nums, k); //原地旋转
		assertArrayEquals(result_nums, nums);//expected_result,actual_result
	}
	
	@Test
	public void solution3TestRotate() {
		Solution3.rotate(nums, k); //原地旋转
		assertArrayEquals(result_nums, nums);//expected_result,actual_result
	}
	
	@Test
	public void solution4TestRotate() {
		Solution3.rotate(nums, k); //原地旋转
		assertArrayEquals(result_nums, nums);//expected_result,actual_result
	}

}
