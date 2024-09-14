/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.logica;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author horacio
 */
public class ManejadorDistribucion {
    private static ManejadorDistribucion instancia = null;
    private List<Distribucion> distribucion = new ArrayList<>();
    
    private ManejadorDistribucion(){}
    
    public static ManejadorDistribucion getInstancia(){
            if (instancia == null)
                instancia = new ManejadorDistribucion();
            return instancia;
    }
}
