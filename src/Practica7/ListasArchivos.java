/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica7;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author tdwda
 */
public interface ListasArchivos extends Remote{
    ArrayList <Lista_elem> busqueda(String archivo) throws RemoteException;
}
