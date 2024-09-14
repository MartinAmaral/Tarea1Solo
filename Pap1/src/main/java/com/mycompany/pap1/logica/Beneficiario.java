/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author martin
 */
public class Beneficiario extends Usuario {
    private String direccion;
    private LocalDate fechaNacimiento;
    private EstadoBeneficiario estado;
    private Barrio barrio;
    private List<Distribucion> distribuciones;

    public Beneficiario(String nombre, String email, String direccion, LocalDate fechaNacimiento, EstadoBeneficiario estado, Barrio barrio) {
        
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
        this.estado = estado;
        this.barrio = barrio;
        this.distribuciones = new ArrayList<>();
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
    
    public void setDirecion(String direccion){
        this.direccion = direccion;
    }
    public void setFechaNacimiento(LocalDate fecha){
        fechaNacimiento = fecha;
    }
    public void setEstado(EstadoBeneficiario estado){
        this.estado = estado;
    }
    public void setBarrio(Barrio barrio){
        this.barrio = barrio;
    }
      
}
