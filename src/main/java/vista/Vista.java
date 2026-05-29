package vista;

import java.util.Scanner;

public class Vista {
    private Scanner sc = new Scanner(System.in);

    public int menu(String titulo, String[] opciones) {
        System.out.println("\n===== " + titulo + " =====");
        
        for (int i = 0; i < opciones.length; i++){
            System.out.println(i + ". " + opciones[i]);
        }
        
        System.out.print("Opcion: ");
        
        try { 
            return Integer.parseInt(sc.nextLine()); 
        }
        
        catch (Exception e) { 
            return -1; 
        }
    }

    public String pedir(String label) {
        System.out.print(label + ": ");
        
        return sc.nextLine();
    }

    public void mensaje(String msg) { 
        System.out.println(">> " + msg); 
    }

    public void listar(Object[] arr, String titulo) {
        System.out.println("--- " + titulo + " ---");
        
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != null) {
                System.out.println("[" + i + "] " + arr[i]);
            }
        }
    }
}