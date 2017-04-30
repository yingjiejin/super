package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtao
 * Date: 13-6-18
 * Time: 下午5:23
 */
public class StringUtil {

	public static String LF = System.getProperty("os.name").toLowerCase()
		.startsWith("windows") ? "\r\n" : "\n";
	public static final String WINDOWS_NEWLINE = "\r\n";

	public static String getDefaultValue(String s) {

		return getDefaultValue(s, "");
	}

	public static String getDefaultValue(String s, String defaultValue) {

		if (!DataUtil.isValidData(s)) {
			s = defaultValue;
		}
		return s;
	}

	public static List<Integer> toIntegerList(String string, String separator) {

		if (DataUtil.isValidData(string)) {
			return toIntegerList(string.split(separator));
		}
		return null;
	}

	public static List<Integer> toIntegerList(String[] strings) {

		if (DataUtil.isValidData(strings)) {
			List<Integer> list = new ArrayList<>();
			for (String s : strings) {
				list.add(DigitUtil.integerValue(s));
			}

			return list;
		}
		return null;
	}

	public static <T extends Number> String list2String(List<T> list, String separator) {
		if (DataUtil.isValidData(list)) {
			StringBuilder sb = new StringBuilder();
			for (T t : list) {
				sb.append(t.toString()).append(separator);
			}
			return sb.substring(0, sb.length() - 1).toString();
		}
		return "";
	}

	public static boolean checkLength(String string, int minLength, int maxLength) {

		if (DataUtil.isValidData(string)) {
			int length = string.trim().length();

			return length >= minLength && length <= maxLength;
		}

		return false;
	}

	public static String hiddenMobileNum(String mobileNum) {

		System.out.println("mobileNum = " + mobileNum);
		if (DataUtil.isValidPhone(mobileNum)) {
			StringBuilder sb = new StringBuilder(mobileNum.substring(0, 3));
			sb.append("****");
			sb.append(mobileNum.substring(7, 11));

			return sb.toString();
		}
		return "";
	}

	public static String hiddenTrueName(String trueName) {

		if (DataUtil.isValidData(trueName)) {
			StringBuilder sb = new StringBuilder(trueName.substring(0, 1));
			sb.append("**");

			return sb.toString();
		}
		return "";
	}

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>();

		list.add(1);
		list.add(1);
		list.add(1);
		list.add(1);

		System.out.println(list2String(list, ","));
	}
}
