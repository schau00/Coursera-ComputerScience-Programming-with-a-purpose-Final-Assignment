import java.util.Arrays;

public class Bar implements Comparable<Bar> {
    String barname, barcat ;
    int barvalue  ;

    // Creates a new bar.
    public Bar(String name, int value, String category){
        if(name == null || value < 0 || category == null){
            throw new IllegalArgumentException("hello");
        }
        barname = name;
        barvalue = value ;
        barcat = category;
    }

    // Returns the name of this bar.
    public String getName(){
        return this.barname;
    }

    // Returns the value of this bar.
    public int getValue(){
        return this.barvalue;
    }

    // Returns the category of this bar.
    public String getCategory(){
        return barcat ;
    }

    // Compare two bars by value.
    public int compareTo (Bar that){
        // if(that == null){
        //     NullPointerException nullPointer = new NullPointerException();
        //     throw nullPointer;
        // }
        return (this.barvalue - that.barvalue) ;
    }

    // Sample client (see below).
    public static void main(String[] args){
        Bar []bars = new Bar[3];

        for(int i=0;i<3;i++){
            String barname , barcat ;
            int barval ;
            barname = StdIn.readString();
            barval = StdIn.readInt();
            barcat = StdIn.readString();

            bars[i] = new Bar(barname,barval,barcat);

        }

        Arrays.sort(bars);
        for(int i=0;i<3;i++){
            StdOut.println(bars[i].barname + " "+bars[i].barvalue+" "+bars[i].barcat);
        }
    }

}