package com.project.demo.util;

import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Util {

	public static String writeValueAsString(Object value) {
		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.writeValueAsString(value);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static String generateUuid() {

		String result = UUID.randomUUID().toString();

		String resultMod = result.replace("-", "").substring(0, 10);

		return resultMod;

	}

	public static boolean fieldValidate(String value, String pattern) {

		Pattern pat = Pattern.compile(pattern);
		Matcher mat = pat.matcher(value);
		if (mat.matches()) {
			return true;
		} else {
			return false;
		}
	}

}
