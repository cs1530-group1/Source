/**
 *
 * @author Muneeb
 */
import java.util.*;
import java.io.*;

public class garden {

    //in add plant, still need to modify old file
    //work on initialize plants

    
    public static void main(String[] args)
    {   
        boolean success = false;
        
        ArrayList<species> speciesList = initializeSpecies();
        ArrayList<plant> plantList = new ArrayList<>(200);
        
        initializePlants(); //get all possible plants from the garden
        
        success = addPlant(plantList, speciesList);
        
        return;
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

            speciesList = new ArrayList<>(numSpecies);
            
            //initialize the list of species by parsing the input file speciesdata.txt
            for (int i = 0; i < numSpecies; i++)
            {
                String speciesDescription = infile.readLine();
                String[] parsed = speciesDescription.split(":");
                String type = parsed[0];
                String sun = parsed[1];
                int prune = Integer.parseInt(parsed[2]);
                int water = Integer.parseInt(parsed[3]);
                int fertilize = Integer.parseInt(parsed[4]);
                
                speciesList.add(new species(type, sun, prune, water, fertilize));
            }
            
            infile.close();
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
    
    //initialize plants from plantdata.txt
    public static boolean initializePlants()
    {
        return true;
    }
    
    //add plant to garden
    public static boolean addPlant(ArrayList<plant> plantList, ArrayList<species> speciesList)
    {
        Scanner reader = new Scanner(System.in);
        String species;
        int x, y;
        
        //this simulates the user interface for the app
        System.out.println("Enter a species name");
        species = reader.next();
        System.out.println("Enter x:");
        x = reader.nextInt();
        System.out.println("Enter y:");
        y = reader.nextInt();
        
        reader.close();
        
        boolean found = false;
        for(species s: speciesList)
        {
            if (s.type.equalsIgnoreCase(species))
            {
                String sun = s.sun;
                int water = s.water;
                int prune = s.prune;
                String type = s.type;
                int fertilize = s.fertilize;
                
                //update plantdata.txt with new plant
                try
                {
                    PrintWriter out = new PrintWriter("plantdata.txt");
                    out.print(Integer.toString(x) + Integer.toString(y) + ":");
                    out.print(type + ":" + sun + ":");
                    out.print(Integer.toString(prune) + ":"  + Integer.toString(water) + ":" + Integer.toString(fertilize) + "\n");
                    out.flush();
                }
                catch (FileNotFoundException ex)
                {
                    System.out.println("The file plantdata.txt was not found. Please try again");
                }

                species newSpecies = new species(type, sun, prune, water, fertilize);
                plant newPlant = new plant(x,y,newSpecies);
                plantList.add(newPlant);
                found = true;
            }
            
            //exit foreach loop
            if (found)
            {
                break;
            }
        }
        
        //there was an error if this is true
        if (!found)
        {
            return false;
        }
        else
        {
            return true;         
        }
    }
    
    //add new species
    public static boolean addSpecies()
    {
        return true;
    }
    
    //remove or modify existing species
    public static boolean editSpecies()
    {
        return true;
    }
    
    //remove or modify existing plant
    public static boolean editPlant()
    {
        return true;
    }
    
}
