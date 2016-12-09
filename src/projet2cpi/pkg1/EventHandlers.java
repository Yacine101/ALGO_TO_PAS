package projet2cpi.pkg1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class EventHandlers 
{
    
    // Une class qui contient les ecouteurs de quelques boutons et comboBox pour leur reutiliation //
    ////////////////////////////////////////////////////////////////////////////////////////////////
    
    
  // L'ecouteur du comboBox de choix d'un type ou variable //
    ////////////////////////////////////////////////////
    
     public void TitleAction(final Entete e,final Entete e2)
     {   
        e.cb[0].setOnAction(new EventHandler<ActionEvent>()
        {         
            @Override public void handle(ActionEvent a)
            {
                e.tf[1].setEditable(true);
                String s=e.cb[0].getValue().toString();
                switch(s)
                {
                    case "Tableau d'entier":                        
                        e.tf[1].setText("tableau [..] d'entier"); 
                        if (!"".equals(e.tf[0].getText()))
                        {
                            Entete.ol.add(e.tf[0].getText());
                        }
                        
                    break;
                    case "Tableau de reel":
                        e.tf[1].setText("tableau [..] deReel"); 
                        if (!"".equals(e.tf[0].getText()))
                        {
                            Entete.ol.add(e.tf[0].getText());
                        }
                        
                    break;
                    case "Tableau de caractere":
                        e.tf[1].setText("tableau [..] deCaractere"); 
                        if (!"".equals(e.tf[0].getText()))
                        {
                            Entete.ol.add(e.tf[0].getText());
                        }
                        
                    break;
                    case "Intervalle numerique":
                        e.tf[1].setText(" [..]"); 
                        if (!"".equals(e.tf[0].getText()))
                        {
                            Entete.ol.add(e.tf[0].getText());
                        }
                       
                    break;
                    case "Intervalle alphanumerique":
                        e.tf[1].setText("[''..'']"); 
                        if (!"".equals(e.tf[0].getText()))
                        {
                            Entete.ol.add(e.tf[0].getText());
                        }
                        
                    break;
                          case "Enregistrement":
                            {
                                e.hb.getChildren().remove(e.tf[1]);
                                e.hb.getChildren().remove(e.cb[0]);
                                e.hb.getChildren().addAll(e.Tenr,e.cb[0]);
                                if (!"".equals(e.tf[0].getText()))
                                {
                                    Entete.ol.add(e.tf[0].getText());
                                }
                            }
                    break;
                }
            }
        });
    }
     
     
      public void choixVar(final Entete e)
      {  
            e.cb[0].setOnAction(new EventHandler<ActionEvent>()
            {     
                @Override public void handle(ActionEvent a)
                {
                    e.tf[1].setEditable(true);
                    String s=e.cb[0].getValue().toString();
                    e.tf[1].setText(s);   
                    e.tf[1].setEditable(false);
                }
            });
        }
     
   // Recuperation d'une rubrique apres ça suppression            //
   // L'ecouteur du ComboBox contenant (Contante Variable .. etc) //
     
     public void recup_rubrique(final Entete A,final Entete A1,final Entete A2)
     {
            A.cb[0].setOnAction(new EventHandler<ActionEvent>() 
            {
                @Override
                public void handle(ActionEvent e) 
                {
                    if (false==Entete.exist)
                    {
                        String c=A.cb[0].getValue().toString();
                        System.out.println(c);
                        if (c.equalsIgnoreCase("Constante"))
                        {
                            A1.tf[0].setText("");
                            A1.tf[1].setText("");
                            A1.lab[0].setStyle(Entete.style);
                            A1.lab[1].setStyle(Entete.style);
                            A1.hb.setVisible(true);
                            Models.C=0;
                        }              
                        if (c.equalsIgnoreCase("Type"))
                        {
                            A2.tf[0].setText("");
                            A2.tf[1].setText("");
                            A2.lab[0].setStyle(Entete.style);
                            A2.lab[1].setStyle(Entete.style);
                            A2.hb.setVisible(true);
                            Models.T=0;
                        }             
                    } 
                }
            }); 
        }
    }