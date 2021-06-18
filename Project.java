package Poised;

import java.util.InputMismatchException;

public class Project {
	// store project information
	int projectNumber;
	String projectName;
	String projectType;
	String projectAdress;
	String projectDeadline;
	int erfNumber;
	double totalFee;
	double amountPaid;

	
	
	public Project(int projectNumber, String projectName,String projectType, String projectAdress, String projectDeadline, int erfNumber, double totalFee, double amountPaid){
		//store the information
		this.projectNumber = projectNumber;
		this.projectName = projectName;
		this.projectType = projectType;
		this.projectAdress = projectAdress;
		this.projectDeadline = projectDeadline;
		this.erfNumber = erfNumber;
		this.totalFee = totalFee;
		this.amountPaid = amountPaid;		
	}

	
	public int getProjectNum() {
		return projectNumber;
	}
	
	public double getAmount() {
		return amountPaid;
	}
	
	public String toString() {
		// create format for information to be print out 
		String output = "Project Number: " + projectNumber ;
		output += "\nProject Name: " + projectName ;
		output += "\nProject Type: " + projectType ;
		output += "\nProject Adress: " + projectAdress ;
		output += "\nProjeact Deadline: " + projectDeadline ;
		output += "\nERF number: " + erfNumber ;
		output += "\nTotal Fee R: " + totalFee ;
		output += "\nAmount Paid R: " + amountPaid ;
		
		return output;
		 
	}
}



