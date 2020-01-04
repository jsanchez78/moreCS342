
public class GenericProjectClass {
	public static void main(String[] args) {
	}
}

class GenericList{
  private int length;
  private Node<T> head = null;
  //Constructor
  public GenericList(){
    this.length= 0;
    this.head = null;
  }
  public class Node<T>{
    private T data;
    private Node<T> next;
    //Constructor
    public Node(){
      this.data = null;
      this.next = null;
    }
    public Node(T data){
      this.data = data;
      this.next = null;
    }
    //Getter functions
    public T getData(){
      return this.data;
    }
    public Node<T> getNext(){
      return next;
    }
    //Setter function
    public void setData(T data){
      this.data = data;
    }
    public void setNext(Node<T> next){
      this.next = next;
    }
  }
//End of Node class
  public static void print(){
    Node tmp = this.head;
    while(tmp!=null){
      System.out.println(tmp.getData());
      tmp = tmp.getNext();
    }
  }
  public void abstractAdd(T data){
    Node newNode = new Node(data);
    if(head==null)
      front = newNode;
  }
  public static int delete(){
    int deletedValue;
    //Delted value
    if(head!=null){
      deletedValue = this.head.getData();
      this.head = this.head.getNext();
      this.length = this.length--;
      return deletedValue;
    }
    else{
      System.out.println("List is empty!");
      return -1;
    }
  }

}
///Inheritance
class GenericStack extends GenericList{
  //Stack Constructor
  public GenericStack(){
    this.length= 0;
    this.head = null;
  }
  public void add(T data){
    Node newNode = new Node(data);
    newNode.next = head;
    this.head = newNode;
    this.length = this.length++;
  }
}

public class GenericQueue extends GenericList{
  //Queue Constructor
  public GenericQueue(){
    this.length= 0;
    this.head = null;
}
public void enqueue(T data){
  Node newNode = new Node(data);
  Node curr = head;
  while(curr.getNext()!=null){
    curr = curr.getNext();
  }
  curr.setNext(newNode);
  this.length = this.length++;
}

}
