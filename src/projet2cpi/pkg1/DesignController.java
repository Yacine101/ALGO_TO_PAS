package projet2cpi.pkg1;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;



public class DesignController implements Initializable 
{
    
       // La classe controleuse du fichier FXML               //
        // Peut etre conciderer comme le Main de notre projet //
    
    
       @FXML AnchorPane pane1;
       @FXML Button nouveau,ouvrir,enreg,enregSous,traduire,devpascal;       
       @FXML TabPane tabPane1;       
       @FXML Tab tabModel;
       @FXML AnchorPane ContentModel;     
       Image [] images= new Image[8];       
       Models model;
       Traduire tr;
       public  static String pth="";
       public  static String dir="";
       public  static String pas="";
       public  String pasfile="";
       public static  Boolean verif=false;
       public static  Boolean verif2=false;
       public  Boolean quit=false;
       public static String stab="";
       public Models verify;
     
       // L'ecouteur du bouton Ouvrir pour l'ouverture d'un fichier //
       //////////////////////////////////////////////////////////////
       
       @FXML
       private void nouveauFX(ActionEvent event) 
       { // Ajouter une nouvel Tab    
            JFrame frame= new JFrame();  // La fenetre d'option . 
            String titre=(String)JOptionPane.showInputDialog(frame, "Veuillez introduire le nom du nouveau algorithme ", null, JOptionPane.PLAIN_MESSAGE, null, null, ""); 
            Tab t =new Tab(); // creer une nouvelle Tab .
            while (titre.trim().equalsIgnoreCase("") || titre.trim().matches(".*\\W.*"))
            { // Regex
                JOptionPane.showMessageDialog(null, "Veuillez introduire un nom non vide avec des charachtéres Alphanumériques .", "Erreur",JOptionPane.ERROR_MESSAGE);
                titre=(String)JOptionPane.showInputDialog(frame, "Veuillez introduire le nom du nouveau fichier algorithme","ouverture :", JOptionPane.PLAIN_MESSAGE, null, null, "");
            }
            if(!titre.equalsIgnoreCase(""))
            {
                t.setText(titre);
                pas="";
                dir="";
                pasfile="";
                verif=false;
                verif2=false;
                stab="";
                quit=true;
                stab=titre+".algo";
                pas=titre;
                model = new Models(t); // une instance de la classe Model , ModelTab est maintenant le Constructeur 
                tabPane1.getTabs().add(t);
                SingleSelectionModel<Tab> selectionModel = tabPane1.getSelectionModel(); // Afficher la tab apres son ajout . 
                selectionModel.select(t); 
            }
        }
      
    // L'ecouteur du bouton quitter  //   
       
        @FXML
     private void quitterFX(ActionEvent evnt) throws IOException
     {  
        if ((quit==true) )
        {
            String nom=model.entete[0].tf[0].getText();
            if  (!"N o m  A l g o r i t h m e".equals(nom))
            {
                if   ( (true==verif)||(false==verif2 ))
                {
                    Object[] options = {"Oui", "NON","Annuler"};
                    int option;   
                    option = JOptionPane.showOptionDialog(null,"Voulez-vous enregistrer avant de quitter?","",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[2]);
                    if(option == JOptionPane.OK_OPTION)
                    { 
                        enregistrerFX(evnt);
                        System.exit(0);
                    }
                    else if (option == JOptionPane.NO_OPTION)
                    {
                        System.exit(0);
                    }
                }
            }
            else{System.exit(0);}
        }
        else
        {
            System.exit(0);
        }
    }   
     
     // L'ecouteur du bouton ouvrir (L'etappe la plus difficile) //
        ////////////////////////////////////////////////////
        
