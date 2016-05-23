/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectois;


import java.awt.Image;
import java.util.Calendar;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.FromTerm;
import javax.mail.search.OrTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.SearchTerm;
import javax.mail.search.SubjectTerm;
import javax.security.auth.Subject;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumnModel;


/**
 *
 * @author luismiguel
 */
public class LecturaCorreo extends javax.swing.JFrame {

    /**
     * Creates new form LecturaCorreo
     */
    
    // Variables de la clase LecturaCorreo
	
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
        
        String usuarioRemitente;
        
         int contadorintegrante1=0;
        int contadorintegrante2=0;
        
    public LecturaCorreo() {
        initComponents();
    }

    public void validarLectura (){
    	
        	
        Properties props = new Properties();
        props.setProperty("mail.pop3.starttls.enable", "false");
        props.setProperty("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.pop3.socketFactory.fallback", "false");
        props.setProperty("mail.pop3.port", "995");
        props.setProperty("mail.pop3.socketFactory.port", "995");
        Session sesion = Session.getInstance(props);
        lecturaInbox(sesion);
    }
    
    
    public void lecturaInbox(Session sesion){

        try
        {
          
            Store store = sesion.getStore("pop3");
            store.connect("pop.gmail.com", usuarioEmisor, claveEmisor);
            //Folder folder = store.getFolder("INBOX");
            //folder.open(Folder.READ_ONLY);
                Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);
            mostrarInbox(inbox,store);
            

            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public void mostrarInbox(Folder inbox,Store store){
        String inboxok = "";
        String temporal ="";
        usuarioRemitente= CampoRemitente.getText();
        try{
        //Message[] mensajes = folder.getMessages();
        //TableColumnModel columnModel = new DefaultTableColumnModel();
       // InternetAddress [] direcciones ={ new InternetAddress("luchoguer@gmail.com"),
        //new InternetAddress("luchoguerr@gmail.com")};
        
//     SearchTerm sender = new FromTerm(new InternetAddress(usuarioRemitente));
      
      //  SearchTerm sender = new OrTerm(new InternetAddress(usuarioRemitente), "holafinal");  
       // SearchTerm sender = new SubjectTerm ("holafinal");
        
      // Calendar cal = Calendar.getInstance();
    //cal.roll(Calendar.MONTH, false);
    //Message[] mensajes = inbox.search(new ReceivedDateTerm(ComparisonTerm.GT, cal.getTime()));
        // System.out.println(" universidad "+inbox.getFolder("CIRCLES"));
        Message[] mensajes = inbox.search(new SubjectTerm(usuarioRemitente));
     //  Message[] mensajes = inbox.search(sender); 
        String integrante1="luchoguer@gmail.com";
       
        String integrante2="hidefimci@gmail.com";
        
  
                for (int i = 0; i < mensajes.length; i++)
            {
               
               inboxok+=mensajes[i].getSentDate();
                inboxok+="      \t";
               
               inboxok+=mensajes[i].getFrom()[0].toString();
               // inboxok+="      \n";
                inboxok+="      \t";
                
                
                Address[] froms = mensajes[i].getFrom();
                String email = froms == null ? null : ((InternetAddress) froms[0]).getAddress();
                temporal=email;
                
                
                //System.out.println("temporal "+ temporal);
                if(integrante1.equals(temporal) ){
                 contadorintegrante1++;
                   
                 System.out.println("contador1: "+contadorintegrante1);
                    
                } else{ 
                    if(integrante2.equals(temporal)){
                 contadorintegrante2++;
                 System.out.println("contador2: "+contadorintegrante2);
                }
                
                }
                temporal=null;
                //temporal=null;
                
                
               // inboxok+=mensajes[i].getSubject();
                
                inboxok+="\n";
                System.out.println(i+" "+inboxok);
                
                
                         
             
            }
                inboxok+="\n\n";
                inboxok+="Mensajes total del Integrante Luis Miguel:";
                inboxok+="      \t"+contadorintegrante1+" Mensajes\n";
                inboxok+="Mensajes total del Integrante Hi Defi:";
                inboxok+="      \t"+contadorintegrante2+" Mensajes\n";
                
                CampoImpresion.setText(inboxok);
                
               
              
            inbox.close(false);
            store.close();
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
    }
       
     public void obtenerDatos(String emisor, String contrasena){
		usuarioEmisor=emisor;
                claveEmisor=contrasena;
              
		
	}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CampoImpresion = new javax.swing.JTextArea();
        BotonLeer = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CampoRemitente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        obtenerGrafico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inbox");
        setResizable(false);

        CampoImpresion.setColumns(20);
        CampoImpresion.setRows(5);
        jScrollPane1.setViewportView(CampoImpresion);

        BotonLeer.setText("Buscar Mensajes");
        BotonLeer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLeerActionPerformed(evt);
            }
        });

        jLabel1.setText("Fecha de Recepcion del Mensaje");

        jLabel2.setText("Remitente");

        jLabel3.setText("Asunto a Buscar");

        obtenerGrafico.setText("Obtener Grafico");
        obtenerGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obtenerGraficoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 41, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(128, 128, 128))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(37, 37, 37)
                .addComponent(CampoRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(BotonLeer))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(obtenerGrafico)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CampoRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(29, 29, 29)
                .addComponent(BotonLeer)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(obtenerGrafico)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonLeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLeerActionPerformed
        // TODO add your handling code here:
        validarLectura();
        
    }//GEN-LAST:event_BotonLeerActionPerformed

    private void obtenerGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obtenerGraficoActionPerformed
       
         VisualGrafica ejecutaraccion =new VisualGrafica();
                ejecutaraccion.obtenerDatos(contadorintegrante1,contadorintegrante2);
                ejecutaraccion.VentanaPrincipal();
                 this.setVisible(false);
              
   // TODO add your handling code here:
    }//GEN-LAST:event_obtenerGraficoActionPerformed

    public void VentanaPrincipal(){
       
        ImageIcon ImageIcon = new ImageIcon(getClass().getResource("images/ico.png"));
        Image Image = ImageIcon.getImage();
        this.setIconImage(Image);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LecturaCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LecturaCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LecturaCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LecturaCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new login().VentanaPrincipal();
            }
        });
    }

    public JTextField getCampoRemitente() {
        return CampoRemitente;
    }

    public void setCampoRemitente(JTextField CampoRemitente) {
        this.CampoRemitente = CampoRemitente;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonLeer;
    private javax.swing.JTextArea CampoImpresion;
    private javax.swing.JTextField CampoRemitente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton obtenerGrafico;
    // End of variables declaration//GEN-END:variables
}
