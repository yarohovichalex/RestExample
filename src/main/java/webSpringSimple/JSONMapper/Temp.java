package webSpringSimple.JSONMapper;

import webSpringSimple.entity.NewArr;
import webSpringSimple.entity.SimpleNew;

public class Temp {
	
	public static void main(String[] args) {
		SimpleNew sn1 = new SimpleNew(1,"http://via.placeholder.com/350x150", "Title1", "Lorem Ipsum is simply dummy text");
		SimpleNew sn2 = new SimpleNew(2,"http://via.placeholder.com/350x150", "Title2", "Lorem Ipsum is simply dummy text");
		SimpleNew[] simpleNewArr = {sn1, sn2};
		NewArr  newArr = new NewArr(simpleNewArr); 
		Converter.toJSON(newArr);
		Converter.toJsonToo(newArr);
		System.out.println(newArr);
		NewArr ass = Converter.toJavaObject();
		System.out.println(ass);
		
	}
}
