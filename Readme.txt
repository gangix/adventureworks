DB Issues:
	I used RDS server(MySql) which runs on AWS.
	I created 2 tables for Spring Security (Basic Authentication)
	Schema and Data sql files are added under resources package of project. 

Application Issues:
	I used RabbitMQ for queue management. 
		Directly saving data in db and sending message to queue.
		RabbitMQ should be installed in machine.(It would be nice to run application in AWS as MySqlDB
		and then this could be not issue) 
	
		Consumer:
		Controlling words in comment. If there is/are bad words updates the review as inAppropriate and 
		does not send any notification to customer.
		if the comment passes kontrol , sends to customer notification email. 

	Security(Basic Authentication)
	I used Spring Basic Authentication with Database. I created new Entities , repositories, service etc 
	for security and put them in same package called  {spring main package}.auth.config.
	Saved password hashed(BCryptPasswordEncoderTest) in DB.
 
 Test :
 		(Used jacoco Tool)
 		in order to see test coverage. It s more than %60 .

Api UserName = adventure
Api Password = adventure
