/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author hubert
 */
public class GrilleAccessException extends Exception{
    public GrilleAccessException(String message){
        super(message);
    }
    
    public GrilleAccessException(String message , Throwable source){
        super(message , source);
    }
    
    public GrilleAccessException(Throwable source){
        super(source);
    }
    
    
}
