package Planner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Arrays; 

public class Date {

public static void main(String[] args) {

String Event;
String inputString;
String Inputdays;
int version=0;
int version2=0;
int EventIncr = 0;
String InputNum;
int Days =0;
int Modulo;
int EventNum;
int ArrayNum = 30;
LocalDate ReminderD;
LocalDate ReminderW;
LocalDate ReminderM;
LocalDate ReminderY;
String ReminderDin = "null", ReminderWin = "null",ReminderMin = "null",ReminderYin = "null",Titlein = "null",Localbot = "null";
String[] EventUpdated = new String[ArrayNum]; //Array Holding Each Event Date, title and location by version 
String[] ReminderUpdated = new String[ArrayNum]; //Array Holding Each reminder by version
String priority = "null"; 



Scanner keyboard = new Scanner(System.in);

LocalDate myDateObj = LocalDate.now();
//System.out.println("Before formatting: " + myDateObj);

DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
String formattedDate = myDateObj.format(myFormatObj);
//System.out.println("After formatting: " + formattedDate);

System.out.println("How many Events would you like to set?");
InputNum = keyboard.nextLine();
EventNum = Integer.parseInt(InputNum);



for(int i = 0; EventNum > i; EventNum--){

		EventIncr++;
		System.out.println("Enter the priority for your event " + EventIncr  + " (high med low): ");
		priority = keyboard.nextLine();
	
		System.out.println("Enter Your Event date (use format yyyy-mm-dd) : ");
		inputString = keyboard.nextLine();
		Event= inputString;
		formattedDate = Event.substring(0, 9);          //Saves EventDate to formattedDate, for later use.


	if (Event.startsWith(formattedDate)) {
		System.out.println("Todays Date: "+ LocalDate.now()+ "\n" + "Event: " + Event);
		System.out.println("Give your Event a Title:");
		Titlein = keyboard.nextLine();
		System.out.println("Location of Event:");
		Localbot = keyboard.nextLine();



		LocalDate localDateR = LocalDate.now();
		
		if (priority.equalsIgnoreCase("high") || priority.equalsIgnoreCase("med")) {
		System.out.println("Enter in how many days you need your reminder: ");
		Inputdays = keyboard.nextLine();
		Days = Integer.parseInt(Inputdays);
		}
		else {}


	if(Days <= 6) { //Days
		
		if(priority.equalsIgnoreCase("high") || priority.equalsIgnoreCase("med")) {
		ReminderD = localDateR.plusDays(Days);
		System.out.println("Enter Your reminder notification message: ");
		ReminderDin = keyboard.nextLine();
		System.out.println( "Setting reminder for "+ Titlein + " Event located at " + Localbot + " on "  + ReminderD);
		//System.out.println("Reminder set for: "+ Days + " Days " + "\n"+ "The Date of your reminder is: " + ReminderD);
		}
		else {
			System.out.println("Event Created.");
		}

}

	else if(Days >= 7 && Days <= 29 ) { //Weeks

		if(priority.equalsIgnoreCase("high") || priority.equalsIgnoreCase("med")) {
		System.out.println("Enter Your reminder notification message: ");
		ReminderWin = keyboard.nextLine();
		Modulo = Days%7;
		Days = Days/7;
		System.out.println("Reminder set for: " + Days + " Weeks " + " And " + Modulo + " Days ");
		ReminderW = localDateR.plusWeeks(Days).plusDays(Modulo);
		System.out.println( "Setting reminder for "+ Titlein + " Event located at " + Localbot + " on "  + ReminderW);
		//System.out.println( "The Date of your reminder is: " + ReminderW);
		}
		else {
			System.out.println("Event Created.");
		}

}

	else if(Days >= 30 && Days <= 364) {  //Months

		if(priority.equalsIgnoreCase("high") || priority.equalsIgnoreCase("med")) {
		System.out.println("Enter Your reminder notification message: ");
		ReminderMin = keyboard.nextLine();
		Modulo = Days%30;
		Days = Days/30;
		System.out.println("Reminder set for: " + Days + " Months " + " And " + Modulo + " Days ");
		ReminderM= localDateR.plusMonths(Days).plusDays(Modulo);
		System.out.println( "Setting reminder for "+ Titlein + " Event located at " + Localbot + " on "  + ReminderM);
		}
		else {
			System.out.println("Event Created.");
		}

}

	else if(Days >= 365) { //Years

		if(priority.equalsIgnoreCase("high") || priority.equalsIgnoreCase("med")) {
		System.out.println("Enter Your reminder notification message: ");
		ReminderYin = keyboard.nextLine();
		Modulo = Days%365;
		Days = Days/365;
		System.out.println("Reminder set for: " + Days + " Years " + " And " + Modulo + " Days ");
		ReminderY = localDateR.plusYears(Days).plusDays(Modulo);
		System.out.println( "Setting reminder for "+ Titlein + " Event located at " + Localbot + " on "  + ReminderY);
		//System.out.println( "The Date of your reminder is: " + ReminderY);
		}
		else {
			System.out.println("Event Created.");
		}

}
}


version++;
EventUpdated[version] = "\n"+ Event + "\n" + Titlein + "\n" + Localbot + "v" + version;  //Saving Event Title and location in array with version

if (ReminderDin != "null") {                                                            //saving reminder in its own array with version
	version2++;
	ReminderUpdated[version2] = ReminderDin + "v" + version2;
	
}
else if (ReminderWin != "null") {
	version2++;
	ReminderUpdated[version2] = ReminderWin + "v" + version2;
	
}
else if (ReminderMin != "null") {
	version2++;
	ReminderUpdated[version2] = ReminderMin + "v" + version2;
	
}
else if (ReminderYin != "null") {
	version2++;
	ReminderUpdated[version2] = ReminderYin + "v" + version2;
	
}
}

System.out.println(Arrays.toString(ReminderUpdated));  //Test
keyboard.close();
}

}



	


