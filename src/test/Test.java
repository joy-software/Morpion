/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import exceptions.GrilleAccessException;
import kernel.Coup;
import kernel.PlayBoard;

/**
 *
 * @author hubert
 */
public class Test {
    public static void main(String[] args) throws GrilleAccessException  {
        PlayBoard p = new PlayBoard(5,3);
        p.play(new Coup(0,0), 10);
        PlayBoard pC = p.clone();
        
        pC.play(new Coup(1,1), 5);
        
        System.out.println("p " + p);
        System.out.println("pC " + pC);
        
    }
}
