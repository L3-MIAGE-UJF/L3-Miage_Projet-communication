package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Model;
import core.pcore.CoreApp;

/**
*
* DO NOT EDIT THIS FILE IT BELONG TO THE FRAMEWORK
* @author groupe1
*
*/
public class Core {
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("\n>>> ================================= <<<");
		System.out.println(">>> Main Core : Lancement des modules <<<");
		System.out.println(">>> ================================= <<<\n");
			
		/*
		 * Déclaration des fichiers de configuration contenant la liste des modules a activer
		 */
		File file = new File("/home/d/douchetm/L3/projet-com/src/config/activated_model.list");
		HashSet<String> activated_model_set = null;
		
		/*
		 * Parse of listing files
		 */
		activated_model_set=parseListModel(file);
		
		/*
		 * Instantiation of listed nodes
		 */
		
		if (instantiateListedNodes(activated_model_set)) {
			System.out.println("\n>>> Main Core : Tout les modules on étés correctement instanciés");
		}
		else {
			System.err.println(">>> Main Core : Erreur certains modules n'ont pas étés instanciés");
		}
		
		/*
		 * Execution of the mainApp() written by devOps
		 */
		CoreApp.mainApp(args);
	}

	/**
	 * 
	 * @param activated_model_set
	 * @return
	 */
	private static boolean instantiateListedNodes(HashSet<String> activated_model_set) {
		boolean ret = true;
	    Iterator<String> iamodelSet=activated_model_set.iterator();
	    String currentModel = null;
	    
	    while(iamodelSet.hasNext()) {
			try {
				currentModel=iamodelSet.next();
				Class<?> exemple = Class.forName(currentModel);
				//Model modele = (Model) exemple.newInstance();
				exemple.newInstance();
			} catch (InstantiationException | IllegalAccessException e) {
				System.err.println("Main Core : InstantiationException or IllegalAccessException : "+currentModel);
				e.getMessage();
				ret=false;
			} catch (ClassNotFoundException e) {
				System.err.println("Main Core : ClassNotFoundException : "+currentModel);
				e.getMessage();
				ret=false;
			}
	    }
		return ret;
	}

	/**
	 * 
	 * @param activated_model_file
	 * @return
	 */
	private static HashSet<String> parseListModel(File activated_model_file) {
		HashSet<String> setListModel = new HashSet<String>();
		
		/*
		 * FileInputStream is used for reading streams of raw bytes of data, like raw images.
		 * FileReaders, on the other hand, are used for reading streams of characters
		 * The difference between FileInputStream and FileReader is,
		 * FileInputStream reads the file byte by byte and FileReader reads the file character by character.
		 */
		
		try (BufferedReader br = new BufferedReader(new FileReader(activated_model_file))) {
			/*
			 * Déclaration des variables nécessaires pour l'utilisation de test avec expressions régulières
			 */
		    String line = null;
		    String patternCom = "(^#)(.)*"; 
			
		    Pattern regPatCom = Pattern.compile(patternCom, Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
		    Matcher matcher = null;
		    
		    while ((line = br.readLine()) != null) {		    	
				line = line.trim();
				matcher = regPatCom.matcher(line);
				if (!matcher.matches() && !line.isEmpty()) {
					setListModel.add("model."+line);
				}
		    }
		} catch (FileNotFoundException e) {
			System.err.println("Main Core : parseListModel : FileNotFoundException");
			e.getMessage();
		} catch (IOException e) {
			System.err.println("Main Core : parseListModel : IOException");
			e.getMessage();
		}
		
		return setListModel;
	}
}
