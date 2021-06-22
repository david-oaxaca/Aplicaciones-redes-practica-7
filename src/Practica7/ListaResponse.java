/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica7;

import java.util.ArrayList;

/**
 *
 * @author David Arturo Oaxaca Pérez
 * @author David Madrigal Buendia
 */
public class ListaResponse {
    private ArrayList <Lista_elem> archivos;
    
    public ListaResponse(){}
    
    public ListaResponse( ArrayList <Lista_elem> respuesta ){
        this.archivos = respuesta;
    }

    public ArrayList<Lista_elem> getArchivos() {
        return archivos;
    }

    public void setArchivos(ArrayList<Lista_elem> archivos) {
        this.archivos = archivos;
    }
}
