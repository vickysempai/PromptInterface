/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PromptIndexer;

import indexador.Indexador;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author Usuario
 */
public class PromptIndexer {
    
    Indexador index=new Indexador();
    
    public void Search(String query){
        String[] top5 = index.Search(query);
        for(int i=0; i<5; i++){
            if (top5==null)break;
            if(top5[i]!="")
            System.out.println(top5[i]);}
    }
    
    public void load(String direction) throws IOException, FileNotFoundException, ClassNotFoundException{
        index.load(direction);
    }
    public void Index(String direction) throws Exception{
        index.Indexar(direction);
    }
    
    public void ComandReader(String Command) throws Exception{
        StringTokenizer st = new StringTokenizer(Command);
        //String[] lines = {"", "", "", "", "", "", "", "", ""};
        String[] lines = Command.split(" ");
        int position=0;/*
        while (st.hasMoreTokens())
            {
            lines[position] = st.nextToken();
            position++;
            }*/
        try{
        if(lines[0].equals("indexar")&&(lines[1].equals("-f"))) this.Index(lines[2]);
        
        else if(lines[0].equals("cargar")&&(lines[1].equals("-p"))) this.load(lines[2]);
        
        else if(lines[0].equals("buscar")&&(lines[1].equals("-q"))){
            this.Search(Command.subSequence(10, Command.length()-5).toString());
        }
        else if(lines[0].equals("exit")){}
        else System.out.println("no se reconoce el comando");
        } catch (Exception e) {System.out.println("comando incompleto");}
            }
        
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, Exception {
        System.out.println("Bienvenido a mi indexador");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        PromptIndexer thisInstance = new PromptIndexer();
        System.out.println("escriba exit para salir");
        
        while (line.equalsIgnoreCase("exit") == false) {
            line = in.readLine();
            thisInstance.ComandReader(line);
        }
        in.close();
    }
}