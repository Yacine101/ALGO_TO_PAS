package projet2cpi.pkg1;

import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;

public class MenuOper 
{
     // Une classe qui contient les element du menu contextuel . A l'initialisation on aura un menu contextuel contenant //
    // Les elements voulus // 

    public ContextMenu getCont() 
    {
        return cont;
    }

    public void setCont(ContextMenu cont) 
    {
        this.cont = cont;
    }
    
    private ContextMenu cont = new ContextMenu();
    MenuItem men1 = new MenuItem();
    MenuItem men2 = new MenuItem();
    MenuItem men3 = new MenuItem();
    MenuItem men4 = new MenuItem();
    MenuItem men5 = new MenuItem();
    MenuItem men6 = new MenuItem();
    MenuItem men7 = new MenuItem();
    MenuItem men8 = new MenuItem();
       
    Button pr = new Button("POUR");
    Button tq = new Button("TANTQUE");
    Button si = new Button("SI");
    Button aff = new Button("AFFECTER");
    Button rep = new Button("REPETER");
    Button si_sinon = new Button("SI/SINON");
    Button lire = new Button("LIRE");
    Button ecrire = new Button("ECRIRE");
    Button com = new Button("COMMENTER");
      
    public MenuOper()
    {
        String styl="-fx-background-color:#696969;\n" +
                    "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );" +
                    "-fx-text-fill: white;\n" +
                    "    -fx-font-family: \"arial, cursive\";\n" +
                    "    -fx-font-weight: bold;\n"+"-fx-background-radius: 30;\n";

        men1.setText("POUR");
        men2.setText("TANTQUE");
        men3.setText("SI");
        men4.setText("AFFECTER");
        men5.setText("REPETER");
        men6.setText("SI/SINON");
        men7.setText("LIRE");
        men8.setText("ECRIRE");
        
        pr.setPrefSize(120,20);
        pr.setStyle(styl);
        tq.setPrefSize(120,20);
        tq.setStyle( styl);
        lire.setPrefSize(120,20);
        lire.setStyle( styl);
        ecrire.setPrefSize(120,20);
        ecrire.setStyle( styl);
        si.setPrefSize(120,20);
        si.setStyle( styl);
        si_sinon.setPrefSize(120,20);
        si_sinon.setStyle( styl);
        aff.setPrefSize(120,20);
        aff.setStyle( styl);
        rep.setPrefSize(120,20);
        rep.setStyle( styl);
        com.setPrefSize(120,20);
        com.setStyle( styl);
        cont.getItems().addAll(men1,men2,men3,men4,men5,men6,men7,men8);
    }
}