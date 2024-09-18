/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pap1.logica;


import java.util.List;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author horacio
 */
public class ManejadorDistribucion {
    private static ManejadorDistribucion instancia = null;
    
    private ManejadorDistribucion(){}
    
    public static ManejadorDistribucion getInstancia(){
            if (instancia == null)
                instancia = new ManejadorDistribucion();
            return instancia;
    }
    
    public List<Distribucion> getDistribuciones(){
        
        var emf = Persistence.createEntityManagerFactory("tarea");
        var em = emf.createEntityManager(); 
        
        
        String jpql = "SELECT d FROM Distribucion d";
        TypedQuery<Distribucion> query = em.createQuery(jpql, Distribucion.class);

        List<Distribucion> res = query.getResultList();
        
        em.close();
        emf.close();
        return res;
    }
    
    public List<Distribucion> getDistribucionesPorEstado(EstadoDistribucion estado){
        var emf = Persistence.createEntityManagerFactory("tarea");
        var em = emf.createEntityManager();
        
        
        String jpql = "SELECT d FROM Distribucion d WHERE d.estado = :estado";
        TypedQuery<Distribucion> query = em.createQuery(jpql, Distribucion.class);
        query.setParameter("estado",estado.toString());

        List<Distribucion> res = query.getResultList();
        
        em.close();
        emf.close();
        return res;
    }
}
