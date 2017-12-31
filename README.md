# java-enneagram

## About
Build a logic for Enneagram Survey Application

## Interface
* void readAll()
Read all of Mapped data in Data instance from Mysql connection
* void sendEvent(int type, int value)
Add values to Array in Data instance for finding appropriate type of the user

## Before getting started
1. Must create /src/p_config/Config.java
2. Define valuables in Class like below:
```
private final String src = "jdbc:mysql://host_address/db_name"; //<-- Set your values
private final String id = "username"; //<-- Set your values
private final String pw = "password"; //<-- Set your values
	
public String getUrl() {
	return url;
}
	
public String getId() {
	return id;
}
	
public String getPw() {
	return pw;
}
```
