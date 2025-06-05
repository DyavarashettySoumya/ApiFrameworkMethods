package resources;

import ContactPojo.AddContact;
import ContactPojo.Employer;
import ContactPojo.Location;
import TfPojo.Email;
import TfPojo.Otp;

import java.util.ArrayList;
import java.util.List;

public class TestDataBuild {
	public AddContact addContactPayLoad(String firstName, String lastName, String email)
	{
		AddContact c =new AddContact();
		c.setFirstName("Ramya");
		c.setLastName("Dyava");
		c.setEmail("ram@gatestautomation.com");
//		List<String> =new ArrayList<String>();
//		myList.add("shoe park");
//		myList.add("shop");
//		List<String> myList =new ArrayList<String>();
//		myList.add("shoe park");
//		myList.add("shop");

		Location l=new Location();
		l.setCity("Hyd");
		l.setCountry("India");

		Employer e = new Employer();
		e.setJobTitle("SDET");
		e.setCompany("HSBC");
		return c;
	}
	
	public String deleteContactPayload(String _id)
	{

		return "{\r\n    \"_id\":\""+_id+"\"\r\n}";
	}

	public Email emailPayload(String email)
	{
		Email e = new Email();
		e.setEmail("Test@gatestautomation.com");
		return e;
	}

	public Otp otpPayload(int otp)
	{
		Otp o = new Otp();
		o.setOtp(100000);
		return o;
	}
}
