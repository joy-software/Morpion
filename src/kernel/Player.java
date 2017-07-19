/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kernel;

/**
 * represente un joueur
 * @author hubert
 */
public class Player {
    /**
     * nom du joueur
     */
    private String nom = "player";
    
    /**
     * identifiant du joueur (unique)
     */
    private int value;
    
    /**
     * 
     * @param value  identifiant du joueur
     */
    public Player(int value){
        this.value = value;
        this.nom += (" "+value);
    }
    
    /**
     * 
     * @param value identifiant du joueur
     * @param nom  nom du joueur
     */
    public Player(int value , String nom){
        this.value = value;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    
}
