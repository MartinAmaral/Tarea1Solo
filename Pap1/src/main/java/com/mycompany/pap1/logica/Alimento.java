/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.logica;


import java.time.LocalDate;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author martin
 */
@Entity
@DiscriminatorValue("Alim")
public class Alimento extends Donacion {
    
    private String descripcionProductos;
    private int cantElementos;

    public Alimento(){
        super();
    }
    
    public Alimento(String descripcionProductos, int cantElementos, LocalDate fechaIngresada) {
        this.fechaIngresada = fechaIngresada;
        this.descripcionProductos = descripcionProductos;
        this.cantElementos = cantElementos;
    }

    public String getDescripcionProductos() {
        return descripcionProductos;
    }

    public void setDescripcionProductos(String descripcionProductos) {
        this.descripcionProductos = descripcionProductos;
    }
    
    
    public int getCantElementos(){
        return cantElementos;
    }
    
    public void setCantElementos(int cantidad){
        cantElementos = cantidad;
    }
    

}
