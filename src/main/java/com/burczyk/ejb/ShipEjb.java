
package com.burczyk.ejb;

import com.burczyk.domain.Ship;
import java.util.List;
import javax.ejb.Stateful;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateful
@Named
public class ShipEjb {

    @PersistenceContext(unitName = "JPU")
    private EntityManager em;
    
    public List<Ship> getShips() {
        return em.createQuery("select s from Ship s").getResultList();
    }
    
    public void delete(Ship ship) {
        ship = em.merge(ship);
        em.remove(ship);
    }
 
    public void merge(Ship ship) {
        em.merge(ship);
    }
   
}
