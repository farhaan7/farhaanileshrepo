package myTests;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.mail.DefaultAuthenticator;

public class SendEmail 
{
	public static void main(String args[]) throws EmailException
	{
		
	
	Email email = new SimpleEmail();
	email.setHostName("smtp.gmail.com");
	//email.setSmtpPort(993);
	email.setAuthenticator(new DefaultAuthenticator("youremailid", "ghfcagyu"));
	email.setSSLOnConnect(true);
	email.setFrom("fkapde@gmail.com");
	email.setSubject("TestMail");
	email.setMsg("hi sagar i am selenium)");
	email.addTo("fkapde@gmail.com");
	email.send();
	System.out.println("email sent");
}
}