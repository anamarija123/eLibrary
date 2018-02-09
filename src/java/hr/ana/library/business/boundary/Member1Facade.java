/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.ana.library.business.boundary;

import hr.ana.library.business.entity.Member1;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author anama
 */
@Stateless
public class Member1Facade extends AbstractFacade<Member1> {

    @PersistenceContext(unitName = "Library3PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Member1Facade() {
        super(Member1.class);
    }
    
}
