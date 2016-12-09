package projet2cpi.pkg1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;


public class Entete 
{
    // La classe Entete , on initialise de cette classe les elements de l'entéte //
    //////////////////////////////////////////////////////////////////////////////
    
    
    public HBox hb = new HBox(20);
    public Label lab[]= new Label[5];
    public TextField tf[]=new TextField[5];
    public ComboBox cb[]=new ComboBox[5];
    public  TextArea  Tenr ;
    public boolean bc=false;
    public boolean bt=false;
    public  boolean bv=false;
    public static boolean exist=true;
    public static String style;//pour les chapms active 
    public static String style3;//pr les champs grisé
    public static String style2;//pr les btn
    public static ObservableList<String> ol= FXCollections.observableArrayList("Entier","Reel","Caractere","Chaine","Booleen");
    public Button boutonA = new Button("+");
    public Button boutonS = new Button("-");
    private int Ligne;
    private int nbLignes=0;
    
    public Entete(String A)
    {   //constructeur entete    
        bc=false;
        bt=false;
        bv=false;
        exist=true;
        style=  "-fx-font-size: 12px;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-text-fill:#191970;\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );";
       style2="   -fx-background-color:#696969;\n" +
               "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );" +
               "-fx-text-fill: white;\n" +
               "    -fx-font-family: \"arial, cursive\";\n" +
               "    -fx-font-weight: bold;\n";
        boutonA.setStyle(style2);               
        boutonS.setStyle(style2);
        style3= " -fx-font-size: 12px;\n" +
                "    -fx-font-weight: bold;\n" +
                "    -fx-text-fill: #a9a9a9;\n" +
                "    -fx-effect: dropshadow( gaussian , rgba(255,255,255,0.5) , 0,0,0,1 );";
       
        if(A.equalsIgnoreCase("A"))
        {
            lab[0] = new Label("Algorithme");
            cb[0]=new ComboBox();
            ObservableList<String> rubrique= FXCollections.observableArrayList("Constante","Type");
            cb[0].setItems(rubrique);
            cb[0].setStyle(style2);
            lab[0].setStyle(style);
            tf[0]=  new TextField();
            lab[0].getStyle();
            tf[0].setMinWidth(200);
            tf[0].setPrefWidth(200);
            tf[0].setMaxWidth(400);
            tf[0].setText("N o m  A l g o r i t h m e");
            tf[0].setStyle("-fx-text-fill: #dcdcdc;");
            tf[0].textProperty().addListener(new ChangeListener<String>() 
            {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
                {
                    tf[0].setPrefWidth(tf[0].getText().length() * 7); 
                }
            });
            hb.getChildren().addAll(lab[0],tf[0],cb[0]);
            Ligne=0;
        }    
        else if(A.equalsIgnoreCase("C"))
        {
            lab[0] = new Label("Constante");
            lab[0].setStyle(style3);
            lab[1] = new Label("=");     
            lab[1].setStyle(style3);
            tf[0]= new TextField();
            tf[1] = new TextField();       
            tf[0].setEditable(false);
            tf[1].setEditable(false);
            tf[0].setStyle("-fx-text-fill:#000000;\n"+"-fx-font-size: 12px;\n" +"-fx-font-weight: bold;\n");
            tf[1].setStyle("-fx-text-fill:#000000;\n"+"-fx-font-size: 12px;\n" +"-fx-font-weight: bold;\n");
            for (int j=0;j<2;j++)
            {
                tf[j].setMinWidth(50);
                tf[j].setPrefWidth(50);
                tf[j].setMaxWidth(400);}
                tf[0].textProperty().addListener(new ChangeListener<String>() 
                {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
                    {
                        tf[0].setPrefWidth(tf[0].getText().length() * 7); 
                    }
                });
                tf[1].textProperty().addListener(new ChangeListener<String>() 
                {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
                    {
                        tf[1].setPrefWidth(tf[1].getText().length() * 7); 
                    }
                }); 
                hb.setSpacing(0.0);
                hb.getChildren().addAll(lab[0],tf[0],lab[1],tf[1]);
                hb.setSpacing(30.0);
                hb.getChildren().addAll(boutonA,boutonS);
                Ligne=1;
            }
            else if (A.equalsIgnoreCase("T"))
            {
                lab[0] = new Label("Type");
                lab[0].setStyle(style3);
                lab[1] = new Label("=");
                lab[1].setStyle(style3);
                tf[0]=new TextField();
                tf[0].setEditable(false);
                tf[0].setMinWidth(30);
                tf[0].setPrefWidth(50);
                tf[0].setMaxWidth(400);
                tf[0].textProperty().addListener(new ChangeListener<String>() 
                {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
                    {
                        tf[0].setPrefWidth(tf[0].getText().length() * 7); // why 7? Totally trial number.
                    }
                });       
                tf[1]=new TextField();
                tf[1].setMinWidth(100);
                tf[1].setEditable(false);     
                cb[0]= new ComboBox();
                ObservableList<String> ct1 = FXCollections.observableArrayList("Tableau d'entier","Tableau de reel","Tableau de caractere","Intervalle numerique","Intervalle alphanumerique","Enregistrement");
                cb[0].setItems(ct1);
                cb[0].setStyle(style2);
                cb[0].setMaxWidth(20);
                tf[0].setStyle("-fx-text-fill:#000000;\n"+"-fx-font-size: 12px;\n" +"-fx-font-weight: bold;\n");
                tf[1].setStyle("-fx-text-fill:#000000;\n"+"-fx-font-size: 12px;\n" +"-fx-font-weight: bold;\n");
                hb.getChildren().addAll(lab[0],tf[0],lab[1],tf[1],cb[0],boutonA,boutonS);
                Ligne=2;         
            }
            else if (A.equalsIgnoreCase("V"))
            {
                lab[0] = new Label("Variable");
                lab[0].setStyle(style);
                lab[1] = new Label(":");
                lab[1].setStyle(style);
                tf[0]= new TextField();
                cb[0]= new ComboBox();
                tf[1]= new TextField();
                cb[1]= new ComboBox();
                cb[0].setItems(ol);
                cb[0].setMaxWidth(60);
                cb[0].setStyle(style2);
                tf[0].setMinWidth(30);
                tf[0].setPrefWidth(30);
                tf[0].setMaxWidth(400);
                tf[0].textProperty().addListener(new ChangeListener<String>() 
                {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
                    {
                        tf[0].setPrefWidth(tf[0].getText().length() * 7); 
                    }
                });
                tf[1].setMinWidth(30);
                tf[1].setPrefWidth(30);
                tf[1].setMaxWidth(400);
                tf[1].textProperty().addListener(new ChangeListener<String>() 
                {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
                    {
                        tf[1].setPrefWidth(tf[1].getText().length() * 7); 
                    }
                });
                tf[0].setStyle("-fx-text-fill:#000000;\n"+"-fx-font-size: 12px;\n" +"-fx-font-weight: bold;\n");       
                tf[1].setStyle("-fx-text-fill:#000000;\n"+"-fx-font-size: 12px;\n" +"-fx-font-weight: bold;\n");             
                hb.getChildren().addAll(lab[0],tf[0],lab[1],tf[1],cb[0],  boutonA , boutonS); 
                Ligne=3;
            }
            else if(A.equalsIgnoreCase("NC"))
            {   
                bc=true;
                hb.setPadding(new Insets(0,0,0,90));
                lab[0] = new Label("=");
                tf[0]= new TextField();
                tf[1] = new TextField();
                tf[0].setStyle("-fx-text-fill:#000000;\n"+"-fx-font-size: 12px;\n" +"-fx-font-weight: bold;\n");
                tf[1].setStyle("-fx-text-fill:#000000;\n"+"-fx-font-size: 12px;\n" +"-fx-font-weight: bold;\n");
                for (int j=0;j<2;j++)
                {       
                    tf[j].setMinWidth(50);
                    tf[j].setPrefWidth(50);
                    tf[j].setMaxWidth(400);
                }
                tf[0].textProperty().addListener(new ChangeListener<String>() 
                {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
                    {
                        tf[0].setPrefWidth(tf[0].getText().length() * 7);
                    }
                });
                tf[1].textProperty().addListener(new ChangeListener<String>() 
                {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
                    {
                        tf[1].setPrefWidth(tf[1].getText().length() * 7); 
                    }
                });
                hb.getChildren().addAll(tf[0],lab[0],tf[1]);
                Ligne++;
            }
            else if(A.equalsIgnoreCase("NT"))
            { 
                bt=true;
                hb.setPadding(new Insets(0,0,0,45));
                tf[0]=new TextField();
                lab[0] = new Label("=");
                tf[1]=new TextField();
                tf[1].setMinWidth(100); 
                tf[0].setMinWidth(30);
                tf[0].setPrefWidth(50);
                tf[0].setMaxWidth(400);
                tf[0].textProperty().addListener(new ChangeListener<String>() 
                {
                    @Override
                    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
                    {
                        tf[0].setPrefWidth(tf[0].getText().length() * 7); // why 7? Totally trial number.
                    }
                });
       cb[0]= new ComboBox();
       Tenr =new TextArea();
       Tenr.setPrefSize(300,100);
       Tenr.setStyle(   "    -fx-padding: 0.166667em; " +
                        "  -fx-background-color: transparent, white, transparent, white;  \n" +
                        "    -fx-borders-color:white;\n" +
                        "    -fx-background-radius: 0, 0, 0, 0; \n"+
                        "-fx-text-fill:#000000;\n"+
                        "-fx-font-size: 12px;\n" +
                        "-fx-font-weight: bold;\n");
        Tenr.setText("Enregistrement");
        Tenr.appendText("\n\n\n\n");
        Tenr.appendText("Fin");
        ObservableList<String> ct = FXCollections.observableArrayList("Tableau d'entier","Tableau de reel","Tableau de caractere","Intervalle numerique","Intervalle alphanumerique","Enregistrement");
        cb[0].setItems(ct);
        cb[0].setStyle(style2);
        cb[0].setMaxWidth(20);
        tf[0].setStyle("-fx-text-fill:#000000;\n"+"-fx-font-size: 12px;\n" +"-fx-font-weight: bold;\n");
        tf[1].setStyle("-fx-text-fill:#000000;\n"+"-fx-font-size: 12px;\n" +"-fx-font-weight: bold;\n");
        hb.getChildren().addAll(tf[0],lab[0],tf[1],cb[0]);
        Ligne++;        
     }       
     else if(A.equalsIgnoreCase("NV"))
     {
        bv=true;
        hb.setPadding(new Insets(0,0,0,70));
        lab[0] = new Label(":");
        tf[0]= new TextField();
        tf[1]= new TextField();
        cb[0]= new ComboBox();
        cb[0].setItems(ol);
        cb[0].setStyle(style2);
        cb[0].setMaxWidth(60);
        tf[0].setMinWidth(30);
        tf[0].setPrefWidth(30);
        tf[0].setMaxWidth(400);
        tf[0].textProperty().addListener(new ChangeListener<String>() 
        {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
            {
                tf[0].setPrefWidth(tf[0].getText().length() * 7);
            }
        });
        tf[1].setMinWidth(30);
        tf[1].setPrefWidth(30);
        tf[1].setMaxWidth(100);
        tf[1].textProperty().addListener(new ChangeListener<String>() 
        {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) 
            {
                tf[1].setPrefWidth(tf[1].getText().length() * 7); 
            }
        });

        tf[0].setStyle("-fx-text-fill:#000000;\n"+"-fx-font-size: 12px;\n" +"-fx-font-weight: bold;\n");     
        tf[1].setStyle("-fx-text-fill:#000000;\n"+"-fx-font-size: 12px;\n" +"-fx-font-weight: bold;\n");
        hb.getChildren().addAll(tf[0],lab[0],tf[1],cb[0]);
        Ligne++;
    } 
}
    
    public void setLigne(int i)
    {
        this.Ligne=i;
    }
    
    public int getLigne()
    {
        return this.Ligne;
    }
    
    public void setnbLignes(int i)
    {
        this.nbLignes=i;
    }
    
    public int getnbLignes()
    {
        return this.nbLignes;
    }

}
