/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kernel;

/**
 * intelligence artificiel representant un joueur
 * @author hubert
 */
public abstract class IA extends Player{
    protected int profondeur = 3;
    
    public IA(int value) {
        super(value , "IA");
    }
    
    public IA(int value , String nom){
        super(value , nom);
    }
    
    public IA(int value , int profondeur , String nom){
        super(value , nom);
        this.profondeur = profondeur;
    }
    
    public IA(int value , int profondeur){
        super(value);
        this.profondeur = profondeur;
    }
    
    abstract public Coup play(PlayBoard p);

    
    public int getProfondeur() {
        return profondeur;
    }

    public void setProfondeur(int profondeur) {
        this.profondeur = profondeur;
    }
    
    
    
}