        @FXML
     private void ouvrirFX(ActionEvent event) throws IOException
     {
        FileChooser fileChooser = new FileChooser();
        int i=0,r=0, j=0;;
        Tab tb=new Tab();
        String open;
        open = "";
        Character c;
        String mots [];
        String tbalg []=new String [100];
        boolean plus=false;
        //extension
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt","*.algo");
        fileChooser.getExtensionFilters().add(extFilter);
        File file= fileChooser.showOpenDialog(null);
        String nomfich=file.getPath();
        pasfile="";      
        while (i<nomfich.length())
        {
            c=nomfich.charAt(i);
            pasfile=pasfile+((char)c);
            if (0 ==c.compareTo((Character)'.'))  
            {
                pasfile=pasfile+"pas";
                i=i-1;
                c=nomfich.charAt(i);
                while (c.compareTo((Character)'\\') !=0)
                {          
                    open=((char)c)+open;
                    i--; 
                    c=nomfich.charAt(i);
                }
                i=nomfich.length();  
            }
            i++;
        }
        tb.setText(open);
        stab=open+".algo";
        model = new Models(tb); 
        tabPane1.getTabs().add(tb);
        SingleSelectionModel<Tab> selectionModel = tabPane1.getSelectionModel();
        selectionModel.select(tb);
        try
        {
            try ( BufferedReader buff = new BufferedReader(new FileReader(nomfich))) 
            {
                String line;                
                while ((line = buff.readLine()) != null) 
                {
                    mots = line.split(" ") ;
                    for(String mo :mots)
                    {
                        if ((mo.length()!=0)&&(!"=".equals(mo))&&(!":".equals(mo))&&(!")".equals(mo))&&(!"(".equals(mo)))
                        {
                            tbalg[j]=mo;
                            j++;
                        } 
                    }   
                }
            }
        } catch (IOException ioe) 
        {
            System.out.println("Erreur --" + ioe.toString());
            JOptionPane jop2;
            JOptionPane.showMessageDialog(null, "Probléme d'ouverture de fichier", "Erreur", JOptionPane.INFORMATION_MESSAGE);
        } 
        verif=true;
 //****************************************************************************
 //on commence a ecrire dans l'interface          

        model.entete[0].tf[0].setStyle("-fx-text-fill: #000000;");
        model.entete[0].tf[0].setText(tbalg[r+1]);  
        r=r+2;          
        plus=false;     
        if (tbalg[r].equalsIgnoreCase("Constante"))
        {
            r=r+1;
            System.out.println(r);
            if (!"Type".equalsIgnoreCase(tbalg[r])) 
            {
                model.entete[1].lab[0].setStyle(Entete.style);
                model.entete[1].lab[1].setStyle(Entete.style);
                model.entete[1].bc=true;
                Models.C=Models.C+1;
                model.entete[1].tf[0].setEditable(true);
                model.entete[1].tf[1].setEditable(true);
                model.entete[1].tf[0].setText(tbalg[r]);
                r=r+1;
                model.entete[1].tf[1].setText(tbalg[r]);     
                r=r+1;
                plus=true;
            }     
        }
        if(plus==true)
        {
            while((!"Type".equalsIgnoreCase(tbalg[r]))&&(!"Variable".equalsIgnoreCase(tbalg[r]))&&(!"DEBUT".equalsIgnoreCase(tbalg[r])))
            { 
                model.entete[model.nbLigneE]= new Entete("NC");
                model.entete[model.nbLigneE].tf[0].setEditable(true);
                model.entete[model.nbLigneE].tf[0].setText(tbalg[r]);
                r=r+1;
                model.entete[model.nbLigneE].tf[1].setEditable(true);
                model.entete[model.nbLigneE].tf[1].setText(tbalg[r]);
                model.vb.getChildren().add(model.entete[1].getLigne()+1,model.entete[model.nbLigneE].hb);
                model.nbLigneE++;
                model.nbLigneEntete++;  
                model.entete[1].setnbLignes(model.entete[1].getnbLignes()+1);
                model.entete[2].setLigne(model.entete[2].getLigne()+1);
                model.entete[3].setLigne(model.entete[3].getLigne()+1);
                r=r+1;
            }
        }         
        plus=false;
        if (tbalg[r].equalsIgnoreCase("Type"))
        {
            r=r+1;
            if (!"Variable".equalsIgnoreCase(tbalg[r])) 
            { 
                model.entete[2].lab[0].setStyle(Entete.style);
                model.entete[2].lab[1].setStyle(Entete.style);
                model.entete[2].bt=true;
                Models.T=Models.T+1;
                model.entete[2].tf[0].setEditable(true);
                model.entete[2].tf[0].setText(tbalg[r]);
                r=r+1;
                String h=tbalg[r]+" "+tbalg[r+1]+" "+tbalg[r+2];
                model.entete[2].tf[1].setEditable(true);
                model.entete[2].tf[1].setText(h);
                r=r+3;
            }
            plus=true;
        }
        if(plus==true)
        {
            while((!"Variable".equalsIgnoreCase(tbalg[r]))&&(!"DEBUT".equalsIgnoreCase(tbalg[r])))
            { 
                model.entete[model.nbLigneE]= new Entete("NT");
                model.entete[model.nbLigneE].tf[0].setEditable(true);
                model.entete[model.nbLigneE].tf[0].setText(tbalg[r]);
                r=r+1;
                model.entete[model.nbLigneE].tf[1].setEditable(true);
                model.entete[model.nbLigneE].tf[1].setText(tbalg[r]);
                model.vb.getChildren().add(model.entete[2].getLigne()+1, model.entete[model.nbLigneE].hb);
                model.nbLigneE++;
                model.nbLigneEntete++;
                model.entete[2].setnbLignes(model.entete[2].getnbLignes()+1);
                model.entete[3].setLigne(model.entete[3].getLigne()+1);
                r=r+1;      
            }     
        }
        plus=false;
        if (tbalg[r].equalsIgnoreCase("Variable"))
        { 
            r=r+1;
            if (!"DEBUT".equalsIgnoreCase(tbalg[r]))
            {   
                model.entete[3].tf[0].setText(tbalg[r]);
                r=r+1;
                System.out.println(r);
                model.entete[3].tf[1].setEditable(true);
                model.entete[3].tf[1].setText(tbalg[r]);
                r=r+1;
                System.out.println(r);
                plus=true;
            }  
        }      
        if(plus==true)
        {
            while((!"DEBUT".equalsIgnoreCase(tbalg[r]))&&(!"FIN".equalsIgnoreCase(tbalg[r])))
            {
                model.entete[model.nbLigneE]= new Entete("NV");
                model.entete[model.nbLigneE].tf[0].setText(tbalg[r]);
                r=r+1;
                model.entete[model.nbLigneE].tf[1].setText(tbalg[r]);
                model.vb.getChildren().add(model.entete[3].getLigne()+1, model.entete[model.nbLigneE].hb);
                model.handler.choixVar(model.entete[model.nbLigneE]);
                model.nbLigneE++;
                model.nbLigneEntete++;
                model.entete[3].setnbLignes(model.entete[3].getnbLignes()+1);
                r=r+1;
            }
        }
        model.positionADD=model.vb.getChildren().indexOf(model.hb[1]);
        plus=false;
        System.out.println(r);
        model.decalageADD=new Insets(0,0,0,20);
        int ins=20;              
        if (tbalg[r].equalsIgnoreCase("DEBUT"))
        {
            System.out.println(r);
            System.out.println(tbalg[r]);
            r=r+1;
            System.out.println(r);
            System.out.println(tbalg.length);
            plus=true;
        }
        String cond=tbalg[r];
        if (plus==true)
        {
            while ((! tbalg[r].equals("FIN"))&&(r<tbalg.length))
            {
                switch (cond) 
                {
                    case "Pour":
                        if(model.positionADD>model.nbLigneEntete+1 )
                        {  
                            if ((!tbalg[r+1].equals("allantDe"))&&(!tbalg[r+3].equals("a:"))&&(!tbalg[r+5].equals("faire"))){ model.ModelPour(model.vb,model.positionADD,tbalg[r+1],tbalg[r+3],tbalg[r+5]);
                                model.positionADD-=3;
                                r=r+8;}
                             else
                            {
                            model.ModelPour(model.vb,model.positionADD,"","","");
                            r=r+5;
                            }
                            cond=tbalg[r];
                            if (!cond.equals("FPR"))
                            {
                                model.positionADD+=2;
                                ins=ins+20;
                            }
                            else
                            {
                                model.positionADD+=3 ;
                                r++;
                                cond=tbalg[r];
                            }  
                            model.decalageADD=new Insets(0,0,0,ins);
                        }
                        break;
                        case "FPR":
                            model.positionADD+=1 ;
                            r++;
                            cond=tbalg[r];
                            ins=ins-20;
                            model.decalageADD=new Insets(0,0,0,ins);
                        break;
                        case "Tantque":
                            if(model.positionADD>model.nbLigneEntete+1 )
                            {        
                                if ((!tbalg[r+1].equals("faire")))
                                { 
                                    model.ModelTQ(model.vb,model.positionADD,tbalg[r+1]);
                                    model.positionADD-=3;
                                    r=r+4;
                                }
                                else
                                {
                                    model.ModelTQ(model.vb,model.positionADD,"");
                                    model.positionADD-=3;
                                    r=r+3;
                                }
                                cond=tbalg[r];
                                if (!cond.equals("FTQ")){model.positionADD+=2;;ins=ins+20;}
                                else
                                { 
                                    model.positionADD+=3;
                                    r++;
                                    cond=tbalg[r];
                                }  
                                model.decalageADD=new Insets(0,0,0,ins);
                            }
                        break;
                        case "FTQ":
                            model.positionADD+=1 ;
                            r++;
                            cond=tbalg[r];
                            ins=ins-20;
                            model.decalageADD=new Insets(0,0,0,ins);
                        break;
                        case "Lire":
                            if(model.positionADD>model.nbLigneEntete+1 )
                            {        
                                model.ModelL(model.vb,model.positionADD,tbalg[r+1]);
                                r=r+2;
                                cond=tbalg[r];
                                
                            }
                        break;
                        case "SI":
                             if(model.positionADD>model.nbLigneEntete+1 )
                             {
                                if ((!tbalg[r+1].equals("Alors"))){ model.ModelSI(model.vb,model.positionADD,tbalg[r+1]);
                                    model.positionADD-=3;
                                    r=r+4;}
                                else
                                {   
                                    
                                    model.ModelSI(model.vb,model.positionADD,"");
                                    model.positionADD-=3;
                                    r=r+3;
                                }
                                cond=tbalg[r];
                                if (!cond.equals("FSI")){model.positionADD+=2;ins=ins+20;}
                                else
                                { 
                                    model.positionADD+=3 ;
                                    r++;
                                    cond=tbalg[r];
                                }  
                                model.decalageADD=new Insets(0,0,0,ins);
                            }
                        break; 
                        case "FSI":
                            model.positionADD+=1 ;
                            r++;
                            cond=tbalg[r];
                            ins=ins-20;
                            model.decalageADD=new Insets(0,0,0,ins);
                        break;
                        case "Ecrire":
                            if ((tbalg[r].equals("Ecrire"))&&(!tbalg[r].equals("FIN")))
                            {    
                                String ecr;
                                r++;
                                if(!tbalg[r].equals("\"")){ecr=tbalg[r];}
                                else
                                {
                                    ecr=tbalg[r];
                                    r++;
                                    while((!tbalg[r].equals("\"")))
                                    {   
                                        ecr=ecr+" "+tbalg[r+1];r++;
                                    } 
                                }
                                if(model.positionADD>model.nbLigneEntete+1 )
                                {        
                                    model.ModelE(model.vb,model.positionADD,ecr);
                                    r=r+1;
                                    cond=tbalg[r];
                                    
                                }
                            } 
                            break;
                            case "/*":
                                if ((tbalg[r].equals("/*"))&&(!tbalg[r].equals("FIN.")))
                                {    
                                    String ecr;
                                    r++;
                                    if(tbalg[r].equals("*/")){ecr="";}
                                    else
                                    {
                                        ecr=tbalg[r];
                                        r++;
                                        while((!tbalg[r].equals("*/")))     {ecr=ecr+" "+tbalg[r+1];r++;}
                                    }
                                    if(model.positionADD>model.nbLigneEntete+1 )
                                    {        
                                        model.ModelComment(model.vb,model.positionADD,ecr);
                                        r=r+1;
                                        cond=tbalg[r];
                                        
                                    }
                                } 
                            break;
                            case "Si":
                                if((tbalg[r].equals("Si"))&&(!tbalg[r].equals("FIN")))
                                {
                                    if(model.positionADD>model.nbLigneEntete+1 )
                                    {
                                        if ((!tbalg[r+1].equals("Alors")))
                                        { 
                                            model.ModelSISIN(model.vb,model.positionADD,tbalg[r+1]);
                                            model.positionADD-=3;
                                            r=r+4;
                                        }
                                        else
                                        {
                                            model.ModelSISIN(model.vb,model.positionADD,"");
                                            model.positionADD-=3;
                                            r=r+3;
                                        }
                                        cond=tbalg[r];
                                        if (!cond.equals("FSi")){model.positionADD+=2;ins=ins+20;}
                                        else
                                        { 
                                            model.positionADD+=3 ;
                                            r++;
                                            cond=tbalg[r];
                                        }  
                                        model.decalageADD=new Insets(0,0,0,ins);
                                    }
                                }
                            break;
                            case "FSi":
                                model.positionADD+=2 ;
                                r=r+2;
                                cond=tbalg[r];
                             break;
                             case "FSIN":
                                model.positionADD+=1 ;
                                r++;
                                cond=tbalg[r];
                                ins=ins-20;
                                model.decalageADD=new Insets(0,0,0,ins);
                            break;
                            case "Repeter":
                                if ((tbalg[r].equals("Repeter"))&&(!tbalg[r].equals("FIN")))
                                {
                                    if(model.positionADD>model.nbLigneEntete+1 )
                                    {        
                                        model.ModelREP(model.vb,model.positionADD);
                                        model.positionADD-=3;
                                        r=r+1;
                                        cond=tbalg[r];
                                        if (!cond.equals("Jusqu'a")){model.positionADD+=1;ins=ins+20;}
                                        else
                                        { 
                                            model.positionADD+=2 ;
                                            r=r+2;
                                            cond=tbalg[r];
                                        }  
                                        model.decalageADD=new Insets(0,0,0,ins);
                                    }
                                }
                            break;
                            case "Jusqu'a":
                                model.positionADD+=1;
                                model.t9.setText(tbalg[r+1]);
                                r=r+2;
                                cond=tbalg[r];
                                ins=ins-20;
                                model.decalageADD=new Insets(0,0,0,ins);
                            break;
                            case ":=":
                                if(model.positionADD>model.nbLigneEntete+1 )
                                {        
                                    model.ModelAFF(model.vb,model.positionADD,tbalg[r-1],tbalg[r+1]);
                                    r=r+2;
                                    cond=tbalg[r];
                                    
                                }
                            break;    
                            default:
                                if (tbalg[r+1].equals(":="))
                                {
                                    r++;
                                    cond=tbalg[r];
                                }
                            break;
                            }
                        }           
                    }
                    model.ouvrePas(pasfile);
     }
     
