// import java.io.BufferedReader;
// import java.io.InputStreamReader;
// import java.util.ArrayList;
// import java.util.logging.Level;
// import java.util.logging.Logger;
// import java.io.*;

// import org.springframework.beans.factory.BeanFactory;
// //import org.springframework.beans.factory.xml.XmlBeanFactory;
// import org.springframework.context.ApplicationContext;
// import org.springframework.context.ApplicationContext;
// import org.springframework.context.support.ClassPathXmlApplicationContext;
// import org.springframework.core.io.ClassPathResource;
// import org.springframework.core.io.Resource;

// import com.spring.Event;
// import com.spring.EventList;

// public class Main {

// 	public static void main(String[] args) throws IOException {
// 		Logger log = Logger.getLogger("org.hibernate");
// 		log.setLevel(Level.OFF);
// 		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
// 		//Fill your code here
// 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 		ApplicationContext factory =new ClassPathXmlApplicationContext("applicationContext.xml");
// 		Event e1 = (Event)factory.getBean("event1");
// 		Event e2 = (Event)factory.getBean("event2");
// 		Event e3 = (Event)factory.getBean("event3");
		
// 		EventList ev = new EventList();
// 		ev.insert(e1);
// 		ev.insert(e2);
// 		ev.insert(e3);
		
// 		System.out.println("Enter your Budget");
// 		Double budget = Double.parseDouble(br.readLine());
// 		ArrayList<String> list =ev.recommendfor(budget);
// 		for(String s:list) {
// 			System.out.println(s);
// 		}
// 	}
// }



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

// import org.springframework.beans.factory.BeanFactory;
// import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.spring.Event;
import com.spring.EventList;

public class Main {

	public static void main(String[] args) throws Exception {
		Logger log = Logger.getLogger("org.hibernate");
		log.setLevel(Level.OFF);
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
		//Fill your code here
				EventList eventList = new EventList();

                ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
                Event event1 = (Event) context.getBean("event1");
                // System.out.println(event1);
				eventList.insert(event1);

				Event event2 = (Event) context.getBean("event2");
                // System.out.println(event2);
				eventList.insert(event2);
				
				Event event3 = (Event) context.getBean("event3");
                // System.out.println(event3);
				eventList.insert(event3);

				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

				System.out.println("Enter your Budget");
				Double budget = Double.parseDouble(br.readLine());
				// System.out.println(budget);

				ArrayList<String> strList =	eventList.recommendfor(budget);

				for(String s: strList){
					System.out.println(s);
				}
                
	}

}

