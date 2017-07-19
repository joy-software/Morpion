/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import kernel.Coup;

/**
 *
 * @author hubert
 */
public class Util {
    public static ArrayList<Coup> shuffle(ArrayList<Coup> coups){
        ArrayList<Coup> coupsDesordonnee = new ArrayList<>();
        for(int i=0 ; i<coups.size() ; i++){
            int k = (int)Math.round(Math.random()*(coups.size()-1));
            coupsDesordonnee.add(coups.get(k));
            coups.remove(k);
        }
        return coupsDesordonnee;
        
    }
}
