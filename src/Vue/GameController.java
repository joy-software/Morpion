/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controlleur.LoadApp;
import exceptions.GrilleAccessException;
import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.ToolBar;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import kernel.Coup;
import kernel.IAMinMax;
import kernel.PlayBoard;
import kernel.Player;


/**
 * FXML Controller class
 *
 * @author NDJAMA
 */
public class GameController implements Initializable {
    

    /**
     * l'anchorpane de la grille
     */
    public static AnchorPane grille_grille_anchor;
    /**
     * gere l'affichage de l'image
     */
    public static boolean image = true;
    /**
     * Permet de rendre disable la grille
     */
    public static boolean grilleDisable;
    /**
     * permet de verifier qu'un joueur a gagner
     */
    public static boolean win;
    /**
     * Permet de verifier si la partie n'est pas terminer
     */
    public static boolean partieFinie;
    /**
     * le gridPane qui contiendra notre jeu
     */
    @FXML
    private GridPane grille_gridpane;
    /**
     * l'anchorpane de notre grille de jeu
     */
    @FXML
    public static AnchorPane grille_anchor;
    /**
     * le label sur lequel on clique
     */
    @FXML
    private Label grille_label;
    /**
     * valeur de test
     */
    public static int iter = 0;
    /**
     * Le toolbar de nouveau jeu
     */
    @FXML
    private ToolBar jeu;
    /**
     * Le toolbar de Nouvelle Partie
     */
    @FXML
    private ToolBar partie;
    /**
     * Le toolbar pour enregistrer une partie
     */
    @FXML
    private ToolBar enregistrer;
    /**
     * Le toolbar pour reprendre une partie
     */
    @FXML
    private ToolBar reprendre;
    /**
     * Le toolbar pour changer le nom du joueur
     */
    @FXML
    private ToolBar changeNom;
    /**
     * le label qui contiendra la première photo
     */
    @FXML
    private Label jeu_photo1;
    /**
     * le label qui contiendra la deuxième photo
     */
    @FXML
    private Label jeu_photo2;
    /**
     * le label qui contiendra la troisième photo
     */
    @FXML
    private Label jeu_photo3;
    /**
     * le radio qui permet de choisir le combat vs machine
     */
    @FXML
    private RadioButton jeu_machine;
    /**
     * le radio qui permet de choisir le combat vs human
     */
    @FXML
    private RadioButton jeu_human;
    /**
     * le vbox qui permet de choisir les differents levels
     */
    @FXML
    private VBox jeu_vbox;
    /**
     * le choiceBox qui permet de choisir le taille et le nombre de points gagnants
     */
    @FXML
    private ChoiceBox jeu_choice;
    /**
     * l'Anchor pour le nouveau jeu
     */
    @FXML
    private  AnchorPane jeu_acnchor;
    /**
     * le splitPane de notre jeu
     */
    @FXML
    private SplitPane jeu_split;
    /**
     * permet de spécifier la page en cours
     */
    private int page;
    /**
     * permet d'indiquer le niveau choisi
     */
    private int level;
    /**
     * indique si nous sommes entrain de jouer contre la machine ou contre un autre joueur
     */
    public static boolean machine;
    /**
     * Permet l'affichage de la fenetre d'enregistrement du nom
     */
    private Stage stage;
    /**
     * Permet d'enregistrer le nom du joueur
     */
    private String playerName;
    /**
     * permet de relier l'interface grille à un object de type playboard
     */
    public static  PlayBoard playboard;
    /**
     * permet de verifier qu'on peut changer le nom du joueur
     */
    private static Boolean changenom = false;
    /**
     * le joueur 1
     */
    private static  Player player1;
    /**
     * le joueur 2
     */
    private static Player player2;
    /**
     * le toolbar du joueur 1
     */
    @FXML
    private ToolBar toolplayer1;
    /**
     * le toolBar du joueur 
     */
    @FXML
    private ToolBar toolplayer2;
    /**
     * Le label qui renseigne sur le joueur qui a la main
     */
    @FXML
    public AnchorPane playerLabel;
    /**
     * l'anchorpane des status
     */
    @FXML
    private AnchorPane status;
    /**
     * le controlleur du label 
     */
    public  LabelController control;
    /**
     * le controlleur du label 
     */
    public  LabelsController controls;
    /**
     * l'intelligence artificielle de l'application
     */
    public static IAMinMax IA;
    
    
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
   
    
    /**
     * la fonction qui permet de configurer un nouveau jeu
     */
    @FXML
    private void handleJeu() throws GrilleAccessException
    {
        page = 1;
        handlePage();
    }
    
    
    /**
     * la fonction qui permet de lancer une partie
     */
    @FXML
    private void handlePartie() throws GrilleAccessException
    {
        page = 2;
        handlePage();
    }
    
    
    /**
     * la fonction qui permet de reprendre la partie
     */
    @FXML
    private void handleReprendre() throws GrilleAccessException
    {
        page = 3;
        handlePage();
    }
    
    
    /**
     * la fonction qui permet de reprendre la partie
     */
    @FXML
    private void handleChangeNom() throws GrilleAccessException
    {
        page = 5;
        handlePage();
    }
    
    
    /**
     * la fonction qui permet de lancer l'enregistrement
     */
    @FXML
    private void handleEnregistrer() throws GrilleAccessException
    {
        page = 4;
        handlePage();
    }
    
    
    /**
     * on clique sur le radio machine
     */
    @FXML
    private void vsMachine()
    {
        jeu_human.setSelected(false);
        jeu_machine.setSelected(true);
        jeu_vbox.setDisable(true);
        //jeu_level2.setSelected(true);
        level = 2;
        if(jeu_choice.getItems().isEmpty())
        {
            fillChoiceBox();
        }
        machine = true;
        changenom = false;
       // partie.setDisable(false);
    }
    
