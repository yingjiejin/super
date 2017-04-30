package utils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Title: StringUtil.java Description:
 *
 * @author Nesta
 * @version 1.0
 * @date 2011-11-1
 */
public final class DataUtil {

	private DataUtil() {
	}

	public static Boolean isValidData(Object o) {
		return o != null;
	}

	public static Boolean isValidData(List<?> l) {
		return ((l != null) && (l.size() > 0));
	}

	public static Boolean isValidData(Set<?> s) {
		return ((s != null) && (s.size() > 0));
	}

	public static Boolean isValidData(Map<?, ?> m) {
		return ((m != null) && (m.size() > 0));
	}

	public static Boolean isValidData(String s) {
		return (!(s == null || s.trim().equals("")));
	}

	public static Boolean isValidData(Integer i) {
		return i != null;
	}

	public static Boolean isValidData(Double d) {
		return d != null;
	}

	public static Boolean isValidData(Long l) {
		return l != null;
	}

	public static Boolean isValidData(Integer i, char sign) {
		Boolean status = true;
		if (i == null) {
			status = false;
		} else {
			if (sign == '+' && i <= 0) {
				status = false;
			} else if (sign == '-' && i >= 0) {
				status = false;
			}
		}
		return status;
	}

	public static Boolean isValidData(Long i, char sign) {
		Boolean status = true;
		if (i == null) {
			status = false;
		} else {
			if (sign == '+' && i <= 0) {
				status = false;
			} else if (sign == '-' && i >= 0) {
				status = false;
			}
		}
		return status;
	}

	public static Boolean isValidData(Integer i, char sign,
																		Boolean includeZero) {
		if (!includeZero) {
			return isValidData(i, sign);
		} else {
			Boolean status = true;
			if (i == null) {
				status = false;
			} else {
				if (sign == '+' && i < 0) {
					status = false;
				} else if (sign == '-' && i > 0) {
					status = false;
				}
			}
			return status;
		}
	}

	public static Boolean isValidData(Float f, char sign) {
		Boolean status = true;
		if (f == null) {
			status = false;
		} else {
			if (sign == '+' && f <= 0) {
				status = false;
			} else if (sign == '-' && f >= 0) {
				status = false;
			}
		}
		return status;
	}

	public static Boolean isValidData(String dst, String reg) {
		Pattern p = Pattern.compile(reg);
		Matcher matcher = p.matcher(dst);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	public static Boolean isValidNumber(String s) {
		return isValidData(s) && isNumber(s);
	}

	public static Boolean isValidInteger(String s) {
		return isValidData(s) && isInteger(s);
	}

	/**
	 * check is Unicom number or not
	 *
	 * @param mobileNumber
	 * @return boolean
	 */
	public static boolean isValidUniNumber(String mobileNumber) {
		try {
			Pattern p = Pattern.compile("^((13[0-2])|155|156|185|186)\\d{8}$");
			return p.matcher(mobileNumber).matches();
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * check is phone num or not
	 *
	 * @param str
	 * @return boolean
	 */
	public static boolean isValidPhone(String str) {
		/*
		 * if (str.length() == 11 && isNumber(str)) { int pref =
		 * Integer.parseInt(str.substring(0, 2)); if ((pref == 13) || (pref ==
		 * 15)) return true; } return false;
		 * ^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$
		 */
		try {
			Pattern p = Pattern.compile("^1[3|4|5|7|8][0-9]\\d{8}$");
			return p.matcher(str).matches();
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isValidMail(String mail) {
		/*
		 * int i; int len = mail.length(); int aPos = mail.indexOf("@"); int
		 * dPos = mail.indexOf("."); int aaPos = mail.indexOf("@@"); int adPos =
		 * mail.indexOf("@."); int ddPos = mail.indexOf(".."); int daPos =
		 * mail.indexOf(".@"); String lastChar = mail.substring(len - 1, len);
		 * String chkStr =
		 * "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890-_@.";
		 * 
		 * if (len >= 50) { return false; } if ((aPos <= 0) || (aPos == len - 1)
		 * || (dPos <= 0) || (dPos == len - 1) || (adPos > 0) || (daPos > 0) ||
		 * (lastChar.equals("@")) || (lastChar.equals(".")) || (aaPos > 0) ||
		 * (ddPos > 0)) { return false; } if (mail.indexOf("@", aPos + 1) > 0) {
		 * return false; } while (aPos > dPos) { dPos = mail.indexOf(".", dPos +
		 * 1); if (dPos < 0) { return false; } } for (i = 0; i < len; i++) { if
		 * (chkStr.indexOf(mail.charAt(i)) < 0) { return false; } } return true;
		 */

		String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern regex = Pattern.compile(check);
		Matcher matcher = regex.matcher(mail);
		return matcher.matches();
	}

	/**
	 * check is post num or not
	 *
	 * @param str
	 * @return boolean
	 */
	public static boolean isValidPost(String str) {
		return (str.length() == 6 && isNumber(str));
	}

	/**
	 * 判断一个字符串是否可以是数值
	 *
	 * @param str
	 * @return boolean
	 */
	public static boolean isInteger(String str) {
		/*
		 * int i; for (i = 0; i < str.length(); i++) { if
		 * (!java.lang.Character.isDigit(str.charAt(i))) return false; } return
		 * true;
		 */
		Pattern p = Pattern.compile("^([0-9]+)$");
		Matcher m = p.matcher(str);
		return m.matches();
	}

	public static boolean isPositiveInteger(String str) {
		Pattern p = Pattern.compile("^([1-9][0-9]*)$");
		Matcher m = p.matcher(str);
		return m.matches();
	}

	/**
	 * 判断一个字符串是否可以是数值
	 *
	 * @param str
	 * @return boolean
	 */
	public static boolean isNumber(String str) {
		/*
		 * int i; for (i = 0; i < str.length(); i++) { if
		 * (!java.lang.Character.isDigit(str.charAt(i))) return false; } return
		 * true;
		 */
		Pattern p = Pattern.compile("^([0-9]+([\\.]{0,1}[0-9]+){0,1})$");
		Matcher m = p.matcher(str);
		return m.matches();
	}

	/**
	 * @param list
	 * @return
	 */
	public static boolean isNumber(List<String> list) {
		return isNumber(
			list.toString().substring(1, list.toString().length() - 1),
			", ");
	}

	/**
	 * 判断一个字符串是否可以是数值
	 *
	 * @param str String类型
	 * @return boolean类型 true为数字 false为非数字
	 * format为字符串分隔的符号如:12,23,65,65;format是“，”
	 */
	public static boolean isNumber(String str, String format) {
		if ("".equals(format)) {
			return isNumber(str);
		} else {
			/*
			 * 如果str的长度长,下面的正则就比较有用了,但是需要对format进行转义判断,所以暂时不用下面的正则 Pattern p =
			 * Pattern.compile("^([0-9]+([\\.]{0,1}[0-9]+){0,1}" + format +
			 * ")+([0-9]+([\\.]{0,1}[0-9]+){0,1})$"); Matcher m =
			 * p.matcher(str); return m.matches();
			 */
			String[] strs = str.split(format);
			for (int i = 0; i < strs.length; i++) {
				if (!isNumber(strs[i])) {
					return false;
				}
			}
			return true;
		}
	}
	/**
	 * 判断一个字符串是否是银行卡
	 */
	public static boolean isBankCard(String str) {
		Pattern p = Pattern.compile("^\\d{16}|\\d{19}$");
		Matcher m = p.matcher(str);
		return m.matches();
	}

}
