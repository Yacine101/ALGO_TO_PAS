package projet2cpi.pkg1;


import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Traduire 
{	
    // La classe qui vas faire la traduction //
    ///////////////////////////////////////////
    
    public Traduire (){}

    static String Dictionnaire [][] = 
    {
        {"a:","algorithme","allantde","alors","booleen","chaine","charactere","constante","de","d'entier","debut","dsi","dpr","dtq","ecrire","entier","enregistrement","faire","fin.","fpr","fsi","ftq","fsin","fin","jusqu'a","lire","pour","reel","repeter","si","sinon","tableau","tantque","type","variable","dereel","decaractere"}, //vecteur des mots clés en algorithmique
        {"to","program",":=","then","boolean","string","char","\nconst","of","of integer","\nbegin","begin","begin","begin","Writeln","integer","Record","do","end .","end","end","end","end","end","while","Readln","for","float","do","if","else","array","while","\ntype","\nvar","of float","of char"}    //vecteur des mots clés en pascal
    };
		
    public static String EnPascal (String MotAlgo)	
    {
        boolean trouv = false;
	int i=0;
	String pascal = MotAlgo;
	while ((i<Dictionnaire[0].length) & (!trouv))
	{
            String word = Dictionnaire [0][i];
            if (MotAlgo.equals(word))
            {
                trouv = true;
		pascal = Dictionnaire [1][i];
            }
            else
            {
                i++;
            }
	}
        return pascal;
    }
		
    public static void EcrireLigne(String filename, String text) 
    {
        BufferedWriter bufWriter = null;
        FileWriter fileWriter = null;
        try 
            {
                fileWriter = new FileWriter(filename, true);
		bufWriter = new BufferedWriter(fileWriter);
                if ( ! ";".equals(text)  ){
		bufWriter.newLine();
		bufWriter.write(text);
		bufWriter.close();}
            } catch (IOException ex) {
                Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
                    try 
                {
                    bufWriter.close();
                    fileWriter.close();
                } catch (IOException ex) 
                {
                Logger.getLogger(FileWriter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }  

    
    public static void Traduction (String path ,String path2)
    {
        int i=0;
        String LigneTraduite="",DernierMot ="",line;
	String[] mots ;
        
	File file = new File(path2+".pascal.pas");//Enregistrer/lo.algo
	if (file.exists()) 
	{
            file.delete();
        }
	try
            {	
                BufferedReader buff = new BufferedReader(new FileReader(path2+path)); 
                try 
                {
                    while ((line = buff.readLine()) != null)
                    {
                        if ( 0!=line.length())
                        {
                        LigneTraduite ="";
			for (int j=0;j<i;j++)
                        {
                            LigneTraduite = LigneTraduite+"\t";
			}
			mots = line.split(" ") ;
			for(String mot : mots)
			{   
                            System.out.print(mot);
                            mot = mot.toLowerCase();
                            String sa = EnPascal(mot);
                            if (sa.equalsIgnoreCase("begin"))
                            {
                                i++;
                            }
                            else
                            {
                                if (sa.equalsIgnoreCase("end")) i--;
				else 
                                { 
                                    if (mot.equalsIgnoreCase("sinon")) i++; 
                                }
                            }
                            LigneTraduite = LigneTraduite +" "+sa;
                            DernierMot =mot;
			}
			String Diff1 [] = {"sinon","type","constante","variable","faire",".","debut","dpr","dsi","dtq",",","alors","*/","repeter"};
			int j=0;
			boolean trouv=false;
			while ((j<Diff1.length) & (trouv==false) & (DernierMot.length()>=1))
			{
                            if (DernierMot.equals(Diff1[j]))
                            {
                                trouv = true;
                            }
                            else
                            {
                                j++;
                            }
			}
			if (trouv == false)
			{
                            LigneTraduite = LigneTraduite + ";" ;
			}
                        EcrireLigne(path2+".pascal.pas", LigneTraduite);
                    }
                }
            } finally 
            {
                buff.close();
            }
        } catch (IOException ioe) 
        {
            System.out.println("Erreur --" + ioe.toString());
        }
        try
        {
            try ( BufferedReader buff = new BufferedReader(new FileReader(path2+".pascal.pas"))) 
            {
                String lin;
                while ((lin = buff.readLine()) != null) 
                {
                    System.out.println(lin);
                    Models.ta.appendText(lin);
                    Models.ta.appendText("\n");
                }
            }
        } catch (IOException ioe) 
        {
            // erreur de fermeture des flux
            System.out.println("Erreur --" + ioe.toString());
        }
        Models.ta.setEditable(false);
    }
}
