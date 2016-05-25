/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoingsoft;

import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author luismiguel
 */
public class VisualGrafica extends javax.swing.JFrame {
Graficos  migrafico = new Graficos ();
    /**
     * Creates new form Graficas
     */
    public VisualGrafica() {
        initComponents();
    }
        int contadorintegrante1=0;
        
        int contadorintegrante2=0;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        areaGrafica = new javax.swing.JPanel();
        BotonGraficar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout areaGraficaLayout = new javax.swing.GroupLayout(areaGrafica);
        areaGrafica.setLayout(areaGraficaLayout);
        areaGraficaLayout.setHorizontalGroup(
            areaGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );
        areaGraficaLayout.setVerticalGroup(
            areaGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 252, Short.MAX_VALUE)
        );

        BotonGraficar.setText("Graficar");
        BotonGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGraficarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(BotonGraficar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(areaGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(areaGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(BotonGraficar)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 public void obtenerDatos(int contintegrante1,int contintegrante2){
		
                contadorintegrante1=contintegrante1;
                contadorintegrante2=contintegrante2;
              
		
	}
    private void BotonGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGraficarActionPerformed

              //tamaño del grafico
        Dimension d = areaGrafica.getSize();//toma el tamaño del contenedor
        //se crean los datos
        int[] valores = {contadorintegrante1,contadorintegrante2};
        String[] arg1 = {"Luis Miguel","Hi Defi"};
        String[] arg2 = {"Mensajes","Mensajes"};
        //titulo, lateral 1, lateral 2
        String[] data = {"Interacciones","INBOX","Mensajes"};
        //se crea el grafico
        migrafico.crear_grafico_de_barras(d, valores, arg2, arg1, data);
        //se crea un jlabel para colocar el grafico
        JLabel j = new JLabel();
        j.setBounds(0, 0, d.width, d.height);
        //se carga el grafico de memoria
        migrafico.cargar_grafico(j);
        //se añade al contenedor
        areaGrafica.add(j);
        this.repaint();

        // TODO add your handling code here:
    }//GEN-LAST:event_BotonGraficarActionPerformed
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
            java.util.logging.Logger.getLogger(VisualGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VisualGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VisualGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VisualGrafica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             new login().VentanaPrincipal();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonGraficar;
    private javax.swing.JPanel areaGrafica;
    // End of variables declaration//GEN-END:variables
}
