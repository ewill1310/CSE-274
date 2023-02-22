import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Address class for use in CSE 274 Homework on LinkedLists
 * @author Dr. Johnson
 * September 8 ,2022
 *
 */
public class Address implements Comparable<Address>
{

    //attributes of the address
    private String firstName;
    private String lastName;
    private int zipcode;
    private String streetAddress;
    private String phoneNumber;
    
    
    /**
     * Default Constructor
     */
    public Address()
    {
        // do nothing - all variables equal null until set methods called.
       
    }

    /**
     * @param firstName
     * @param lastName
     * @param zipcode
     * @param streetAddress
     * @param phoneNumber
     */
    public Address(String firstName, String lastName, int zipcode, String streetAddress, String phoneNumber)
    {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.zipcode = zipcode;
        this.streetAddress = streetAddress;
        this.phoneNumber = phoneNumber;
    } 
    
    
    /**
     * @return the firstName
     */
    public String getFirstName()
    {
        return firstName;
    }


    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }


    /**
     * @return the lastName
     */
    public String getLastName()
    {
        return lastName;
    }


    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }


    /**
     * @return the zipcode
     */
    public int getZipcode()
    {
        return zipcode;
    }


    /**
     * @param zipcode the zipcode to set
     */
    public void setZipcode(int zipcode)
    {
        this.zipcode = zipcode;
    }


    /**
     * @return the streetAddress
     */
    public String getStreetAddress()
    {
        return streetAddress;
    }


    /**
     * @param streetAddress the streetAddress to set
     */
    public void setStreetAddress(String streetAddress)
    {
        this.streetAddress = streetAddress;
    }


    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }


    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public int compareTo(Address o)
    {
        // we will sort only on first and last name
        // assumes no two entries have the same first and last name
        if (this.firstName.equals(o.firstName) && this.lastName.equals(o.lastName))
        {
            // they are equal- return 0
            return 0;
        }
        else if (this.lastName.equals(o.lastName))
        {
            // if the last names are equal - sort based on first name
            // since firstName is a String - use the String compareTo method
            return this.firstName.compareTo(o.firstName);
        }
        else
        {
            // not equal and last names are different- sort on last name
            return this.lastName.compareTo(o.lastName);
        }
       
    }

    @Override
    public String toString()
    {
        return   firstName + " " + lastName + "\n" + streetAddress + "\n" + phoneNumber ;
    }

}
