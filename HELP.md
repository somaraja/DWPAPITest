# Department for Work and Pensions API Challenge
# Programmer - Somaraja Surampudi

## Problem
Using the language of your choice please build your own API which calls the API at https://bpdts-test-app.herokuapp.com/, and returns people who are listed as either living in London, or whose current coordinates are within 50 miles of London.

## Approach
I have used Spring Boot Rest API to develop services like getting all users, getting users based on city, and getting users whose current coordinates are within X miles of certain city.

## Run a project
Do "mvn clean install" on DWPAPITest project, it will create DWPAPITest-0.0.1-SNAPSHOT.jar under target folder.
Then run this jar file using command "java -jar DWPAPITest-0.0.1-SNAPSHOT.jar" under targer folder. Once server is up and running we can try and invoke any one of the following said end points either using postman or browser. 

### End Points
Following are the 3 end points and will get responses in json format,
1) http://localhost:8081/dwpapitest/users (This is GET method to get all users using above mentioned API)
2) http://localhost:8081/dwpapitest/users/city?city=London (This is GET method to get users belongs to certain city using above mentioned API, Note here city is dynamic value)
3) http://localhost:8081/dwpapitest/users/coordinates?city=London&distance=50 (This is GET method to get users belongs to certain city and with in certain distance using above mentioned API, Note here city and distance are dynamic values)



