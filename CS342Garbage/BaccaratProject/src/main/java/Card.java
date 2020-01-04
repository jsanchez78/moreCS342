import javafx.application.Application;

class Card {
    private String suite;
    private int value;

    Card(String theSuite, int theValue){
        this.suite = theSuite;
        this.value = theValue;
    }
    Card(){
        this.suite = null;
        this.value = 0;
    }
    public int getValue() {
        return this.value;
    }
    public String getSuite(){
        return this.suite;
    }
    public void setValue(int value){
        this.value = value;
    }
    public void setSuite(String suite){
        this.suite = suite;
    }

}
