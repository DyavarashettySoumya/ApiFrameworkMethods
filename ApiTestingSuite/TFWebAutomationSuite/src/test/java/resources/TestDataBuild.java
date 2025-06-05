package resources;

import java.util.ArrayList;
import java.util.List;

import TfPojo.Email;
import TfPojo.Otp;
import TfPojo.otpResponse;
import pojo.AddPlace;
import pojo.Location;

public class TestDataBuild {
	public Email emailPayload(String email)
	{
		Email e = new Email();
		e.setEmail("Test@gatestautomation.com");
		return e;
	}

	public Otp otpPayload(String email,int otp)
	{
		Otp o = new Otp();
		o.setEmail(email);
		o.setOtp(otp);
		return o;
	}
	public otpResponse tenantPayload()
	{
		otpResponse or = new otpResponse();
		or.getId();
//		or.getMsg();
		return or;
	}
}
