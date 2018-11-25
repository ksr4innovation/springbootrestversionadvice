package com.snkit.restversionadvice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class DemoService {

	public void getEmp() throws FileNotFoundException {
		System.out.println("  From demoservice getEmp ");
		
		File file = new File("");
		
		file.isFile();
		
	
			FileInputStream fis = new FileInputStream(file);
		
		
		
		throw new DemoException(UUID.randomUUID().toString(),"User not found");
	}
}
