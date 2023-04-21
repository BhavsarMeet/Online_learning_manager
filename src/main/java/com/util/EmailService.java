package com.util;


import java.util.Properties;


import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;

@org.springframework.stereotype.Service
public class EmailService 
{
	public void send(String to,String sub,String msg)
	{
		final String userName="tempforemail9@gmail.com";
		final String password="Temp$eMAIL";
		
		Properties props=new Properties();
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.user", userName);
		props.put("mail.smtp.password", password);
		props.put("mail.smtp.port", 587);
		
		// Accept only TLS 1.1 and 1.2(resolution for  Could not convert socket to TLS/No appropriate protocol (protocol is disabled or cipher suites are inappropriate))
		props.setProperty("mail.smtp.ssl.protocols", "TLSv1.1 TLSv1.2");
		//to use https 
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.EnableSSL.enable","true");
		
		//just to debuge the mail process or to see logs
		props.put("mail.debug","true");
		props.put("mail.smtp.auth","true");
		
		Session session = Session.getInstance(props,new Authenticator() {
		
			protected javax.mail.PasswordAuthentication getPasswordAuthentication()
			{
				return new javax.mail.PasswordAuthentication(userName, password);
			}
		});
		
		MimeMessage message=new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(userName));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject(sub);
			message.setText(msg);
			
			Transport.send(message);
			System.out.println("done");
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	/*public static void main(String[] args) {
		Mailer m=new Mailer();
		m.send("meetbhavsar14@gmail.com", "check mail", "otp 1717171");
	}*/
}

