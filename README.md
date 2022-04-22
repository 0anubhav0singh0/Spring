@ModelAttribute at the Method Level - The impact of @ModelAttribute when placed over a method.
	- A method with a @ModelAttribute on top it executes first, followed by a handler method.
	- Using @ModelAttribute at the method level, we can set data in the Model before a handler method executes.
		- In simple words it helps us to prepopulate the Model object before a RequestMapping invokes
	- We can set all the common attributes inside a method by marking it with a @ModelAttribute so that those data will be availabel during each request
	- Using @ModelAttribute at the method level, We can also set global data for our web app
	- Any data we set inside a method annoted with @ModelAttribute, Availabel to every request of a controller
	- When used as method parameters, the indicated parameters should be retrieved from the model. 
	  If it does not exist, it should be instantiated first and then added to the model. 
	  Once it appears in the model, the parameter field should be populated from all request parameters with matching names.


difference between @RequestParam and @ModelAttribute
	- @ModelAttribute: Bind the entire Java object (such as Employee). Support multiple request parameters
	- @RequestParam: Combine a single request parameter (like firstName)
	- @RequestParam is most suitable for reading a small params.
	- @ModelAttribute is used for forms with a large number of fields.
	- @ModelAttribute provides you with additional features such as data binding, validation and form pre-filling.
	- When using @RequestParam() and @RequestBody at the same time, the parameters specified by @RequestParam() can be ordinary elements, arrays, collections, objects, etc.


@RequestBody
	- @RequestBody is mainly used to receive the data in the json string passed from the front end to the back end (data in the request body);
	- @RequestBody is used for post requests, not for get requests.
	- Note: A request has only one RequestBody; a request can have multiple RequestParams.


FETCH TYPE
	- LAZY 	:- In Lazy loading, associated data loads only when we explicitly call getter or size method
	- EAGER :- It is a design pattern in which data loading occurs on the spot
