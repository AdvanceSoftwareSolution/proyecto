



import java.io.UnsupportedEncodingException;

import java.util.Properties;

import javax.mail.*;

import javax.mail.internet.*;

public class EnviarCorreoNombre {

	
		public static void main(String []args) throws UnsupportedEncodingException{
			
		
			
			String emisor = "juankaperez.jcp@gmail.com";
			String clave = "juanperez";
			String receptor = "anadelina.rincon@gmail.com";
				
			
			try {
				
				Properties props = new Properties();
				String smtpHost = "smtp.gmail.com";
				props.put("mail.smtp.auth","true");
				props.put("mail.smtp.starttls.enable","true");
				props.put("mail.smtp.host",smtpHost);
				props.put("mail.smtp.port","587");
				
				
				
				
		
				Session sesion = Session.getInstance(props,new javax.mail.Authenticator(){
					protected PasswordAuthentication getPasswordAuthentication(){
						return new PasswordAuthentication(emisor,clave);
					}
				});
				
				
				
				
				
				Message mensaje = new MimeMessage(sesion);
				
				
				
				
				Address address = new InternetAddress(emisor,"juan perez");
				mensaje.setFrom(address);

				
				mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(receptor));
				mensaje.setSubject("EJEMPLO 1");
				mensaje.setText("PRIMER MENSAJE");
				
				
				Transport.send(mensaje);
				
				System.out.println("EL MENSAJE SE HA ENVIADO CON EXITO");
				
				
				
			} catch (MessagingException e) {
				
				System.out.println(e.getMessage());
				System.out.println("EL MENSAJE NO PUDO ENVIARSE");
				//e.printStackTrace();
			}
					
		}
		
	}


