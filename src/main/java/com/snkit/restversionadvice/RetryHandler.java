package com.snkit.restversionadvice;

import org.springframework.stereotype.Service;

@Service
public class RetryHandler implements ErrorHandler {

	@Override
	public void handle(Throwable t) {
		
		
		for (int i=0;i<10;i++) {
			System.out.println("   from Retry handler");
		}

	}

}
