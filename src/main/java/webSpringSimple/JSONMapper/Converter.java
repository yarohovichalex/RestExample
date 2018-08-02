package webSpringSimple.JSONMapper;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import webSpringSimple.entity.NewArr;

public class Converter {
private final static String baseFilePath = "src\\main\\resources\\simpleNew.json";
	
	public static void toJSON(NewArr newArr) {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			mapper.writeValue(new File(baseFilePath), newArr);
			
	        System.out.println("json created!");
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	public static String toJsonToo(NewArr newArr) {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			String json = ow.writeValueAsString(newArr);
			return json;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static NewArr toJavaObject()  {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(new File(baseFilePath), NewArr.class);
		} catch (IOException e) {
			System.out.println("error");
			e.printStackTrace();
		}
		return null;
	}
}
