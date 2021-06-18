/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica7;

import java.io.IOException;
import java.net.MulticastSocket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author tdwda
 */
public class Main {
    
    public static void main(String main[]) throws IOException{
        
        Scanner sc = new Scanner(System.in);
        int rmi_envio = 8000;
        int flujo_envio = 7778;
        String uniqueID = UUID.randomUUID().toString();
        
        ArrayList <Nodo> nodos_encontrados = new ArrayList();
        
        MulticastSocket socket;
        socket = new MulticastSocket(7777);
        socket.setReuseAddress(true);
        socket.setTimeToLive(255);
        
        //Inicialización de hilos para anuncio de puertos y descubrimiento de nodos
        System.out.println("ID de sesio: " + uniqueID);
        new ServidorMulticast(socket, rmi_envio, flujo_envio, uniqueID, "Puertos").start();
        new ClienteNodos(socket, nodos_encontrados, rmi_envio, flujo_envio, uniqueID).start();
        
        
        System.out.println("*************************************************");
        System.out.println("Escriba el nombre del archivo que desea buscar entre los servidores: ");
        System.out.println("*************************************************");
        
        String archivo = sc.nextLine();
        
        
        
        
    }
}


