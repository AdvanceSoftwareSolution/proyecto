/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unsch.efpis.modelo;

import java.io.IOException;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
 /**
 *
 * @author JDFIELD
 */
public class ModeloBandejaDeEntrada {
 
    private String usuarioEMail;
    private String passwordEMail;
 
    public void setPasswordEMail(String passwordEMail) {
        this.passwordEMail = passwordEMail;
    }
 
    public String getUsuarioEMail() {
        return usuarioEMail;
    }
 
    public void setUsuarioEMail(String usuarioEMail) {
        this.usuarioEMail = usuarioEMail;
    }
   
    //Dirección del servidor para este protocolo (POP3)
    private String pop3Host = "pop.gmail.com";
    Properties propiedades = new Properties();
 
    public Message[] getMensajes() throws IOException, MessagingException {
 
        //Se obtiene una sesión con las propiedades anteriormente que hemos
        //guardado en -props-
        Properties props = new Properties();
        props.setProperty("mail.pop3.starttls.enable", "false");
        props.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.pop3.socketFactory.fallback", "false");
        props.setProperty("mail.pop3.port", "995");
        props.setProperty("mail.pop3.socketFactory.port", "995");
        Session sesion = Session.getInstance(props);
        
 
        //Vamos a crear un Store indicando el protocolo de acceso
        //para conectarse a él.
        Store store = sesion.getStore("pop3");
        store.connect(pop3Host,usuarioEMail,passwordEMail);
        //Crear un Folder y abrir la carpeta Inbox en modo de Sólo Lectura
        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_ONLY);
        //Obtenemos todos los mensajes almacenados en la carpeta y la
        //guardamos en el array
        Message[] mensajes = folder.getMessages();
 
        return mensajes;
    }
}