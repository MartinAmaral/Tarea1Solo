/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.logica;

import com.mycompany.pap1.interfaces.IControladorDonacion;
import java.time.LocalDate;


public class ControladorDonacion implements IControladorDonacion{
    
    private static ControladorDonacion instancia = null;
    
    public static ControladorDonacion getInstancia(){
            if (instancia == null)
                instancia = new ControladorDonacion();
            return instancia;
    }
    
    LocalDate fecha;
    
    String descripcionAlimento;
    int cantidadAlimento;
    
    String descipcionArticulo;
    float peso;
    String dimensiones;
    
    @Override
    public void AgregarDatosDonacion(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public void AgregarDatosAlimento(String descripcion, int cantidad) {
        this.descripcionAlimento = descripcion;
        this.cantidadAlimento = cantidad;
    }

    @Override
    public void AgregarDatosArticulo(String descripcion, float peso, String dimensiones) {
        this.descipcionArticulo = descripcion;
        this.peso = peso;
        this.dimensiones = dimensiones;
    }

    @Override
    public void ConfirmarAltaAlimento() {
        
    }

    @Override
    public void ConfirmarAltaArticulo() {
    
    }
    
    
    
 }

