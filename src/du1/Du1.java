/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package du1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author jethro
 */
public class Du1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        System.out.print("Zadejte zobrazení:");
        char pismeno = readChar();
        System.out.print("Zadejte meritko:");
        int scale = readInt();
        System.out.print("Zadejte polomer:");    
        double R = readDouble();
        if (R == 0){
            R = 6371.11;} 

        
//        LAMBERTOVO ZOBRAZENÍ  
        if (pismeno =='L'){                        
            System.out.println("Rovnobezky: ");           
            for (int u = -90; u<=90; u= u+10){
            double y = (R * Math.sin(u * (Math.PI/180)) * 100000) / scale;     
            
            if (y > 100 || y < -100) 
                    System.out.print("-, ");
            else
            System.out.format("%.1f ", y);
            }
            
            System.out.println("\nPoledniky: ");
//            vypocet_x();
            for (int v=-180; v<=180 ; v= v+10){
            double x = R * 100000 * (v * (Math.PI/180)) / scale;
            if (x > 100 || x < -100) 
                    System.out.print("-, ");
            else
            System.out.format("%.1f " , x);
            }
        }
//        MARINOVO ZOBRAZENÍ  
        else if (pismeno == 'A'){
            System.out.println("Rovnobezky: ");         
            for (int u = -90; u<=90; u= u+10){
            double y = R * 100000 * (u * (Math.PI/180)) / scale;
            if (y > 100 || y < -100) 
                    System.out.print("-, ");
            else
            System.out.format("%.1f ", y);
            }
            
            System.out.println("\nPoledniky: ");
            for (int v=-180; v<=180 ; v= v+10){
            double x = R * 100000 * (v * (Math.PI/180)) / scale;
            if (x > 100 || x < -100) 
                    System.out.print("-, ");
            else
            System.out.format("%.1f " , x);
            }
        }
//        BRAUNOVO ZOBRAZENÍ  
        else if (pismeno=='B'){
            System.out.println("Rovnobezky: ");         
            for (int u = -90; u<=90; u= u+10){
            double y = 2 * R * 100000 * Math.tan((u * (Math.PI/180))/2) / scale;
            if (y > 100 || y < -100) 
                    System.out.print("-, ");
            else
            System.out.format("%.1f ", y);
            }
            
            System.out.println("\nPoledniky: ");
            for (int v=-180; v<=180 ; v= v+10){
            double x = R * 100000 * (v * (Math.PI/180)) / scale;
            if (x > 100 || x < -100) 
                    System.out.print("-, ");
            else
            System.out.format("%.1f " , x);
            }
            
        }
//        MERCATOROVO ZOBRAZENÍ
        else if (pismeno == 'M'){
            System.out.println("Rovnobezky: ");         
            for (int u = -90; u<=90; u= u+10){
            double y = R * 100000 * Math.log(Math.tan(((u * (Math.PI/180))/2) + (45 * (Math.PI/180)))) / scale;
            if (y > 100 || y < -100) 
                    System.out.print("-, ");
            else
            System.out.format("%.1f ", y);
            }
            
            System.out.println("\nPoledniky: ");
            for (int v=-180; v<=180 ; v= v+10){
            double x = R * 100000 * (v * (Math.PI/180)) / scale;
            if (x > 100 || x < -100) 
                    System.out.print("-, ");
            else
            System.out.format("%.1f " , x);                   
            }
        }
        else 
            System.out.println("Neplatná hodnota");
    }

    public static void vypocet_x() throws IOException{
        double R = 6371.11;
        int scale=readInt();
        int v;
        System.out.println("Poledniky: ");
        for ( v=-180; v<=180 ; v= v+10){
            double x = R * 100000 * (v * (Math.PI/180)) / scale;
            
        
        if (x > 100 || x < -100) 
                System.out.print("-, ");
        else
            System.out.format("%.1f " , x);        
        }
    }
        
      
 
        
    public static int readInt() throws IOException{
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(reader.readLine());
        
    }
    
    public static double readDouble() throws IOException{
        BufferedReader reader;
        reader = new BufferedReader(new InputStreamReader(System.in));
        return Double.parseDouble(reader.readLine());
    }
    
    public static char readChar() throws IOException{
        Scanner s= new Scanner(System.in);
        return  s.next().charAt(0);
    }
}

