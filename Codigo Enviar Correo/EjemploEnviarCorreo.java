

// Elaborado por Juan Carlos Perez Rincon

import java.util.Properties;

import javax.mail.*;

import javax.mail.internet.*;


public class EjemploEnviarCorreo {

	public static void main(String[] args) {
		
	
		String emisorp = "juankaperez.jcp@gmail.com";
		String clavep = "juanperez";
		String receptorp = "anadelina.rincon@gmail.com";
		
		Properties props = new Properties();
		String smtpHost = "smtp.gmail.com";
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.smtp.host",smtpHost);
		//props.put("mail.smtp.port","587");
		
		
		
		try {
			
			Session sesion = Session.getInstance(props,new javax.mail.Authenticator(){
				protected PasswordAuthentication getPasswordAuthentication(){
					return new PasswordAuthentication(emisorp,clavep);
				}
			});
			
			Message mensaje = new MimeMessage(sesion);
			

			mensaje.setFrom(new InternetAddress(emisorp));
			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(receptorp));
			mensaje.setSubject("EJEMPLO 1");
			mensaje.setText("PRIMER MENSAJE");
			
			Transport.send(mensaje);
			
			System.out.println("EL MENSAJE SE HA ENVIADO CON EXITO");
			
			
			
		} catch (MessagingException e) {
			
			System.out.println(e.getMessage());
			System.out.println("EL MENSAJE NO PUDO ENVIARSE");
			
		}
	}

}