     // L'ecouteur du bouton enregistrer //
        //////
     
         @FXML
     private void enregistrerFX(ActionEvent ev) throws IOException
     {
        if(verif==true)
        {      //fichier ouvert
            model.recupText("",pth);     
            model.recupPas(pasfile);
            JOptionPane jop1;
            JOptionPane.showMessageDialog(null, "Votre fichier a été enregistré", "Enregistrer", JOptionPane.INFORMATION_MESSAGE);
        }      
        else if (verif2==false)//si il a fait enregistrer sans enregsous
        {
             enregSousFX(ev);
        }   
        else if (verif2==true)  //un nouveau fichier
        {
            String tmp =dir+stab;
            String tmp2 =dir+pas+".pas";
            model.recupText("",tmp);
            model.recupPas(tmp2);
            JOptionPane jop1;
            JOptionPane.showMessageDialog(null, "Votre fichier a été enregistré", "Enregistrer", JOptionPane.INFORMATION_MESSAGE);
        }
     }
       
       // L'ecouteur du bouton enregistrer sous ///  
        ////////////////////////////////////////// 
          @FXML
        private void enregSousFX(ActionEvent event) throws IOException 
        {
            verif2=true;
            DirectoryChooser directoryChooser = new DirectoryChooser(); 
            File file = directoryChooser.showDialog(null);
            dir=file.getPath();
            System.out.println(dir);
            dir=dir+"\\";
            model.recupText(stab,dir);
            String cal =dir+pas+".pas";
            model.recupPas(cal);
        }
     