    /**
     * on clique sur le radio vsHuman
     */
    @FXML
    private void vsHuman()
    {
        jeu_human.setSelected(true);
        jeu_machine.setSelected(false);
        jeu_vbox.setDisable(false);
        machine = false;
        if(jeu_choice.getItems().isEmpty())
        {
            fillChoiceBox();
        }
        changenom = false;
    }
    
   
    /**
     * permet de remplir notre choiceBox qui permet de choisir 
     * la taille et le nombre de pions faisant gagnés
     */
    private void fillChoiceBox()
    {
        
        ObservableList<String> list = FXCollections.observableArrayList();
        list.add("3x3 (03pions to win)");
        list.add("4x4 (03pions to win)");
        list.add("4x4 (04pions to win)");
        list.add("5x5 (04pions to win)");
        partie.setDisable(false);
        jeu_choice.setItems(list);
        jeu_choice.setValue("3x3 (03pions to win)");
    }
     
    /**
     * cette méthode permet de lancer la bonne page dans notre fenêtre fonction
     * de l'attribut page passé en paramètres au test de contrôle switch
     */
    private void handlePage() throws GrilleAccessException
    {
        switch(page)
        {
            case 1:
               setSecondaire(GameController.grille_anchor);
                //File f = new File("./photo/Bienvenue.png");
                
               // AlgoRechercheController.anchorBienvenue.getChildren().get(0).setEffect(new ImageInput(new Image("file:/"+f.getAbsolutePath())));
                break;
            case 2:
                if(!machine)
                {
                    if((""+jeu_choice.getValue()).equals("3x3 (03pions to win)"))
                    {
                         LoadApp.getGrille3();
                        playboard = new PlayBoard(3,3);
                        grilleDisable = false;


                    }
                    if((""+jeu_choice.getValue()).equals("4x4 (03pions to win)"))
                    {
                        LoadApp.getGrille4();
                        grilleDisable = false;
                        playboard = new PlayBoard(4,3);

                    }
                    if((""+jeu_choice.getValue()).equals("4x4 (04pions to win)"))
                    {
                        LoadApp.getGrille4();
                        grilleDisable = false;
                        playboard = new PlayBoard(4,4);
                    }
                    if((""+jeu_choice.getValue()).equals("5x5 (04pions to win)"))
                    {
                        LoadApp.getGrille5();  
                        grilleDisable = false;
                        playboard = new PlayBoard(5,4);

                    }
                }
                else
                {
                     LoadApp.getGrille3();
                     playboard = new PlayBoard(3,3);
                     grilleDisable = false;
                }
                Initialisation();
                setSecondaire(GameController.grille_grille_anchor);
                
                break;
            case 3:
               /* if(checkHeuristique())
                {
                    precedent.setDisable(false);
                    suivant.setDisable(false);
                    bienvenue.setVisible(true);
                    donnees.setVisible(true);
                    algorithme.setVisible(true);
                    resultat.setVisible(false);
                    pagelab.setText("Choississez un algorithme");
                    setSecondaire(AlgoRechercheController.anchorAlgorithme);
                    f = new File("./photo/algo.jpg");
                    AlgoRechercheController.anchorAlgorithme.getChildren().get(2).setEffect(new ImageInput(new Image("file:/"+f.getAbsolutePath())));
                }
                else
                {
                    page--;
                }//*/
                break;
            case 4:
             /*   //System.out.println(" algo "+algorithme_algo+ " choix "+algorithme_choixSolution);
                if(algorithme_algo != 0)
                {
                    precedent.setDisable(false);
                    suivant.setDisable(true);
                    bienvenue.setVisible(true);
                    donnees.setVisible(true);
                    algorithme.setVisible(true);
                    pagelab.setText("Voici les resultats ");
                    resultat.setVisible(true);
                    setSecondaire(AlgoRechercheController.anchorResultat);
                    f = new File("./photo/resultat.jpg");
                    AlgoRechercheController.anchorResultat.getChildren().get(2).setEffect(new ImageInput(new Image("file:/"+f.getAbsolutePath())));
                    response();
                    loadAlgo.start();
                }
                else
                {
                    messageErreur("du choix des algorithmes", "Veillez selectionner l'algorithme à executer avant de continuer");
                    page--;
                }//*/
                break;
            case 5:
                ChangeName(getValue(getValue(iter - 1)));
                break;
        }
        
    }
            
