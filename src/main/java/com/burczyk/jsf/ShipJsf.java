
package com.burczyk.jsf;

import com.burczyk.domain.Ship;
import com.burczyk.ejb.ShipEjb;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class ShipJsf implements Serializable {
    
    private ListDataModel<Ship> ships = new ListDataModel<Ship>();
    private Ship ship;
    
    @Inject
    private ShipEjb shipEjb; 
    
    public ListDataModel<Ship> getShips() {
        ships.setWrappedData(shipEjb.getShips());
        return ships;
    }

    public Ship getShip() {
        if(ship == null){ ship = new Ship(); }
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
    
    public String show() {
        ship = ships.getRowData();
        return "show";
    }
    
    public String add() {
        return "add";
    }
    
    public String edit() {
        ship = ships.getRowData();
        return "edit";
    }
    
    public String delete() {
        ship = ships.getRowData();
        shipEjb.delete(ship);
        return "all";
    }
    
    public String merge() {
        shipEjb.merge(ship);
        return "all";
    }
}
