package resources;
//enum is special class in java which has collection of constants or  methods
public enum APIResources {
	
	AddContactAPI("/contacts"),
	getContactAPI("/contacts/{_id}"),
	deleteContactAPI("/contacts/{_id}"),

	//----------------------------------TF-WEB----------------------------------------
	createEmail("/iam-service/v1.0/tenants/signup"),
	otp("/iam-service/v1.0/tenants/otp-verification"),
	tenantCreation("/marketplace-service/api/v1.0/tenants"),
	token("/iam-service/oauth/token");

	private String resource;
	
	APIResources(String resource)
	{
		this.resource=resource;
	}
	
	public String getResource()
	{
		return resource;
	}
	

}
