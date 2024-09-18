/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.datatypes;

import java.util.List;
import com.mycompany.pap1.logica.EstadoBeneficiario;
import com.mycompany.pap1.logica.Barrio;
import com.mycompany.pap1.logica.Distribucion;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author horacio
 */
public class dtBeneficiario {
    private String nombre;
    private String email;
    private String direccion;
    private LocalDate fechaNacimiento;
    private EstadoBeneficiario estado;
    private Barrio barrio;
    private List<Distribucion> distribuciones;

    public dtBeneficiario(String nombre,String email, String direccion, LocalDate fechaNacimiento, EstadoBeneficiario estado,
                Barrio barrio) {
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
        this.barrio = barrio;
        this.distribuciones = new ArrayList<>();
    }
    public String getNombre(){
        return nombre;
    }
    public String getEmail(){
        return email;
    }
    
    public String getDireccion(){
        return direccion;
    }
    public LocalDate getFechaNacimiento(){
        return fechaNacimiento;
    }
    public EstadoBeneficiario getEstado(){
        return estado;
    }
    public Barrio getBarrio(){
        return barrio;
    }

    public List<Distribucion> getDistribuciones() {
        return distribuciones;
    }
    
   
      
}

