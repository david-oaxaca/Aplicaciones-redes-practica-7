/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica7;

/**
 *
 * @author David Arturo Oaxaca Pérez
 * @author David Madrigal Buendia
 */
public class Nodo {
    private String puerto_RMI;
    private String puerto_Flujo;
    private String ID;

    public Nodo(){ }
    
    public Nodo(int rmi, int flujo, String id){
        this.puerto_RMI = ""+rmi;
        this.puerto_Flujo = ""+flujo;
        this.ID = id;
    }
    
    public String getPuerto_RMI() {
        return puerto_RMI;
    }

    public void setPuerto_RMI(String puerto_RMI) {
        this.puerto_RMI = puerto_RMI;
    }

    public String getPuerto_Flujo() {
        return puerto_Flujo;
    }

    public void setPuerto_Flujo(String puerto_Flujo) {
        this.puerto_Flujo = puerto_Flujo;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    
    
}
