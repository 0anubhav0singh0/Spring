package com.aop;

import org.springframework.stereotype.Component;

@Component
public class Student {
	public int study(int i, int j) {
		System.out.println("i am in school and studying right now !" + i + j);
		return 0;
	}

//	public String doOperation() {
//		throw new MyException("this is my exception..!!");
//	}

	public int rankOfVideo(int noOfViews, int watchtime) {
		return (noOfViews * watchtime) - (noOfViews + watchtime);
	}
}
