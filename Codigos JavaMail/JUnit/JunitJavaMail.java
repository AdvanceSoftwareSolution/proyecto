package ejemjunitjmail;

import java.util.Properties;
import java.util.Scanner;
import javax.mail.*;
import javax.mail.internet.*;

public class JunitJavaMail {

Scanner teclado = new Scanner(System.in);
	
	String usuarioEmisor;
	String claveEmisor;
	String usuarioReceptor;
	String asuntoMensaje;
	String contenidoMensaje;
	
public JunitJavaMail(String usuEmi ,String claEmi){
		
		usuarioEmisor=usuEmi;
		claveEmisor=claEmi;
		validarSesion(usuarioEmisor,claveEmisor);
	}
	
	
	public void validarSesion (String emisor, String clave){
		
		Properties props = new Properties();
		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session sesion = Session.getInstance(props, new javax.mail.Authenticator(){
			protected PasswordAuthentication
		getPasswordAuthentication(){
				return new PasswordAuthentication(emisor,clave);
			}
		});
		
		crearMensaje(sesion,emisor);
		
		
	}// Cierre del Método
	
	

	public void crearMensaje(Session session, String emisorFrom){
		
		Message message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress(emisorFrom));
			usuarioReceptor = "anadelina.rincon@gmail.com";
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(usuarioReceptor)
					);
			
			System.out.print("En este campo escribe el asunto y el contenido del Mensaje"+ "\n");
			System.out.print("ASUNTO:" + "\t");
			asuntoMensaje=teclado.nextLine();
			message.setSubject(asuntoMensaje);
			System.out.print("CONTENIDO:" + "\n");
			contenidoMensaje=teclado.nextLine();
			message.setText(contenidoMensaje);
			
			System.out.print("EL MENSAJE HA SIDO CREADO" + "\n");
			enviarMensaje(message);
			
		} catch (MessagingException e) {
			
			System.out.print("EL MENSAJE NO HA SIDO CREADO");
		}
		
		
	}// Cierre del Método
	
	
	public boolean enviarMensaje(Message mensaje){
		
		try {
			Transport.send(mensaje);
			System.out.print("EL MENSAJE HA SIDO ENVIADO EXITOSAMENTE");
		} catch (MessagingException e) {
			System.out.print("EL MENSAJE NO SE HA PODIDO ENVIAR");
			return false;
		}
		return true;
	}// Cierre del Método
}
