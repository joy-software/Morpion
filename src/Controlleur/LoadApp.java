/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import Vue.GameController;
import Vue.LabelsController;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 *
 * @author NDJAMA
 */
public class LoadApp extends Application {
    
    
    /**
     * le stage qui permettra l'affichage de notre fenêtre javaFx
     */
    private static Stage primaryStage;
    /**
     * cet anchorpane va contenir le pane principal renvoyer par notre fichier FXML
     */
    private AnchorPane anchor;
    /**
     * le controleur de nos fenêtres JavaFx
     */
    public static GameController controlleur ;

    /**
     * le getteur de notre PrimaryStage
     * @return primaryStage
     */
    public static Stage getPrimaryStage() {
        return primaryStage;
    }
    
    
    
    
    /**
     * cette méthode permet de lancer notre interface graphique
     * @param primaryStage 
     */
    @Override
    public void start(Stage primaryStage) {
        
        LoadApp.primaryStage = primaryStage;
        LoadApp.primaryStage.setTitle("MORPION GAME");
        File f1 = new File("./photos/IconCSP.png");
        System.out.println("file "+f1.getAbsolutePath());
        LoadApp.primaryStage.getIcons().add(new Image("file:/"+f1.getAbsolutePath()));
     
        
        launchApp();
        getLabel();
        //getJeu();
    }

    
    
    /**
     * cette méthode permet de charger notre anchorpane de jeu
     */
    /*private void getJeu()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            File f = new File("src/Vue/jeu.fxml");
            loader.setLocation(new URL("file:/"+f.getAbsolutePath()));
            loader.setRoot(anchor);
            GameController.grille_anchor = (AnchorPane)loader.load();
            //BienvenueController controlleur = loader.getController();
             
            
           //controlleur.setSecondaire(BienvenueController.anchorBienvenue);
        } catch (Exception e) {
            LoadApp.printStrace(e);
        }
    }
//*/
    
    /**
     * cette méthode permet de charger notre anchorpane de jeu
     */
    private void getLabel()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            File f = new File("src/Vue/label.fxml");
            loader.setLocation(new URL("file:/"+f.getAbsolutePath()));
          
            controlleur.playerLabel.getChildren().remove(0);
            controlleur.playerLabel.getChildren().add((Label)loader.load());
            controlleur.control  = loader.getController();
            //BienvenueController controlleur = loader.getController();
             
            
           //controlleur.setSecondaire(BienvenueController.anchorBienvenue);
        } catch (Exception e) {
            LoadApp.printStrace(e);
        }
    }
    
    
    /**
     * cette méthode permet de charger notre anchorpane qui contient la grille 3x3
     */
    public static void getGrille3()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            File f = new File("src/Vue/game_3.fxml");
            loader.setLocation(new URL("file:/"+f.getAbsolutePath()));
                
            GameController.grille_grille_anchor = (AnchorPane)loader.load();
            LabelsController control = loader.getController();
            controlleur.controls = control;
            control.gamecontrol = controlleur;
            control.control = controlleur.control;
           // control.playboard = controlleur.playboard;
           
            //BienvenueController controlleur = loader.getController();
             
            
           //controlleur.setSecondaire(BienvenueController.anchorBienvenue);
        } catch (Exception e) {
            LoadApp.printStrace(e);
        }
    }
//*/
    
    
    
    /**
     * cette méthode permet de charger notre anchorpane qui contient la grille 4x4
     */
    public static void getGrille4()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            File f = new File("src/Vue/game_1.fxml");
            loader.setLocation(new URL("file:/"+f.getAbsolutePath()));
            GameController.grille_grille_anchor = (AnchorPane)loader.load();
            LabelsController control = loader.getController();
            controlleur.controls = control;
            control.gamecontrol = controlleur;
            control.control = controlleur.control;
            //control.playboard = controlleur.playboard;
            //BienvenueController controlleur = loader.getController();
             
            
           //controlleur.setSecondaire(BienvenueController.anchorBienvenue);
        } catch (Exception e) {
            LoadApp.printStrace(e);
        }
    }
    
    
    /**
     * cette méthode permet de charger notre anchorpane qui contient la grille 4x4
     */
    public static void getGrille5()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            File f = new File("src/Vue/game_2.fxml");
            loader.setLocation(new URL("file:/"+f.getAbsolutePath()));
            GameController.grille_grille_anchor = (AnchorPane)loader.load();
            LabelsController control = loader.getController();
            controlleur.controls = control;
            control.gamecontrol = controlleur;
            control.control = controlleur.control;
            //BienvenueController controlleur = loader.getController();
             
            
           //controlleur.setSecondaire(BienvenueController.anchorBienvenue);
        } catch (Exception e) {
            LoadApp.printStrace(e);
        }
    }
    
    
    /**
     * cette méthode permet d'associer au stage de notre interface la scène graphique principale
     */
    private void launchApp()
    {
        try {
            FXMLLoader loader = new FXMLLoader();
            File f = new File("src/Vue/tictactoe.fxml");
            loader.setLocation(new URL("file:/"+f.getAbsolutePath()));
            
            //loader.setController(controlleur);
            anchor = (AnchorPane)loader.load();
            //GameController.grille_anchor = anchor;
            controlleur = loader.getController();
            
            
            
            Scene scene = new Scene(anchor);
            primaryStage.setOnShown((WindowEvent we) -> {
                
                //controlleur.setSecondaire(GameController.grille_anchor);
                System.out.println("Merci Joy je t'aime");
                File f1 = new File("./photos/photo2.png");
                File f2 = new File("./photos/photo1.png");
                File f3 = new File("./photos/photo4.jpg");
                VBox vbox = (VBox)anchor.getChildren().get(0);
                SplitPane spl = (SplitPane)vbox.getChildren().get(1);
                GameController.grille_anchor = (AnchorPane)spl.getItems().get(1);
                GameController.grille_anchor.getChildren().get(5).setEffect(new ImageInput(new Image("file:/" + f1.getAbsolutePath())));
                GameController.grille_anchor.getChildren().get(4).setEffect(new ImageInput(new Image("file:/" + f2.getAbsolutePath())));
                GameController.grille_anchor.getChildren().get(8).setEffect(new ImageInput(new Image("file:/" + f3.getAbsolutePath())));
            
            }); 
            primaryStage.setScene(scene);
            primaryStage.show();
                
            
        } catch (Exception e) {
            LoadApp.printStrace(e);
        }
    }
   
           
        /**
	 * Cette méthode permet de recuperer une erreur
	 * et de l'afficher
	 * @param e
	 * @return
	 */
           public static String getStackTrace( Exception e ) { 
	    Writer result = new StringWriter(); 
	    PrintWriter printWriter = new PrintWriter( result ); 
	    e.printStackTrace( printWriter ); 
	    return result.toString(); 
	  }
    
           
         /**
	 * ecrire dans notre fichier log
	 * @param e
	 */
        public static  void printStrace(Exception e)
        {
	   
	    String nom = "./logs/log.del";
	    
	    PrintWriter fich = null;

	    try {
			fich = new PrintWriter(new BufferedWriter(new FileWriter(nom, true)));
			//true c'est elle qui permet d'écrire à la suite des donnée enregistrer et non de les remplacé 
		} catch (IOException e1) {
		} 
	    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy  HH:mm:ss");
	    String dateStr = sdf.format(new Date());
	    fich.println(dateStr + " " + getStackTrace(e));
	    fich.println();
	    fich.println();
	    fich.close();
        }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
