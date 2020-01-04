import java.util.Iterator;

class GenericQueue<I> extends GenericList<I> {

    //Constructor
    GenericQueue(I data){
        setHead(new Node<>(data));
        setLength(1);
    }
    GenericQueue(){
        setHead(null);
    }
    void add(I data) {
        if(getHead() == null){
            setHead(new Node<>(data));
            setLength(1);
            return;
            /*
            this.head = new Node<>(data);
            this.length = this.length + 1;
            */
        }
        Node<I> tmp = getHead();
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = new Node<>(data);
        setLength(1);
    }
    void enqueue(I data)
    {
        add(data);
    }
    ///Delete from the front of link list
    I delete(){
        if(getHead() == null){
            return null;
        }
        I val = getData(getHead());
        setLength(-1);
        setHead(getNext(getHead()));
        return val;
    }

    I dequeue(){
        return delete();
    }
    void _print(Node<I> node){
        if(node==null)
            return;
        System.out.println(getData(node));
        _print(getNext(node));
    }
    void print(){
        _print(getHead());
    }
}