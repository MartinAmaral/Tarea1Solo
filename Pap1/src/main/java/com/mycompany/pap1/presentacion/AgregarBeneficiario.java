/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pap1.presentacion;

import com.mycompany.pap1.fabricas.FabricaCUsuario;
import com.mycompany.pap1.logica.Barrio;
import com.mycompany.pap1.logica.EstadoBeneficiario;
import java.time.LocalDate;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class AgregarBeneficiario extends JInternalFrame {

    JInternalFrame frameUsuario;
    /**
     * Creates new form AgregarBeneficiario
     */
    public AgregarBeneficiario(JInternalFrame frameUsuario) {
        this.frameUsuario = frameUsuario;
        initComponents();
        ComboBoxBarrio.removeAllItems();
        for (Barrio barrio : Barrio.values()) {
            ComboBoxBarrio.addItem( barrio.toString());
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        TextDireccion = new javax.swing.JTextField();
        ComboBoxBarrio = new javax.swing.JComboBox<>();
        ButtonIngresar = new javax.swing.JButton();
        ButtonCancelar = new javax.swing.JButton();
        SpinnerDia = new javax.swing.JSpinner();
        SpinnerMes = new javax.swing.JSpinner();
        SpinnerAno = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ingresa Datos de Beneficiario");

        jLabel2.setText("Direccion:");

        jLabel3.setText("Fecha Nacimiento:");

        jLabel4.setText("Barrio:");

        TextDireccion.setPreferredSize(new java.awt.Dimension(124, 23));

        ComboBoxBarrio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        ButtonIngresar.setText("Ingresar");
        ButtonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonIngresarActionPerformed(evt);
            }
        });

        ButtonCancelar.setText("Cancelar");
        ButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ButtonIngresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ButtonCancelar)
                        .addGap(65, 65, 65))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(28, 28, 28)
                                .addComponent(SpinnerDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(SpinnerMes, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SpinnerAno, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ComboBoxBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TextDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(46, 46, 46))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TextDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(SpinnerDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SpinnerMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SpinnerAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(ComboBoxBarrio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonIngresar)
                    .addComponent(ButtonCancelar))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonIngresarActionPerformed
                                              
    String mensaje = "Seleccione un número válido";

    try {
        int dia = (Integer)(SpinnerDia.getValue());
        int mes = (Integer)(SpinnerMes.getValue());
        int ano = (Integer)(SpinnerAno.getValue());

        System.out.println("Fecha ingresada: " + dia + "/" + mes + "/" + ano);

        if(dia < 1 || dia > 31){
            mensaje = "Día inválido";
            throw new Exception();
        }
        if(mes < 1 || mes > 12){
            mensaje = "Mes inválido";
            throw new Exception();
        }
        
        if(ano <1900 || ano >2024){
            mensaje = "Ano invalido";
            throw new Exception();
        }
        
        if((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30){
            mensaje = "Día inválido";
            throw new Exception();
        }
        
        if(mes == 2) {
            if(dia > 29) {
                mensaje = "Día inválido";
                throw new Exception();
            }
            if(dia == 29 && !(ano % 4 == 0 && (ano % 100 != 0 || ano % 400 == 0))) {
                mensaje = "Día inválido en año no bisiesto";
                throw new Exception();
            }
        }

        if(TextDireccion.getText().trim().isEmpty()){
            mensaje = "Ingrese una Dirección";
            throw new Exception();
        }
        
        FabricaCUsuario.getControlador().AgregarDatosAltaBeneficiario(TextDireccion.getText(),
                LocalDate.of(ano, mes, dia), EstadoBeneficiario.ACTIVO,
                Barrio.valueOf((String)ComboBoxBarrio.getSelectedItem()));
        
        // Mensaje de éxito
        JOptionPane.showMessageDialog(null, 
        "Beneficiario guardado exitosamente", 
        "Éxito", 
        JOptionPane.INFORMATION_MESSAGE);
        frameUsuario.dispose();
        this.dispose();
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, 
        mensaje, 
        "Error", 
        JOptionPane.ERROR_MESSAGE);
    }                                       
                

    }//GEN-LAST:event_ButtonIngresarActionPerformed

    private void ButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelarActionPerformed
        FabricaCUsuario.getControlador().CancelartAlta();
        this.dispose();
    }//GEN-LAST:event_ButtonCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCancelar;
    private javax.swing.JButton ButtonIngresar;
    private javax.swing.JComboBox<String> ComboBoxBarrio;
    private javax.swing.JSpinner SpinnerAno;
    private javax.swing.JSpinner SpinnerDia;
    private javax.swing.JSpinner SpinnerMes;
    private javax.swing.JTextField TextDireccion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