     // L'ecouteur du bouton traduire pour affectuer la traduction//     
     //////////////////////////////////////////////////////////////
         @FXML
     private void traduireFX(ActionEvent event) throws IOException
     {
        Models.ta.setEditable(true);
        Models.ta.setText(" ");
        tr=new Traduire();
        String s;
        s=".";
        System.out.print(s);
        model.recupText("tmp.algo",pth+"temp/");
        s="tmp.algo";
        Traduire.Traduction( s , pth+"temp/");
    }
         
         
     // L'ecouteur du bouton Exportation en dev pascal .
         
      @FXML
     private void devpas(ActionEvent event) throws IOException
     {
        File devpas = new File("C:\\Dev-Pas\\devpas.exe");
        if(devpas.exists()){
        Models.ta.setEditable(true);
        Models.ta.setText(" ");
        tr=new Traduire();
        String s;
        s=".";

        model.recupText("tmp.algo",pth+"temp/");
                
        s="tmp.algo";
        Traduire.Traduction( s , pth+"temp/");
        String pth2= pth.replaceFirst("/", "");

        Runtime.getRuntime().exec("C:\\Dev-Pas\\devpas.exe " +"\""+pth2+"temp\\.pascal.pas\"" ); 
        }else{
        JOptionPane.showMessageDialog(null,"Vous devez installer Dev-Pas pour l'exporter","Erreur",JOptionPane.INFORMATION_MESSAGE);
        }
    }  
         
