/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoingsoft;


import java.awt.Image;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import javax.mail.Address;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.internet.InternetAddress;
import javax.mail.search.SubjectTerm;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextField;


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
        ResourceBundle fuente;
        String asuntoBusqueda;
        String idioma;
         int contadorintegrante1=0;
        int contadorintegrante2=0;
          int contadorintegrante3=0;
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
        asuntoBusqueda= CampoRemitente.getText();
        try{
        
        Message[] mensajes = inbox.search(new SubjectTerm(asuntoBusqueda));
    
        String integrante1="inteproyecto1@gmail.com";
       
        String integrante2="inteproyecto2@gmail.com";
        
         String integrante3="luchoguer@gmail.com";
        
        
  
                for (int i = 0; i < mensajes.length; i++)
            {
               
               inboxok+=mensajes[i].getSentDate();
                inboxok+="      \t";
               
               inboxok+=mensajes[i].getFrom()[0].toString();
             
                inboxok+="      \t";
                
                
                Address[] froms = mensajes[i].getFrom();
                String email = froms == null ? null : ((InternetAddress) froms[0]).getAddress();
                temporal=email;
                
                
                if(integrante1.equals(temporal) ){
                 contadorintegrante1++;
                   
                 System.out.println("contador1: "+contadorintegrante1);
                    
                } else{ 
                    if(integrante2.equals(temporal)){
                 contadorintegrante2++;
                 System.out.println("contador2: "+contadorintegrante2);
                }
                    else{
                        if(integrante3.equals(temporal)){
                             contadorintegrante3++;
                            System.out.println("contador3: "+contadorintegrante3);
                            }
                    
                    }
                
                }
                temporal=null;
                
                inboxok+="\n";
                System.out.println(i+" "+inboxok);
                
                
                         
             
            }
                inboxok+="\n\n";
                inboxok+="Mensajes total del Integrante 1:";
                inboxok+="      \t"+contadorintegrante1+" Mensajes\n";
                inboxok+="Mensajes total del Integrante 2:";
                inboxok+="      \t"+contadorintegrante2+" Mensajes\n";
                inboxok+="Mensajes total del Integrante Luis Miguel:";
                inboxok+="      \t"+contadorintegrante3+" Mensajes\n";
                
                CampoImpresion.setText(inboxok);
                
               
              
            inbox.close(false);
            store.close();
        }
        
        catch(Exception e){
            e.printStackTrace();
        }
    }
       
     public void obtenerDatos(String emisor, String contrasena,String idiomaregion){
		usuarioEmisor=emisor;
                claveEmisor=contrasena;
             idioma=idiomaregion;
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
        BotonBuscar = new javax.swing.JButton();
        EtFechaRecepcion = new javax.swing.JLabel();
        EtRemitente = new javax.swing.JLabel();
        CampoRemitente = new javax.swing.JTextField();
        EtAsunto = new javax.swing.JLabel();
        obtenerGrafico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("proyectoingsoft/Bundle"); // NOI18N
        setTitle(bundle.getString("LecturaCorreo.title")); // NOI18N
        setResizable(false);

        CampoImpresion.setColumns(20);
        CampoImpresion.setRows(5);
        jScrollPane1.setViewportView(CampoImpresion);

        BotonBuscar.setText(bundle.getString("LecturaCorreo.BotonBuscar.text")); // NOI18N
        BotonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarActionPerformed(evt);
            }
        });

        EtFechaRecepcion.setText(bundle.getString("LecturaCorreo.EtFechaRecepcion.text")); // NOI18N

        EtRemitente.setText(bundle.getString("LecturaCorreo.EtRemitente.text")); // NOI18N

        EtAsunto.setText(bundle.getString("LecturaCorreo.EtAsunto.text")); // NOI18N

        obtenerGrafico.setText(bundle.getString("LecturaCorreo.obtenerGrafico.text")); // NOI18N
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
                .addComponent(EtFechaRecepcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EtRemitente)
                .addGap(128, 128, 128))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EtAsunto)
                .addGap(37, 37, 37)
                .addComponent(CampoRemitente, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(163, 163, 163))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(BotonBuscar))
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
                    .addComponent(EtAsunto))
                .addGap(29, 29, 29)
                .addComponent(BotonBuscar)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EtFechaRecepcion)
                    .addComponent(EtRemitente))
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

    private void BotonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarActionPerformed
        // TODO add your handling code here:
       
        validarLectura();
        
    }//GEN-LAST:event_BotonBuscarActionPerformed
 
    
    public void traducir(ResourceBundle fuenteok){
        fuente=fuenteok;
      BotonBuscar.setText(fuente.getString("LecturaCorreo.BotonBuscar.text"));
      EtAsunto.setText(fuente.getString("LecturaCorreo.EtAsunto.text"));
      obtenerGrafico.setText(fuente.getString("LecturaCorreo.obtenerGrafico.text"));
      this.setTitle(fuente.getString("LecturaCorreo.title"));
      EtFechaRecepcion.setText(fuente.getString("LecturaCorreo.EtFechaRecepcion.text"));
      EtRemitente.setText(fuente.getString("LecturaCorreo.EtRemitente.text"));
     
      
           
      }
    private void obtenerGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obtenerGraficoActionPerformed
       
         VisualGrafica ejecutaraccion =new VisualGrafica();
                ejecutaraccion.obtenerDatos(contadorintegrante1,contadorintegrante2,contadorintegrante3);
               ejecutaraccion.traducir(fuente);
                System.out.println(usuarioEmisor);
                ejecutaraccion.VentanaPrincipal();
                 ejecutaraccion.obtenerDatos(usuarioEmisor, claveEmisor,idioma);
                 
                 this.setVisible(false);
              
   // TODO add your handling code here:
    }//GEN-LAST:event_obtenerGraficoActionPerformed
   
    
    /**
     * @param args the command line arguments
     */
    
    public void VentanaPrincipal(){
       
        ImageIcon ImageIcon = new ImageIcon(getClass().getResource("images/ico.png"));
        Image Image = ImageIcon.getImage();
        this.setIconImage(Image);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
   

    public JTextField getCampoRemitente() {
        return CampoRemitente;
    }

    public void setCampoRemitente(JTextField CampoRemitente) {
        this.CampoRemitente = CampoRemitente;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonBuscar;
    private javax.swing.JTextArea CampoImpresion;
    private javax.swing.JTextField CampoRemitente;
    private javax.swing.JLabel EtAsunto;
    private javax.swing.JLabel EtFechaRecepcion;
    private javax.swing.JLabel EtRemitente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton obtenerGrafico;
    // End of variables declaration//GEN-END:variables
}
