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
String Title,Location,InputNum,update;
int Days;
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

		System.out.println("Enter in how many days you need your reminder:  : ");
		Inputdays = keyboard.nextLine();
		Days = Integer.parseInt(Inputdays);



	if(Days <= 6) { //Days

		ReminderD = localDateR.plusDays(Days);
		System.out.println("Enter Your reminder notification message: ");
		ReminderDin = keyboard.nextLine();
		System.out.println( "Setting reminder for "+ Titlein + " Event located at " + Localbot + " on "  + ReminderD);
		//System.out.println("Reminder set for: "+ Days + " Days " + "\n"+ "The Date of your reminder is: " + ReminderD);

}

	else if(Days >= 7 && Days <= 29 ) { //Weeks

		System.out.println("Enter Your reminder notification message: ");
		ReminderWin = keyboard.nextLine();
		Modulo = Days%7;
		Days = Days/7;
		System.out.println("Reminder set for: " + Days + " Weeks " + " And " + Modulo + " Days ");
		ReminderW = localDateR.plusWeeks(Days).plusDays(Modulo);
		System.out.println( "Setting reminder for "+ Titlein + " Event located at " + Localbot + " on "  + ReminderW);
		//System.out.println( "The Date of your reminder is: " + ReminderW);

}

	else if(Days >= 30 && Days <= 364) {  //Months

		System.out.println("Enter Your reminder notification message: ");
		ReminderMin = keyboard.nextLine();
		Modulo = Days%30;
		Days = Days/30;
		System.out.println("Reminder set for: " + Days + " Months " + " And " + Modulo + " Days ");
		ReminderM= localDateR.plusMonths(Days).plusDays(Modulo);
		System.out.println( "Setting reminder for "+ Titlein + " Event located at " + Localbot + " on "  + ReminderM);

}

	else if(Days >= 365) { //Years

		System.out.println("Enter Your reminder notification message: ");
		ReminderYin = keyboard.nextLine();
		Modulo = Days%365;
		Days = Days/365;
		System.out.println("Reminder set for: " + Days + " Years " + " And " + Modulo + " Days ");
		ReminderY = localDateR.plusYears(Days).plusDays(Modulo);
		System.out.println( "Setting reminder for "+ Titlein + " Event located at " + Localbot + " on "  + ReminderY);
		//System.out.println( "The Date of your reminder is: " + ReminderY);

}
}


version++;
EventUpdated[version] = "\n"+ Event + "\n" + Titlein + "\n" + Localbot + "v" + version;

if (ReminderDin != "null") {
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

System.out.println(Arrays.toString(EventUpdated));
keyboard.close();
}

}



	


