/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.fabricas;

import com.mycompany.pap1.interfaces.IControladorDistribucion;
import com.mycompany.pap1.logica.ControladorDistribucion;


/**
 *
 * @author martin
 */
public class FabricaCDistribucion {
    
    public static IControladorDistribucion getControlador(){
        return ControladorDistribucion.getInstancia();
    }
}
