public class Species {
    private String name;
    private int population;

    public Species() {
        name = "Empty";
        population = 0;
    }
    public void setSpecies(String newName, int newPop) {
        name = newName;
        population = newPop;
    }
    public String getName(){
        return name;
    }
    public int getPop(){
        return population;
    }

}
