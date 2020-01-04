import java.util.Iterator;

public class GLIterator<I> implements Iterator<I> {

    private GenericList.Node<I> tmp;

    //Constructor for GLIterator
    GLIterator(GenericList<I> list){

        tmp = list.getHead();
    }

    public boolean hasNext() {
        return tmp != null;
    }
    //Return  data type of next
    public I next(){

        if(tmp == null){
            return null;
        }
        I val = tmp.data;
        tmp = tmp.next;
        return val;

    }

}
