##IMPORTANT TERMS
- Spring Boot Security Secure our web application by default and further we can customize as per our need
- Authentication -> The identity of users are checked for providing the access to the system. User is Verified. validating that users are whom they claim to be.
- Authorization  -> Giving the user permission to access a specific resource or function.
- Filter 		   -> A filter is an object that is invoked at the preprocessing and postprocessing of a request.
	---------------						---------------
	|				| Request	 -------	|				|
	|	 Client		|----------|Filter|->	|	 Server		|
	|				|			 -------	|				|
	---------------						---------------


##HOW SPRING SECURITY WORKS?
- Spring security me filter hi sabse main kam karte hai
- Filter sirf bich me request pakad sakta hai, Filter ke pass authentication ki koi power nahi hai, to ye ek authentication ka object banayega 
  or uske andar basic information ko rakh dega or request ko delegate kar dega AUTHENTICATION MANAGER ke pass
- Authentication manager ki responsibility hai ki jp authentication object mila hai jiske andar detail hai usko authenticate karna ki banda valid hai li nahi 
  To Authentication manager kya karta hai ki ek authenticate(Authentication auth) naam ka function call karta hai 
  Authentication manager basically interface hai to authenticate ki funcationallity iske pass nahi hai to authentication ko call karne ke liye bhaut saare alag-alag
	Authentication Providers hai (ye call kar sakte hai authentication ko)
- Authentication manager ye nahi samajh payega ki konsa Authentication provider hamare liye suitable hai to Authenticatio Provider kya kart ahi ki ye call karta hai PROVIDER MANAGER
  PROVIDER MANAGER ke pass ye power hai ki wo check karega ki konsa AUthentication Provider suitable hai hamare request ko authenticate karne ke liye
  To supose koi ek Authentication Provider suitable nikla authentication ke liye to wo Authentication Provider true return karega
  To Authentication manager help lega ___UserDetailService___ ki (iske andar wo funcation hoat hai jo database se data ko lata hai) ye iske help lega and Authentication Provider
	hamare autheticate function ko call kar lega or yaha se authentication ho jayega jab authetication ho jayega tab ye ussi Authetication object ke andar ek authentication true karke property 
	hoti hai usko set kardega that means valid authentication object return kardega hamare Provider manager ko
	Provider kya karega simply filter ko wo valid authetication ka object bhej dega or ye FILTER kya karega ki security context me wo authentication set kar dega


			----------------------------------------				 -------------------
			|											|				 |					 |
			|		     Authentication				|		|------>| Authentication	 |
			|				  Manager					|		|		 |   Provider		 |
			|											|		|		 -------------------
			----------------------------------------		|												
					^							|				|		 -------------------
					|	authenticate(Authentication auth)	|		 |					 |
					|							|				|------>| Authentication	 |
					|							|				|		 |	  Provider		 |
					|							|			   |		 -------------------
					|							V			  	|
request		--------------	-----		  -------------		| true	 ------------------   	----------------------
--------->	|					|		  |				|------|------>|					|----->|						|	
			|	  Filter		|<-------|  Provider	|<-------------| Authentication	|<-----| UserDetailService	|
			|(Authentication)	|		  |	  Manager	|	    		 |	  Provider		|		----------------------
			|					|		  -------------			     ------------------
			|					|-------> Set the autehntication to securitycontext 
			-------------------


##Spring @EnableWebSecurity Example
- The Spring Security @EnableWebSecurity annotation is annotated at class level with @Configuration annotation to enable web securities in our application defined by WebSecurityConfigurer implementations. 
- The WebSecurityConfigurerAdapter is the implementation class of WebSecurityConfigurer interface. The @EnableWebSecurity enables the web securities defined by WebSecurityConfigurerAdapter automatically. 
- To override web securities defined by WebSecurityConfigurerAdapter in our Java configuration class, we need to extend this class and override its methods.


##What is configure HttpSecurity HTTP?
- A HttpSecurity is similar to Spring Security's XML <http> element in the namespace configuration. It allows configuring web based security for specific http requests. By default it will be applied to all requests, but can be restricted using requestMatcher(RequestMatcher) or other similar methods.


##AntMatcher
- By default koi URL public karna hai ya home page public karna hai to aap waha pe urls ko match kara sakte ho
- The antMatchers() is a Springboot HTTP method used to configure the URL paths from which the Springboot application security should permit requests based on the user’s roles. 
- The antmatchers() method is an overloaded method that receives both the HTTP request methods and the specific URLs as its arguments.
- Springboot uses the antmatchers() to protect URLs by binding patterns representing the application’s endpoints to specific users. Then it either permits or denies access to these URLs based on the roles or permissions of the users. 


##FORM BASED AUTHENTICATION (Website ka standard method hai)
- Username & Password
- Standard in most websites
- FOrms (Full Control)
- Can Logout
- HTTPS recommended
- Username & Password dena hota hai POST method me
- UserId or Password nahi bhejna baar baar sessionid se hi authentication ho jayega

	------------									------------
	|  client	|									|  server	|
	------------									------------
		|	POST username password						|
		|------------------------------------------->	|
		|													|<-------- Validates credentials
		|													|
		|<-------------------OK----------------------	|
		|													|
		|<-------------Cookies SESSIONID-------------	|
		|													|
		|---------Any equest with SESSIONID--------->	|
		|													|
		|													|<-------- Validates SESSIONID
		|<-----------------200 OK--------------------	|
		|													|
