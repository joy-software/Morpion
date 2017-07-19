/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kernel;

import exceptions.GrilleAccessException;
/**
 *Table de jeux
 * @author hubert
 */
public class PlayBoard{
    /**
     * partie null
     */
    public static final int NULL_GAME = 0;
    
    /**
     * grille de jeux
     */
    private Grille grille;
    
    /**
     * nombre de case par ligne
     */
    private final int cote;
    
    /**
     * nombre de point à aligner pour gagner
     */
    private int nombreGagnant = 3;
    
    /**
     * determiner s'il y a un gagnant ou pas
     */
    private boolean win = false;
    
    /**
     * id du gagnant, en cas de match null , elle continet NULL_GAME
     */
    private int winnerValue = 0;
    
    
    
    public PlayBoard(int cote , int nombreGagnant){
        this.cote = cote;
        this.grille = new Grille(cote);
        this.nombreGagnant = nombreGagnant;
    }
    
    public PlayBoard clone(){
        PlayBoard p =  new PlayBoard(this.cote , this.nombreGagnant);
        
        p.grille = new Grille(this.cote);
        for(int i=0 ; i<this.cote ; i++){
            for(int j=0 ; j<this.cote ; j++){
                p.grille.set(i, j, this.grille.get(i, j));
            }
        }
        p.win = this.win;
        p.winnerValue = this.winnerValue;
        
        return p;
    }
    
    
    
	/**
     * permet de joueur un coup
     * @param c le coup à joueur
     * @param value l'identifiant du joueur
     * @throws exceptions.GrilleAccessException
     */
    public void play(Coup c , int value) throws GrilleAccessException 
    {
        if(grille.get(c.getLigne(), c.getColone()) !=0){
            throw new GrilleAccessException("case deja occupe");
        }else if(win){
            throw new GrilleAccessException("Partie terminer");
        }{
            grille.set(c.getLigne(), c.getColone() , value);
            evaluate(value);
        }
    }
	
    public void annuler(Coup c , int value){
        grille.set(c.getLigne(), c.getColone(),Grille.NULL_CASE);
        evaluate(-value);
    }
    
    /**
     * evalue le jeux pour savoir si la partie est finie, null , ou alors si le 
     * joueur d'identifiant value à gagner
     * @param value identifiant du joueur
     */
    protected void evaluate(int value){
        int max = 0;
        int nbr;
        int points = 0;
        boolean flag;

        for(int i=0 ; i <  cote ; i++ ){
            for(int j=0 ; j < cote ; j++){
                //on effectue une analyse si la case sur
                //laquelle on est correspond a celle du joueur
                if(grille.get(i, j) == value){
                    //analyse horizontal vers la droite
                    nbr = 1;
                    flag = true;
                    for(int k=j+1 ; k < cote && flag ; k++){
                        
                        if(grille.get(i , k) != value){
                            flag = false;
                        }else{
                            nbr++;
                            //System.out.println("on compte k="+k);
                        }
                    }

                    //System.out.println("nbr " + nbr);
                    max = nbr > max ? nbr:max;
                    //points += com
                    
                    /**
                     * TODO analyse oblique vers la droite
                     */
                    nbr=1;
                    flag = true;
                    for(int k = 1 ; k<=i && k<cote-j && flag ;k++){
                        if(grille.get(i-k , j+k) != value){
                            flag = false;
                        }else{
                            nbr++;
                     //       System.out.println("on compte i="+(i-k)+" j="+(j+k));
                        }
                    }
                    
                    max = nbr > max ? nbr:max;
                    //System.out.println("max " + max);

                    
                    
                    /**
                     * TODO analyse vertical ascendante
                     */
                    nbr = 1;
                    flag = true;
                    for(int k=i-1 ; k >= 0 && flag ; k--){
                        
                        if(grille.get(k , j) != value){
                            flag = false;
                        }else{
                            nbr++;
                            //System.out.println("on compte k="+k);
                        }
                    }
                    max = nbr > max ? nbr:max;
                    //System.out.println("max " + max);
                    
                    
                    /**
                     * TODO analyse oblique vers la gauche
                     */
                    nbr=1;
                    flag = true;
                    for(int k = 1 ;k<=i && k<=j && flag ;k++){
                        if(grille.get(i-k , j-k) != value){
                            flag = false;
                        }else{
                            nbr++;
                            //System.out.println("on compte i="+(i-k)+" j="+(j+k));
                        }

                    }
                    max = nbr > max ? nbr:max;
                }
                
            }

        }
        //System.out.println("resultat : "+max);
        
        //traitement du resultat
        if(max >= nombreGagnant){
            win = true;
            winnerValue = value;
        }else{
            win = false;
            winnerValue = NULL_GAME;
        }
    }
    
    
    
    /**
     * informe si le jeux est terminer
     * @return 
     */
    public boolean isOver(){
        if(win){
            return true;
        }
        for(int i=0 ; i<cote ; i++){
            for(int j=0 ; j<cote ; j++){
                if(grille.get(i, j) == Grille.NULL_CASE){
                    return false;
                }
            }
        }
        winnerValue = NULL_GAME;
        return true;
    }
    
    /**
     * indique si la partie se termine null ou pas
     * @return 
     */
    public boolean isNull(){
        return winnerValue == NULL_GAME;
    }
    
    /**
     * retourner l'identifiant du gagant
     * @return 
     */
    public int winner(){
        return winnerValue;
    }
    
    
    public int get(int i , int j){
        return grille.get(i, j);
    }


    public Grille getGrille() {
        return grille;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }
    
    @Override
    public String toString(){
        return grille +"";
    }

    public boolean getWin() {
        return win;
    }
    
    
}
