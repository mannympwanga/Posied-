package Poised;
import java.util.*;
import java.sql.*;


public class PoisedEngineering 	
{

	//Connect to database
	static final String DB_URL = "jdbc:mysql://localhost:3306/PoisePMS?user=root";
	static final String USER = "root";
	static final String PASS = "Manny@Nf201";
	static final String QUERY1 = "SELECT  proj_num, proj_name, proj_type, proj_address, erf_num, total_paid, total_fee, proj_deadline FROM Project";
	static final String QUERY2 = "SELECT  proj_num, name, telephone_num, email, address FROM Architect";
	static final String QUERY3 = "SELECT  proj_num, name, telephone_num, email, address FROM contractor";
	static final String QUERY4 = "SELECT  proj_num, name, telephone_num, email, address FROM customer";
	
	/**
	 * Main Method 
	 * */
	  public static void main(String[] args) 
	  {
	    // print out a welcome statement
	    System.out.print("WELCOME TO POISED ENGINEERING\n");

	    // call back the console method
	    extracted();
		
	  }
	  
	  /**
	   * Method
	   * */
	  
	  private static void extracted() 
	  {
		    int choice;

		    int userInput;
		    int projectNumber = 0;
		    String projectName;
		    String projectType;
		    String projectAdress;
		    String projectDeadline;
		    int erfNumber = 0;
		    double totalFee;
		    double amountPaid;

		    String architectName;
		    int arcTelephoneNum;
		    String arcEmail;
		    String arcAddress;

		    String contaractorName;
		    int telephoneNumber;
		    String conEmail;
		    String conAddress;

		    String customerName;
		    int telephoneNum;
		    String email;
		    String address;

		    final int create = 0;
		    final int edit = 1;
		    final int invoice = 2;
		    final int search = 3;
		    final int exit = 4;
		    
			// create scanner to take in user input
			Scanner scan = new Scanner(System.in).useDelimiter("\r\n");
			
			// create a try and catch if database/ table is not found within user
			try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement();
					ResultSet rs1 = stmt.executeQuery(QUERY1);
					ResultSet rs2 = stmt.executeQuery(QUERY2);
					ResultSet rs3 = stmt.executeQuery(QUERY3);
					ResultSet rs4 = stmt.executeQuery(QUERY4);)
			{
				// Menu for user to see option the y can select
				System.out.println("0: Create new project\n1: Edit Project\n2: Generate Inovice\n3: Search\n4: Exit ");
				userInput = scan.nextInt();
				
				if (userInput == create) 
				{
				  // if user choice to create new project 
				  //request user to enter project information
				  while (true) 
				  {
				    // create a try and catch in case user enter wrong value
					  try 
					    {
						  // request user to enter a project number for the project
					      System.out.println("Enter project number: ");
					      projectNumber = scan.nextInt();

					      // request user to enter a name for project
					      System.out.println("Enter project name: ");
					      projectName = scan.next();
					      scan.nextLine();

					      // request user to enter the type of project
					      System.out.println("Enter project Type: ");
					      projectType = scan.next();

					      // request user to enter the address where project is being done
					      System.out.println("Enter address for project site: ");
					      projectAdress = scan.next();
					      scan.nextLine();

					      // request user to  enter  the deadline for project
					      System.out.println("Enter deadline for project: ");
					      projectDeadline = scan.next();
					      scan.nextLine();

					      // request user to enter the erf number to be assigned to project
					      System.out.println("Enter ERF NUmber: ");
					      erfNumber = scan.nextInt();

					      // Request user to enter a total of the project
					      System.out.println("Enter Total Fee: ");
					      totalFee = scan.nextDouble();

					      // request user to enter the amount that has been paid 
					      System.out.println("Enter the amount that has been paid");
					      amountPaid = scan.nextDouble();
					      
					      // print out details of the new project
					      Project newpro = new Project(projectNumber, projectName, projectType, projectAdress, projectDeadline, erfNumber, totalFee, amountPaid);
					      System.out.println("\n" + newpro + "\n");
					      
					      // right the new details into the data base 
			    			stmt.executeUpdate("INSERT INTO Project VALUE('"+projectNumber+"','"+projectName+"','"+projectType+"','"+projectAdress+"','"+erfNumber+"', '"+amountPaid+"', '"+totalFee+"', '"+projectDeadline+"')");
			    			System.out.println("Book Has Been Add");

					      // request user to input Architect information
			    			// request user to enter the name of the architect
					      System.out.println("Enter Architect name for project: ");
					      architectName = scan.next();

					      // request user to enter the phone number of the architect
					      System.out.println("Enter Architect telephone number: ");
					      arcTelephoneNum = scan.nextInt();

					   // request user to enter the  email address of the architect
					      System.out.println("Enter Architect email address");
					      arcEmail = scan.next();
					      
					   // request user to enter the physical address of the architect
					      System.out.println("Enter Architect pyhsical address");
					      arcAddress = scan.next();
					      scan.nextLine();

					      // print out the details of the architect
					      Details arc = new Details(architectName, arcTelephoneNum, arcEmail, arcAddress);
					      System.out.println("\nArchitect\n" + arc + "\n");
					      
					      
					      // write architect details in database
			    			stmt.executeUpdate("INSERT INTO Architect VALUE('"+projectNumber+"','"+architectName+"','"+arcTelephoneNum+"','"+arcEmail+"', '"+arcAddress+"')");
			    			System.out.println("Architect Has Been Add To Database\n");

					      // request user to input contractor information
			    			// request user to enter the name of the contractor
					      System.out.println("Enter Contaractor name for project: ");
					      contaractorName = scan.next();

					   // request user to enter the telephone number of the contractor
					      System.out.println("Enter Contaractor telephone number: ");
					      telephoneNumber = scan.nextInt();

					   // request user to enter the email address of the contractor
					      System.out.println("Enter Contaractor email address");
					      conEmail = scan.next();
					      scan.nextLine();

					   // request user to enter the physical address of the contractor
					      System.out.println("Enter Contaractor pyhsical address");
					      conAddress = scan.next();
					      scan.nextLine();
					      

					      // print out the new contractor information
					      Details cont = new Details(contaractorName, telephoneNumber, conEmail, conAddress);
					      System.out.println("\nContractor\n" + cont + "\n");
					      
					      // write the contractor information into the database
			    			stmt.executeUpdate("INSERT INTO contractor VALUE('"+projectNumber+"','"+contaractorName+"','"+telephoneNumber+"','"+conEmail+"', '"+conAddress+"')");
			    			System.out.println("Contractor Has Been Add To Database\n");

					      // request user to input customer information
			    			// request user to enter the physical address of the customer
					      System.out.println("Enter Customer name for project: ");
					      customerName = scan.next();

					   // request user to enter the telephone numbers of the customer
					      System.out.println("Enter Customer telephone number: ");
					      telephoneNum = scan.nextInt();

					   // request user to enter the email address of the customer
					      System.out.println("Enter Customer email address");
					      email = scan.next();
					      
					   // request user to enter the physical address of the customer
					      System.out.println("Enter Customer pyhsical address");
					      address = scan.next();
					      scan.nextLine();

					      // print out customer details 
					      Details cust = new Details(customerName, telephoneNum, email, address);
					      System.out.println("\nCustomer\n" + cust + "\n");
					      
					      // write user information into database
			    			stmt.executeUpdate("INSERT INTO Customer VALUE('"+projectNumber+"','"+customerName+"','"+telephoneNum+"','"+email+"', '"+address+"')");
			    			System.out.println("Customer Has Been Add To Database\n");
					      
					      System.out.println("New Project Created");
					      break;

					    } 
					  catch (InputMismatchException ex) 
					    {
						  // error message for invalid option
					      System.out.println("Invalid Input");
					      scan.next();
					    } catch (SQLException e) {
	
					    	// error massage if database not founded
							e.printStackTrace();
						}
				  }
				  } else if (userInput == edit) 
					{
					  // if user choice to edit information 
					  // create choice menu of user to choose what they want
					  // create a while loop to keep on running till user enter a valid option
					    try 
					    {
					      // create a try and catch  in case user enters an invalid option 
					      // if user choice to edit information 
					      // create choice menu of user to choose what they want
					    	System.out.println("\nPlease enter Project number");
					    	projectNumber = scan.nextInt();
					    	
					      System.out.println("\n1:Change Due Date\n2: Change Total Amount paid\n3:Update Contact Details ");
					      choice = scan.nextInt();

					      if (choice == 1) 
					      {
					        // request user to enter new deadline
					        System.out.println("Please enter new Deadline");
					        projectDeadline = scan.next();
					        
					        // print confirmation message of change  of deadline
					        System.out.println("Deadline Changed to " + projectDeadline);
					        
					       // Update deadline in database
					        stmt.executeUpdate("UPDATE Project SET proj_deadline = '"+projectDeadline+"' WHERE proj_num = '"+projectNumber+"'");
					        System.out.println("Deadline Has be changed in database ");

					      } else if (choice == 2) 
					      {
					        // request user to new amount paid 
					        System.out.println("Please enter new amount paid");
					        amountPaid = scan.nextDouble();
					        
					     // print confirmation message of change  of deadline
					        System.out.println("New Amount Paid " + amountPaid);
					        
					        // Enter new  amount in database
					        stmt.executeUpdate("UPDATE Project SET total_paid = '"+amountPaid+"' WHERE proj_num = '"+projectNumber+"'");
					        System.out.println("New amount has be  entered in database");

					      } else if (choice == 3) 
					      {
					        // request user to enter architect new details 
					        System.out.println("Please enter new contact details ");

					        System.out.println("Enter new Architect name for project: ");
					        architectName = scan.next();

					        System.out.println("Enter new Architect telephone number: ");
					        arcTelephoneNum = scan.nextInt();

					        System.out.println("Enter new Architect email address");
					        arcEmail = scan.next();

					        System.out.println("Enter new Architect pyhsical address");
					        arcAddress = scan.next();
					        scan.nextLine();

					        // print out the new details 
					        Details arc = new Details(architectName, arcTelephoneNum, arcEmail, arcAddress);
					        System.out.println("\nArchitect\n" + arc + "\n");
					        
					        // update architect details in  database
					        stmt.executeUpdate("UPDATE Architect SET name = '"+architectName+"' WHERE proj_num = '"+projectNumber+"'");
					        stmt.executeUpdate("UPDATE Architect SET telephone_num = '"+arcTelephoneNum+"' WHERE proj_num = '"+projectNumber+"'");
					        stmt.executeUpdate("UPDATE Architect SET email = '"+arcEmail+"' WHERE proj_num = '"+projectNumber+"'");
					        stmt.executeUpdate("UPDATE Architect SET address = '"+arcAddress+"' WHERE proj_num = '"+projectNumber+"'");
					        System.out.println("\nArchitect details updated in database\n");

					        // request user to enter  new details of the Contractor
					        System.out.println("Enter new Contractor name for project: ");
					        contaractorName = scan.next();

					        System.out.println("Enter new Contractor telephone number: ");
					        telephoneNumber = scan.nextInt();

					        System.out.println("Enter new Contractor email address");
					        conEmail = scan.next();
					        scan.nextLine();

					        System.out.println("Enter new Contractor pyhsical address");
					        conAddress = scan.next();
					        scan.nextLine();

					        // Print out the new details of the Contractor
					        Details cont = new Details(contaractorName, telephoneNumber, conEmail, conAddress);
					        System.out.println("\nContractor\n" + cont + "\n");
					        
					        // update the details of Contractor
					        stmt.executeUpdate("UPDATE contractor SET name = '"+contaractorName+"' WHERE proj_num = '"+projectNumber+"'");
					        stmt.executeUpdate("UPDATE contractor SET telephone_num = '"+telephoneNumber+"' WHERE proj_num = '"+projectNumber+"'");
					        stmt.executeUpdate("UPDATE contractor SET email = '"+conEmail+"' WHERE proj_num = '"+projectNumber+"'");
					        stmt.executeUpdate("UPDATE contractor SET address = '"+conAddress+"' WHERE proj_num = '"+projectNumber+"'");
					        System.out.println("\nContractor has been updated in database\n");

					        // request user to enter new details of the customer
					        System.out.println("Enter new Customer name for project: ");
					        customerName = scan.next();

					        System.out.println("Enter new Customer telephone number: ");
					        telephoneNum = scan.nextInt();

					        System.out.println("Enter new Customer email address");
					        email = scan.next();

					        System.out.println("Enter new Customer pyhsical address");
					        address = scan.next();
					        scan.nextLine();

					        // print out the new details of customer
					        Details cust = new Details(customerName, telephoneNum, email, address);
					        System.out.println("\nC+ustomer\n" + cust + "\n");
					        
					        // update user customer details in database
					        stmt.executeUpdate("UPDATE customer SET name = '"+customerName+"' WHERE proj_num = '"+projectNumber+"'");
					        stmt.executeUpdate("UPDATE customer SET telephone_num = '"+telephoneNum+"' WHERE proj_num = '"+projectNumber+"'");
					        stmt.executeUpdate("UPDATE customer SET email = '"+email+"' WHERE proj_num = '"+projectNumber+"'");
					        stmt.executeUpdate("UPDATE customer SET address = '"+address+"' WHERE proj_num = '"+projectNumber+"'");
					        System.out.println("\nCustomer has been updated in database\n");
					        
					        System.out.println("Information Updated");

					      }

					      } catch (InputMismatchException ex){
					    	  // error massage if invalid option entered
					        System.out.println("Invalid Input");
					        scan.next();
					      } catch (SQLException e) {
					    	  // error massage if database not founded
							e.printStackTrace();
						}
					    }

					else if (userInput == invoice) 
					{
						
						// request user to enter project number to link project
						System.out.println("Enter project number: ");
						projectNumber = scan.nextInt();
						
					//Open database to read from database
						 final String DB_URL = "jdbc:mysql://localhost:3306/PoisePMS?user=root";
						 final String USER = "root";
						 final String PASS = "Manny@Nf201";
						 final String QUERY11 = "SELECT  * FROM Project WHERE proj_num = '"+projectNumber+"'";
						 final String QUERY21 = "SELECT  * FROM Architect WHERE proj_num = '"+projectNumber+"'";
						 final String QUERY31 = "SELECT  * FROM contractor WHERE proj_num = '"+projectNumber+"'";
						 final String QUERY41 = "SELECT  * FROM customer WHERE proj_num = '"+projectNumber+"'";
						 int completion;
						
						try (Connection conn1 = DriverManager.getConnection(DB_URL, USER, PASS);
								Statement stmt1 = conn1.createStatement();
									ResultSet rs11 = stmt1.executeQuery(QUERY11);
									ResultSet rs21 = stmt1.executeQuery(QUERY21);
									ResultSet rs31 = stmt1.executeQuery(QUERY31);
									ResultSet rs41 = stmt1.executeQuery(QUERY41);){
						
							try 
							{

								// Request if project  is complete or not
								System.out.println("Is Project Complete (1.Yes/2.No)");
								completion = scan.nextInt();
								
								// if project is complete create an invoice for customer with all the details of project
								if(completion == 1) 
								{
									while(rs11.next()) 
									{
										// get project information from database
										String invoicePD = "";
										for (int i = 1; i <= 6; i++) 
										{
											invoicePD += rs11.getString(i) + ":";
										}
										System.out.println(invoicePD);
									}
									
									while(rs21.next()) 
									{
										// get Architect information from database 
										String invoiceAD = "";
										for (int i = 1; i <= 6; i++) 
										{
											invoiceAD += rs21.getString(i) + ":";
										}
										System.out.println(invoiceAD);
									}
									
									while(rs31.next()) 
									{
										// get contractor information from database
										String invoiceCOD = "";
										for (int i = 1; i <= 6; i++) 
										{
											invoiceCOD += rs31.getString(i) + ":";
										}
										System.out.println(invoiceCOD);
									}
									
									while(rs41.next()) 
									{
										// get customer information from database
										String invoiceCUD = "";
										for (int i = 1; i <= 6; i++) 
										{
											invoiceCUD += rs41.getString(i) + ":";
										}
										System.out.println(invoiceCUD);
									}
									
								}else if (completion == 2) 
								{
									System.out.println("PLease complete project before deadline");
								}
								
							} catch (InputMismatchException ex)
							{
						        System.out.println("Invalid Input");
						        scan.next();
						      }
							}catch (SQLException e) {
								e.printStackTrace();
							}
						
						}

				// if user wants to find a project
					else if (userInput == search) 
						{
						// Request for project Number 
							System.out.println("Enter project number: ");
							projectNumber = scan.nextInt();
							
							// get project from database and print out 
							stmt.executeUpdate("SELECT * FROM Project WHERE proj_num = '"+projectNumber+"'");
							System.out.println(stmt);
							 
						}
				
						else if (userInput == exit) 
						{
							// If user selects the exit option
							System.out.println("GoodBye");
						}
						
						
						
					} catch (SQLException e1) {
						e1.printStackTrace();
					}  
					  
	  


}
	  
}