/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectois;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author luismiguel
 */
public class login extends javax.swing.JFrame {
     // Variables de la clase login
	
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
	
	
    /**
     * Creates new form login
     */
    public login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jFrame4 = new javax.swing.JFrame();
        Login = new javax.swing.JPanel();
        EtEmail = new javax.swing.JLabel();
        EtConstrasena = new javax.swing.JLabel();
        CampoContrasena = new javax.swing.JPasswordField();
        CampoCorreo = new javax.swing.JTextField();
        BotonLogin = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame4Layout = new javax.swing.GroupLayout(jFrame4.getContentPane());
        jFrame4.getContentPane().setLayout(jFrame4Layout);
        jFrame4Layout.setHorizontalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame4Layout.setVerticalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Iniciar Sesión");
        setResizable(false);

        EtEmail.setText("Email");

        EtConstrasena.setText("Password");

        BotonLogin.setText("Login");
        BotonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LoginLayout = new javax.swing.GroupLayout(Login);
        Login.setLayout(LoginLayout);
        LoginLayout.setHorizontalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LoginLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(EtEmail)
                    .addComponent(EtConstrasena))
                .addGap(68, 68, 68)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CampoCorreo)
                    .addComponent(CampoContrasena))
                .addGap(34, 34, 34))
            .addGroup(LoginLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(BotonLogin)
                .addContainerGap(148, Short.MAX_VALUE))
        );
        LoginLayout.setVerticalGroup(
            LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EtEmail)
                    .addComponent(CampoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(LoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EtConstrasena)
                    .addComponent(CampoContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(BotonLogin)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	/**
	 * Método obtenerDatos se encarga de obtener el correo y la clave
	 * del usuario emisor.
	 * y luego lo envia por parametro al método validarSesion.
	 * Este método llama al método validarSesion. 
	 * 
	 */
	public void obtenerDatos(){
		
		
		usuarioEmisor=CampoCorreo.getText();
		
		claveEmisor=CampoContrasena.getText();
                 System.out.println(usuarioEmisor);
                 System.out.println(claveEmisor);
                validarSesion(usuarioEmisor,claveEmisor);
                
		
	}// Cierre del Método

    public String getUsuarioEmisor() {
        return usuarioEmisor;
    }

    public void setUsuarioEmisor(String usuarioEmisor) {
        this.usuarioEmisor = usuarioEmisor;
    }

    public String getClaveEmisor() {
        return claveEmisor;
    }

    public void setClaveEmisor(String claveEmisor) {
        this.claveEmisor = claveEmisor;
    }
        
        /**
	 * Método ValidarSesion se encarga de validar y autenticar mediante 
	 * el protocolo smtp el correo y la clave del usuario emisor para
	 * conectarse con Gmail.
	 * Este método llama al método crearMensaje. 
	 *  
	 * @param emisor contiene el correo del usuario emisor.
	 * @param clave  contiene la clave del usuario emisor.
	 */
	
        Session sesion;
	public void validarSesion (String emisor, String clave){
                 
            Properties props = new Properties();
		
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		 sesion= Session.getInstance(props, new javax.mail.Authenticator(){
			protected PasswordAuthentication
		getPasswordAuthentication(){
				return new PasswordAuthentication(emisor,clave);
			}
		});
		        
		
		
	}// Cierre del Método
	
    private void BotonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonLoginActionPerformed
        
                        
               obtenerDatos();
               
                 LecturaCorreo ejecutaraccion =new LecturaCorreo();
                ejecutaraccion.obtenerDatos(usuarioEmisor, claveEmisor);
                ejecutaraccion.setVisible(true);
              
                System.out.println(usuarioEmisor);
                
                   System.out.println(sesion);
               
                
              this.setVisible(false);
	               
    }//GEN-LAST:event_BotonLoginActionPerformed

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
                
            }
        });
    }

   

    public JPasswordField getCampoContrasena() {
        return CampoContrasena;
    }

    public void setCampoContrasena(JPasswordField CampoContrasena) {
        this.CampoContrasena = CampoContrasena;
    }

    public JTextField getCampoCorreo() {
        return CampoCorreo;
    }

    public void setCampoCorreo(JTextField CampoCorreo) {
        this.CampoCorreo = CampoCorreo;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonLogin;
    private javax.swing.JPasswordField CampoContrasena;
    private javax.swing.JTextField CampoCorreo;
    private javax.swing.JLabel EtConstrasena;
    private javax.swing.JLabel EtEmail;
    private javax.swing.JPanel Login;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame4;
    // End of variables declaration//GEN-END:variables
}
