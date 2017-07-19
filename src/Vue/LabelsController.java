/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import static Vue.GameController.grilleDisable;
import static Vue.GameController.grille_grille_anchor;
import static Vue.GameController.image;
import static Vue.GameController.iter;
import static Vue.GameController.partieFinie;
import static Vue.GameController.playboard;
import static Vue.GameController.win;
import exceptions.GrilleAccessException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import kernel.Coup;

/**
 * FXML Controller class
 *
 * @author NDJAMA
 */
public class LabelsController implements Initializable {
    
    public GameController gamecontrol;
    public LabelController control;

    /**
     * le label 00
     */
    @FXML
    public Label label00;
    /**
     * le label 01
     */
    @FXML
    public Label label01;
    /**
     * le label 02
     */
    @FXML
    public Label label03;
    /**
     * le label 04
     */
    @FXML
    public Label label04;
    /**
     * le label 10
     */
    @FXML
    public Label label10;
    /**
     * le label 20
     */
    @FXML
    public Label label20;
    /**
     * le label 30
     */
    @FXML
    public Label label30;
    /**
     * le label 40
     */
    @FXML
    public Label label40;
    /**
     * le label 11
     */
    @FXML
    public Label label11;
    /**
     * le label 12
     */
    @FXML
    public Label label12;
    /**
     * le label 13
     */
    @FXML
    public Label label13;
    /**
     * le label 14
     */
    @FXML
    public Label label14;
    /**
     * le label 21
     */
    @FXML
    public Label label21;
    /**
     * le label 22
     */
    @FXML
    public Label label22;
    /**
     * le label 23
     */
    @FXML
    public Label label23;
    /**
     * le label 24
     */
    @FXML
    public Label label24;
    /**
     * le label 31
     */
    @FXML
    public Label label31;
    /**
     * le label 32
     */
    @FXML
    public Label label32;
    /**
     * le label 33
     */
    @FXML
    public Label label33;
    /**
     * le label 34
     */
    @FXML
    public Label label34;
    /**
     * le label 41
     */
    @FXML
    public Label label41;
    /**
     * le label 42
     */
    @FXML
    public Label label42;
    /**
     * le label 43
     */
    @FXML
    public Label label43;
    /**
     * le label 44
     */
    @FXML
    public Label label44;
   /**
     * le label 02
     */
    @FXML
    public Label label02;
    
