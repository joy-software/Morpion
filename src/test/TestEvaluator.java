/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import exceptions.GrilleAccessException;
import java.util.ArrayList;
import kernel.Coup;
import kernel.Evaluator;
import kernel.PlayBoard;
import kernel.Player;

/**
 *
 * @author hubert
 */
public class TestEvaluator {
    public static void main(String[] args) throws GrilleAccessException  {
        test2();
    }
    
    public static void test(PlayBoard p , int value){
        
        
        
        Evaluator evaluator = new Evaluator();
        System.out.println(p);
        
        System.out.println("evaluation  pour "+value+": "+Evaluator.evaluate(p, value));
    }
    
    public static void test2() throws GrilleAccessException {
        int taille = 3;
        
        Player p1 = new Player(5);
        Player p2 = new Player(10);
        
        Player[] ps = {p1 , p2};
        PlayBoard p = new PlayBoard(taille , 3);
        
        
        //on generer tous les coup possible que l'on place dans un arrayList
        ArrayList<Coup> cs = new ArrayList<>();
        for(int i=0 ; i<taille ; i++){
            for(int j=0 ; j<taille ; j++){
                cs.add(new Coup(i , j));
            }
        }
        int k = (int)Math.round(Math.random()*(cs.size()-1));
        for(int i=0 ; i< k ; i++){
            int l = (int)Math.round(Math.random()*(cs.size()-1));
            
            p.play(cs.get(l) ,  ps[(i)%2].getValue());
            cs.remove(l);
        }
        
        test(p, ps[0].getValue());
        test(p, ps[1].getValue());
        
    }
    public static void test3() throws GrilleAccessException {
        int taille = 3;
        
        Player p1 = new Player(5);
        Player p2 = new Player(10);
        
        Player[] ps = {p1 , p2};
        PlayBoard p = new PlayBoard(taille , 3);
        
        p.play(new Coup(0,1), 5);
        p.play(new Coup(1,1), 10);
        p.play(new Coup(2,1), 5);
        p.play(new Coup(2,2), 10);
        
        test(p, ps[0].getValue());
        test(p, ps[1].getValue());
        
    }
}
