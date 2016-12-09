/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projet2cpi.pkg1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javax.swing.JOptionPane;


public class Models 
{
    // La classe qui permet de definir l'interface de saisi d'un algorithme //
    //////////////////////////////////////////////////////////////////////////
    
    
     EventHandlers handler = new EventHandlers();
     Entete entete[] = new Entete[100]; 
     MenuOper men = new MenuOper();
     public  final VBox vb= new VBox(10);//le vbox principal
     public  HBox hb[]; // Les HBox predefinis
     // attribus de decallage 
     public   int nbLigneE=4;
     public    int nbLigneEntete=4;
     public Insets decalageADD= new Insets(0,0,0,0);
     public  static int C=0;
     public  static  int T=0;
     //
     
     public static TextArea ta; 
     public  TextField  t9 ;
   
     int positionADD=0;
     
     
    public Models(Tab t)
    {   
        final SplitPane p=new SplitPane();
        final StackPane sp1 = new StackPane();
        final StackPane sp2 = new StackPane();
        final StackPane sp3 = new StackPane();
        VBox rb = new VBox();
        ta=  new TextArea();//pr la traduction
        C=0;
        T=0;
        Label action=new Label("  ACTIONS");
        final TextField tfget=new TextField("1");
        final ScrollPane sp= new ScrollPane();
        final AnchorPane a= new AnchorPane(); 
        final Label l1[] = new Label[6];
        //final Button add = new Button("la partie corps");
        final Label vide = new Label("");
       // final Button recup = new Button("recup");
        final ComboBox c1 = new ComboBox();
        
        
        t.setStyle("-fx-background-radius: 30;");
        t.setStyle("-fx-borders-color:#000000;");
        p.setStyle("-fx-borders-color:#000000;");     
        ta.setEditable(false);
        ta.setStyle(" -fx-text-fill: #ffffe0;\n"+
                " -fx-font-size: 13px;\n"+  "-fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );\n"+
                "-fx-background-color: #696969;\n"+ "-fx-font-family: arial, cursive;\n"+" -fx-font-weight: bold;\n");
                
        action.setStyle(" -fx-font-size: 13px;\n" +
"   -fx-font-family: \"Arial Black\";\n" +
"   -fx-fill: #818181;\n" +
"   -fx-effect: innershadow( three-pass-box , rgba(0,0,0,0.7) , 6, 0.0 , 0 , 2 );");
         
        rb.setPadding(new Insets(30,5,100,5));

        tfget.setMinHeight(40);
        tfget.setPrefHeight(40);
        tfget.setMaxHeight(100);
        

        rb.getChildren().addAll(action,new Label(""),new Label(""),new Label(""),men.pr,new Label(""),men.tq,new Label(""),men.si,new Label(""),men.aff,new Label(""),men.rep,new Label(""),men.si_sinon,new Label(""),men.lire,new Label(""),men.ecrire,new Label(""),men.com,new Label(""),tfget,new Label(""));
        
         
         sp3.getChildren().add(rb);
         sp3.setPrefWidth(110);
         sp3.setMaxWidth(110);
         sp3.setMinWidth(110);
         sp3.setStyle("-fx-background-color: #9f9f9f;\n" +
"    -fx-background-insets: 0; ");
         
         p.getItems().addAll(sp3,sp1, sp2);
     //   p.getItems().addAll(sp1, sp2);
           
         hb= new HBox[3];
         t9 =new TextField();
         
    
        // L'initialisation des des attributs de decalage doit etre fait dans la partie constructeur. 
        // Initialisation du contenu des composants et leurs coordonnées .
        ObservableList<String> l2= FXCollections.observableArrayList("PR","TQ","L","E","SI","REP","AFF","SI/SIN");
        String Mots []= {"DEBUT","FIN ."};
        
        String Mots2[]= {"A","C","T","V"};
        c1.setItems(l2);        
        // Initialiser les HBox .
        for(int i=0 ; i<=3 ;i++)
        {
            entete[i]= new Entete(Mots2[i]);
        }
        
        for(int i=0;i<=1;i++)
        { 
            hb[i] = new HBox();
            l1[i]=new Label();
            l1[i].setStyle( " -fx-font-size: 12px;\n" +
                    "    -fx-font-weight: bold;\n" +
                    "    -fx-text-fill: #333333;\n");
             if(i==0){l1[i].setContextMenu(men.getCont());}
            l1[i].setText(Mots[i]);
           
            hb[i].getChildren().add(l1[i]);
        } 
        
        hb[2] = new HBox();
        hb[2].getChildren().addAll(vide);
        
        
         
        
   
        
        
        
        
        // Ajout et suppression d'une ligne dans l'entéte .///
        //////////////////////////////////////////////////////
        
        (entete[1].boutonA).setOnAction(new EventHandler<ActionEvent>()
        {    
            @Override public void handle(ActionEvent e)
            {
                if (true==entete[1].bc){
                entete[nbLigneE]= new Entete("NC");
                
                vb.getChildren().add(entete[2].getLigne(),entete[nbLigneE].hb);
                nbLigneE++;
                nbLigneEntete++;
                entete[1].setnbLignes(entete[1].getnbLignes()+1);
                entete[2].setLigne(entete[2].getLigne()+1);
                entete[3].setLigne(entete[3].getLigne()+1);
                C++;
                }
                }
        });   
        
        
        handler.TitleAction(entete[2],entete[3]);
        
        
         (entete[2].boutonA).setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent a)
            {
                if (entete[2].bt==true){
                entete[nbLigneE]= new Entete("NT");
                T++;
                vb.getChildren().add(entete[3].getLigne(), entete[nbLigneE].hb);
                handler.TitleAction(entete[nbLigneE],entete[3]); 
                nbLigneE++;
                nbLigneEntete++;
                entete[2].setnbLignes(entete[2].getnbLignes()+1);
                entete[3].setLigne(entete[3].getLigne()+1);
          
                
            }
            }
        });
         
        (entete[3].boutonA).setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent a)
            {
               
                entete[nbLigneE]= new Entete("NV");
                vb.getChildren().add(vb.getChildren().indexOf((HBox)hb[0])-1, entete[nbLigneE].hb);
                 handler.choixVar(entete[nbLigneE]);
                nbLigneE++;
                nbLigneEntete++;
                entete[3].setnbLignes(entete[3].getnbLignes()+1);
               
                
            }
        });
       
       
        (entete[1].boutonS).setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent e)
            {
                if(vb.getChildren().contains(vb.getChildren().get(entete[1].getLigne()+1))  && entete[1].getnbLignes()>0)
                {
                    vb.getChildren().remove(entete[2].getLigne()-1);
                    nbLigneE--;
                    nbLigneEntete--;
                    entete[1].setnbLignes(entete[1].getnbLignes()-1);
                    entete[2].setLigne(entete[2].getLigne()-1);
                    entete[3].setLigne(entete[3].getLigne()-1);
                    C--;
                }
            }
        }); 
        
        (entete[2].boutonS).setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent a)
            {
                if(entete[2].getnbLignes()>0)
                {
             String typ= ((TextField)(((HBox)(vb.getChildren().get(entete[2].getLigne()+1))).getChildren().get(0))).getText();
             Entete.ol.removeAll(typ);   
                    vb.getChildren().remove(entete[3].getLigne()-1);
                  
                     nbLigneE--;
                    nbLigneEntete--;
                    entete[2].setnbLignes(entete[2].getnbLignes()-1);
                    entete[3].setLigne(entete[3].getLigne()-1);
                    T--;
                }
            }
        });
        (entete[3].boutonS).setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent c)
            {
                if(entete[3].getnbLignes()>0)
                {
                    vb.getChildren().remove(vb.getChildren().indexOf((HBox)hb[0])-2);
                    nbLigneE--;
                    nbLigneEntete--;
                    entete[3].setnbLignes(entete[3].getnbLignes()-1);
    entete[3].setLigne(entete[3].getLigne()-1);
                }
            }
        });
        
        // Les Ecouteurs des differents elements de l'entéte //
        ///////////////////////////////////////////////////////
        
        entete[0].tf[0].setOnMouseClicked(new EventHandler<MouseEvent>()
        {
            @Override public void handle(MouseEvent mouseEvent)
            {
                entete[0].tf[0].setText("");
        entete[0].tf[0].setStyle("-fx-text-fill:#000000;\n"+"-fx-font-size: 12px;\n" +"-fx-font-weight: bold;\n");
            }
        });

        entete[1].lab[0].setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
            if(mouseEvent.getButton().equals(MouseButton.PRIMARY) || mouseEvent.getButton().equals(MouseButton.SECONDARY)){  
            if(mouseEvent.getClickCount() == 1){
                 entete[1].lab[0].setStyle(Entete.style);
                 entete[1].lab[1].setStyle(Entete.style);
                 entete[1].tf[0].setEditable(true);
                 entete[1].tf[1].setEditable(true);
                  entete[1].bc=true;
                 }
                if(mouseEvent.getClickCount() == 2){  
                
                String cte=entete[1].tf[0].getText();
                if (cte.length()!=0){
                    
                 Object[] options = {"Oui", "Annuler"};
                  int n;   
                  n = JOptionPane.showOptionDialog(null, "Etes-vous sure,vous voulez supprimer Constante?", "", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null,   options, options[0]);
  
                 if(n == JOptionPane.OK_OPTION){
               
                     
              for (int v=0;v<=C;v++){
                  if(vb.getChildren().contains(vb.getChildren().get(entete[1].getLigne()+1))  && entete[1].getnbLignes()>0)
                {
                   vb.getChildren().remove(entete[1].getLigne()+1);
                    nbLigneE--;
                    nbLigneEntete--;
                    entete[1].setnbLignes(entete[1].getnbLignes()-1);
                    entete[2].setLigne(entete[2].getLigne()-1);
                    entete[3].setLigne(entete[3].getLigne()-1);
                    System.out.println(C);
                }
                  }
               entete[1].lab[0].setStyle(Entete.style3);
               entete[1].lab[1].setStyle(Entete.style3);
               entete[1].tf[0].setText("");
               entete[1].tf[1].setText("");
                entete[1].hb.setVisible(false);
              Entete.exist=false;
            }}
                else{for (int v=0;v<=C;v++){
           if(vb.getChildren().contains(vb.getChildren().get(entete[1].getLigne()+1))  && entete[1].getnbLignes()>0)
                {
                   vb.getChildren().remove(entete[1].getLigne()+1);
                 nbLigneE--;
             nbLigneEntete--;
                    entete[1].setnbLignes(entete[1].getnbLignes()-1);
                    entete[2].setLigne(entete[2].getLigne()-1);
                    entete[3].setLigne(entete[3].getLigne()-1);
                    System.out.println(C);
                }
                  }
               entete[1].lab[0].setStyle(Entete.style3);
               entete[1].lab[1].setStyle(Entete.style3);
               entete[1].tf[0].setText("");
               entete[1].tf[1].setText("");
                entete[1].hb.setVisible(false);
              Entete.exist=false;}
            
            
            }
              }        
          }
         });

  // Ecouteur Types//      
        
  entete[2].lab[0].setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent mouseEvent) {
              if(mouseEvent.getButton().equals(MouseButton.PRIMARY) || mouseEvent.getButton().equals(MouseButton.SECONDARY)){  
            if(mouseEvent.getClickCount() == 1){
                 entete[2].lab[0].setStyle(Entete.style);
                 entete[2].lab[1].setStyle(Entete.style);
                 entete[2].tf[0].setEditable(true);
                 entete[2].tf[1].setEditable(true);
                  entete[2].bt=true;
                 }
            if(mouseEvent.getClickCount() == 2){ 
                String typ=entete[2].tf[0].getText();
                if (typ.length()!=0){
                    
  Object[] options = {"Oui", "Annuler"};
int n;   
n = JOptionPane.showOptionDialog(null, "Etes-vous sure,vous voulez supprimer Type?", "", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null,   options, options[0]);
  
 if(n == JOptionPane.OK_OPTION){ // si on'a clické sur oui .
  Entete.ol.remove(typ);
//Entete.ol=FXCollections.observableArrayList("Entier","Reel","Caractere","Chaine De Caractere","Booleen"); 
               for (int v=0;v<T;v++){
                  if(entete[2].getnbLignes()>0)
                {
                    //String ty=entete[2].tf[0].getText();
                    // Entete.ol.remove(ty);
      String ty= ((TextField)(((HBox)(vb.getChildren().get(entete[2].getLigne()+1))).getChildren().get(0))).getText();
       Entete.ol.removeAll(ty); 
                    vb.getChildren().remove(entete[2].getLigne()+1);
                   // vb.getChildren().get(entete[2].getLigne()+1).getClip();
                    nbLigneE--;
                    nbLigneEntete--;
                    entete[2].setnbLignes(entete[2].getnbLignes()-1);
                    entete[3].setLigne(entete[3].getLigne()-1);
                    System.out.println(entete[3].getLigne());
                }
                  }
               entete[2].lab[0].setStyle(Entete.style3);
               entete[2].lab[1].setStyle(Entete.style3);
              
   entete[2].ol.removeAll(entete[2].tf[0].getText());
                        
               entete[2].tf[0].setText("");
               entete[2].tf[1].setText("");
                entete[2].hb.setVisible(false);
               
                        
              Entete.exist=false;
            }}
                else{ for (int v=0;v<T;v++){
                  if(entete[2].getnbLignes()>0)
                {
                    vb.getChildren().remove(entete[2].getLigne()+1);
                    nbLigneE--;
                    nbLigneEntete--;
                    entete[2].setnbLignes(entete[2].getnbLignes()-1);
                    entete[3].setLigne(entete[3].getLigne()-1);
                    System.out.println(entete[3].getLigne());
                }
                  }
               entete[2].lab[0].setStyle(Entete.style3);
               entete[2].lab[1].setStyle(Entete.style3);
               entete[2].tf[0].setText("");
               entete[2].tf[1].setText("");
 ///////////                
     entete[2].ol.removeAll(entete[2].tf[0].getText());
 ////////////////////////                       
                entete[2].hb.setVisible(false);
            
                        
                
                Entete.exist=false;}
            
            }
             }        
          }
         });
   handler.recup_rubrique(entete[0],entete[1],entete[2]);
   handler.choixVar(entete[3]);
     
        
 // Gestion du menu de clique sur les Rubtic DEBUT et FIN .

        hb[0].setOnMouseClicked(new EventHandler<MouseEvent>() 
        {
            @Override public void handle(MouseEvent mouseEvent) 
            {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY) || mouseEvent.getButton().equals(MouseButton.SECONDARY))
                { // S'il y'a un click Gauche 
                    if(mouseEvent.getClickCount() == 1)
                    {  // Si on'a un seul click et que le text n'apparait pas
                        positionADD=vb.getChildren().indexOf(hb[1]);
                        //  System.out.println("--------->fin"+positionADD);
                        
                        Insets i = hb[0].getInsets();
                        decalageADD=new Insets(i.getTop(),i.getRight(),i.getBottom(),i.getLeft()+20);
                       
                        
                        ClearColors(vb,nbLigneEntete+1);
                        hb[0].setStyle("-fx-background-color: #f8f8ff;");
                        hb[1].setStyle("-fx-background-color: #f8f8ff;");
                    }
                }
                
                
   
                
            }
        });
        
 
        
       // Les Ecouteurs des bouton de la bare Fixe //
       ////////////////////////////////////////////// 
        
         men.pr.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
               // String s=c1.getValue().toString();
                int border = Integer.valueOf(tfget.getText());
                if(positionADD>nbLigneEntete+1 )
                {   for(int i=1;i<=border;i++){  
                    ModelPour(vb,positionADD,"","","");
                }
                }
            }
        });
      men.tq.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
              int border = Integer.valueOf(tfget.getText());
                if(positionADD>nbLigneEntete+1 )
                {        
                 for(int i=1;i<=border;i++){ 
                 ModelTQ(vb,positionADD,""); } 
                }
            }
        });
      men.si.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
               int border = Integer.valueOf(tfget.getText());
                if(positionADD>nbLigneEntete+1 )
                {    
                 for(int i=1;i<=border;i++){ 
                 ModelSI(vb,positionADD,"");}
                }
            }
        });
      men.aff.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int border = Integer.valueOf(tfget.getText());
                if(positionADD>nbLigneEntete+1 )
                {   
                    for(int i=1;i<=border;i++){ 
                    ModelAFF(vb,positionADD,"","");}
                }
            }
        });
        men.rep.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int border = Integer.valueOf(tfget.getText());
                if(positionADD>nbLigneEntete+1 )
                {     
                 for(int i=1;i<=border;i++){    
                 ModelREP(vb,positionADD);
                 }  
                }
            }
        });
        men.si_sinon.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int border = Integer.valueOf(tfget.getText());
                if(positionADD>nbLigneEntete+1 )
                {  
                   for(int i=1;i<=border;i++){  
                   ModelSISIN(vb,positionADD,"");
                   }
                   }
            }
        });
       men.lire.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int border = Integer.valueOf(tfget.getText());
                if(positionADD>nbLigneEntete+1 )
                {     
                  for(int i=1;i<=border;i++){ 
                  ModelL(vb,positionADD,"");
                  }
                }
            }
        });
         men.ecrire.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int border = Integer.valueOf(tfget.getText());
                if(positionADD>nbLigneEntete+1 )
                {  
                   for(int i=1;i<=border;i++){  
                   ModelE(vb,positionADD,"");
                   }
                }
            }
        });
         
          men.com.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int border = Integer.valueOf(tfget.getText());
                if(positionADD>nbLigneEntete+1 )
                {  
                   for(int i=1;i<=border;i++){ 
                   ModelComment(vb,positionADD,"");
                   }
                }
            }
        });
        
          
        // Les Ecouteurs du menu Contextuel //  
        //////////////////////////////////////  
          
            men.getCont().getItems().get(0).setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int border = Integer.valueOf(tfget.getText());
                if(positionADD>nbLigneEntete+1 )
                {   
                    for(int i=1;i<=border;i++){ 
                    ModelPour(vb,positionADD,"","","");
                    }
                }
            }
        });
           men.getCont().getItems().get(1).setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int border = Integer.valueOf(tfget.getText());
                if(positionADD>nbLigneEntete+1 )
                { 
                 for(int i=1;i<=border;i++){    
                 ModelTQ(vb,positionADD,""); 
                 }
                }
            }
        });
              men.getCont().getItems().get(2).setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int border = Integer.valueOf(tfget.getText());
                if(positionADD>nbLigneEntete+1)
                {
                 for(int i=1;i<=border;i++){     
                 ModelSI(vb,positionADD,"");
                 }
                }
            }
        });
                 men.getCont().getItems().get(3).setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int border = Integer.valueOf(tfget.getText());
                if(positionADD>nbLigneEntete+1 )
                {   
                    for(int i=1;i<=border;i++){ 
                    ModelAFF(vb,positionADD,"","");
                    }
                }
            }
        });
                    men.getCont().getItems().get(4).setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int border = Integer.valueOf(tfget.getText());
                if(positionADD>nbLigneEntete+1 )
                {     
                 for(int i=1;i<=border;i++){ 
                 ModelREP(vb,positionADD);
                 }  
                }
            }
        });
            men.getCont().getItems().get(5).setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int border = Integer.valueOf(tfget.getText());
                if(positionADD>nbLigneEntete+1 )
                {  
                   for(int i=1;i<=border;i++){  
                   ModelSISIN(vb,positionADD,"");
                   }
                }
            }
        });
        men.getCont().getItems().get(6).setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int border = Integer.valueOf(tfget.getText());
                if(positionADD>nbLigneEntete+1 )
                {     
                  for(int i=1;i<=border;i++){ 
                  ModelL(vb,positionADD,"");
                  }
                  
                }
            }
        });
           men.getCont().getItems().get(7).setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                int border = Integer.valueOf(tfget.getText());
                if(positionADD>nbLigneEntete+1 )
                {  
                   for(int i=1;i<=border;i++){  
                   ModelE(vb,positionADD,"");
                   }
                }
            }
        });
        
        

        vb.setPadding(new Insets(5,5,5,5));
        vb.getChildren().addAll(entete[0].hb,entete[1].hb,entete[2].hb,entete[3].hb);
        vb.getChildren().add(hb[2]); 
        nbLigneE++;
        vb.getChildren().addAll(hb[0],hb[1]); nbLigneE=nbLigneE+2;
        a.getChildren().add(vb);       
      
        sp.setStyle("-fx-background-color:white");
       
        t.setContent(p);
        sp1.getChildren().add(sp);
        sp2.getChildren().add(ta);
        sp.setContent(a);
        
    }
    

    /////                 Les Methodes Generatrices de Models d'Actions                //////          
    /////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    /// IMPORTANT : Le fonctionnement de chaque methode est similaire , donc on'a commenter ModelPour //
    
    
    
    // La methode qui vas creer la boucle pour dans le VBox dans un emplacement r //
    ///////////////////////////////////////////////////////////////////////////////
    public void ModelPour(final VBox vb,int r,String s1,String s2,String s3)
    {    
        // Declaration des attributs des Listes et leurs elements //
        
        final HBox hb[]= new HBox[3];  
        String Mots[] = {"Pour ","DPR","FPR"};
        final TextField  t1= new TextField();
        final TextField  t2= new TextField();
        final TextField  t3= new TextField();
        final int nbLigne=3;      
        final Label l2[] = new Label[3];
        Button sup=new Button("-");
        
        // Design des elements et
            t1.setMinWidth(30);
            t1.setPrefWidth(30);
            t1.setMaxWidth(400);
            
            t2.setMinWidth(40);
            t2.setPrefWidth(40);
            t2.setMaxWidth(400);  
            
             t3.setMinWidth(40);
             t3.setPrefWidth(40);
             t3.setMaxWidth(400);
             
             t1.setText(s1);    
             t2.setText(s2); 
             t3.setText(s3); 
        
        // Les ecouteurs des champs de text //
             
        t1.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        t1.setPrefWidth(t1.getText().length() * 7); 
        }
        });

            

        t2.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        t2.setPrefWidth(t2.getText().length() * 7); // why 7? Totally trial number.
           }
        });
             

        t3.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
         t3.setPrefWidth( t3.getText().length() * 7); 
    }
});
        
        
        sup.setStyle(Entete.style2);
        
        
        // Declaration des elements des HBox // 
        ///////////////////////////////////////
        
        for(int i=0;i<=2;i++)
        {  
             hb[i]=new HBox(); 
             hb[i].setStyle(Entete.style);
             hb[i].setPadding(decalageADD);
             l2[i]=new Label(Mots[i]);
             if(i==0){l2[i].setContextMenu(men.getCont());}      
             hb[i].getChildren().add(l2[i]);
        }
        

        l2[0].setStyle("-fx-text-fill: #b8860b;");
        l2[1].setStyle("-fx-text-fill: #191970;");
        l2[2].setStyle("-fx-text-fill: #191970;");
        hb[0].getChildren().addAll(t1);
        Label  lp=new Label("allantDe");
        hb[0].getChildren().addAll(lp);
        hb[0].getChildren().addAll(t2);
        Label  lp2=new Label("a:");
        hb[0].getChildren().addAll(lp2);
        hb[0].getChildren().addAll(t3);
        Label  lp3=new Label("faire   ");
        lp3.setStyle("-fx-text-fill: #b8860b;");
        hb[0].getChildren().addAll(lp3);
        hb[0].getChildren().addAll(sup);
         final  MenuItem men9 = new MenuItem("SUPPRIMER");
         
        // L'ecouteur du premier HBox qui vas etre Le HBox qui contient le MenuContextuel //     
         ///////////////////////////////////////////////////////////////////////////////////
         /////////////////////////////////////////////////////////////////////////////////////
         ////////////////////////////////////////////////////////////////////////////////////
         
        hb[0].setOnMouseClicked(new EventHandler<MouseEvent>() 
        {
            @Override public void handle(MouseEvent mouseEvent) 
            {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY) || mouseEvent.getButton().equals(MouseButton.SECONDARY))
                { // S'il y'a un click Gauche 
                    if(mouseEvent.getClickCount() == 1)
                    {  // Si on'a un seul click et que le text n'apparait pas
                        positionADD=vb.getChildren().indexOf(hb[2]);
                        System.out.println("----pr"+positionADD);
                         Insets i = hb[0].getInsets();
                        decalageADD=new Insets(i.getTop(),i.getRight(),i.getBottom(),i.getLeft()+20);
                        
                        ClearColors(vb,nbLigneEntete+1);
                        hb[0].setStyle("-fx-background-color: rgba(0,0,0,0);");
                        hb[1].setStyle("-fx-background-color: #f8f8ff;");
                        hb[2].setStyle("-fx-background-color: #f8f8ff;");
                   
                     if(men.getCont().getItems().size()==9){
                          men.getCont().getItems().remove(8);
                            }
                        men.getCont().getItems().add(men9);       
                        
                    
                    
                    }
                }
                
     
            }
        });
        
        
        
        final ObservableList<HBox> l= FXCollections.observableArrayList(hb[0],hb[1],hb[2]);
        
        // Ecouteur du bouton supprimer de la boucle //
        
        sup.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent c)
            {
                
    // Fenetre d'interogation //            
    ////////////////////////////
    ///////////////////////////            
                
    Object[] options = {"Oui", "Annuler"};
    int n;   
    n = JOptionPane.showOptionDialog(null, "Etes-vous sure,tout le contenu de Pour sera supprimé?", "", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null,   options, options[0]);
  
    if(n == JOptionPane.OK_OPTION){ // si on'a clické sur oui .
        vb.getChildren().remove(vb.getChildren().indexOf(hb[0]), vb.getChildren().indexOf(hb[2])+1);
                nbLigneE=nbLigneE-nbLigne;
                positionADD=positionADD-nbLigne;
 }
      
            }
        });
        
    if(men.getCont().getItems().size()==9){
                          men.getCont().getItems().remove(8);
                            }
                        men.getCont().getItems().addAll(men9); 
          
          men9.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                Object[] options = {"Oui", "Annuler"};
                int n;   
                n = JOptionPane.showOptionDialog(null, "Etes-vous sure,tout le contenu de Pour sera supprimé?", "", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null,   options, options[0]);
                if(n == JOptionPane.OK_OPTION)
                { 
                vb.getChildren().remove(vb.getChildren().indexOf(hb[0]), vb.getChildren().indexOf(hb[2])+1);
                nbLigneE=nbLigneE-nbLigne; 
                positionADD=positionADD-nbLigne;
                }
            }
        });
          
        // Ajout du model a la r'eme indice de la liste Vertical //
          //////////////////////////////////////////////////////
          
        vb.getChildren().addAll(r,l);
        nbLigneE=nbLigneE+nbLigne;
        positionADD=positionADD+nbLigne;
    }    
    
  
    void ModelTQ(final VBox vb,int r,String s)
    {    
        final HBox hb[]= new HBox[3]; 
        Button sup=new Button("-");
         sup.setStyle(Entete.style2);
        final int nbLigne=3;
        String Mots[] = {"Tantque ( ","DTQ","FTQ"};
        Label l2[] = new Label[3];
        for(int i=0;i<=2;i++)
        {
            hb[i]=new HBox();
            hb[i].setStyle(Entete.style);
             hb[i].setPadding(decalageADD);
            l2[i]=new Label(Mots[i]);
              if(i==0){l2[i].setContextMenu(men.getCont());}
          
            hb[i].getChildren().add(l2[i]);
        }
        l2[0].setStyle("-fx-text-fill: #b8860b;");
        l2[1].setStyle("-fx-text-fill: #191970;");
        l2[2].setStyle("-fx-text-fill: #191970;");
        final TextField  t4 =new TextField();
      
        
                
             t4.setMinWidth(60);
            t4.setPrefWidth(60);
            t4.setMaxWidth(400);

t4.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        t4.setPrefWidth(t4.getText().length() * 7); 
    }
});


        
   t4.setText(s);
        
        
        hb[0].getChildren().addAll(t4);
        Label lt=new Label("  ) faire  ");
        lt.setStyle("-fx-text-fill: #b8860b;");
        hb[0].getChildren().addAll(lt);
        hb[0].getChildren().addAll(sup);
        final MenuItem men9 = new MenuItem("SUPPRIMER"); 
        hb[0].setOnMouseClicked(new EventHandler<MouseEvent>() 
        {
            @Override public void handle(MouseEvent mouseEvent) 
            {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY) || mouseEvent.getButton().equals(MouseButton.SECONDARY))
                { // S'il y'a un click Gauche 
                    if(mouseEvent.getClickCount() == 1)
                    {  // Si on'a un seul click et que le text n'apparait pas
                       // positionADD=vb.getChildren().indexOf(hb[2]);
                        
                        Insets i = hb[0].getInsets();
                        positionADD=vb.getChildren().indexOf(hb[2]);
                        decalageADD=new Insets(i.getTop(),i.getRight(),i.getBottom(),i.getLeft()+20);
                        
                        ClearColors(vb,nbLigneEntete+1);
                        hb[0].setStyle("-fx-background-color:rgba(0,0,0,0);;");
                        hb[1].setStyle("-fx-background-color:#f8f8ff;");
                        hb[2].setStyle("-fx-background-color:#f8f8ff;");
                    
                    if(men.getCont().getItems().size()==9){
                          men.getCont().getItems().remove(8);
                            }
                        men.getCont().getItems().addAll(men9); 
                    }
                }
                
                
      
                
            }
        });
        final ObservableList<HBox> l= FXCollections.observableArrayList(hb[0],hb[1],hb[2]);
        
        sup.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent c)
            {
                
                Object[] options = {"Oui", "Annuler"};
int n;   
n = JOptionPane.showOptionDialog(null, "Etes-vous sure,tout le contenu de Tantque sera supprimé?", "", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null,   options, options[0]);
  
 if(n == JOptionPane.OK_OPTION){ // si on'a clické sur oui .
           vb.getChildren().remove(vb.getChildren().indexOf(hb[0]), vb.getChildren().indexOf(hb[2])+1);
                nbLigneE=nbLigneE-nbLigne;   
                positionADD=positionADD-nbLigne;
 }
                
                
     
                      
            }
        });
        
        
        if(men.getCont().getItems().size()==9){
                          men.getCont().getItems().remove(8);
                            }
                        men.getCont().getItems().add(men9); 
                        
        men9.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent t) 
            {
                Object[] options = {"Oui", "Annuler"};
                int n;   
                n = JOptionPane.showOptionDialog(null, "Etes-vous sure,tout le contenu de Tantque sera supprimé?", "", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null,   options, options[0]);
                if(n == JOptionPane.OK_OPTION)
                { 
                vb.getChildren().remove(vb.getChildren().indexOf(hb[0]), vb.getChildren().indexOf(hb[2])+1);
                nbLigneE=nbLigneE-nbLigne; 
                positionADD=positionADD-nbLigne;
                }
            }
        }); 
        
        
        
        vb.getChildren().addAll(r,l);
        nbLigneE=nbLigneE+nbLigne;
        positionADD=positionADD+nbLigne;
    }      
    
    //**********************************************************************************
     
     void ModelL(final VBox vb,int r,String sl)
     {
        final HBox hb[]= new HBox[3]; 
        Button sup=new Button("-");
        sup.setStyle(Entete.style2);
        final int nbLigne=1;
        String Mots[] = {"Lire ("};
        Label l2[] = new Label[1];    
        for(int i=0;i<=0;i++)
        {
            hb[i]=new HBox();
            hb[i].setStyle(Entete.style);
            hb[i].setPadding(decalageADD);
            l2[i]=new Label(Mots[i]);
            if(i==0){l2[i].setContextMenu(men.getCont());}
            hb[i].getChildren().add(l2[i]);
        }
        final TextField  t5 =new TextField(sl);
        t5.setMinWidth(30);
        t5.setPrefWidth(30);
        t5.setMaxWidth(400);
        t5.textProperty().addListener(new ChangeListener<String>() 
        {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
            {
                t5.setPrefWidth(t5.getText().length() * 7);
            }
        });
        hb[0].getChildren().addAll(t5);
        Label ll=new Label(")  ");
        hb[0].getChildren().addAll(ll);
        hb[0].getChildren().addAll(sup);
        final MenuItem men9 = new MenuItem("SUPPRIMER");
        hb[0].setOnMouseClicked(new EventHandler<MouseEvent>() 
        {
            @Override public void handle(MouseEvent mouseEvent) 
            {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY) || mouseEvent.getButton().equals(MouseButton.SECONDARY))
                { // S'il y'a un click Gauche 
                    if(mouseEvent.getClickCount() == 1)
                    {  // Si on'a un seul click et que le text n'apparait pas
                        Insets i = hb[0].getInsets();
                        decalageADD=new Insets(i.getTop(),i.getRight(),i.getBottom(),i.getLeft());
                        positionADD=vb.getChildren().indexOf(hb[0]);
                        System.out.println("----lire"+positionADD);
                        ClearColors(vb,nbLigneEntete+1);
                        hb[0].setStyle("-fx-background-color:rgba(0,0,0,0);");                    
                        if(men.getCont().getItems().size()==9){
                          men.getCont().getItems().remove(8);
                            }
                        men.getCont().getItems().addAll(men9); 
                    }    
                }
           }
        });
        final ObservableList<HBox> l= FXCollections.observableArrayList(hb[0]);        
        sup.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent c)
            {
                vb.getChildren().removeAll(l);
                nbLigneE=nbLigneE-nbLigne; 
                positionADD=positionADD-nbLigne;
            }
        });
        if(men.getCont().getItems().size()==9){
                          men.getCont().getItems().remove(8);
                            }
                        men.getCont().getItems().addAll(men9); 
        men9.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent t) 
            {   
                vb.getChildren().removeAll(l);
                nbLigneE=nbLigneE-nbLigne; 
                positionADD=positionADD-nbLigne;
            }
        });    
       
        
        vb.getChildren().addAll(r,l);
        nbLigneE=nbLigneE+nbLigne;
        positionADD=positionADD+nbLigne;
        
    } 
     
     
     //**********************************************************************************
     
     
        void ModelComment(final VBox vb,int r,String ec)
        {  
            final HBox hb[]= new HBox[1]; 
            Button sup=new Button("-");
            sup.setStyle(Entete.style2);
            final int nbLigne=1;
            String Mots[] = {"/*"};
            Label l2[] = new Label[1];
            for(int i=0;i<=0;i++)
            {
                hb[i]=new HBox();
                hb[i].setStyle(Entete.style);
                hb[i].setPadding(decalageADD);
                l2[i]=new Label(Mots[i]);
                l2[i].setStyle("-fx-text-fill: #a9a9a9;");
                hb[i].getChildren().add(l2[i]);
            }
            final TextField  t0 =new TextField();
            t0.setText(ec);
            t0.setStyle("-fx-text-fill: #a9a9a9;");
            t0.setMinWidth(20);
            t0.setPrefWidth(20);
            t0.setMaxWidth(400);
            t0.textProperty().addListener(new ChangeListener<String>() 
            {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
                {
                    t0.setPrefWidth(t0.getText().length() * 7); 
                }
            });
            t0.setText(ec);
            hb[0].getChildren().addAll(t0);
            Label lE=new Label("*/");
            lE.setStyle("-fx-text-fill: #a9a9a9;");
            hb[0].getChildren().addAll(lE);
            hb[0].getChildren().addAll(sup);
            hb[0].setOnMouseClicked(new EventHandler<MouseEvent>() 
            {
                @Override public void handle(MouseEvent mouseEvent) 
                {
                    if(mouseEvent.getButton().equals(MouseButton.PRIMARY) || mouseEvent.getButton().equals(MouseButton.SECONDARY))
                    { // S'il y'a un click Gauche 
                        if(mouseEvent.getClickCount() == 1)
                        {  // Si on'a un seul click et que le text n'apparait pas
                            Insets i = hb[0].getInsets();
                            decalageADD=new Insets(i.getTop(),i.getRight(),i.getBottom(),i.getLeft());
                            positionADD=vb.getChildren().indexOf(hb[0]);
                            ClearColors(vb,nbLigneEntete+1);
                            hb[0].setStyle("-fx-background-color:rgba(0,0,0,0);");
                        }
                    }
                }
            });
            final ObservableList<HBox> l= FXCollections.observableArrayList(hb[0]);
            sup.setOnAction(new EventHandler<ActionEvent>()
            {
                @Override public void handle(ActionEvent c)
                {
                    vb.getChildren().removeAll(l);
                    nbLigneE=nbLigneE-nbLigne;
                    positionADD=positionADD-nbLigne;
                }
            });
            
            
            vb.getChildren().addAll(r,l);
            nbLigneE=nbLigneE+nbLigne;
            positionADD=positionADD+nbLigne;
        }
     
     
     //****************************************************************************
    
    void ModelE(final VBox vb,int r,String ec)
    {  
        final HBox hb[]= new HBox[1]; 
        Button sup=new Button("-");
        sup.setStyle(Entete.style2);
        final int nbLigne=1;
        String Mots[] = {"Ecrire ("};
        Label l2[] = new Label[1];
        for(int i=0;i<=0;i++)
        {
            hb[i]=new HBox();
            hb[i].setStyle(Entete.style);
            hb[i].setPadding(decalageADD);
            l2[i]=new Label(Mots[i]);
            if(i==0){l2[i].setContextMenu(men.getCont());}
            hb[i].getChildren().add(l2[i]);
        }
        final TextField  t6 =new TextField();
        //changer la taille du text field avc la longueur de la chaine
        t6.setMinWidth(40);
        t6.setPrefWidth(40);
        t6.setMaxWidth(400);
        t6.textProperty().addListener(new ChangeListener<String>() 
        {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
            {
                t6.setPrefWidth(t6.getText().length() * 7); // why 7? Totally trial number.
            }
        });
        t6.setText(ec);
        hb[0].getChildren().addAll(t6);
        Label lE=new Label(")  ");
        hb[0].getChildren().addAll(lE);
        hb[0].getChildren().addAll(sup);
        final MenuItem men9 = new MenuItem("SUPPRIMER");
        hb[0].setOnMouseClicked(new EventHandler<MouseEvent>() 
        {
            @Override public void handle(MouseEvent mouseEvent) 
            {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY) || mouseEvent.getButton().equals(MouseButton.SECONDARY))
                { // S'il y'a un click Gauche 
                    if(mouseEvent.getClickCount() == 1)
                    {  // Si on'a un seul click et que le text n'apparait pas
                        Insets i = hb[0].getInsets();
                        decalageADD=new Insets(i.getTop(),i.getRight(),i.getBottom(),i.getLeft());
                        positionADD=vb.getChildren().indexOf(hb[0]);
                        ClearColors(vb,nbLigneEntete+1);
                        hb[0].setStyle("-fx-background-color:rgba(0,0,0,0);");
                        if(men.getCont().getItems().size()==9){
                          men.getCont().getItems().remove(8);

                            }
                        men.getCont().getItems().addAll(men9); 
                    }
                }
            }
        });
        final ObservableList<HBox> l= FXCollections.observableArrayList(hb[0]);
        sup.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent c)
            {
                vb.getChildren().removeAll(l);
                nbLigneE=nbLigneE-nbLigne;
                positionADD=positionADD-nbLigne;
            }
        });
        if(men.getCont().getItems().size()==9){
                          men.getCont().getItems().remove(8);
                            }
                        men.getCont().getItems().addAll(men9); 
        men9.setOnAction(new EventHandler<ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent t) 
            {
                vb.getChildren().removeAll(l);
                nbLigneE=nbLigneE-nbLigne;
                positionADD=positionADD-nbLigne;
                
            }
        });
        
        
        
        vb.getChildren().addAll(r,l);
        nbLigneE=nbLigneE+nbLigne;
        positionADD=positionADD+nbLigne;
    }
     //**********************************************
     
     void ModelAFF(final VBox vb,int r,String f,String d){
         
        final HBox hb[]= new HBox[1]; 
        Button sup=new Button("-");
        sup.setStyle(Entete.style2);
        final int nbLigne=1;
        String Mots[] = {"  :=  "};
        Label l2[] = new Label[1];
        hb[0]=new HBox();
        hb[0].setStyle(Entete.style);
        hb[0].setPadding(decalageADD);
        final TextField  t7 =new TextField();
        t7.setMinWidth(30);
        t7.setPrefWidth(20);
        t7.setMaxWidth(400);
        t7.textProperty().addListener(new ChangeListener<String>() 
        {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
            {
                t7.setPrefWidth(t7.getText().length() * 7);
            }
        });
        hb[0].getChildren().addAll(t7);
        l2[0]=new Label(Mots[0]);
        l2[0].setContextMenu(men.getCont());
        hb[0].getChildren().add(l2[0]);
        final TextField  t8 =new TextField();
                    t8.setMinWidth(30);
            t8.setPrefWidth(20);
            t8.setMaxWidth(400);
          

t8.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
       t8.setPrefWidth(t8.getText().length() * 7); // why 7? Totally trial number.
    }
});
     t7.setText(f);
     t8.setText(d);
       
     hb[0].getChildren().addAll(t8);
        hb[0].getChildren().addAll(sup);
         final MenuItem men9 = new MenuItem("SUPPRIMER");
        hb[0].setOnMouseClicked(new EventHandler<MouseEvent>() 
        {
            @Override public void handle(MouseEvent mouseEvent) 
            {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY) || mouseEvent.getButton().equals(MouseButton.SECONDARY))
                { // S'il y'a un click Gauche 
                    if(mouseEvent.getClickCount() == 1)
                    {  // Si on'a un seul click et que le text n'apparait pas
                        positionADD=vb.getChildren().indexOf(hb[0]);
                        
                        Insets i = hb[0].getInsets();
                        decalageADD=new Insets(i.getTop(),i.getRight(),i.getBottom(),i.getLeft());
                        ClearColors(vb,nbLigneEntete+1);
                        hb[0].setStyle("-fx-background-color:rgba(0,0,0,0);");
                    if(men.getCont().getItems().size()==9){
                          men.getCont().getItems().remove(8);
                            }
                        men.getCont().getItems().addAll(men9); 
                    }
                }
                
   
            }
        });
        final ObservableList<HBox> l= FXCollections.observableArrayList(hb[0]);        
        sup.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent c)
            {
                vb.getChildren().removeAll(l);
                nbLigneE=nbLigneE-nbLigne;
                positionADD=positionADD-nbLigne;
                
            }
        });
        
   if(men.getCont().getItems().size()==9){
                          men.getCont().getItems().remove(8);
                            }
                        men.getCont().getItems().addAll(men9); 
           men9.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                
                              
                vb.getChildren().removeAll(l);
                nbLigneE=nbLigneE-nbLigne;
                positionADD=positionADD-nbLigne;
                
            }
        });     
        
        
        vb.getChildren().addAll(r,l);
        nbLigneE=nbLigneE+nbLigne;
        positionADD=positionADD+nbLigne;
    }

     
    void ModelREP(final VBox vb,int r)
    {
        final HBox hb[]= new HBox[2]; 
        Button sup=new Button("-");
        sup.setStyle(Entete.style2);
        final int nbLigne=2;
        String Mots[] = {"Repeter   ","Jusqu'a"};
        Label l2[] = new Label[3];
        for(int i=0;i<2;i++)
        {
            hb[i]=new HBox();
            hb[i].setStyle(Entete.style);
            hb[i].setPadding(decalageADD);
            l2[i]=new Label(Mots[i]);
            l2[0].setContextMenu(men.getCont());
            hb[i].getChildren().add(l2[i]);
        }
        //l2[0].setStyle("-fx-text-fill: #da70d6;");
        l2[0].setStyle("-fx-text-fill: #b8860b;");
        l2[1].setStyle("-fx-text-fill: #b8860b;");
        hb[0].getChildren().addAll(sup);
        
        
                    t9.setMinWidth(40);
            t9.setPrefWidth(40);
            t9.setMaxWidth(400);
           

t9.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
       t9.setPrefWidth(t9.getText().length() * 7);
    }
});
 // t9.setText(r);
        
        hb[1].getChildren().addAll(t9);
         final MenuItem men9 = new MenuItem("SUPPRIMER");
        hb[0].setOnMouseClicked(new EventHandler<MouseEvent>() 
        {
            @Override public void handle(MouseEvent mouseEvent) 
            {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY) || mouseEvent.getButton().equals(MouseButton.SECONDARY))
                { // S'il y'a un click Gauche 
                    if(mouseEvent.getClickCount() == 1)
                    {  // Si on'a un seul click et que le text n'apparait pas
                        positionADD=vb.getChildren().indexOf(hb[1]);
                        Insets i = hb[0].getInsets();
                        decalageADD=new Insets(i.getTop(),i.getRight(),i.getBottom(),i.getLeft()+20);
                        ClearColors(vb,nbLigneEntete+1);
                        hb[0].setStyle("-fx-background-color:#f8f8ff;");
                        hb[1].setStyle("-fx-background-color:#f8f8ff;");
                        //hb[2].setStyle("-fx-background-color:grey;");
                    if(men.getCont().getItems().size()==9){
                          men.getCont().getItems().remove(8);
                            }
                        men.getCont().getItems().addAll(men9); 
                    
                    }
                }
                
        
            }
        });
        final ObservableList<HBox> l= FXCollections.observableArrayList(hb[0],hb[1]);        
        sup.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent c)
            {
                
                
                                Object[] options = {"Oui", "Annuler"};
int n;   
n = JOptionPane.showOptionDialog(null, "Etes-vous sure,tout le contenu de Repeter sera supprimé?", "", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null,   options, options[0]);
  
 if(n == JOptionPane.OK_OPTION){ // si on'a clické sur oui .
          vb.getChildren().removeAll(l);
                nbLigneE=nbLigneE-nbLigne;
                positionADD=positionADD-nbLigne;
 }
                        
            }
        });
        
    if(men.getCont().getItems().size()==9){
                          men.getCont().getItems().remove(8);
                            }
                        men.getCont().getItems().addAll(men9); 
                        
           men9.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                
                Object[] options = {"Oui", "Annuler"};
                int n;   
                n = JOptionPane.showOptionDialog(null, "Etes-vous sure,tout le contenu de Repeter sera supprimé?", "", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null,   options, options[0]);
                if(n == JOptionPane.OK_OPTION)
                { 
                
                vb.getChildren().removeAll(l);
                nbLigneE=nbLigneE-nbLigne;
                positionADD=positionADD-nbLigne;
                }
            }
        });
           
          
           
        vb.getChildren().addAll(r,l);
        nbLigneE=nbLigneE+nbLigne;
        positionADD=positionADD+nbLigne;
    }

    
    void ModelSI(final VBox vb,int r,String ss)
    {
        final HBox hb[]= new HBox[3]; 
        Button sup=new Button("-");
        sup.setStyle(Entete.style2);
        final int nbLigne=3;
        String Mots[] = {"SI ( ","DSI","FSI"};
        Label l2[] = new Label[3];     
        for(int i=0;i<=2;i++)
        {
            hb[i]=new HBox();
            hb[i].setStyle(Entete.style);
             hb[i].setPadding(decalageADD);
            l2[i]=new Label(Mots[i]);
              l2[0].setContextMenu(men.getCont());
            hb[i].getChildren().add(l2[i]);
        }
        l2[0].setStyle("-fx-text-fill: #b8860b;");
        l2[1].setStyle("-fx-text-fill: #191970;");
        l2[2].setStyle("-fx-text-fill: #191970;");
        final TextField  t10=new TextField();
        
                    t10.setMinWidth(40);
            t10.setPrefWidth(40);
            t10.setMaxWidth(400);
          

t10.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
       t10.setPrefWidth(t10.getText().length() * 7); // why 7? Totally trial number.
    }
});
        
   t10.setText(ss);     
        
        hb[0].getChildren().addAll(t10);
        Label lS=new Label(" ) Alors  ");
        lS.setStyle("-fx-text-fill: #b8860b;");
        hb[0].getChildren().addAll(lS);
        hb[0].getChildren().addAll(sup);
       final MenuItem men9 = new MenuItem("SUPPRIMER");
        hb[0].setOnMouseClicked(new EventHandler<MouseEvent>() 
        {
            @Override public void handle(MouseEvent mouseEvent) 
            {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY) || mouseEvent.getButton().equals(MouseButton.SECONDARY))
                { // S'il y'a un click Gauche 
                    if(mouseEvent.getClickCount() == 1)
                    {  // Si on'a un seul click et que le text n'apparait pas
                        positionADD=vb.getChildren().indexOf(hb[2]);
                         Insets i = hb[0].getInsets();
                        decalageADD=new Insets(i.getTop(),i.getRight(),i.getBottom(),i.getLeft()+20);
                        ClearColors(vb,nbLigneEntete+1);
                        hb[0].setStyle("-fx-background-color:rgba(0,0,0,0);");
                        hb[1].setStyle("-fx-background-color:#f8f8ff;");
                        hb[2].setStyle("-fx-background-color:#f8f8ff;");
                    if(men.getCont().getItems().size()==9){
                          men.getCont().getItems().remove(8);
                            }
                        men.getCont().getItems().add(men9); 
                        
                    
                    }
                }
      
            }
        });
        final ObservableList<HBox> l= FXCollections.observableArrayList(hb[0],hb[1],hb[2]);        
        sup.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent c)
            {
                
                
                                Object[] options = {"Oui", "Annuler"};
int n;   
n = JOptionPane.showOptionDialog(null, "Etes-vous sure,tout le contenu de SI sera supprimé?", "", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null,   options, options[0]);
  
 if(n == JOptionPane.OK_OPTION){ // si on'a clické sur oui .
         vb.getChildren().removeAll(l);
                 nbLigneE=nbLigneE-nbLigne;
                 positionADD=positionADD-nbLigne;
 }
                
                
                              
            }
        });
        
        
     if(men.getCont().getItems().size()==9){
                          men.getCont().getItems().remove(8);
                            }
                        men.getCont().getItems().add(men9); 
                        
           men9.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                Object[] options = {"Oui", "Annuler"};
                int n;   
                n = JOptionPane.showOptionDialog(null, "Etes-vous sure,tout le contenu de SI sera supprimé?", "", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null,   options, options[0]);
                if(n == JOptionPane.OK_OPTION)
                { 
                vb.getChildren().removeAll(l);
                nbLigneE=nbLigneE-nbLigne;
                positionADD=positionADD-nbLigne;
                }
            }
        });
       
         
           
        vb.getChildren().addAll(r,l);
        nbLigneE=nbLigneE+nbLigne; 
        positionADD=positionADD+nbLigne;
    }
 
      
    void ModelSISIN(final VBox vb ,int r,String w)
    {       
        final HBox hb[]= new HBox[5]; 
        Button sup=new Button("-");
        sup.setStyle(Entete.style2);
        final int nbLigne=5;
        String Mots[] = {"Si ( ","DSi","FSi","SINON","FSIN","FSIN"};
        Label l2[] = new Label[5];     
        for(int i=0;i<=4;i++)
        {
            hb[i]=new HBox();
            hb[i].setStyle(Entete.style);
             hb[i].setPadding(decalageADD);
            l2[i]=new Label(Mots[i]);
             if(i==0){l2[i].setContextMenu(men.getCont());}
            if(i==3){l2[i].setContextMenu(men.getCont());}
        
            hb[i].getChildren().add(l2[i]);
        }
        l2[0].setStyle("-fx-text-fill: #b8860b;");
        l2[1].setStyle("-fx-text-fill: #191970;");
        l2[2].setStyle("-fx-text-fill: #191970;");
        l2[3].setStyle("-fx-text-fill: #b8860b;");
        l2[4].setStyle("-fx-text-fill: #191970;");
        final TextField  t11=new TextField();
        
        
                    t11.setMinWidth(20);
            t11.setPrefWidth(20);
            t11.setMaxWidth(400);
          

t11.textProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
       t11.setPrefWidth(t11.getText().length() * 7); // why 7? Totally trial number.
    }
});
t11.setText(w);
        hb[0].getChildren().addAll(t11);
        Label lN=new Label(" ) Alors   ");
        lN.setStyle("-fx-text-fill: #b8860b;"); 
        hb[0].getChildren().addAll(lN);
     
        hb[0].getChildren().addAll(sup);
            final MenuItem men9 = new MenuItem("SUPPRIMER");
     
        hb[0].setOnMouseClicked(new EventHandler<MouseEvent>() 
        {
            @Override public void handle(MouseEvent mouseEvent) 
            {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY) || mouseEvent.getButton().equals(MouseButton.SECONDARY))
                { // S'il y'a un click Gauche 
                    if(mouseEvent.getClickCount() == 1)
                    {  // Si on'a un seul click et que le text n'apparait pas
                        positionADD=vb.getChildren().indexOf(hb[2]);
                        Insets i = hb[0].getInsets();
                        decalageADD=new Insets(i.getTop(),i.getRight(),i.getBottom(),i.getLeft()+20);
                        ClearColors(vb,nbLigneEntete+1);
                        hb[0].setStyle("-fx-background-color:rgba(0,0,0,0);");
                        hb[1].setStyle("-fx-background-color:#f8f8ff;");
                        hb[2].setStyle("-fx-background-color:#f8f8ff;");
                   if(men.getCont().getItems().size()==9){
                          men.getCont().getItems().remove(8);
                            }
                        men.getCont().getItems().add(men9); 
                        
                    
                    
                    }
                }
                
              
            }
        });
        
        
        
        
        hb[3].setOnMouseClicked(new EventHandler<MouseEvent>() 
        {
            @Override public void handle(MouseEvent mouseEvent) 
            {
                if(mouseEvent.getButton().equals(MouseButton.PRIMARY) || mouseEvent.getButton().equals(MouseButton.SECONDARY))
                { // S'il y'a un click Gauche 
                    if(mouseEvent.getClickCount() == 1)
                    {  // Si on'a un seul click et que le text n'apparait pas
                        positionADD=vb.getChildren().indexOf(hb[4]);
                        ClearColors(vb,nbLigneEntete+1);
                        hb[3].setStyle("-fx-background-color:#f8f8ff;");
                       hb[4].setStyle("-fx-background-color:#f8f8ff;");
                        // hb[5].setStyle("-fx-background-color:grey;");
                    }
                }
                
                 
            }
        });
        final ObservableList<HBox> l= FXCollections.observableArrayList(hb[0],hb[1],hb[2],hb[3],hb[4]);
        
        sup.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override public void handle(ActionEvent c)
            {
                
                     Object[] options = {"Oui", "Annuler"};
int n;   
n = JOptionPane.showOptionDialog(null, "Etes-vous sure,tout le contenu de SISIN sera supprimé?", "", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null,   options, options[0]);
  
 if(n == JOptionPane.OK_OPTION){ // si on'a clické sur oui .
       vb.getChildren().removeAll(l);
                nbLigneE=nbLigneE-nbLigne;
                positionADD=positionADD-nbLigne;
 }
                
                
                              
            }
        });
        
          
         if(men.getCont().getItems().size()==9){
                          men.getCont().getItems().remove(8);
                            }
                        men.getCont().getItems().addAll(men9); 
                        
           men9.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent t) {
                Object[] options = {"Oui", "Annuler"};
                int n;   
                n = JOptionPane.showOptionDialog(null, "Etes-vous sure,tout le contenu de SI/SINON sera supprimé?", "", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE, null,   options, options[0]);
                if(n == JOptionPane.OK_OPTION)
                { 
                vb.getChildren().removeAll(l);
                nbLigneE=nbLigneE-nbLigne;
                positionADD=positionADD-nbLigne;
                }
            }
        });
        
        
           
           
      
        vb.getChildren().addAll(r,l);
        nbLigneE=nbLigneE+nbLigne; 
        positionADD=positionADD+nbLigne;
    } 
      
    ///////////////////////////////////////////////////////////////////////
    //Restoration des couleurs apres avoir clicker sur une autre rubrique//
    //////////////////////////////////////////////////////////////////////
    
    public void ClearColors(VBox vb , int st)
    {
        while(true)
        {
            try 
            {    
                vb.getChildren().get(st).setStyle("-fx-background-color:white");
                st++;
            }
            catch(IndexOutOfBoundsException a) 
            {
                break;
            }
        } 
    }
    
     ///////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////
     // Module Essentiel Pour la recuperation du text de l'algorithme // 
    ////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////
    
    public void recupText(String title,String s){ // Recupere l'Algo dans un fichier text .
        int st =0;
        int se=0;
        HBox ab ;
        Node ac;
        Label label;
        TextArea textarea;
        TextField tf;
       FileWriter  out ;
     
        try
        {    
           out = new FileWriter(s+title); 
            while(true) // Parcourir tout le Box Vertical jusqu'a trouver une exception , on sort avec 'break;' //
            {             
                try 
                {    
                    // Si l'element du VBOX est un HBox en Rentre et on le recupére //
                    if(vb.getChildren().get(st) instanceof HBox)
                    {
                        ab=(HBox)vb.getChildren().get(st); 
                        while(true) // On parcour la liste horizontal et on recupere de chaque element jusqu'a //
                        {           // trouver une exception de fin de liste  // 
                            try
                            {
                                ac=ab.getChildren().get(se); 
                                if(ac instanceof Label) 
                                {
                                    label=(Label)ab.getChildren().get(se);
                                    String sty=label.getStyle();
                                    if (! sty.equalsIgnoreCase(Entete.style3)){
                                    out.write(label.getText() + " ");} 
                                }
                                else if (ac instanceof TextField)
                                {
                                    tf =(TextField)ab.getChildren().get(se);  
                                    out.write(tf.getText() + " ");
                                }

                                 else if (ac instanceof TextArea)
                                {
                                    textarea = (TextArea)ab.getChildren().get(se);
                                   out.write(textarea.getText() + " ");
                                }
                                se++;
                            }
                            catch(IndexOutOfBoundsException f)
                            {
                                out.write("\r\n");
                                se=0;    
                                break;
                            }
                        }
                    }
                    st++;
                }
                catch(IndexOutOfBoundsException a) 
                {
                    out.close();
                    break;
                } 
            } 
        }
        catch(IOException e){        }  
    }
    
    public void ouvrePas(String nomFichier) throws IOException{
    try
        {
            String ligne = "";
            BufferedReader lecteurFichier; 
 
            lecteurFichier = new BufferedReader(new FileReader(nomFichier));
 
            while ((ligne = lecteurFichier.readLine()) != null)
            {
            
                 Models.ta.appendText(ligne);
                Models.ta.appendText("\n");
            }
        }
        catch (java.io.FileNotFoundException e)
        {
           
            System.out.println("fichier n'existe pas");
        }
    
    
    
    }
    public void recupPas(String p) throws IOException
    {
        
        
         
           String[] textLigne = Models.ta.getText().split("\n");
     
           if (Models.ta.getText().length()!=0){
                  BufferedWriter bufWriter = null;
        FileWriter pa = null;
         pa = new FileWriter(p);
         bufWriter = new BufferedWriter(pa);
        try 
            {
                  for (String textLigne1 : textLigne) {
                    
                      System.out.println(textLigne1);
		bufWriter.newLine();
		bufWriter.write(textLigne1);
		//
                
            }
            } catch (IOException ex) {
                Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
                    try 
                {
                    bufWriter.close();
                    pa.close();
                } catch (IOException ex) 
                {
                Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
             bufWriter.close(); 
           
           
           }
    
    
    }
    
 
}
