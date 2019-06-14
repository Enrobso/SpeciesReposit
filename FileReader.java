import java.util.Scanner;
import java.io.*;

public class FileReader {
    private static String UserInput = "";
    public static void main (String [] args) {
        //Import previous program
        System.out.println("The previous program will be imported.");
        System.out.println("The species with greatest and lowest population will be displayed.");

        //First obtain the name of the previous file from SpeciesFileName.txt
        Scanner inputStream = null;
        try{
            inputStream = new Scanner(new File("SpeciesFileName.txt"));
        }
        catch(Exception e){
            System.out.println("There was an error in reading the file name.");
            System.exit(0);
        }
        UserInput = inputStream.nextLine();
        UserInput = UserInput.trim();
        inputStream.close();


        //Now read the file and save the animals with the greatest and smallest population.
        String animalOne = "";
        int popAnimalOne = 0;
        String animalTwo = "";
        int popAnimalTwo = 0;
        String animalThree;
        int popAnimalThree;

        Scanner inputAgainStream = null;
        try{
            inputAgainStream = new Scanner(new File(UserInput));
        }
        catch (Exception e){
            System.out.println("There was an error in opening the file.");
            System.exit(0);
        }
        //Initialise both animals first
        UserInput = inputAgainStream.nextLine();
        animalThree = UserInput.substring(0, UserInput.indexOf(" "));
        popAnimalThree = Integer.parseInt(UserInput.substring(UserInput.indexOf(" ")+1));

        animalOne = animalThree;
        popAnimalOne = popAnimalThree;

        UserInput = inputAgainStream.nextLine();
        animalThree = UserInput.substring(0, UserInput.indexOf(" "));
        popAnimalThree = Integer.parseInt(UserInput.substring(UserInput.indexOf(" ")+1));

        animalTwo = animalThree;
        popAnimalTwo = popAnimalThree;

        //But these 2 read animals may be the greatest animal.
        //Test for this.
        if (popAnimalOne >= popAnimalTwo){
            animalTwo = animalOne;
            popAnimalTwo = popAnimalOne;
        }

        //Now test the other animals.
        while(inputAgainStream.hasNextLine()){
            UserInput = inputAgainStream.nextLine();
            animalThree = UserInput.substring(0, UserInput.indexOf(" "));
            popAnimalThree = Integer.parseInt(UserInput.substring(UserInput.indexOf(" ")+1));

            if (popAnimalOne >= popAnimalThree){
                animalOne = animalThree;
                popAnimalOne = popAnimalThree;
            }
            if (popAnimalTwo <= popAnimalThree){
                animalTwo = animalThree;
                popAnimalTwo = popAnimalThree;
            }
        }

        //Display data of species with greatest and smallest population.
        System.out.println("Animal one: "+animalOne+" Population: "+popAnimalOne);
        System.out.println("Animal two: "+animalTwo+" Population: "+popAnimalTwo);
    }

}
