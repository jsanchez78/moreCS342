
class ageAnonClassEx{
    public static void main(String[] args){
        ///Class implements age interface
        ageImplementation age1 = new ageImplementation();

        ///Calling getAge() method implements at ageImplementation level
        age1.getAge();

    }
}
class ageImplementation implements Age{
    @Override
    public void getAge(){
        System.out.println("Age is " + x);
    }
}

interface Age{
    int x = 22;
    void getAge();
}