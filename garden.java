/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Muneeb
 */
import java.util.*;
import java.io.*;

public class garden {
    
    ArrayList<species> speciesList = null;
    
    public static void main(String[] args)
    {
        initializeSpecies();
        
        ArrayList<species> speciesList = initializeSpecies();
        
    }
    
    //initialize the speciesList
    public static ArrayList<species> initializeSpecies()
    {
        String  speciesData = "speciesdata.txt";
        BufferedReader infile;
        ArrayList<species> speciesList = null;
        
        //try to read in data from speciesdata.txt
        try
        {
            infile = new BufferedReader(new FileReader(speciesData));
            int numSpecies = Integer.parseInt(infile.readLine());
            String speciesDescription = infile.readLine();
            String[] parsed = speciesDescription.split(":");
            speciesList = new ArrayList<>(numSpecies);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Input File was not found. Please try again");
        }
        catch (IOException ex)
        {
            System.out.println("Could not read speciesdata.txt. Please try again");
        }
  
        return speciesList;
        
    }    
}
