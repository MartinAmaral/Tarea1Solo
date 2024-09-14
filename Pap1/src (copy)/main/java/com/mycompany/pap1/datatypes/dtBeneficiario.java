/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.datatypes;

import java.util.List;
import com.mycompany.pap1.logica.EstadoBeneficiario;
import com.mycompany.pap1.logica.Barrio;
import com.mycompany.pap1.logica.Distribucion;

/**
 *
 * @author horacio
 */
public class dtBeneficiario {
    private String direccion;
    private int fechaNacimiento;
    private EstadoBeneficiario estado;
    private Barrio barrio;
    private List<Distribucion> distribuciones;

    public dtBeneficiario(String direccion, int fechaNacimiento, EstadoBeneficiario estado, Barrio barrio) {
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
        this.barrio = barrio;
    }

    
        
    public String getDireccion(){
        return direccion;
    }
    public int getFechaNacimiento(){
        return fechaNacimiento;
    }
    public EstadoBeneficiario getEstado(){
        return estado;
    }
    public Barrio getBarrio(){
        return barrio;
    }
    
    public void setDirecion(String direccion){
        this.direccion = direccion;
    }
    public void setFechaNacimiento(int fecha){
        fechaNacimiento = fecha;
    }
    public void setEstado(EstadoBeneficiario estado){
        this.estado = estado;
    }
    public void setBarrio(Barrio barrio){
        this.barrio = barrio;
    }
      
}

