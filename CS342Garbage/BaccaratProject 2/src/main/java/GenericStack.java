
class GenericStack<I> extends GenericList<I>{

    //Constructor

    GenericStack(I data){
        setHead(new Node<>(data));
        setLength(1);
    }

    GenericStack(){
        setHead(new Node<>());
        setLength(0);
    }

    void add(I data){
        if(getHead() == null){
            setHead(new Node<>(data));
            setLength(getLength()+1);
            return;
        }
        setHead(new Node<>(data,getHead()));
        setLength(getLength()+1);
    }
    void push(I data){
        add(data);
    }
    I delete(){
        if(getHead()== null)
            return null;
        I val = getData(getHead());
        setHead(getNext(getHead()));
        setLength(-1);
        return val;
    }
    I pop(){
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

