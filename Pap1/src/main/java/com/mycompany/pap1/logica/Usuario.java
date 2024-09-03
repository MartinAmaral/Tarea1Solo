/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.logica;


/**
 *
 * @author martin
 */
abstract class Usuario {
    private String nombre;
    private String email;

    public Usuario() {
        super();
    }
        
    public String getNombre(){
        return nombre;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setEmail(String email){
        this.email = email;   
    }
}
