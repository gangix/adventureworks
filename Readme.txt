DB Issues:
	I excecuted all script(AWBackup.sql) in my db and it didnt get any error.
	I used RDS server which runs on AWS.
	I convert productEntity primary key as BIGINT because i used long in application. 
	I created one more column productreview table, in order to hold InAppropriate info
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
	I used Spring Basic Authentication with Database. I created new Entities , repositories, services etc 
	in same package called  {spring main package}.auth.config 
	Saved password hashed(BCryptPasswordEncoderTest) in DB.
 
 Test :
 		(Used jacoco Tool)
 		in order to see test coverage. It s more than %60 . 


  1) Make sure to run unit tests,check code coverage, ensure application is compiling and all dependencies are included.
  2) Commit everything using (git add --all && git commit -m "My submission")
  3) Create patch file with name without spaces 'cross-solar-java_<YourNameHere>.patch', using the specified tag as the starting point (git format-patch initial-commit --stdout > cross-solar-java_<yournamehere>.patch)
  4) Store your file in a shared location where Crossover team can access and download it for evaluation. and add your sharable link in the answer field of this question.