    /**
     * cette méthode permet de recuperer le nom du joueur 
     */
    private void playerName(int i)
    {
                TextInputDialog dialog = new TextInputDialog("Type Your name");
                dialog.initOwner(LoadApp.getPrimaryStage());
                // Get the Stage.
                stage = (Stage) dialog.getDialogPane().getScene().getWindow();
            
                File f = new File("./photos/IconCSP.png");
            
                // Add a custom icon.
                stage.getIcons().add(new Image("file:"+f.getAbsolutePath()));
                if(i != 1)
                {
                    i = 2;
                }
                dialog.setTitle("Player "+i+" name:");
                dialog.setHeaderText("Before beginning to play,");
                dialog.setContentText("Please enter your name:");

                // Traditional way to get the response value.
                Optional<String> result = dialog.showAndWait();
                
                // The Java 8 way to get the response value (with lambda expression).
                result.ifPresent(name -> playerName = name);
                System.out.println("Player Name "+playerName);
    }
    
    
    /**
     * cette méthode permet de recuperer le nom du joueur 
     */
    private void ChangeName(int i)
    {
        String names = getName(i);
        
                TextInputDialog dialog = new TextInputDialog(names);
                dialog.initOwner(LoadApp.getPrimaryStage());
                // Get the Stage
                stage = (Stage) dialog.getDialogPane().getScene().getWindow();
            
                File f = new File("./photos/IconCSP.png");
            
                // Add a custom icon.
                stage.getIcons().add(new Image("file:"+f.getAbsolutePath()));
                
                if(i != 1)
                {
                    dialog.setTitle("Player 2 name:");
                }
                else
                {
                    dialog.setTitle("Player 1 name:");
                }
                dialog.setHeaderText("Before beginning to play,");
                dialog.setContentText("Please enter your name:");

                // Traditional way to get the response value.
                Optional<String> result = dialog.showAndWait();
                
                // The Java 8 way to get the response value (with lambda expression).
                result.ifPresent(name -> playerName = name);
                if(i == 1)
                {
                    player1.setNom(playerName);
                    player1.setNom(playerName);
                    Label label = (Label)toolplayer1.getItems().get(0);
                    label.setText(playerName);
                }
                else
                {
                    player2.setNom(playerName);
                    Label label = (Label)toolplayer2.getItems().get(0);
                    label.setText(playerName);
                }
                System.out.println("Player Name "+playerName);
    }
    
    
     
