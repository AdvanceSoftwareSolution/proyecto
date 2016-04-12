package ejemplomail;

import java.util.Scanner;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;


/**
 * Esta clase es el primer ejemplo de estructuracion del programa
 * usando los entandares de codificacion en java.
 * @author JUAN PEREZ
 * @version 12/04/2016
 */
public class EjemploMetodos {

	Scanner teclado = new Scanner(System.in);
	
	// Variables de la clase EjemploMetodos
	
	/** usuarioEmisor obtiene y contiene 
	 *  el correo electronico de usuario emisor.
	 */
	String usuarioEmisor;
	
	/** claveEmisor obtiene y contiene 
	 *  la clave del correo electronico del usuario emisor.
	 */
	String claveEmisor;
	
	/** usuarioReceptor obtiene y contiene 
	 *  el correo electronico de usuario receptor.
	 */
	String usuarioReceptor;
	
	/** asuntoMensaje  obtiene y contiene 
	 *  el asunto del mensaje a enviar.
	 */
	String asuntoMensaje;
	
	/** contenidoMensaje obtiene y contiene 
	 *  el cuerpo en texto plano del mensaje.
	 */
	String contenidoMensaje;
	
	
	/**
	 * Método obtenerDatos se encarga de obtener el correo y la clave
	 * del usuario emisor.
	 * y luego lo envia por parametro al método validarSesion.
	 * Este método llama al método validarSesion. 
	 * 
	 */
	public void obtenerDatos(){
		
		System.out.print("Ingrese el correo del usuario:" + "\t");
		usuarioEmisor=teclado.nextLine();
		System.out.print("Ingrese la clave del usuario" + "\t");
		claveEmisor=teclado.nextLine();
		validarSesion(usuarioEmisor,claveEmisor);
		
	}// Cierre del Método
	
	
	/**
	 * Método ValidarSesion se encarga de validar y autenticar mediante 
	 * el protocolo smtp el correo y la clave del usuario emisor para
	 * conectarse con Gmail.
	 * Este método llama al método crearMensaje. 
	 *  
	 * @param emisor contiene el correo del usuario emisor.
	 * @param clave  contiene la clave del usuario emisor.
	 */
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
	
	
	/**
	 * Método crearMensaje recibe por parametro la sesion valida
	 * y el correo del usuario emisor para proceder a crear el 
	 * mensaje.
	 * Este método llama al método enviarMensaje. 
	 *
	 * @param session   es un objeto de la clase Session y me dice la sesion valida
	 * @param emisorFrom en una variable que contiene el correo del usuario emisor
	 */
	public void crearMensaje(Session session, String emisorFrom){
		
		Message message = new MimeMessage(session);
		
		try {
			message.setFrom(new InternetAddress(emisorFrom));
			System.out.print("Ingrese el correo del destinatario:" + "\t");
			usuarioReceptor=teclado.nextLine();
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
	
	
	/**
	 * Método enviarMensaje solo se encarga de recibir por 
	 * parametro un objeto de la clase Message  y de enviar
	 * el mensaje al destinatario.
	 * 
	 * @param mensaje es el objeto de la clase Message que 
	 * contiene el asunto y contenido del mensaje.
	 */
	public void enviarMensaje(Message mensaje){
		
		try {
			Transport.send(mensaje);
			System.out.print("EL MENSAJE HA SIDO ENVIADO EXITOSAMENTE");
		} catch (MessagingException e) {
			System.out.print("EL MENSAJE NO SE HA PODIDO ENVIAR");
		}
	}// Cierre del Método
	
	/**
	 * Método main  en el se creao un objeto de la clase 
	 * EjemplosMetodos para llamar a un metodo que se encuentra
	 * dentro de la clase.
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		
		EjemploMetodos jp = new EjemploMetodos();
		jp.obtenerDatos();
	}
}// Cierre de la Clase EjemploMetodos
