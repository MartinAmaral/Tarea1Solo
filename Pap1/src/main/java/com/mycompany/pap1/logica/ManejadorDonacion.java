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
public class ManejadorDonacion {
    private static ManejadorDonacion instancia = null;
    
    private ManejadorDonacion(){}
    
    public static ManejadorDonacion getInstancia(){
            if (instancia == null)
                instancia = new ManejadorDonacion();
            return instancia;
    }
    
    public void agregarDonacion(Donacion donacion) {
        var emf = Persistence.createEntityManagerFactory("tarea");
        var em = emf.createEntityManager();
        
        em.getTransaction().begin();
		
        em.persist(donacion);
		
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
    public Donacion buscarDonacionPorId(int id) {
        var emf = Persistence.createEntityManagerFactory("tarea");
        var em = emf.createEntityManager();
        
        var res= em.find(Donacion.class, id);
        
        em.close();
        emf.close();
        return res;
    }
    
    public List<Donacion> obtenerDonacionesPorTipo(Class<? extends Donacion> tipo) {
        var emf = Persistence.createEntityManagerFactory("tarea");
        var em = emf.createEntityManager();
        
        String tipoQ;
        
        if(tipo == Articulo.class){
            
            tipoQ = "Art";
        }
        else tipoQ= "Ali";
        
        
        String jpql = "SELECT d FROM Donacion d WHERE d.dtype = :tipo";
        TypedQuery<Donacion> query = em.createQuery(jpql, Donacion.class);
        query.setParameter("tipo",tipoQ ); // Replace with actual value

        List<Donacion> res = query.getResultList();
        
        em.close();
        emf.close();
        return res;
    }
}
