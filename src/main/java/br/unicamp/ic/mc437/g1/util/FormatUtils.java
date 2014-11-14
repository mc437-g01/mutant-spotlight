package br.unicamp.ic.mc437.g1.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FormatUtils {
	
	/**
	 * Gets the id from a key: e.g. returns "TC_01" from the key "D:\tmp\MGEO\TESTE_00\Tests\TS_01\TC_01.ecase" 
	 * @param key
	 * @return id
	 */
	public static String getIdFromKey(String key) {
		String pattern = "\\\\([^\\\\]+)\\.[^\\.]+$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(key);
		if (m.find()) {
			return m.group(1);
		} else {
			throw new RuntimeException("Id not found in key \""+key+"\"");
		}
	}
	
	public static String extractNumber(String string) {
		String pattern = "[0-9]+";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(string);
		if (m.find()) {
			return m.group();
		} else {
			throw new RuntimeException("Number not found in string \""+string+"\"");
		}
	}
	
	public static String getMutantOperator(String path) {
		String pattern = "MUT\\$([^\\\\\\$]+)\\$([0-9]+)\\.[^\\.]+$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(path);
		if (m.find()) {
			return m.group(1) + " " + m.group(2);
		} else {
			throw new RuntimeException("Id not found in key \""+path+"\"");
		}
	}
	
	public static String getMutantOperatorName(String path) {
		String pattern = "MUT\\$([^\\\\\\$]+)\\$([0-9]+)\\.[^\\.]+$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(path);
		if (m.find()) {
			return m.group(1);
		} else {
			throw new RuntimeException("Id not found in key \""+path+"\"");
		}
	}
	
	public static String getMutantOperatorIndex(String path) {
		String pattern = "MUT\\$([^\\\\\\$]+)\\$([0-9]+)\\.[^\\.]+$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(path);
		if (m.find()) {
			return m.group(2);
		} else {
			throw new RuntimeException("Id not found in key \""+path+"\"");
		}
	}
	
	public static String yesNo(boolean yes) {
		return yes ? "Sim" : "Não";
	}
}