          @FXML
       private void aideFX(ActionEvent event) throws IOException { 
             
         String pth2= pth.replaceFirst("/", "");
         Runtime.getRuntime().exec("C:\\WINDOWS\\hh.exe "+pth2+"help.chm");   
     
       }
       
          
       // l'ecouteur du Bouton a propos .
          
            @FXML
       private void aproposFX(ActionEvent event) throws IOException 
       { 
            JOptionPane.showMessageDialog(null,"Ce Projet AlgoPas  a été développé par :\n\n#Ouarezki Yacine (CE)\n#Bachiri Aicha\n#Aklil Salima\n#Miloudi Amar\n#Chenna Sofiane\n#Abismail Walid ","Credits",JOptionPane.INFORMATION_MESSAGE);
       }
          
            
        // Methode de suppression d'un disser .    
            
        private void delete(File directory) throws IOException{
       
           if(directory.isDirectory()){
           
               if(directory.list().length==0){
               directory.delete();//supprimer simplement
               }
               else{
               String list[] = directory.list();
               
               for (String temp : list) {

        	      File fileDelete = new File(directory,temp);
        	      delete(fileDelete);
        	   }
        	   if(directory.list().length==0){
           	     directory.delete();
        	   }
               
               }
           }else{
               directory.delete();
           }

       }
     
       
     @Override
    public void initialize(URL url, ResourceBundle rb) // La fonction qui vas initialiser l'interface . 
    {
        
         // Obtention du chemin vers le fichier .
        try{
        String foo = DesignController.class.getProtectionDomain().getCodeSource().getLocation().toURI().resolve(".").getPath();
        try{
        pth = URLDecoder.decode(foo, "UTF-8");
        } catch(UnsupportedEncodingException uee){};
        }
        catch(URISyntaxException e){}
        //
        
        
        // Creation du dossier temporaire  temp apres tout  lancement du programme .
        
        File directory = new File(pth+"temp");
        
        if(!directory.exists()){
        directory.mkdir();
        }
        
        else{  
            
         try{
        delete(directory);
        directory.mkdir();
         }catch(IOException ioe){}
         
        }
       
        /////
        
        
        quit=false;    
        
        // initialisation des images de la barre d'acces rapide .///
        ////////////////////////////////////////////////////////////
        
        for(int i=1;i<=7;i++)
        {
            images[i]=new Image(getClass().getResourceAsStream("images/i"+i+".png")); 
        }
        nouveau.setGraphic(new ImageView(images[1]));
        ouvrir.setGraphic(new ImageView(images[2]));
        enreg.setGraphic(new ImageView(images[3]));
        enregSous.setGraphic(new ImageView(images[4]));
        devpascal.setGraphic(new ImageView(images[5]));
        traduire.setGraphic(new ImageView(images[7]));    
       
    }    
}