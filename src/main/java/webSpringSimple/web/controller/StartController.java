package webSpringSimple.web.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import webSpringSimple.entity.Car;


@Controller
@RequestMapping(value = "/restt")
public class StartController {
	
	public static ArrayList<Car> cars = new ArrayList<>();

	static {
		cars.add(new Car(0,"aaa","aaaa"));
		cars.add(new Car(1,"bbb","bbbb"));
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		
//		model.addAttribute("message", "Spring 3 MVC - Hello World");
		return "index";
	}
	
	
	@RequestMapping(value = "/article", method = RequestMethod.GET)
	public String printArticle(ModelMap model) {
		
		return "articles";
	}
	
	@RequestMapping(value = "/admin_page", method = RequestMethod.GET)
	public String printAdminPage(ModelMap model) {
		
		return "admin_page";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String welcomePage(ModelMap model) {
		System.out.println(cars.size() + " size");
		model.addAttribute("message", "Hello");
		model.addAttribute("mycarlist", cars);

		return "login";
	}
	
	@RequestMapping(value = "/restp", method = RequestMethod.GET)
	public String restPage() {
		return "restPage";
	}
		
	@RequestMapping(value = "/index", method = RequestMethod.POST)
	@ResponseBody
//	(@RequestParam(value = "dept", required = false)String deptName)
	public String pageParam(@RequestParam(value = "log", required = false)String log) {
		System.out.println(log);
		System.out.println("asdfasdf");
		return "index";
	}
}
