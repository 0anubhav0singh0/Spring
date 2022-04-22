## Important Classes and Interface
  -> java.util.Properties
    The Properties class represents a persistent set of properties.
    The Properties can be saved to a stream or loaded from a stream.
    Most Java application need to use properties at some point, generally to store simple parameters as key-value pairs, outside of compiled code

  -> javax.mail.Message
    This class models an email message. To send a message, subclass of Message (e.g. MimeMessage) is instantiated, the attributes and content are filled in, and message is sent using Transport.send method

  -> javax.mail.MessagingException
    This is base class for all exceptions thrown by the Messaging classes

  -> javax.mail.PasswordAuthentication:
    This class is simply a repository for a user name and a password

  -> javax.mail.Session
    Session class represents a mail session

  https://javaee.github.io/javamail/FAQ#getdefaultinstance

  -> javax.mail.Transport
    This is abstract class that models a message transport

  -> javax.mail.internet.InternetAddress
    This class represents an Internet email address using the syntax of RFC822
    Typical address syntax is of the form "user@host.domain" or "Personal Name <user@host.domain>".

  -> javax.mail.internet.MimeMessage
    This class represents a MIME style email message. It implements the Message abstract class and the MimePart interface.


## STEPS
	1. Get the session
	2. Compose the message
	3. Send the message

we need a gmail account
once created, then login and go to your google account>security>less securec app>switch on it

kya kya hona chahiye
	message=""
	subject=""
	to=""
	from=""
