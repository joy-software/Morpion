/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import exceptions.GrilleAccessException;
import java.util.ArrayList;
import kernel.Coup;
import kernel.PlayBoard;
import kernel.Player;

/**
 *
 * @author hubert
 */
public class TestSimulationPartie {
    
    
    
    public static void main(String[] args) throws GrilleAccessException  {
        TestSimulationPartie t = new TestSimulationPartie();
        int taille = 1;
        System.out.println("taille " + taille);
        long td = System.currentTimeMillis();
        for(int i=0 ; i<taille ; i++){
            t.test();
        }
        long tend = System.currentTimeMillis();
        
        System.out.println("\n\n execution de "+taille+" de partie en " + (tend-td) + " ms");
    }
    
    public void test() throws GrilleAccessException {
        int taille = 5;
        
        Player p1 = new Player(5);
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
        
        //System.out.println("taille   :  " +cs.size());
        int i=0;
        while(!p.isOver()){
            int k = (int)Math.round(Math.random()*(cs.size()-1));
            
            p.play(cs.get(k) ,  ps[(i++)%2].getValue());
            cs.remove(k);
                   // System.out.println(p);        

            
        }
        System.out.println(p);        
        System.out.println("player : "+p.winner()+" win ");
        
        TestEvaluator.test(p, ps[0].getValue());
        
    }

}
