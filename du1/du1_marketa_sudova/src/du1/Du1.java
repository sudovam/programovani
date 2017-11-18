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
//      Zadani vstupnich parametru   
        System.out.print("Zadejte zobrazeni:");
        char pismeno = readChar();
        System.out.print("Zadejte meritko:");
       
       /*
        * Vyber zobrazeni podle zadanych parametru uzivatele
        */        
//      LAMBERTOVO ZOBRAZENI  
        if (pismeno =='L'|| pismeno == 'l'){                        
            Lambert();
        }
//      MARINOVO ZOBRAZENI  
        else if (pismeno =='A'|| pismeno == 'a'){
            Marina();
        }
//      BRAUNOVO ZOBRAZENI  
        else if (pismeno=='B'|| pismeno == 'b'){
            Braun();               
        }
//      MERCATOROVO ZOBRAZENI
        else if (pismeno =='M'|| pismeno == 'm'){
            Mercator();
        }
//      BEHRMANNOVO ZOBRAZENI        
        else if (pismeno =='H'|| pismeno == 'h'){
            Behrmann();
        }
//      GNOMONICKA PROJEKCE        
        else if (pismeno =='G'|| pismeno == 'g'){
            Gnomonicka_projekce();
        }
        else          
            System.out.println("Neplatna hodnota");
    }
   /* 
    * Vypocet Lambertova zobrazeni
    * Vstupni parametry: polomer R, meritko scale, zemepisna sirka u, zemepisna delka v
    * Vystupni parametry: x - vzdalenost poledniku od 0, y - vzdalenost rovnobezek od 0 
    */  
    public static void Lambert() throws IOException{
        double R =6371.11;
        int scale = readInt();
       /*
        * Cyklus pro prepocet zemepisne sirky podle zobrazovaci rovnice na vzdalenost v mape  
        */    
        System.out.print("Rovnobezky: ");
        for (int u = -90; u<=90; u= u+10){
            double y = (R * Math.sin(u * (Math.PI/180)) * 100000) / scale;     
            if (y > 100 || y < -100) 
                System.out.print("-, ");
            else
                System.out.format("%.1f ", y);
        }
       /*
        * Cyklus pro prepocet zemepisne delky podle zobrazovaci rovnice na vzdalenost v mape  
        */  
        System.out.print("\nPoledniky: ");
        for (int v=-180; v<=180 ; v= v+10){
            double x = R * 100000 * (v * (Math.PI/180)) / scale;
            if (x > 100 || x < -100) 
                System.out.print("-, ");
            else
                System.out.format("%.1f " , x);
        }
    }
   /* 
    * Vypocet Marinova zobrazeni
    * Vstupni parametry: polomer R, meritko scale, zemepisna sirka u, zemepisna delka v
    * Vystupni parametry: x - vzdalenost poledniku od 0, y - vzdalenost rovnobezek od 0
    */    
    public static void Marina() throws IOException{
        double R = 6371.11;
        int scale = readInt();
       /*
        * Cyklus pro prepocet zemepisne sirky podle zobrazovaci rovnice na vzdalenost v mape  
        */      
        System.out.print("Rovnobezky: ");         
        for (int u = -90; u<=90; u= u+10){
            double y = R * 100000 * (u * (Math.PI/180)) / scale;
            if (y > 100 || y < -100) 
                System.out.print("-, ");
            else
                System.out.format("%.1f ", y);
        }
       /*
        * Cyklus pro prepocet zemepisné delky podle zobrazovaci rovnice na vzdalenost v mape  
        */      
        System.out.print("\nPoledniky: ");
        for (int v=-180; v<=180 ; v= v+10){
            double x = R * 100000 * (v * (Math.PI/180)) / scale;
            if (x > 100 || x < -100) 
                System.out.print("-, ");
            else
                System.out.format("%.1f " , x);
        }
    }
   /* 
    * Vypocet Braunova zobrazeni
    * Vstupni parametry: polomer R, meritko scale, zemepisna sirka u, zemepisna delka v
    * Vystupni parametry: x - vzdalenost poledniku od 0, y - vzdalenost rovnobezek od 0 
    */    
    public static void Braun() throws IOException{
        double R = 6371.11;
        int scale = readInt();
       /*
        * Cyklus pro prepocet zemepisne sirky podle zobrazovaci rovnice na vzdalenost v mape 
        */  
        System.out.println("Rovnobezky: ");         
        for (int u = -90; u<=90; u= u+10){
            double y = 2 * R * 100000 * Math.tan((u * (Math.PI/180))/2) / scale;
            if (y > 100 || y < -100) 
                System.out.print("-, ");
            else
                System.out.format("%.1f ", y);
        }
       /*
        * Cyklus pro prepocet zemepisne delky podle zobrazovaci rovnice na vzdalenost v mape  
        */  
        System.out.println("\nPoledniky: ");
        for (int v=-180; v<=180 ; v= v+10){
            double x = R * 100000 * (v * (Math.PI/180)) / scale;
            if (x > 100 || x < -100) 
                System.out.print("-, ");
            else
                System.out.format("%.1f " , x);
        } 
    }
   /* 
    * Vypocet Mercatorova zobrazeni
    * Vstupni parametry: polomer R, meritko scale, zemepisna sirka u, zemepisna delka v
    * Vystupni parametry: x - vzdalenost poledniku od 0, y - vzdalenost rovnobezek od 0 
    */    
    public static void Mercator() throws  IOException{
        double R = 6371.11;
        int scale = readInt();
       /*
        * Cyklus pro prepocet zemepisne sirky podle zobrazovaci rovnice na vzdalenost v mape  
        */  
        System.out.println("Rovnobezky: ");         
        for (int u = -90; u<=90; u= u+10){
            double y = R * 100000 * Math.log(Math.tan(((u * (Math.PI/180))/2) + (45 * (Math.PI/180)))) / scale;
            if (y > 100 || y < -100) 
                System.out.print("-, ");
            else
                System.out.format("%.1f ", y);
        }
       /*
        * Cyklus pro prepocet zemepisne delky podle zobrazovaci rovnice na vzdalenost v mape  
        */      
        System.out.println("\nPoledniky: ");
        for (int v=-180; v<=180 ; v= v+10){
            double x = R * 100000 * (v * (Math.PI/180)) / scale;
            if (x > 100 || x < -100) 
                System.out.print("-, ");
            else
                System.out.format("%.1f " , x);                   
        }
    }
   /* 
    * Vypocet Behrmannova zobrazeni
    * Vstupni parametry: polomer R, meritko scale, zemepisna sirka u, zemepisna delka v, 
    * konstanta u0
    * Vystupni parametry: x - vzdalenost poledniků od 0, y - vzdalenost rovnobezek od 0 
    */    
    public static void Behrmann()throws  IOException{
        double R = 6371.11;
        int scale = readInt();
        double u0 = 30 * (Math.PI/180);
       /*
        * Cyklus pro prepocet zemepisne sirky podle zobrazovaci rovnice na vzdalenost v mape  
        */  
        System.out.println("Rovnobezky: ");         
        for (int u = -90; u<=90; u= u+10){
            double y = R * Math.sin(u*(Math.PI/180)) * 1/Math.cos(u0) * 100000 / scale;
            if (y > 100 || y < -100) 
                System.out.print("-, ");
            else
                System.out.format("%.1f ", y);
        }
       /*
        * Cyklus pro prepocet zemepisne delky podle zobrazovaci rovnice na vzdalenost v mape  
        */  
        System.out.println("\nPoledniky: ");
        for (int v=-180; v<=180 ; v= v+10){
            double x = R * 100000 * (v * (Math.PI/180)) * Math.cos(u0) / scale;
            if (x > 100 || x < -100) 
                System.out.print("-, ");
            else
                System.out.format("%.1f " , x);
        } 
    }
   /* 
    * Vypocet Gnomonicke projekce
    * Vstupni parametry: polomer R, meritko scale, zemepisna sirka u, zemepisna delka v
    * Vystupni parametry: x - vzdalenost poledniku od 0, y - vzdalenost rovnobezek od 0 
    */    
    public static void Gnomonicka_projekce()throws  IOException{
        double R = 6371.11;
        int scale = readInt();
       /*
        * Cyklus pro prepocet zemepisne sirky podle zobrazovaci rovnice na vzdalenost v mape
        * V bode [0,0] se zobrazuje pol
        */  
        System.out.println("Rovnobezky pro jednu polokouli: ");         
        for (int u = 0; u<=90; u= u+10){
            int delta = 90 - u;
            double rho = R * Math.tan(delta * (Math.PI/180))* 100000 / scale;
            if (rho > 100 || rho < -100) 
                System.out.print("-, ");
            else
                System.out.format("%.1f ", rho);
        }
       /*
        * Cyklus pro prepocet zemepisne delky podle zobrazovaci rovnice na uhel v mape
        * Vstupni parametr: zemepisna delka v
        */  
        System.out.println("\nUhel mezi poledniky[°]: ");
        for (int v=0; v<=360 ; v= v+10){
        double eps = v;
        System.out.format("%.0f  ",eps);
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