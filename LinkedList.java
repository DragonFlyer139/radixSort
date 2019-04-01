
public class LinkedList 
{
	private Node front;
	
	public LinkedList()
	{
		front = null;
	}
	
	public void insertFront(long d)
	{
		Node newNode = new Node(d);
		newNode.setNext(front);
		front = newNode;
	}
	
	public long removeFront()
	{
		long temp = front.getData();
		front = front.getNext();
		return temp;
	}
	
	public void insertRear(long d)
	{
		Node current = front;
		if (isEmpty())
			insertFront(d);
		else
		{
			while (current.getNext() != null)
				current = current.getNext();
			Node newNode = new Node(d);
			current.setNext(newNode);
			newNode.setNext(null);
		}
	}
	
	public long removeRear()
	{
		Node current = front;
		while (current.getNext().getNext() != null)
			current = current.getNext();
		long temp = current.getNext().getData();
		current.setNext(null);
		return temp;
	}
	
	public boolean isEmpty()
	{
		return (front == null);
	}
}
