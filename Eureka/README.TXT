Eureka - Online Shopping Experience


-1) Create a schema in mysql : 
    schema name : eureka
    
  2) Do a maven build : 
      goals : clean install    (Make sure you have a successful build)
      
  3) Configure Apache Server (v9.0) on your IDE
      Run it on the Server 
       - There is a simple servlet, showing a welcoming message.
      
     
   Troubleshooting : (in case you run into errors)
    - Make sure to include the MavenDependencies in the Java build path ,
      when deploying the project to the server
      
      
For Email Support, Configure :
 
  <property name="username" value="foo@gmail.com" />
  <property name="password" value="password" />
	
in src/main/resources/applicationContext.xml
   