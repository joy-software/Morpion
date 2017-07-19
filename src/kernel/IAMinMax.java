/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kernel;

import exceptions.GrilleAccessException;
import java.util.ArrayList;
import java.util.Random;


/**
 * Première implementation de IA, execute l'algorithme minMax
 * @author hubert
 */
public class IAMinMax extends IA{
    private ArrayList<Coup> coup = new ArrayList<>();

    /**
     * 
     * @param value identifiant du joueur
     */
    public IAMinMax(int value) {
        super(value);
    }
    
    /**
     * 
     * @param value identifiant du joueur
     * @param nom  nom du joueur
     */
    public IAMinMax(int value , String nom){
        super(value , nom);
    }
    
    /**
     * 
     * @param value identifiant du joueur
     * @param profondeur profondeur de la recherche de l'ia
     * @param nom nom du joueur
     */
    public IAMinMax(int value , int profondeur , String nom){
        super(value ,profondeur, nom);
    }
    
    public IAMinMax(int value , int profondeur){
        super(value, profondeur);
    }
    
    
    /**
     * cette fonction permet a l'ia d'annalyse le jeu et de joueur le meilleur
     * coup possible en fonction de la profondeur. 
     * NB: ici, l'ia effectue un jeu aleatoire, pas de reflexion, ceci ne te
     * servira que pour des test
     * @param p la table de jeux
     * @return le coup choisit par l'ia
     */
    /*public Coup play(PlayBoard p){
        PlayBoard pClone = p.clone();
        ArrayList<Coup> cs = new ArrayList<>();
        for(int i=0 ; i<p.getGrille().getCote() ; i++){
            for(int j=0 ; j<p.getGrille().getCote() ; j++){
                cs.add(new Coup(i , j));
            }
        }
        
        cs = Util.shuffle(cs);

        for( int i=0 ; i<cs.size() ; i++){
            try {
                
                pClone.play(cs.get(i), this.getValue());
                
                return cs.get(i);
            } catch (GrilleAccessException ex) {
                
            }
        }
        
        return null;
    }*/
    @Override
    public Coup play(PlayBoard p){
        
        return minMax(p.clone(),this.getValue());
    }
    
    protected Coup minMax(PlayBoard p,int value){
        coup.clear();
        int scoreMax = Evaluator.MIN_VALUE;
        //System.out.println("profondeur "+profondeur);
        for(int i=0 ; i<p.getGrille().getCote() ; i++){
            for(int j=0 ; j<p.getGrille().getCote() ; j++){
                //on simuler le coup
                //PlayBoard pClone = p.clone();
                if(p.get(i, j) == Grille.NULL_CASE){
                   try {
                        p.play(new Coup(i , j), value);
                    } catch (GrilleAccessException ex) {
                        //System.err.println("erreur " + ex.getMessage());
                    }
                    //System.out.println("la grille de l'IA");
                    //System.out.println(p.getGrille());
                    //on evalue le tableau de jeux
                    //int playboardValue = (int) Math.round(Math.random()*10000);
                    int playboardValue = calculAdd(p.clone(),-1*value);
                    ////System.out.println("valeur minimale du noeud "+ playboardValue);
                    //on comparer a la valeur max
                    if(playboardValue > scoreMax){//&& Math.round(Math.random())%2==0)
                        coup.clear();
                        scoreMax = playboardValue;
                        coup.add(new Coup(i,j));
                    }
                    else
                    {
                        if(playboardValue == scoreMax)
                        {
                           coup.add(new Coup(i,j)); 
                        }
                    }
                    
                    p.annuler(new Coup(i , j) , value);
                }
                
            }
        }
        Random rand = new Random();
        //System.out.println(coup);
        return coup.get(rand.nextInt(coup.size()));
    }
    
    
    protected int calculAdd(PlayBoard p , int value){
        
        int  scoreMin = Evaluator.MIN_VALUE;
        //System.out.println("profondeur "+profondeur);
        int playboardValue;
        int score = 0;
        if(p.isOver() || profondeur == 0){
            score =  Evaluator.evaluate(p,-value);
        }
        else
        {
            //on parcours le tableau de jeux
            for(int i=0 ; i<p.getGrille().getCote() ; i++){
                for(int j=0 ; j<p.getGrille().getCote() ; j++){
                    //on simuler le coup
                    //PlayBoard pClone = p.clone();
                    if(p.get(i, j) == Grille.NULL_CASE){
                        try {
                            p.play(new Coup(i , j), value);
                        } catch (GrilleAccessException ex) {
                            //System.err.println("erreur " + ex);
                        }
                        //System.out.println("la grille de min");
                        //System.out.println(p.getGrille());
                    //on evalue le tableau de jeux
                    //int playboardValue = Evaluator.evaluate(p,this.getValue());
                    playboardValue = calculAdd(p, -1*value);
                    //on annuler le coup
                    p.annuler(new Coup(i , j),value);
                    
                    //on comparer a la valeur max
                    if(playboardValue > scoreMin) {
                            scoreMin = playboardValue;
                        }
                   
                  }

                }
            }
            score = -scoreMin;
        }
        ////System.out.println("scoreMin"+scoreMin);
        
        return score;
    }
    /*
    protected int calculMax(PlayBoard p , int profondeur){
        int  scoreMax=0;
        //System.out.println("profondeur "+profondeur);
       
        if(p.isOver() || profondeur == 0){
            return Evaluator.evaluate(p, -this.getValue());
        }
        
        //on parcours le tableau de jeux
        for(int i=0 ; i<p.getGrille().getCote() ; i++){
            for(int j=0 ; j<p.getGrille().getCote() ; j++){
                //on simuler le coup
                //PlayBoard pClone = p.clone();
                if(p.get(i, j) == Grille.NULL_CASE){
                    try {
                        p.play(new Coup(i , j), this.getValue());
                    } catch (GrilleAccessException ex) {
                        //System.err.println("erreur " + ex);
                    }
                     //System.out.println("la grille de max");
                    //System.out.println(p.getGrille());
                //on evalue le tableau de jeux
                //int playboardValue = Evaluator.evaluate(p,this.getValue());
                int playboardValue = calculMin(p, profondeur);
                //on comparer a la valeur max
//                if((playboardValue < scoreMax) ||
//                        (playboardValue==scoreMax )){//&& Math.round(Math.random())%2==0
//                        scoreMax = playboardValue;
//                    }
//                
//                    
                    //on annuler le coup
                   // p.annuler(new Coup(i , j), this.getValue());
                    
                }
                
            }
        }
        ////System.out.println("scoreMax "+scoreMax);
        return 0;
    } 
    //*/
}
