/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.logica;

import java.time.LocalDate;
/**
 *
 * @author martin
 */
public class Articulo extends Donacion {
    
    private String descripcion;
    private float peso;
    private String dimensiones;

    public Articulo(String descripcion, float peso, String dimensiones, int id, LocalDate fechaIngresada) {
        super(id, fechaIngresada);
        this.descripcion = descripcion;
        this.peso = peso;
        this.dimensiones = dimensiones;
    }  
    
    public String getDescripcion(){
        return descripcion;
    }
    public float getPeso(){
        return peso;
    }
    public String getDimensiones(){
        return dimensiones;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void setPeso(float peso){
        this.peso = peso;
    }
    public void setDimensiones(String dimensiones){
        this.dimensiones = dimensiones;
    }
    
}
