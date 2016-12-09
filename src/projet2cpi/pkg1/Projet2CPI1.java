package projet2cpi.pkg1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class Projet2CPI1 extends Application 
{
     // La classe principal requise par JavaFX // 
     ////////////////////////////////////////////
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        // Le fichier FXML qui est le constructeur de l'interface IHM //
        ////////////////////////////////////////////////////////////////
        
        Parent root = FXMLLoader.load(getClass().getResource("Design.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add
                
         // Le fichier design du fichier FXML  de la scéne //     
                ///////////////////////////////
                
        (Projet2CPI1.class.getResource("Design.css").toExternalForm());
        stage.setTitle("AlgoPas");
        
        Image image = new Image("icon.png");    //ajouter une image icon pour l'application
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
}
