/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.newtonpaiva;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author caioa
 */
public class PersistenceService {
    
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("NewSuppliesCompanyPU"); 
    private static final EntityManager em = emf.createEntityManager();
    
    public static EntityManager getEntityManager() {
        return em;
    }
    
}
