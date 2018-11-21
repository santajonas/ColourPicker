import java.util.Objects;

public class Colour {

    private double red;
    private double green;
    private double blue;

    public Colour(double red, double green, double blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public void setRed(double red) {
        this.red = red;
    }

    public void setGreen(double green) {
        this.green = green;
    }

    public void setBlue(double blue) {
        this.blue = blue;
    }

    public double getRed() {
        return red;
    }

    public double getGreen() {
        return green;
    }

    public double getBlue() {
        return blue;
    }
    public boolean isGray(){
        if(red==green && green==blue && red==blue){
            return true;}
        else {
            return false;
        }
    }

    public void mixWith(Colour colour2){
        this.red =(getRed()+colour2.getRed())/2;
        this.green=(getGreen()+colour2.getGreen())/2;
        this.blue=(getBlue()+colour2.getBlue())/2;
    }

    public Colour copy(){
        return new Colour(red,green,blue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colour colour = (Colour) o;
        return Double.compare(colour.red, red) == 0 &&
                Double.compare(colour.green, green) == 0 &&
                Double.compare(colour.blue, blue) == 0;
    }

    @Override
    public String toString() {
        return "Colour{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                '}';
    }

}

