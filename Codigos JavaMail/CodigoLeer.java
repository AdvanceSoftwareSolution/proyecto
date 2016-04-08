

// Elaborado por Juan Carlos Perez Rincon

import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class EjemploLeer {

	public static void main(String[] args) {
		
		
        Properties props = new Properties();
        props.setProperty("mail.pop3.starttls.enable", "false");
        props.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.pop3.socketFactory.fallback", "false");
        props.setProperty("mail.pop3.port", "995");
        props.setProperty("mail.pop3.socketFactory.port", "995");
        Session sesion = Session.getInstance(props);
        

        try
        {
          
            Store store = sesion.getStore("pop3");
            store.connect("pop.gmail.com", "juankaperez.jcp@gmail.com", "juanperez");
            Folder folder = store.getFolder("INBOX");
            folder.open(Folder.READ_ONLY);

            
            Message[] mensajes = folder.getMessages();

            
            for (int i = 0; i < mensajes.length; i++)
            {
                System.out.println(
                    "From:" + mensajes[i].getFrom()[0].toString());
                System.out.println("Subject:" + mensajes[i].getSubject());
                
                
            }

            folder.close(false);
            store.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

	}

}
