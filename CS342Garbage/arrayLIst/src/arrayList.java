import java.util.ArrayList;
import java.util.Iterator;

public class arrayList {
    public static void main(String[] args){
        int x = 20, y = 30, z = 40;

        ArrayList<Integer> myList = new ArrayList<Integer>();

        myList.add(x);
        myList.add(y);
        myList.add(z);

        for (int i =0;i<myList.size();i++){
            System.out.println(myList.get(i));
        }
        Iterator<Integer> i = myList.iterator();

        while (i.hasNext()){
            System.out.println(i.next());
        }
        for (Integer val: myList){
            System.out.println(val);
        }
        myList.remove(1);
        System.out.println(myList.get(0));
        System.out.println(myList.get(1));///Java Shifts list for you
        System.out.println(myList.get(0));
    }

    Integer wrapperint = 10;
    int val = wrapperint;
    //Why can we do this?
    //Autoboxing and unboxing

    GenericOne<Integer,String> g1 = new GenericOne<Integer,String>(20,"Vilmar");

    g1.printVal();

}


//Iterator only go forward

//Cannot go backward


/*
* Iterator is inefficient for large list
* Performance issue
*
*
*For loops the way to go ----> modifications
*
*
* */

class GenericOne<T,U,Z>{
    T val;
    U val2;
    ArrayList<Z> myList;

    GenericOne(T val,U val2,ArrayList<Z> list){
        this.val = val;
        this.val2 = val2;
        this.myList = list;
    }
    /*
    void printVal(){
        System.out.println(val + " " + val2);
    }
    */
    void printVal(){
        for (T val: myList){
            System.out.println(myList);
        }
    }

}