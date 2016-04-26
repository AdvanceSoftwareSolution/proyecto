
import java.util.Properties;

import javax.mail.Message;

import javax.mail.MessagingException;

import javax.mail.PasswordAuthentication;

import javax.mail.Session;

import javax.mail.Transport;

import javax.mail.internet.InternetAddress;

import javax.mail.internet.MimeMessage;



public class javamail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		final String username = "juankaperez.jcp@gmail.com";
		final String password = "juanperez";
		
		// creando la instancia de properties
		
		Properties props = new Properties();
		
		props.put("mail.smtp.auth", "true");
		
		props.put("mail.smtp.starttls.enable", "true");
		
		props.put("mail.smtp.host", "smtp.gmail.com");
		
		props.put("mail.smtp.port", "587");
		
		
		
		// iniciar sesion en gmail
		
		Session session = Session.getInstance(props,
					
			new javax.mail.Authenticator(){
			
				protected PasswordAuthentication 
		getPasswordAuthentication(){
					return new PasswordAuthentication(username, password);
				}
		});
		
		try {
			// creamos un nuevo mensaje  y le pasamos la sesion iniciada
			Message message = new MimeMessage(session);
			
			// seteamos la direccion desde la cual enviaremos el mensaje 
			message.setFrom(new InternetAddress("juankaperez.jcp@gmail.com"));
			
			//seteamos el destino de nuestro mensaje 
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("juan.perez_020@hotmail.com"));
			
			
			// seteamos el asunto del mensaje
			
			message.setSubject("Prueba ejemplo mail");
			
			// contenido del mensaje
			message.setText("HOLA POR FIN PUDE CONECTAR");
			
			// AQUI CON ESTA ORDEN ENVIO EL MENSAJE
			
			Transport.send(message);
			
			// verificamos que el mensaje fue enviado
			
			System.out.println("El mensaje a sido enviado");
			
			
		}catch (MessagingException e){
			
			// si existe un error  en el envio 
			// se le hace saber y se envia una excepcion
			
			System.out.println("Hubo un error al enviar el mensaje!");
			
			throw new RuntimeException(e);
		}
	}
	//para que mi mesaje sea enviado con exito debo activar en mi cuenta gmail (emisor)
	// la opcion de acceso para aplicaciones menos seguras
	// este opcion tambien se puede revertir.

}
