package com.snkit.restversionadvice;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@RestController
public class DemoVersionController {
	
	DemoService demoService;
	public DemoVersionController(DemoService demoService) {
		this.demoService = demoService;
	}
	

		
	@PostMapping(value="/api/rest/getEmp",consumes= {"application/json"},produces= {"application/json","application/xml"})
	public List<Employee> getEmployees(@RequestBody DemoInputVO inputVO){
		List<Employee> list= new ArrayList<Employee>();
		
		Employee e = new Employee();
		e.setFname("demo1");
		e.setLname("demo2");;
		list.add(e);	
		
		Employee e2 = new Employee();
		e2.setFname("demo21");
		e2.setLname("demo22");;
		list.add(e2);		
		
		
		return list;
		
		
	}
	
	
	
	@PostMapping(value="/api/rest/getEmp",consumes=Constants.consumer_content,produces= {"application/vnd.snkit-v2+json","application/vnd.snkit-v2+xml"})
	public List<Employee> getEmployeesupdate(@Valid @RequestBody DemoInputVO inputVO) throws FileNotFoundException{
		List<Employee> list= new ArrayList<Employee>();
		
		Employee e = new Employee();
		e.setFname("demo1");
		e.setLname("demo2");;
		list.add(e);
		
		
		Employee e2 = new Employee();
		e2.setFname("demo21");
		e2.setLname(inputVO.getEmail());;
		list.add(e2);
		
		String str=null;
		
		//str.toLowerCase();
		
		demoService.getEmp();
		
		return list;
		
		
	}
	
	


}
