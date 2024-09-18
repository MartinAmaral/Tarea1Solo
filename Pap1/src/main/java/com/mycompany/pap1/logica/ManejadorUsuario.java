/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.logica;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;

/**
 *
 * @author horacio
 */
public class ManejadorUsuario {
    private static ManejadorUsuario instancia = null;
    
    private ManejadorUsuario(){}
    
    public static ManejadorUsuario getInstancia(){
            if (instancia == null)
                instancia = new ManejadorUsuario();
            return instancia;
    }
    
    public void AgregarUsuario(Usuario usuario){
        var emf = Persistence.createEntityManagerFactory("tarea");
        var em = emf.createEntityManager();
        
        em.getTransaction().begin();
		
        em.persist(usuario);
		
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    
    public List<Usuario> GetUsuarios(){
        var res = new ArrayList<Usuario>();
        return res;
    }
    
}
