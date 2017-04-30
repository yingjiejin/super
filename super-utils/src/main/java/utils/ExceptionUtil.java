package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class ExceptionUtil {

	private static String packageName = "com.sihuanian";

	private static final Logger log = LoggerFactory
		.getLogger(ExceptionUtil.class);

	private ExceptionUtil() {
	}

	/**
	 * save exception message
	 * @param e
	 * @param clazz  The class that threw the Exception
	 */
	public static void setException(Exception e, Class<?> clazz) {
		StringBuffer sb = new StringBuffer(StringUtil.LF);
		sb.append("****************Exception****************");
		String causedBy = getCauseByMsg(e);
		if (causedBy != null) {
			sb.append(StringUtil.LF);
			sb.append(causedBy);
		}
		StackTraceElement[] traces = getStackTrace(e.getStackTrace(), clazz);
		if (traces != null) {
			if (traces[1] != null
				&& traces[1].getClassName().startsWith(packageName)) {

				sb.append("************1************");
				sb.append(StringUtil.LF);
				sb.append("The Class Name is : ");
				sb.append(traces[1].getClassName());
				sb.append(StringUtil.LF);
				sb.append("The Function Name is : ");
				sb.append(traces[1].getMethodName());
				sb.append(StringUtil.LF);
				sb.append("the Line Number is : ");
				sb.append(traces[1].getLineNumber());
				sb.append(StringUtil.LF);
				sb.append(e.getMessage());
				sb.append(" @ ");
				sb.append(traces[1].toString());
				sb.append(StringUtil.LF);
				sb.append("************1************");
				sb.append(StringUtil.LF);
				// The exception threw by invoked method
				sb.append("************2************");
				sb.append(StringUtil.LF);
				sb.append("The Class Name is : ");
				sb.append(traces[0].getClassName());
				sb.append(StringUtil.LF);
				sb.append("The Function Name is : ");
				sb.append(traces[0].getMethodName());
				sb.append(StringUtil.LF);
				sb.append("the Line Number is : ");
				sb.append(traces[0].getLineNumber());
				sb.append(StringUtil.LF);
				sb.append(e.getMessage());
				sb.append(" @ ");
				sb.append(traces[0].toString());
				sb.append(StringUtil.LF);
				sb.append("************2************");
			} else {
				sb.append("The Class Name is : ");
				sb.append(traces[0].getClassName());
				sb.append(StringUtil.LF);
				sb.append("The Function Name is : ");
				sb.append(traces[0].getMethodName());
				sb.append(StringUtil.LF);
				sb.append("the Line Number is : ");
				sb.append(traces[0].getLineNumber());
				sb.append(StringUtil.LF);
				sb.append(e.getMessage());
				sb.append(" @ ");
				sb.append(traces[0].toString());
			}
		} else {
			sb.append("the Exception Message is :");
			sb.append(e.getMessage());
		}
		sb.append(StringUtil.LF);
		sb.append("****************Exception****************");
		sb.append(StringUtil.LF);
		log.error(sb.toString());
	}

	private static StackTraceElement[] getStackTrace(StackTraceElement[] stes,
																									 Class<?> clazz) {
		if (stes.length > 0) {
			Integer i = 0;
			for (StackTraceElement trace : stes) {

				if (trace.getClassName().equals(clazz.getName())) {
					break;
				}
				i++;
			}
			if (i < stes.length - 2) {
				return new StackTraceElement[] { stes[i], stes[i + 1] };
			}
		}

		return null;
	}

	private static String getCauseByMsg(Exception e) {
		if (e.getCause() != null) {
			StackTraceElement[] traces = e.getCause().getStackTrace();
			if (traces.length > 0) {
				StringBuffer sb = new StringBuffer("Cause by : ");
				sb.append(e.getCause().getMessage());
				sb.append(StringUtil.LF);
				return sb.toString();
			}
		}
		return null;
	}
}
