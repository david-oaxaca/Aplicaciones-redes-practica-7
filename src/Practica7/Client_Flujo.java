/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica7;

import java.io.RandomAccessFile;

/**
 *
 * @author tdwda
 */
public class Client_Flujo extends Thread{
    private int puerto;
    private int inicio;
    private int termino;
    private RandomAccessFile archivo;
    private String path;
    
    public Client_Flujo(){}
    
    public Client_Flujo( RandomAccessFile archivo, String path, int puerto, int inicio, int termino){
        this.archivo = archivo;
        this.path = path;
        this.puerto = puerto;
        this.inicio = inicio;
        this.termino = termino;
    }
    
    @Override
    public void run(){
        //System.out.println(""+puerto);
    }
}