    /**
     * cette méthode permet de modifier l'anchorpane secondaire de 
     * notre Slitpane permettant ainsi de pouvoir modifier dynamiquement
     * le contenu de notre page
     * @param pane 
     */
    public void setSecondaire(AnchorPane pane) {
         if(pane != null)
         {
             jeu_split.getItems().remove(1);
             jeu_split.getItems().add(pane);
             
         }
    }
    
    
    /**
     * affiche l'apropos
     */
    @FXML
    private void aboutUs()
    {
        messageInformation("des Auteurs"," \t\t\t\tNDJAMA JOY JEDIDJA \n"
        +"\t\t\t\t NOYESSIE HUBERT \n"
        +"\t\t\t Elèves Ingénieurs à l'Ecole Nationale\n"+
        " \t\t\t\tSupérieure Polytechnique\n"+
        " \t\t\tCopyright (C) Novembre 2015\n"+
        " \t\t\t\t\t GENIE INFOS \n");
    }
    
    
    /**
     * cette méthode gère les messages d'information de notre application
     */
    private void messageInformation(String titre,String sms)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
            message(alert,titre,sms);
    }
    
    
    /**
     * cette méthode permet de génerer la boite de dialogue d'erreur proprement dite
     */
    private void message(Alert alert,String titre,String messag)
    {
        alert.initOwner(LoadApp.getPrimaryStage()); 
            // Get the Stage.
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            
            File f = new File("./photo/iconCSP.png");
            
            // Add a custom icon.
            stage.getIcons().add(new Image("file:/"+f.getAbsolutePath()));
           
            alert.setTitle("Message d'erreur");
            alert.setHeaderText("\t\t\tA propos "+titre);
            alert.setContentText(messag);
            alert.showAndWait();
    }
    
    /**
     * Permet de desiiner un pion sur notre grille
     * @param ligne
     * @param colonne 
     * @param type 
     */
    public void dessiner(int ligne,int colonne,int type)
    {
        //System.out.println("dessin "+ligne+" "+colonne);
        //GridPane temp = (GridPane)grille_grille_anchor.getChildren().get(0);
        GridPane gridpane = (GridPane)grille_grille_anchor.getChildren().get(0);
        Label templabel = (Label)getNodeByRowColumnIndex(ligne,colonne,gridpane);
        addImage(type,templabel);
    }
    
    /**
     * Permet de recuperer le noeud du gridpane connaissant la ligne et la colonne
     * @param row
     * @param column
     * @param gridPane
     * @return 
     */
    public Label getNodeByRowColumnIndex(final int row,final int column,GridPane gridPane) {
        Label result = null;
        
        switch(row)
        {
            case 0:
                switch(column)
                {
                    case 0:
                        result = controls.label00;
                        break;
                    case 1:
                        result = controls.label01;
                        break;
                    case 2:
                        result = controls.label02;
                        break;
                    case 3:
                        result = controls.label03;
                        break;
                    case 4:
                        result = controls.label04;
                        break;
                }
                break;
            case 1:
                switch(column)
                {
                    case 0:
                        result = controls.label10;
                        break;
                    case 1:
                        result = controls.label11;
                        break;
                    case 2:
                        result = controls.label12;
                        break;
                    case 3:
                        result = controls.label13;
                        break;
                    case 4:
                        result = controls.label14;
                        break;
                }
                break;
            case 2:
                switch(column)
                {
                    case 0:
                        result = controls.label20;
                        break;
                    case 1:
                        result = controls.label21;
                        break;
                    case 2:
                        result = controls.label22;
                        break;
                    case 3:
                        result = controls.label23;
                        break;
                    case 4:
                        result = controls.label24;
                        break;
                }
                break;
            case 3:
                switch(column)
                {
                    case 0:
                        result = controls.label30;
                        break;
                    case 1:
                        result = controls.label31;
                        break;
                    case 2:
                        result = controls.label32;
                        break;
                    case 3:
                        result = controls.label33;
                        break;
                    case 4:
                        result = controls.label34;
                        break;
                }
                break;
            case 4:
                switch(column)
                {
                    case 0:
                        result = controls.label40;
                        break;
                    case 1:
                        result = controls.label41;
                        break;
                    case 2:
                        result = controls.label42;
                        break;
                    case 3:
                        result = controls.label43;
                        break;
                    case 4:
                        result = controls.label44;
                        break;
                }
                break;
        }
        
        return result;
    }
    
    
    
    /**
     * cette méthode permet d'ajouter la bonne image dans notre gridpane
     */
    public void  addImage(int type,Label label)
    {
        //image = false;
        switch(type)
        {
            case 0:
                File f = new File("./photos/o33.png");
                label.setEffect(new ImageInput(new Image("file:/"+f.getAbsolutePath())));
                break;
            
            case 1:
                f = new File("./photos/x33.png");
                label.setEffect(new ImageInput(new Image("file:/"+f.getAbsolutePath())));
                break;
        }
    }

    /**
     * Permet d'initiliser notre jeu
     */
    private void Initialisation() throws GrilleAccessException {
        Label label;
        iter = 0;
        win = false;
        partieFinie = false;
         Font font = control.playerLabel.getFont();
         control.playerLabel.setFont(new Font(font.getName(), 13));
        if(!machine)
        {
            if(!changenom)
            {
                playerName(1);
                player1 = new Player(1);
                if(playerName != null)
                  {
                      player1.setNom(playerName);
                      label = (Label)toolplayer1.getItems().get(0);
                      label.setText(playerName);
                  }

            }
            toolplayer1.setVisible(true);

            playerName = null;
             if(!changenom)
            {
                playerName(-1);
                player2 = new Player(-1);
                changenom = true;
                if(playerName != null)
                {
                    player2.setNom(playerName);
                    label = (Label)toolplayer2.getItems().get(0);
                    label.setText(playerName);
                }
            }

            toolplayer2.setVisible(true);
            control.playerLabel.setText(getName(getValue(iter))+" à toi de jouer");
        }
        else
        {
            IA = new IAMinMax(1, 5);
            
            if(!changenom)
            {
                player2 = new Player(-1);
                playerName(-1);
                if(playerName != null)
                  {
                      player2.setNom(playerName);
                      label = (Label)toolplayer1.getItems().get(0);
                      label.setText(playerName);
                  }
                changenom = true;
            }
            control.playerLabel.setText("A moi de jouer");
            toolplayer1.setVisible(true);
        }
        changeNom.setDisable(false);
        control.playerLabel.setVisible(true);
        if(machine)
        {
           controls.grille_getNode(null); 
        }
        
    }
    
    
   
    /**
     * Permet de determiner le joueur qui a le jeu en main
     * @param iter
     * @return 
     */
    public int getValue(int iter) {
        
    if((iter%2) == 0)
        {
            return 1;
        }
        else
        {
            return  -1;
        }
    }

    /**
     * Permet de recuperer le nom du joueur en cours 
     * @param i
     * @return 
     */
    public String getName(int i) {
        
        if(i == 1)
        {
            return player1.getNom();
        }
        else
        {
            return player2.getNom();
        }
    }

    
}
