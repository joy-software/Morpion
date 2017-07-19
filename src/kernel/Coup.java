/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kernel;

/**
 * Represente le coup d'un joueur
 * @author hubert
 */
public class Coup {
    /**
     * la ligne que le joueur choisit. commence à 0
     */
    private int ligne;
    
    /**
     * la colone qu'il choisit, commence à 0
     */
    private int colone;

    /**
     *
     * @return la ligne
     */
    public int getLigne() {
        return ligne;
    }

    /**
     * change de ligne
     * @param ligne la nouvelle valeur de la ligne
     */
    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    /**
     * recuperer la valeur de la colone
     * @return la valeur de la colone
     */
    public int getColone() {
        return colone;
    }

    /**
     * changer la colone
     * @param colone la nouvelle valeur de la colone
     */
    public void setColone(int colone) {
        this.colone = colone;
    }

    /**
     * Constructeur
     * @param ligne la ligne
     * @param colone  la colone 
     */
    public Coup(int ligne, int colone) {
        this.ligne = ligne;
        this.colone = colone;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + this.ligne;
        hash = 23 * hash + this.colone;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coup other = (Coup) obj;
        if (this.ligne != other.ligne) {
            return false;
        }
        if (this.colone != other.colone) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Coup{" + "ligne=" + ligne + ", colone=" + colone + '}';
    }
    
    
    
    
    
}
