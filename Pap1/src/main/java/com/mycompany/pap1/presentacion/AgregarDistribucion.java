/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pap1.presentacion;

import com.mycompany.pap1.fabricas.FabricaCDistribucion;
import com.mycompany.pap1.fabricas.FabricaCDonacion;
import com.mycompany.pap1.fabricas.FabricaCUsuario;
import com.mycompany.pap1.logica.EstadoDistribucion;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author martin
 */
public class AgregarDistribucion extends JInternalFrame {

    private List<String> ben;
    private List<Integer> don;

    /**
     * Creates new form AgregarDistribucion
     */
    public AgregarDistribucion() {
        initComponents();

        Id.removeAllItems();
        Mail.removeAllItems();

        ben = FabricaCUsuario.getControlador().GetEmailBeneficiarios();
        don = FabricaCDonacion.getControlador().GetIdDonaciones();

        Id.addItem("<>");
        Mail.addItem("<>");

        for (var x : ben) {
            Mail.addItem(x);

        }

        for (var x : don) {
            Id.addItem(x.toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        DiaEntrega = new javax.swing.JSpinner();
        MesEntrega = new javax.swing.JSpinner();
        AnoEntrega = new javax.swing.JSpinner();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        DiaPrep = new javax.swing.JSpinner();
        MesPrep = new javax.swing.JSpinner();
        AnoPrep = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Mail = new javax.swing.JComboBox<>();
        Id = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Agregar Datos Distribucion");

        jLabel2.setText("Fecha Entrega:");

        AnoEntrega.setValue(2000);

        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Fecha Preparado:");

        AnoPrep.setValue(2000);

        jLabel4.setText("Mail Beneficiario:");

        jLabel5.setText("Id Donacion:");

        Mail.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Mail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MailActionPerformed(evt);
            }
        });

        Id.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(128, 128, 128))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(88, 88, 88)
                        .addComponent(jButton2)
                        .addGap(96, 96, 96))))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DiaPrep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(MesPrep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AnoPrep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(DiaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(MesEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AnoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(DiaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MesEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AnoEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(DiaPrep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MesPrep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AnoPrep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String mensaje = "";

        try {
            int diaPrep = (Integer) (DiaPrep.getValue());
            int mesPrep = (Integer) (MesPrep.getValue());
            int anoPrep = (Integer) (AnoPrep.getValue());

            int diaE = (Integer) (DiaEntrega.getValue());
            int mesE = (Integer) (MesEntrega.getValue());
            int anoE = (Integer) (AnoEntrega.getValue());

            if (diaPrep < 1 || diaPrep > 31) {
                mensaje = "Día inválido";
                throw new Exception();
            }
            if (mesPrep < 1 || mesPrep > 12) {
                mensaje = "Mes inválido";
                throw new Exception();
            }

            if (anoPrep < 1900 || anoPrep > 2024) {
                mensaje = "Ano invalido";
                throw new Exception();
            }

            if ((mesPrep == 4 || mesPrep == 6 || mesPrep == 9 || mesPrep == 11) && diaPrep > 30) {
                mensaje = "Día inválido";
                throw new Exception();
            }

            if (mesPrep == 2) {
                if (diaPrep > 29) {
                    mensaje = "Día inválido";
                    throw new Exception();
                }
                if (diaPrep == 29 && !(anoPrep % 4 == 0 && (anoPrep % 100 != 0 || anoPrep % 400 == 0))) {
                    mensaje = "Día inválido en año no bisiesto";
                    throw new Exception();
                }
            }

            if (diaE < 1 || diaE > 31) {
                mensaje = "Día inválido";
                throw new Exception();
            }
            if (mesE < 1 || mesE > 12) {
                mensaje = "Mes inválido";
                throw new Exception();
            }

            if (anoE < 1900 || anoE > 2024) {
                mensaje = "Ano invalido";
                throw new Exception();
            }

            if ((mesE == 4 || mesE == 6 || mesE == 9 || mesE == 11) && diaE > 30) {
                mensaje = "Día inválido";
                throw new Exception();
            }

            if (mesE == 2) {
                if (diaE > 29) {
                    mensaje = "Día inválido";
                    throw new Exception();
                }
                if (diaE == 29 && !(anoE % 4 == 0 && (anoE % 100 != 0 || anoE % 400 == 0))) {
                    mensaje = "Día inválido en año no bisiesto";
                    throw new Exception();
                }
            }
            
            if(Id.getSelectedIndex() == 0 || Mail.getSelectedIndex() ==0 )
            {
                mensaje = "Opcion Incorrecta";
                throw new Exception();
            }

            FabricaCDistribucion.getControlador().AgregarDistribucion(LocalDate.of(anoE,mesE,diaE),
                    LocalDate.of(anoPrep,mesPrep,diaPrep), (String)Mail.getSelectedItem(), Integer.parseInt((String)Id.getSelectedItem()));
            // Mensaje de éxito
            JOptionPane.showMessageDialog(null,
                    "Distribucion guardada exitosamente",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
            this.dispose();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null,
                    mensaje,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void MailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MailActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner AnoEntrega;
    private javax.swing.JSpinner AnoPrep;
    private javax.swing.JSpinner DiaEntrega;
    private javax.swing.JSpinner DiaPrep;
    private javax.swing.JComboBox<String> Id;
    private javax.swing.JComboBox<String> Mail;
    private javax.swing.JSpinner MesEntrega;
    private javax.swing.JSpinner MesPrep;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