    /**
     * Permet de recuperer la ligne et la colonne du noeud sur lequel on a clique
     * @param e
     */
    @FXML
    public void grille_getNode(MouseEvent e) throws GrilleAccessException 
    {
//        GridPane source = (GridPane)e.getSource() ;
//        Label label = (Label)getNodeByRowColumnIndex(rowIndex, colIndex, source);
        
        GridPane gridpane = (GridPane)grille_grille_anchor.getChildren().get(0);
        //System.out.println("ligne: "+rowIndex+", colonne: "+colIndex);
        //iter++;
        if(!gamecontrol.machine)
        {
            Label label = (Label)e.getSource();
            //label.setText("0");
            //System.out.println( e.getSceneX());
            int colIndex = GridPane.getColumnIndex(label);
            int rowIndex = GridPane.getRowIndex(label);
            Coup c = new Coup(rowIndex,colIndex);
            playboard.play(c,gamecontrol.getValue(iter));
            GameController.iter++;
            GameController.partieFinie = playboard.isOver();
            if(playboard.getWin()){
                GameController.grilleDisable = true;
                GameController.win = true;
                System.out.println("Partie terminer");
             }
            if(image)
            {
                gamecontrol.addImage((iter%2), label);
            }
            if(grilleDisable)
            {
                grille_grille_anchor.setDisable(true);
            }

            if(win)
            {
                iter--;

                Font font = control.playerLabel.getFont();
                control.playerLabel.setFont(new Font(font.getName(), 20));
                control.playerLabel.setText("Partie terminer:\n "+
                gamecontrol.getName(gamecontrol.getValue(iter))+" a gagné \n"+
                gamecontrol.getName(gamecontrol.getValue(iter + 1)) + ", tu es un Morpion");
            }
            else
            {
                if(partieFinie)
                {
                     Font font = control.playerLabel.getFont();
                     control.playerLabel.setFont(new Font(font.getName(), 20));
                     control.playerLabel.setText("Match Null: \n"
                             + "Il y'a pas de gagnant");
                }
                else
                {
                    control.playerLabel.setText(gamecontrol.getName(gamecontrol.getValue(iter))+" à toi de jouer");
                }    
            }
        }
        else
        {
            int val = gamecontrol.getValue(iter);
            if(val == 1)
            {
                System.out.println("ia joue");
                gridpane.setDisable(true);
                Coup c = gamecontrol.IA.play(playboard);
                playboard.play(c,1);
                GameController.iter++;
                GameController.partieFinie = playboard.isOver();
                if(playboard.getWin()){
                    GameController.grilleDisable = true;
                    GameController.win = true;
                    System.out.println("Partie terminer");
                 }
                //System.out.println("ligne : "+c.getLigne()+" *** colonne: "+c.getColone());
                //playboard.play(c, val);
                gridpane.setDisable(false);
                gamecontrol.dessiner(c.getLigne(), c.getColone(),val);
            }
            else
            {
                
                Label label = (Label)e.getSource();
                //label.setText("0");
                //System.out.println( e.getSceneX());
                int colIndex = GridPane.getColumnIndex(label);
                int rowIndex = GridPane.getRowIndex(label);
                Coup c = new Coup(rowIndex,colIndex);

                playboard.play(c,-1);
                GameController.iter++;
                GameController.partieFinie = playboard.isOver();
                if(playboard.getWin()){
                    GameController.grilleDisable = true;
                    GameController.win = true;
                    System.out.println("Partie terminer");
                 }
                if(image)
                {
                    gamecontrol.addImage(0, label);
                }
            }

            if(grilleDisable)
            {
                grille_grille_anchor.setDisable(true);
            }
            val = gamecontrol.getValue(iter);
            if(win)
            {
                iter--;
                String response;
                val = gamecontrol.getValue(iter);
                 if(val == 1)
                 {
                      response = "J'ai gagné \n"+
                     gamecontrol.getName(gamecontrol.getValue(iter + 1)) + ", tu es un Morpion";
                 }
                 else
                 {
                     response = "Tu m'as gagné. \n"+
                     "Tu es un joueur exceptionnel ";
                 }
                Font font = control.playerLabel.getFont();
                control.playerLabel.setFont(new Font(font.getName(), 20));
                control.playerLabel.setText("Partie terminer:\n "+response);
            }
            else
            {
                if(partieFinie)
                {
                     Font font = control.playerLabel.getFont();
                     control.playerLabel.setFont(new Font(font.getName(), 20));
                     control.playerLabel.setText("Match Null: \n"
                             + "Il y'a pas de gagnant");
                }
                else
                {
                    if(val == 1)
                    {
                        control.playerLabel.setText("C'est à moi de jouer.\n Je refléchis.");
                    }
                    else
                    {
                        control.playerLabel.setText(gamecontrol.getName(gamecontrol.getValue(iter))+" à toi de jouer");
                    }
                }    
            }
             //System.out.println("ieteration ******"+iter);
            val = gamecontrol.getValue(iter - 1);
            //System.out.println("val before launch " +val);
            if(val == -1 && !win)
            {
                grille_getNode(null);
            }
        }
    }
    
    
    /**
     * Permet de recuperer la ligne et la colonne du noeud sur lequel on a clique
     * @param ligne
     * @param colonne
     * @param type 
     */
    @FXML
    private void grille_getNodes(MouseEvent e,int i,int j) throws GrilleAccessException 
    {
//        GridPane source = (GridPane)e.getSource() ;
//        Label label = (Label)getNodeByRowColumnIndex(rowIndex, colIndex, source);
        GridPane gridpane = (GridPane)grille_grille_anchor.getChildren().get(0);
        if(!GameController.machine)
        {
            Label label = (Label)e.getSource();
            //label.setText("0");
            //System.out.println( e.getSceneX());
            //int colIndex = GridPane.getColumnIndex(label);
            //int rowIndex = GridPane.getRowIndex(label);
            Coup c = new Coup(i,j);
            playboard.play(c,gamecontrol.getValue(iter));
            GameController.iter++;
            GameController.partieFinie = playboard.isOver();
            if(playboard.getWin()){
                GameController.grilleDisable = true;
                GameController.win = true;
                System.out.println("Partie terminer");
             }
            if(image)
            {
                gamecontrol.addImage((iter%2), label);
            }
            if(grilleDisable)
            {
                grille_grille_anchor.setDisable(true);
            }

            if(win)
            {
                iter--;

                Font font = control.playerLabel.getFont();
                control.playerLabel.setFont(new Font(font.getName(), 20));
                control.playerLabel.setText("Partie terminer:\n "+
                gamecontrol.getName(gamecontrol.getValue(iter))+" a gagné \n"+
                gamecontrol.getName(gamecontrol.getValue(iter + 1)) + ", tu es un Morpion");
            }
            else
            {
                if(partieFinie)
                {
                     Font font = control.playerLabel.getFont();
                     control.playerLabel.setFont(new Font(font.getName(), 20));
                     control.playerLabel.setText("Match Null: \n"
                             + "Il y'a pas de gagnant");
                }
                else
                {
                    control.playerLabel.setText(gamecontrol.getName(gamecontrol.getValue(iter))+" à toi de jouer");
                }    
            }
        }
        else
        {
            int val = gamecontrol.getValue(iter);
            
            {
                
                Label label = (Label)e.getSource();
                //label.setText("0");
                //System.out.println( e.getSceneX());
                //int colIndex = GridPane.getColumnIndex(label);
                //int rowIndex = GridPane.getRowIndex(label);
                Coup c = new Coup(i,j);

                playboard.play(c,-1);
                GameController.iter++;
                GameController.partieFinie = playboard.isOver();
                if(playboard.getWin()){
                    GameController.grilleDisable = true;
                    GameController.win = true;
                    System.out.println("Partie terminer");
                 }
                if(image)
                {
                    gamecontrol.addImage(0, label);
                }
            }

            if(grilleDisable)
            {
                grille_grille_anchor.setDisable(true);
            }
            val = gamecontrol.getValue(iter);
            if(win)
            {
                iter--;
                String response;
                val = gamecontrol.getValue(iter);
                 if(val == 1)
                 {
                      response = "J'ai gagné \n"+
                     gamecontrol.getName(gamecontrol.getValue(iter + 1)) + ", tu es un Morpion";
                 }
                 else
                 {
                     response = "Tu m'as gagné. \n"+
                     "Tu es un joueur exceptionnel ";
                 }
                Font font = control.playerLabel.getFont();
                control.playerLabel.setFont(new Font(font.getName(), 20));
                control.playerLabel.setText("Partie terminer:\n "+response);
            }
            else
            {
                if(partieFinie)
                {
                     Font font = control.playerLabel.getFont();
                     control.playerLabel.setFont(new Font(font.getName(), 20));
                     control.playerLabel.setText("Match Null: \n"
                             + "Il y'a pas de gagnant");
                }
                else
                {
                    if(val == 1)
                    {
                        control.playerLabel.setText("C'est à moi de jouer.\n Je refléchis.");
                    }
                    else
                    {
                        control.playerLabel.setText(gamecontrol.getName(gamecontrol.getValue(iter))+" à toi de jouer");
                    }
                }    
            }
            //System.out.println("ieteration ******"+iter);
            val = gamecontrol.getValue(iter - 1);
            //System.out.println("val before launch " +val);
            if(val == -1 && !win)
            {
                grille_getNode(null);
            }
        }
    }
   
     
    @FXML
    private void get00(MouseEvent e) throws GrilleAccessException 
    {
        grille_getNodes(e, 0, 0);
    }//*/
    
     @FXML
    private void get01(MouseEvent e) throws GrilleAccessException 
    {
        grille_getNodes(e, 0, 1);
    }//*/
    
     @FXML
    private void get02(MouseEvent e) throws GrilleAccessException 
    {
        grille_getNodes(e, 0, 2);
    }//*/
    
     @FXML
    private void get03(MouseEvent e) throws GrilleAccessException 
    {
        grille_getNodes(e, 0, 3);
    }//*/
    
     @FXML
    private void get04(MouseEvent e) throws GrilleAccessException 
    {
        grille_getNodes(e, 0, 4);
    }//*/
    
     @FXML
    private void get10(MouseEvent e) throws GrilleAccessException 
    {
        grille_getNodes(e, 1, 0);
    }//*/
    
     @FXML
    private void get20(MouseEvent e) throws GrilleAccessException 
    {
        grille_getNodes(e, 2, 0);
    }//*/
    
     @FXML
    private void get30(MouseEvent e) throws GrilleAccessException 
    {
        grille_getNodes(e, 3, 0);
    }//*/
    
     @FXML
    private void get40(MouseEvent e) throws GrilleAccessException 
    {
        grille_getNodes(e, 4, 0);
    }//*/

    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
