import java.util.Iterator;

abstract class GenericList<I> implements CreateIterator<I>{
    ///Constructor for stack and queue
      private Node<I> head;
      private int length;


        //Will get tested on it for test cases
      /****
       *
       * Make data members private
       * Call getData()
       * getNext()
       *
       *
       *
       * */
    //Adjust length in add and delete
    ///Static Node in order to save values
    static class Node<T>{
        T data;
        Node<T> next;

        //Constructor
        Node(T data){
            this.data = data;
            this.next = null;
        }
        Node(T data,Node<T> next){
            this.data = data;
            this.next = next;
        }
        Node(){
            this.data = null;
            this.next = null;
        }

        public T getData(){
            return this.data;
        }
        public Node<T> getNext(){
            return this.next;
        }
    }

      protected Node<I> getHead() {
        return this.head;
        }//In order to access Node class
    protected void setHead(Node<I> new_head){
        this.head = new_head;
    }
      protected Node<I> getNext(Node<I> current){
        return current.next;
      }

      protected int getLength(){
        return this.length;
      }
      protected void setLength(int update){
          this.length += update;
      }
      protected I getData(Node<I> node){
        return node.data;
      }

    abstract void print();
    abstract void add(I data);
    abstract I delete();

    public Iterator<I> createIterator() {

        return new GLIterator<>(this);
    }

}
