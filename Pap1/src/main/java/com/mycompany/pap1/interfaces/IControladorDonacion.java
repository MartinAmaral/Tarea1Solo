/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.interfaces;


import java.time.LocalDate;

/**
 *
 * @author horacio
 */
public interface IControladorDonacion {
    
        // caso alta donacion
        public void AgregarDatosDonacion(LocalDate fecha);
        public void AgregarDatosAlimento(String descripcion , int cantidad);
        public void AgregarDatosArticulo(String descripcion, float peso , String dimensiones);
        public void ConfirmarAltaAlimento();
        public void ConfirmarAltaArticulo();
        
        //
        
}
