class Card {
    private String suite;
    private int value;

    Card(String theSuite, int theValue){
        this.suite = theSuite;
        this.value = theValue;
    }

    public int getValue() {
        return this.value;
    }
}
