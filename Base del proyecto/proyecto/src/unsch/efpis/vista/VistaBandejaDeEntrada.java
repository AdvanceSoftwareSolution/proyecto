/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unsch.efpis.vista;

/**
 *
 * @author JDFIELD
 */
public class VistaBandejaDeEntrada extends javax.swing.JFrame {
 
    public VistaBandejaDeEntrada() {
            initComponents();
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
 
        jScrollPane1 = new javax.swing.JScrollPane();
        listaAsuntoBandejaEntrada = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        areaContenidoBandejaEntrada = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
 
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
 
        listaAsuntoBandejaEntrada.setFont(new java.awt.Font("Trebuchet MS", 3, 11));
        listaAsuntoBandejaEntrada.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listaAsuntoBandejaEntradaValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listaAsuntoBandejaEntrada);
 
        areaContenidoBandejaEntrada.setBackground(new java.awt.Color(0, 0, 0));
        areaContenidoBandejaEntrada.setColumns(20);
        areaContenidoBandejaEntrada.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        areaContenidoBandejaEntrada.setForeground(new java.awt.Color(255, 255, 255));
        areaContenidoBandejaEntrada.setLineWrap(true);
        areaContenidoBandejaEntrada.setRows(5);
        areaContenidoBandejaEntrada.setWrapStyleWord(true);
        jScrollPane2.setViewportView(areaContenidoBandejaEntrada);
 
        jLabel1.setText("Contenido");
 
        jLabel2.setText("Mensaje");
 
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(189, 189, 189))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
 
        pack();
    }// </editor-fold>                        
 
    private void listaAsuntoBandejaEntradaValueChanged(javax.swing.event.ListSelectionEvent evt) {                                                      
       
    }                                                      
 
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaBandejaDeEntrada().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify                    
    public javax.swing.JTextArea areaContenidoBandejaEntrada;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JList listaAsuntoBandejaEntrada;
    // End of variables declaration                  
}
