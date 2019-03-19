/**
 * 
 */
package algorithms.bitCalculate;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Administrator
 * @date 2019年3月16日 上午10:17:01
 * @description 字符串校验 三个同样字符串连在一起，去掉一个就好啦，如helllo--->hello
 *              两对同样字母连在一起，去掉第二对中的一个字母 AABB---> AAB 规则"从左到右"优先匹配 AABBCC--->AABCC
 */

public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			StringBuilder source = new StringBuilder();
			source.append(str);
			int length = source.length();
			char[] array = str.toCharArray();
			Pattern pattern = Pattern.compile("([a-zA-Z])\\1{2}");
			Matcher matcher = pattern.matcher(source);
			while (matcher.find()) {
				int start = matcher.start();
				int end = matcher.end();
				for (; end < source.length(); ++end) {
					if (array[start] == array[end]) {
						++end;
					} else {
						break;
					}
				}
				source.delete(start + 2, end);
				str = source.toString();
				source.delete(0, source.length());
				break;
			}
			System.out.println(source);
		}

	}
}