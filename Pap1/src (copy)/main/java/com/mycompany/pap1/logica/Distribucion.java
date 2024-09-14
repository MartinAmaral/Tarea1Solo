/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.logica;

/**
 *
 * @author martin
 */
public class Distribucion {
    private int fechaPreparacion;
    private int fechaEntrega;
    private EstadoDistribucion estado;
    
    private Beneficiario beneficiario;
    private Donacion donacion;

    public Distribucion() {
        super();
    }
    
    public int getFechaPreparacion(){
        return fechaPreparacion;
    }
    public int getFechaEntrega(){
        return fechaEntrega;
    }
    public EstadoDistribucion getEstadoDistribucion(){
        return estado;
    }
    
    public void setFechaPreparacion(int fecha){
        fechaPreparacion = fecha;
    }
    public void setFechaEntrega(int fecha){
        fechaEntrega = fecha;
    }
    public void setEstadoDistribucion(EstadoDistribucion estado){
        this.estado = estado;
    }
}
