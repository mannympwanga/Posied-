package Poised;

public class Details {

  // Store details for customer, contractor, and  architect 
  private String name;
  private int telephoneNum;
  private String email;
  private String address;

  Details(String name, int telephoneNum, String email, String address) {
    this.name = name;
    this.telephoneNum = telephoneNum;
    this.email = email;
    this.address = address;

  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return address;
  }
  public String toString() {
    // create format to print out the details
    String output = "Name: " + name;
    output += "\nTelephone Number: " + telephoneNum;
    output += "\nEmail: " + email;
    output += "\nAddress: " + address;
    return output;
  }

}



