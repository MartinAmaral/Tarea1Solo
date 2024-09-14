/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.fabricas;

import com.mycompany.pap1.interfaces.IControladorUsuario;
import com.mycompany.pap1.logica.ControladorUsuario;

/**
 *
 * @author martin
 */
public class FabricaCUsuario {
    
    public static IControladorUsuario getControlador(){
        return ControladorUsuario.getInstancia();
    }
}
