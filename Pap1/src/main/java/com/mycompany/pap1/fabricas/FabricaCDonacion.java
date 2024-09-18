/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.fabricas;

import com.mycompany.pap1.interfaces.IControladorDonacion;
import com.mycompany.pap1.logica.ControladorDonacion;

/**
 *
 * @author martin
 */
public class FabricaCDonacion {
    public static IControladorDonacion getControlador(){
        return ControladorDonacion.getInstancia();
    }
}
