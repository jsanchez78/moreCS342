import java.util.Iterator;

public class GLProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericQueue<Integer> q = new GenericQueue<>();
		GenericStack<Integer> s = new GenericStack<>();

		q.enqueue(1);
		q.enqueue(2);
		q.enqueue(3);
		q.enqueue(4);
		q.dequeue();

		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.pop();

		Iterator<Integer> it_stack = s.createIterator();
		Iterator<Integer> it_queue = q.createIterator();

		s.print();
		q.print();
		
		while (it_queue.hasNext()){
			System.out.println(it_queue.next());
		}

		while (it_stack.hasNext()){
			System.out.println(it_stack.next());
		}

	}

}
