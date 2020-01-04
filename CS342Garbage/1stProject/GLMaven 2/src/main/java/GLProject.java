import java.util.Iterator;

public class GLProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello generic lists");
		
		GenericQueue<Integer> q = new GenericQueue<Integer>(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		
		Iterator<Integer> i = q.createIterator();
		
		while(i.hasNext()) {
			System.out.println(i.next());
		}
		
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		
		q.print();
	}

}
