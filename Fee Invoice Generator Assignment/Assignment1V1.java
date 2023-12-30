/* 
 Noah Fuhrman
 Dr. Torosdagli
 COP3330-0002 
 3 Sept. 2023
 																			Assignment_1
 */


import java.util.Scanner; //delete module-info, causes issues with importing package


class Student { //initializing class (struct) called Student
	//I want to store the following properties: student's name, id, courses, and course hours
	String name;
	String id; 
	int course1; 
	int course2; 
	int hour1; 
	int hour2;
	
	//creating Student Object
	public Student(String name, String id, int course1, int hour1, int course2, int hour2) {
		//"this" keyword: allows me to access properties outside of scope of the object. 
		//for reference, I taught myself objects in javascript over the summer :) 
		this.id = id; 
		this.name = name;
		this.course1 = course1;
		this.hour1 = hour1; 
		this.course2 = course2;
		this.hour2 = hour2; 
	}
	
	//creating method to print out the formatting for our receipt 
	public void Format(double price1, double price2, double health, double total)
	{
		System.out.println("Thank you!"); 
		System.out.println("Fee invoice prepared for: " + name); 
		System.out.println("		 					"); 
		System.out.println("		 					"); 
		System.out.println("SIMPLE COLLEGE"); 
		System.out.println("ORLANDO FL 10101");
		System.out.println("*************************"); 
		System.out.println("		 								"); 
		System.out.println("Fee Invoice Prepared for:"); 
		System.out.println("[" + name + "]" + "[" + id + "]"); 
		System.out.println("           "); 
		System.out.println("1 Credit Hour = $120.25"); 
		System.out.println("           "); 
		System.out.println("CRN		CREDIT HOURS");
		System.out.println(course1 + "  		" + hour1 + "		" + "	$" + price1); 
		System.out.println(course2 + "		" + hour2 + "		" + "	$" + price2); 
		System.out.println("		 					"); 
		System.out.println("		Health & id fees" + "	$" + health);
		System.out.println("		 								"); 
		System.out.println("------------------------------------------"); 
		System.out.println("		Total Payments" + "		$" + total); 
		
		
		
		
	}
	
	//creating another method that calculates the cost of the course 
	public double CalcHours(int hour)
	{
		double coursePrice =  hour * 120.25; 
		return coursePrice; 
	}
}

public class Assignment1V1 { //must declare class with file name 
	public static void main(String[] args){ //must be present for code to run; "main function" 
		//setting up scanner input
		Scanner input = new Scanner(System.in); 
		
		//getting id from user input; input.nextLine enables the storing of strings
		System.out.println("Enter the Student's Id: "); 
		String id = input.nextLine(); 
		
		//getting student name from user input 
		System.out.println("Enter Student's full name: "); 
		String name = input.nextLine(); 
		System.out.println("               "); 
		
		//getting courses/course hours from user input
		System.out.println("enter crn/credit hours for the first class (like 5665/3: "); 
		String course1 = input.nextLine(); 
		System.out.println("enter crn/credit hours for the first class (like 5665/3: "); 
		String course2 = input.nextLine(); 
		
		//applying the split method to course/course hour user inputs and setting them as independent integers. 
		String [] array; 
		String str1, str2, str3, str4; 
		array = course1.split("/"); 
		str1 = array[0]; 
		str2 = array[1]; 
		int class1, hour1, class2, hour2; 
		class1 = Integer.parseInt(str1); 
		hour1 = Integer.parseInt(str2); 		
		String [] array2;
		array2 = course2.split("/"); 
		str3 = array2[0]; 
		str4 = array2[1]; 
		class2 = Integer.parseInt(str3); 
		hour2 = Integer.parseInt(str4); 
		
		
		//saving user-input variables to object instance, newStudent 
		Student newStudent = new Student(name, id, class1, hour1, class2, hour2); 
		
		//calling Student method, CalcHours, and saving calculation to variables price1 and price2 
		double price1 = newStudent.CalcHours(hour1); 
		double price2 = newStudent.CalcHours(hour2); 
		
		//setting variables to cost of health and total price
		double health = 35.00; 
		double total = price1 + price2 + health; 
		
		//calling Student method, format, to print out receipt with our new variables: price1, price2, health, and total. 
		System.out.println("               "); 
		newStudent.Format(price1, price2, health, total);
	}
}
