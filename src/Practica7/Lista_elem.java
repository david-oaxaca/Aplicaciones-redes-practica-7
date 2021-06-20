/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica7;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author tdwda
 */
public class Lista_elem implements Serializable{
    
    private String archivo;
    private String Hash;

    
    public Lista_elem(){ }
    
    public Lista_elem(String File_Path, String Hash){
        this.archivo = File_Path;
        this.Hash = Hash;
    }
    
    
    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }

    public String getHash() {
        return Hash;
    }

    public void setHash(String Hash) {
        this.Hash = Hash;
    }
}
