import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ColourPalette {

    private int numberOfColours;
    private int maxNumberOfColours;

    List<Colour> colourList = new ArrayList<>();

    public ColourPalette(int maxNumberOfColours) {
        this.maxNumberOfColours = maxNumberOfColours;
    }

    public double getNumberOfColours() {
        return numberOfColours;
    }

    public void addColour(Colour colour) {
        colourList.add(colour);
    }

    public Colour get(int index) {
        return colourList.get(index);
    }
    public int getNumberOfGrayColours(){
        numberOfColours=0;
        for(int i=0; i<colourList.size(); i++){
        if(colourList.get(i).isGray()){
            numberOfColours++;
        }
        }
        return numberOfColours;
    }

    public List<Colour> getColours(){
        return colourList;
    }

    public void mixColour(int index, Colour c2){
        colourList.get(index).mixWith(c2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColourPalette that = (ColourPalette) o;
        return numberOfColours == that.numberOfColours &&
                maxNumberOfColours == that.maxNumberOfColours &&
                Objects.equals(colourList, that.colourList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfColours, maxNumberOfColours, colourList);
    }

    @Override
    public String toString() {
        return "ColourPalette{" +
                "numberOfColours=" + numberOfColours +
                ", maxNumberOfColours=" + maxNumberOfColours +
                ", colourList=" + colourList +
                '}';
    }
}