/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Practica7;

import java.io.IOException;
import java.net.MulticastSocket;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/**
 *
 * @author tdwda
 */
public class Main {
    
    public static int puertosDisponibles(int lim_menor, int lim_superior){
        for (int port = lim_menor; port < lim_superior; port++) {
            try{
                ServerSocket s = new ServerSocket(port);
                s.close();
                return port;
            }catch(Exception e){}
        }
        return 0;
    }
    
    public static void main(String main[]) throws IOException, InterruptedException{
        
        Scanner sc = new Scanner(System.in);
        int rmi_envio = puertosDisponibles(1999, 4000);
        int flujo_envio = puertosDisponibles(7778, 1000);
        String uniqueID = UUID.randomUUID().toString();
        
        ArrayList <Nodo> nodos_encontrados = new ArrayList();
        
        ArrayList <Lista_elem> allFiles = new ArrayList();
        
        MulticastSocket socket;
        socket = new MulticastSocket(7777);
        socket.setReuseAddress(true);
        socket.setTimeToLive(255);
        
        //Inicialización de hilos para anuncio de puertos y descubrimiento de nodos
        System.out.println("ID de sesion: " + uniqueID);
        System.out.println("*************************************************");
        new ServidorMulticast(socket, rmi_envio, flujo_envio, uniqueID, "Puertos").start();
        new ClienteNodos(socket, nodos_encontrados, rmi_envio, flujo_envio, uniqueID).start();
        
        //System.out.println("Escriba el directorio donde se realizaran las peticiones de busqueda: ");
        //String Dir_Busqueda = sc.nextLine();
        System.out.println("Inicializando servidor RMI...");
        
        new Server_RMI(rmi_envio).start();
        
        Thread.sleep(1000);
        
        //"C:\\Users\\tdwda\\OneDrive\\Documentos\\NetBeansProjects\\Practica7\\Archivos"
        //Archivos
        
        System.out.println("Escriba el nombre del archivo que desea buscar entre los servidores: ");
        String archivo = sc.nextLine();
        
        ArrayList <ListaResponse> respuestas = new ArrayList();
        
        for (Nodo encontrado : nodos_encontrados) {
            ArrayList <Lista_elem> respuesta = new ArrayList();
            new Client_RMI(archivo, Integer.parseInt(encontrado.getPuerto_RMI()), respuesta).start();
            respuestas.add(new ListaResponse(respuesta));
        }
        
        Thread.sleep(1000);
        for (ListaResponse respuesta : respuestas) {
            allFiles.addAll(respuesta.getArchivos());
        }
        
        System.out.println("Se encontraron " + allFiles.size() + " archivos que coinciden con ese nombre");
        
        for (int i = 0; i < allFiles.size(); i++) {
            System.out.println("Archivo " + i + " :");
            System.out.println("\t" + allFiles.get(i).getArchivo());
            System.out.println("\t" + allFiles.get(i).getHash());
        }
        
    }
}


