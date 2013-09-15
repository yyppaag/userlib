package com.xoyogame.utils;

import java.security.MessageDigest;
import java.util.Locale;

public final class Utils {
	public static Boolean stringIsNullOrEmpty(String str) {
		if (str == null || "".equals(str)) {
			return true;
		}

		return false;
	}

	public static String getMD5String(String str) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

		char[] charArray = str.toCharArray();
		byte[] byteArray = new byte[charArray.length];

		for (int i = 0; i < charArray.length; i++) {
			byteArray[i] = (byte) charArray[i];
		}
		byte[] md5Bytes = md5.digest(byteArray);

		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16) {
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		
		return hexValue.toString().toUpperCase(Locale.getDefault());
	}
}
