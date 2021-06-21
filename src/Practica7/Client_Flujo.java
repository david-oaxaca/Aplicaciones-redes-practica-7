/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica7;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        //System.out.println((-1*(inicio-termino)));
        
        try {
            Socket cl = new Socket("localhost", puerto);
            BufferedOutputStream bos = new BufferedOutputStream(cl.getOutputStream());
            DataOutputStream dos = new DataOutputStream(bos);
            
            dos.writeUTF(this.path);
            dos.flush();
            
            dos.writeInt(this.inicio);
            dos.flush();
            
            dos.writeInt(this.termino);
            dos.flush();
            
            DataInputStream dis = new DataInputStream(cl.getInputStream());
            byte[] bytes = new byte[(-1*(inicio - termino))];
            dis.readFully(bytes, 0, (-1*(inicio - termino)));
            
            this.archivo.write(bytes, inicio, (-1*(inicio - termino)));
            
            System.out.println("Parte del archivo descargada...");
            
        } catch (IOException ex) {
            Logger.getLogger(Client_Flujo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}
