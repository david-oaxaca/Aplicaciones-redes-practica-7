/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica7;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author tdwda
 */
public class Client_RMI extends Thread{
    
    public Client_RMI(){
        
    }
    
    public void run(){
    
        String host = "127.0.0.1";
        try{
            Registry registry = LocateRegistry.getRegistry(host);
            ListaArchivos stub = (ListaArchivos) registry.lookup("busqueda");
            
        }catch(Exception e){
            
        }
    }
}
