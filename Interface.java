import java.util.Scanner;
import java.io.*;

public class Interface {
    private static String UserInput;
    private static int age = 0;
    private static int max = 50;
    private static int counter = 0;
    private static Species[] species = new Species[max];
    private static Scanner keyboard = new Scanner(System.in);

    public static void main (String [] args){
        for (int j = 0; j < species.length; j++){
            species[j] = new Species();
        }


        boolean continueLoop = true;

        while (continueLoop) {
            System.out.println("1- Add new Species");
            System.out.println("2- Save and End program");
            UserInput = keyboard.nextLine();
            switch (UserInput) {
                case "1":
                    addSpecies();
                    break;
                case "2":
                    saveAndExit();
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Sorry that is not a valid input.");
                    break;
            }
        }
    }
    public static void addSpecies(){
        System.out.println("Enter the name and population of the new species:");
        try {
            UserInput = keyboard.nextLine();
            age = keyboard.nextInt();

            species[counter].setSpecies(UserInput, age);
            counter++;
            if (counter == max) {
                species = speciesArrayMax();
            }
        } catch (Exception e) {
            System.out.println("There was an error in your input.");
        }
        species = speciesArrayMax();
        keyboard.nextLine();
    }
    public static Species[] speciesArrayMax(){
        max += 5;
        Species[] copySpecies = new Species[max];

            for (int i = 0; i < species.length; i++){
               copySpecies[i] = species[i];
           }
        return copySpecies;
    }

    //Create a method that updates a document containing the name of the last file.
    //Import this file in FileReader. The name is then saved and that file imported.
    public static void saveAndExit(){
        System.out.println("Enter the name of the new file you wish to create.");
        String fileName = keyboard.nextLine();
        if (!fileName.contains(".txt"))
            fileName = fileName+".txt";

        //Save the file
        PrintWriter outputStream = null;
        try{
            outputStream = new PrintWriter(fileName);
        }
        catch(Exception e) {
            System.out.println("There was an error in saving the file.");
        }
        for (int i = 0; i < counter; i++){
            outputStream.println(species[i].getName()+" "+species[i].getPop());
        }
        outputStream.close();

        //Now save the name of the file.
        SaveFileName(fileName);

    }
    public static void SaveFileName(String nameOfFile){
        PrintWriter outputAgainStream = null;
        try{
            outputAgainStream = new PrintWriter("SpeciesFileName.txt");
        }
        catch(Exception e){
            System.out.println("Sorry there was an error in saving the file name.");
        }
        outputAgainStream.println(nameOfFile);
        outputAgainStream.close();
    }
}
