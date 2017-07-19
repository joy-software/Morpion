/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import exceptions.GrilleAccessException;
import java.util.ArrayList;
import kernel.Coup;
import kernel.Grille;
import kernel.IAMinMax;
import kernel.PlayBoard;
import kernel.Player;
import kernel.IA;
import util.Util;

/**
 *
 * @author hubert
 */
public class testIAPlay {
    public static void main(String[] args) throws GrilleAccessException {
        test();
    }
    
    public static void test() throws GrilleAccessException{
        int taille = 5;
        
        IA p1 = new IAMinMax(5);
        Player p2 = new Player(10);
        
        Player[] ps = {p1 , p2};
        PlayBoard p = new PlayBoard(taille , 4);
        
        
        //on generer tous les coup possible que l'on place dans un arrayList
        ArrayList<Coup> cs = new ArrayList<>();
        for(int i=0 ; i<taille ; i++){
            for(int j=0 ; j<taille ; j++){
                cs.add(new Coup(i , j));
            }
        }
        cs = Util.shuffle(cs);
        
        //System.out.println("taille   :  " +cs.size());
        int i=0;
        while(!p.isOver()){
            System.out.println("================ : " + i + " ================== ");
            if(i%2 == 0){
                Coup c = p1.play(p);
                p.play(c, p1.getValue());
            }else{
                //System.out.print();
                for( Coup c : cs){
                    if(p.get(c.getLigne(), c.getColone()) == Grille.NULL_CASE){
                        p.play(c, p2.getValue());
                        break;
                    }
                }
            }
            System.out.println(p);
            i++;   
        }
        System.out.println(p);        
        System.out.println("player : "+p.winner()+" win ");
    }
    
    
}
