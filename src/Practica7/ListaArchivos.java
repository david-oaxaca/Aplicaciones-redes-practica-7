/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica7;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author tdwda
 */
public interface ListaArchivos extends Remote{
    Listas busqueda(String archivo) throws RemoteException;
}
