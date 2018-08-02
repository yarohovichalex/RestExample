package webSpringSimple.web.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import webSpringSimple.entity.Car;
import webSpringSimple.entity.NewArr;
import webSpringSimple.entity.SimpleNew;

@RestController
@RequestMapping(value = "/article")
public class RestControllerClass {
	public static ArrayList<Car> cars = new ArrayList<>();

	static {
		cars.add(new Car(1,"aaa","aaaa"));
		cars.add(new Car(2,"bbb","bbbb"));
	}
	 SimpleNew sn1 = new SimpleNew(1,"http://via.placeholder.com/350x150", "Title1", "Lorem Ipsum is simply dummy text");
	 SimpleNew sn2 = new SimpleNew(2,"http://via.placeholder.com/350x150", "Title2", "Lorem Ipsum is simply dummy text");
	 SimpleNew sn3 = new SimpleNew(3,"http://via.placeholder.com/350x150", "Title3", "Lorem Ipsum is simply dummy text");
	 SimpleNew[] simpleErrArr = {sn1, sn2};
	 NewArr  errorArr = new NewArr(simpleErrArr);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public  NewArr cars(ModelMap model) {
		System.out.println("in cars");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("carlist");
        modelAndView.addObject("mycarlist", cars);
		SimpleNew[] simpleNewArr = {sn1, sn2, sn3};
		NewArr  newArr = new NewArr(simpleNewArr);
        return newArr;
	}
	@RequestMapping(value = "/", method = RequestMethod.POST, consumes = "application/json")
	@ResponseBody
	public SimpleNew addCar(@RequestBody SimpleNew simpleNew) {
		System.out.println("image path " + simpleNew);
		if (simpleNew != null) {
			return simpleNew;
		}
		return simpleNew;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public  @ResponseBody void deleteCar(@PathVariable("id") int id) {
		System.out.println("I deleteCar car=" + id);
		if (id != 0) {
			System.out.println("del");
		}
	}
}
