package com.spring;

import java.util.ArrayList;

public class EventList {

	ArrayList<Event> eventMenu = new ArrayList<>();
	
	public void insert(Event event) {
		//Fill your code here
		eventMenu.add(event);
	}
	public ArrayList<String> recommendfor(Double budget){
		//Fill your code here
		int flag=1;
		ArrayList<String> strList = new ArrayList<String>();
		for(Event event : eventMenu) {
			Double fare=event.getFare();
			if(budget>=fare) {
				Integer b = (int)(budget/fare);
				strList.add(event.getEventName()+"-"+String.valueOf(b));
			}else {
				flag=0;
			}
		}
		if(flag==0){
			System.out.println("No Shows available");
		}
		return strList;
	}

}
