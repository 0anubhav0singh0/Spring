package com.emailpractice;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Preparing to send message....");
		String message = "Hello Dear";
		String subject = "confirmation";
		String to = "anubhavsingh9929@gmail.com";
		String from = "singhanubhav9922@gmail.com";

		// iska matlab hai ki jab bhi aapko jarurat padegi to aap sendEmail wale
		// function ko call karoge
//        sendEmail(message,subject,to,from);
		sendAttach(message, subject, to, from);
	}

	private static void sendAttach(String message, String subject, String to, String from) {
		// Variable for gmail
		// SMTP = Simple Mail Transfer Protocol
		// Gmail SMTP server name
		String host = "smtp.gmail.com";

		// get the system properties
		Properties properties = System.getProperties();
		System.out.println(properties);

		// setting important information to properties oject

		// host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Step 1: To get the session object..
		// session ke paas factory method hai jo object provide karega
		// isme do chiz pass kar deni hai - properties and authenticator(to authenticate
		// that my user name and password is correct)
		// Like a database connection, a mail session is a resource
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("singhanubhav9922@gmail.com", "Anubhav@1010");
			}

		});

		// debug session
		session.setDebug(true);

		// Step 2: compose the message [text, attachment, multimedia... etc]
		MimeMessage mimeMessage = new MimeMessage(session);

		try {
			// from email
			mimeMessage.setFrom(from);

			// adding recipient to message
			// ye message jayega kisko
			// address parameter me internet address use karna hai
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// adding subject to message
			mimeMessage.setSubject(subject);

			// attachment
			String path = "C:\\Users\\anubhav_singh\\Pictures\\aj1.png";
			// reason to use MimeMultipart because - iss multipart me do chize rakh sakte
			// hai (text and attachment)
			MimeMultipart mimeMultipart = new MimeMultipart();
			// for text
			MimeBodyPart textMime = new MimeBodyPart();
			// for file
			MimeBodyPart fileMime = new MimeBodyPart();
			try {
				textMime.setText(message);

				File file = new File(path);
				fileMime.attachFile(file);
				
				// inn dono ko mimeMultipart me rakhna hai
				mimeMultipart.addBodyPart(textMime);
				mimeMultipart.addBodyPart(fileMime);

			} catch (Exception e) {
				e.printStackTrace();
			}
			mimeMessage.setContent(mimeMultipart);

			// send
			// Step 3: send message using Transport class
			Transport.send(mimeMessage);

			System.out.println("sent..............successfully...");
		} catch (Exception e) {
			e.printStackTrace(); // give proper message
		}
	}

	// This method is responsible to send email..
	private static void sendEmail(String message, String subject, String to, String from) {
		// Variable for gmail
		// SMTP = Simple Mail Transfer Protocol
		// Gmail SMTP server name
		String host = "smtp.gmail.com";

		// get the system properties
		Properties properties = System.getProperties();
		System.out.println(properties);

		// setting important information to properties oject

		// host set
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");

		// Step 1: To get the session object..
		// session ke paas factory method hai jo object provide karega
		// isme do chiz pass kar deni hai - properties and authenticator(to authenticate
		// that my user name and password is correct)
		// Like a database connection, a mail session is a resource
		Session session = Session.getInstance(properties, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication("singhanubhav9922@gmail.com", "Anubhav@1010");
			}

		});

		// debug session
		session.setDebug(true);

		// Step 2: compose the message [text, attachment, multimedia... etc]
		MimeMessage mimeMessage = new MimeMessage(session);

		try {
			// from email
			mimeMessage.setFrom(from);

			// adding recipient to message
			// ye message jayega kisko
			// address parameter me internet address use karna hai
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// adding subject to message
			mimeMessage.setSubject(subject);

			// adding text to message
			mimeMessage.setText(message);

			// send
			// Step 3: send message using Transport class
			Transport.send(mimeMessage);

			System.out.println("sent..............successfully...");
		} catch (Exception e) {
			e.printStackTrace(); // give proper message
		}
	}
}
