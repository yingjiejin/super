package utils;

import java.text.NumberFormat;

/**
 * Created with IntelliJ IDEA.
 * User: zhangtao
 * Date: 13-12-18
 * Time: 19:50
 */
public final class DigitUtil {

	public static Integer integerValue(String string) {

		if (DataUtil.isValidInteger(string)) {
			return Integer.valueOf(string);
		}
		return floatValue(string).intValue();
	}

	public static Float floatValue(String string) {

		if (DataUtil.isValidNumber(string)) {
			return Float.valueOf(string);
		}
		return 0F;
	}

	public static Float percent(Integer member, Integer denominator, Integer decimal) {

		if (denominator > 0) {
			decimal = (decimal > 1) ? decimal : 2;
			Integer tmp = 1;
			for (Integer i = 1; i <= decimal; i++) {
				tmp *= 10;
			}
			Float f = (float) member;
			return (float) (Math.round(f * tmp * tmp / denominator)) / tmp;
		}
		return 0f;
	}

	public static Float percent(Float member, Float denominator, Integer decimal) {

		if (denominator > 0) {
			decimal = (decimal > 1) ? decimal : 2;
			Integer tmp = 1;
			for (Integer i = 1; i <= decimal; i++) {
				tmp *= 10;
			}

			return (float) (Math.round(member * tmp * tmp / denominator)) / tmp;
		}
		return 0f;
	}

	
	public static String division(Integer member, Integer denominator, Integer decimal) {

		if (denominator > 0) {
			decimal = (decimal > 1) ? decimal : 2;
			Integer tmp = 1;
			for (Integer i = 1; i <= decimal; i++) {
				tmp *= 10;
			}
			Double f = (double) member;
			NumberFormat nf = NumberFormat.getInstance();
			nf.setGroupingUsed(false);
			
			return nf.format((float) (Math.round(f * tmp / denominator)) / tmp);
		}
		return "0";
	}

	public static Float division(Float member, Float denominator, Integer decimal) {

		if (denominator > 0) {
			decimal = (decimal > 1) ? decimal : 2;
			Integer tmp = 1;
			for (Integer i = 1; i <= decimal; i++) {
				tmp *= 10;
			}

			return (float) (Math.round(member * tmp / denominator)) / tmp;
		}
		return 0f;
	}

	public static int multiplication(Float multiplier, Integer multiplicand) {

		multiplier = multiplier * multiplicand;

		return multiplier.intValue();
	}

	public static Integer multiplication(Integer multiplier, Integer multiplicand) {

		multiplier = multiplier * multiplicand;

		return multiplier.intValue();
	}

	public static Float multiplication(Float... multipliers) {

		Float value = 1F;

		for (Float f : multipliers) {
			value *= f;
		}
		return value;
	}

	public static String format(Float value, Integer decimal) {

		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setGroupingUsed(false);
		nf.setMaximumFractionDigits(decimal);

		return nf.format(value.doubleValue());
	}

	public static Integer abs(Integer i) {
		return Math.abs(i);
	}

	public static Integer getMin(Integer i, Integer j) {
		return i < j ? i : j;
	}

	public static Integer getMax(Integer i, Integer j) {
		return i > j ? i : j;
	}

	public static Float getMin(Float i, Float j) {
		return i < j ? i : j;
	}

	public static Float getMax(Float i, Float j) {
		return i > j ? i : j;
	}

	public static Integer getDefaultValue(Integer value, Integer defaultValue) {
		if (!DataUtil.isValidData(value)) {
			value = defaultValue;
		}
		return value;
	}

	public static Float getDefaultValue(Float value, Float defaultValue) {
		if (!DataUtil.isValidData(value)) {
			value = defaultValue;
		}
		return value;
	}

	public static void main(String[] args) {

		System.out.println(division(102, 100, 2));
	}

	public static int compare(Float minValue, Float maxValue) {

		if (minValue < maxValue){
			return 1;
		}else if (minValue.floatValue() == maxValue.floatValue()){
			return 0;
		}
		return -1;
	}
}
