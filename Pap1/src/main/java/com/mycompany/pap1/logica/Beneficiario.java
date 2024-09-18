/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
/**
 *
 * @author martin
 */

@Entity
@DiscriminatorValue("B")
public class Beneficiario extends Usuario {
    private String direccion;
    private LocalDate fechaNacimiento;
    private EstadoBeneficiario estado;
    
    @Enumerated(EnumType.STRING)
    private Barrio barrio;
    
    @OneToMany(mappedBy = "beneficiario")
    private List<Distribucion> distribuciones;

    public Beneficiario() {
        super();
    }
    
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

    public List<Distribucion> getDistribuciones() {
        return distribuciones;
    }
    
    
    public void setDireccion(String direccion){
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

    public void setDistribuciones(List<Distribucion> distribuciones) {
        this.distribuciones = distribuciones;
    }
    
}
