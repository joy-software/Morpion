/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kernel;

/**
 * Permet d'evaluer une configuration de jeux
 * @author hubert
 */
public class Evaluator {
    /**
     * la valeur maximale que la fonction d'évaluaiton peut retourner, elle est generalement
     * retournée quand le joueur pour lequel on evalue la configuration gagne et 
     * son opposé quand il perd
     */
    public static final int MAX_EVALUATION = Integer.MAX_VALUE;
    public static final int MIN_VALUE = Integer.MIN_VALUE;

    
    /**
     * permet d'evaluer le tableau de jeux pour un joueur donnée
     * @param p le tableau de jeux
     * @param value l'identifiant du joueurs
     */
    public static int evaluate(PlayBoard p , int value){
        int NbPointJoueur=0;
        int NbPointAdversaire=0;
        int resultat=0;
        int cote = p.getGrille().getCote();
        //si la partie est fini, ou null ou gagne
        if(p.isOver()){
            if(p.isNull()){
                return 0;
            }else if(p.winner() == value){
                return 1;
            }else{
                return -1;
            }
        }
        
        //evaluation des n ligne i=0:cote
        for(int i=0 ; i<cote ; i++){
            NbPointJoueur=0;
            NbPointAdversaire=0;
            for(int j=0 ; j < cote ; j++){
                if(p.get(i, j) == value){
                    NbPointJoueur++;
                }else if(p.get(i, j) != Grille.NULL_CASE){
                    NbPointAdversaire++;
                }
                resultat += comptePoint(NbPointJoueur , NbPointAdversaire , cote);
            }
            //System.out.print(" joueur : " + NbPointJoueur + " adversaire "+NbPointAdversaire + "\t");
            //System.out.println("ligne : " + i + " : " + comptePoint(NbPointJoueur , NbPointAdversaire , cote));
            
        }
        
        //evaluation des n colones
        for(int i=0 ; i<cote ; i++){
            NbPointJoueur=0;
            NbPointAdversaire=0;
            for(int j=0 ; j<cote ; j++){
                if(p.get(j, i) == value){
                    NbPointJoueur++;
                }else if(p.get(j, i) != Grille.NULL_CASE){
                    NbPointAdversaire++;
                }
                resultat += comptePoint(NbPointJoueur , NbPointAdversaire , cote);
            }
            //System.out.println("colone : " + i + " : " + comptePoint(NbPointJoueur , NbPointAdversaire , cote));
        }
        
        //diagonale descendante gauche vers droite. on examine a chaque fois 
        //la diagonnale k (superieur et inferieur)
        for(int k=0 ; k<cote ; k++){
            
            //diagonale superieure
            NbPointJoueur=0;
            NbPointAdversaire=0;
            for(int i=0 ; i<cote-k ; i++){
                if(p.get(i, i+k) == value){
                    NbPointJoueur++;
                }else if(p.get(i, i+k) != Grille.NULL_CASE){
                    NbPointAdversaire++;
                }
            }
            resultat += comptePoint(NbPointJoueur, NbPointAdversaire , cote-k);
            //System.out.println("D sup : " + k + " : " + comptePoint(NbPointJoueur , NbPointAdversaire , cote));
            
            //diagonale inferieure
            NbPointJoueur=0;
            NbPointAdversaire=0;
            for(int i=0 ; i<cote-k ; i++){
                if(p.get(i+k, i) == value){
                    NbPointJoueur++;
                }else if(p.get(i+k, i) != Grille.NULL_CASE){
                    NbPointAdversaire++;
                }
            }
            resultat += comptePoint(NbPointJoueur, NbPointAdversaire , cote-k);
            //System.out.println("D inf : " + k + " : " + comptePoint(NbPointJoueur , NbPointAdversaire , cote));
        }
        
        //diagonale ascendante droite vers gauche. on examine a chaque fois 
        //la diagonnale k (superieur et inferieur)
        for(int i=0 ; i<cote ; i++){
            //diagonale superieure
            NbPointJoueur=0;
            NbPointAdversaire=0;
            for(int j=0 ; j<=i ; j++){
                if(p.get(i-j, j) == value){
                    NbPointJoueur++;
                }else if(p.get(i-j, j) != Grille.NULL_CASE){
                    NbPointAdversaire++;
                }
            }
            resultat += comptePoint(NbPointJoueur, NbPointAdversaire , i);
            //System.out.println("D-sup : " + i + " : " + comptePoint(NbPointJoueur , NbPointAdversaire , cote));
            
            //diagonnale inferieure
            NbPointJoueur=0;
            NbPointAdversaire=0;
            for(int j=0 ; j<=i ; j++){
                if(p.get(cote-j-1, j) == value){
                    NbPointJoueur++;
                }else if(p.get(cote-j-1, j) != Grille.NULL_CASE){
                    NbPointAdversaire++;
                }
            }
            resultat += comptePoint(NbPointJoueur, NbPointAdversaire , i);
            //System.out.println("D-inf : " + i + " : " + comptePoint(NbPointJoueur , NbPointAdversaire , cote));
        }

        return resultat;
    }
    
    /**
     * evalue une ligne particulire du jeux
     * @param joueur nombre de point du joueur sur la ligne
     * @param adversaire nombre de pion de l'adversaire sur la ligne
     * @param cote cote
     * @return le nombre de point
     */
    protected static int comptePoint(int joueur , int adversaire , int cote){
        int points = 0;
        
        //System.out.print(" joueur : "+joueur+" adversaire : "+adversaire+"\t");
        
        int diff = joueur-adversaire;
        diff = diff>0 ? diff : 0;
        
        points = diff*10;
        if(joueur > 0){
            points += (cote-joueur-adversaire)*5;
        }
        
        
        return points;
    }

    private int cmptePoint(int nbrPoint){
        int points = 0;
            points += nbrPoint*10;
        return points;
    }

    
    
}
