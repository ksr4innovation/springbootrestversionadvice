package com.snkit.restversionadvice;

import org.springframework.stereotype.Service;

@Service
public class LogConsoleHandler implements ErrorHandler {

	@Override
	public void handle(Throwable t) {
		t.printStackTrace();

	}

}
