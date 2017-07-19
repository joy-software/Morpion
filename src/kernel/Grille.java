/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kernel;



/**
 * represente la grille de jeux
 * @author hubert
 */
public class Grille {
    public static final int NULL_CASE = 0;
    private int cote = 3;
    private final int[][] grille;
    
    public Grille(){
        this.cote = 3;
        grille = new int[this.cote][this.cote];
    }
    
    public Grille(int cote){
        this.cote = cote;
        grille = new int[cote][cote];
    }
    
    
    public int get(int i , int j){    
        return grille[i][j];
    }
    
    public void set(int i , int j , int value) {
        this.grille[i][j] = value;
    }
    
    public int getCote(){
        return cote;
    }
    
    public String toString(){
        String chaine = "";
        chaine+="\n";
        
        for(int[] ligne:grille){
            for(int e : ligne){
                chaine += "" + e + "\t";
            }
            chaine+="\n";
        }
        
        chaine+="\n";
        return chaine;
    }
}
