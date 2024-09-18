/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.logica;


import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
        var emf = Persistence.createEntityManagerFactory("tarea");
        var em = emf.createEntityManager();
        
        
        String jpql = "SELECT u FROM Usuario u";
        TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);

        List<Usuario> res = query.getResultList();
        
        em.close();
        emf.close();
        return res;
    }
    
    public List<Beneficiario> GetBeneficiarios(){
     
        var emf = Persistence.createEntityManagerFactory("tarea");
        var em = emf.createEntityManager();
        
        
        String jpql = "SELECT b FROM Beneficiario b";
        TypedQuery<Beneficiario> query = em.createQuery(jpql, Beneficiario.class);

        List<Beneficiario> res = query.getResultList();
        em.close();
        emf.close();
        return res;
        
    }
    
}
