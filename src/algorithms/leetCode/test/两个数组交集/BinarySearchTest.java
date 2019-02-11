package algorithms.leetCode.test.两个数组交集;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import algorithm.leetCode.两个数组的交集.BinarySearch;
/**
* @author gaochaochao
* @date 2019年1月20日 下午3:51:15
* @description
*/
@RunWith(Parameterized.class)
public class BinarySearchTest {
	private int[] nums;//数组
	private int key;//待查找的关键词
	private int expected_result;//期待结果
	public BinarySearchTest(int[] nums, int key,int expected_result) {
		super();
		this.nums = nums;
		this.key=key;
		this.expected_result = expected_result;
	}
	@Parameters
	public static Collection<Object []> data() {
		return Arrays.asList(new Object [][]{
			// test1 	空数组
			{ new int[0] ,1,-1 },
			// test2	有序不重复，关键词存在，且关键词取数组key==head,
			{ new int[] {1,2,3,4,5,6},1,0},
			// test3	有序不重复，关键词存在，且关键词取数组key==tail,
			{ new int[] {1,2,3,4,5,6},6,5},
			// test4	有序不重复，关键词存在，且关键词取数组 key==any other position,
			{ new int[] {1,2,3,4,5,6},2,1},
			// test5	有序不重复，关键词不存在且关键词取值 key<head,
			{ new int[] {1,5,10,20,50,100} ,0,-1 },
			// test6	有序不重复，关键词不存在且关键词取值 key>head and key<head+1,
			{ new int[] {1,5,10,20,50,100} ,2,0 },
			// test7	有序不重复，关键词不存在且关键词取值 key>tail-1 and key<tail,
			{ new int[] {1,5,10,20,50,100} ,70,4 },
			// test8	有序不重复，关键词不存在且关键词取值 key>tail,
			{ new int[] {1,5,10,20,50,100} ,120,5 },
			// test9	有序不重复，关键词不存在且关键词取值 key between any other position,
			{ new int[] {1,5,10,20,50,100} ,39,3 },	
			// test10	有序重复，关键词存在，且关键词取数组key==head,
			{ new int[] {1,1,2,2,3,3,4,4,5,5,6,6},1,1},
			// test11	有序重复，关键词存在，且关键词取数组key==tail,
			{ new int[] {1,1,2,2,3,3,4,4,5,5,6,6},6,11},
			// test12	有序重复，关键词存在，且关键词取数组 key==any other position,
			{ new int[] {1,1,2,2,3,3,4,4,5,5,6,6},2,3},
			// test13	有序不重复，关键词不存在且关键词取值 key<head,
			{ new int[] {1,1,2,2,3,3,4,4,5,5,6,6} ,0,-1 },
			// test14	有序重复，关键词不存在且关键词取值 key>head and key<head+1,
			{ new int[] {1,1,5,5,10,10,20,20,50,50,100,100} ,2,1 },
			// test15	有序不重复，关键词不存在且关键词取值 key>tail-1 and key<tail,
			{ new int[] {1,1,5,5,10,10,20,20,50,50,100,100} ,70,9 },
			// test16	有序不重复，关键词不存在且关键词取值 key>tail,
			{ new int[] {1,1,5,5,10,10,20,20,50,50,100,100} ,120,11 },
			// test17	有序不重复，关键词不存在且关键词取值 key between any other position,
			{ new int[] {1,1,5,5,10,10,20,20,50,50,100,100} ,39,7 },	
		});
	}
	
	@Test
	public void Solution1TestContainsDuplicate() {
		int actual_result=BinarySearch.binarySearch(nums, key);
		assertEquals(expected_result,actual_result);
	}

}
