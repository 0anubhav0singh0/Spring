// package com.spring;

// import java.util.ArrayList;

// public class EventList {

// 	ArrayList<Event> eventMenu = new ArrayList<>();
	
// 	public void insert(Event event) {
// 		//Fill your code here
// 		eventMenu.add(event);
// 	}
// 	public ArrayList<String> recommendfor(Double budget){
// 		//Fill your code here
// 		int flag=1;
// 		ArrayList<String> strList = new ArrayList<String>();
// 		for(Event event : eventMenu) {
// 			Double fare=event.getFare();
// 			if(budget>=fare) {
// 				Integer b = (int)(budget/fare);
// 				strList.add(event.getEventName()+"-"+String.valueOf(b));
// 			}else {
// 				flag=0;
// 			}
// 		}
// 		if(flag==0){
// 			System.out.println("No Shows available");
// 		}
// 		return strList;
// 	}

// }


package com.spring;

import java.util.*;

public class EventList {

	ArrayList<Event> eventMenu 		= new ArrayList<>();
	ArrayList<String> resultList 	= new ArrayList<>();
	ArrayList<Double> fareList 		= new ArrayList<>();

	public void insert(Event event) {
		//Fill your code here
		eventMenu.add(event);
	}
	
	public ArrayList<String> recommendfor(Double budget){
		for(Event e: eventMenu){
			fareList.add(e.getFare());
			// if(budget<e.getFare()){
			// 	result
			// }
			// System.out.println(e.getFare();
		}

		Collections.sort(fareList);
		// System.out.println(fareList.get(0));

		if( budget < fareList.get(0)){
			System.out.println("No Shows available");
		}else{
			for(Event e: eventMenu){
				Double noOfTicket = budget/e.getFare();
				// System.out.println(noOfTicket.intValue());
				String concatResult = e.getEventName()+"-"+noOfTicket.intValue();
				resultList.add(concatResult);
			}
		}

		// System.out.println(resultList);
		return resultList;
	}

}
