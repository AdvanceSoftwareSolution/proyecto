/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unsch.efpis.controlador;

import java.io.IOException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import unsch.efpis.modelo.ModeloBandejaDeEntrada;
import unsch.efpis.vista.VistaBandejaDeEntrada;
/**
 *
 * @author JDFIELD
 */

public class ControladorBandejaDeEntrada implements ListSelectionListener {
 
    VistaBandejaDeEntrada vistaBandejaDeEntrada = new VistaBandejaDeEntrada();
    ModeloBandejaDeEntrada modeloBandejaDeEntrada = new ModeloBandejaDeEntrada();
    DefaultListModel modeloLista = new DefaultListModel();
    Message[] listaDeMensajes;
 
    public ControladorBandejaDeEntrada(VistaBandejaDeEntrada vista) {
        try {
            modeloBandejaDeEntrada.setUsuarioEMail("juan.zapata@unillanos.edu.co");
            modeloBandejaDeEntrada.setPasswordEMail("1121912982");
            vistaBandejaDeEntrada = vista;
            vistaBandejaDeEntrada.listaAsuntoBandejaEntrada.addListSelectionListener(this);
            listaDeMensajes = modeloBandejaDeEntrada.getMensajes();
            vistaBandejaDeEntrada.listaAsuntoBandejaEntrada.setModel(modeloLista);
           
            for (int i = listaDeMensajes.length-1; i > 0; i--) {
                modeloLista.addElement(listaDeMensajes[i].getSubject());
            }
           
        } catch (IOException ex) {
            System.out.println(ex.toString());
        } catch (MessagingException ex) {
            System.out.println(ex.toString());
            
        }
    }
 
    @Override
    public void valueChanged(ListSelectionEvent e) {
        try {
            int indiceSeleccionadoLista = vistaBandejaDeEntrada.listaAsuntoBandejaEntrada.
                    getSelectedIndex();
            int indiceContenido = listaDeMensajes.length - indiceSeleccionadoLista - 1;
           
            vistaBandejaDeEntrada.areaContenidoBandejaEntrada.setText(
                listaDeMensajes[indiceContenido].getFrom()[0].toString()
                    );
        } catch (MessagingException ex) {
            System.out.println(ex.toString());
        }
    }
   
    public void iniciarVistaBandejaDeEntrada(){
        vistaBandejaDeEntrada.setTitle( "BANDEJA DE ENTRADA" );
        vistaBandejaDeEntrada.setLocationRelativeTo(null);
    }
}
