/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import kernel.Grille;

/**
 *
 * @author hubert
 */
public class TestGrille {
    public static void main(String[] args) {
        Grille g = new Grille(3);
        g.set(1, 2, 10);
        System.out.println(g);
    }
}
