/**
 *
 * A class that implements a queue.  It is your job to complete this class.  Your queue
 * will use a linked list constructed by QueueElements.  However, your queue must be general and allow
 * setting of any type of Object.  Also you cannot use ArrayLists or arrays (you will get zero).
 * @author you
 *
 */

import java.util.NoSuchElementException;

public class Queue<T> {

	//TODO:  You need some data to store the queue.  Put the attributes here.
	private QueueElement<T> front;
	private QueueElement<T> back;

	/**
	 * Constructs an empty Queue.
	 */
	public Queue () {
		//TODO: Write the Queue constructor
		front = null;
		back = null;
	}

	/**
	 * Returns true if the queue is empty
	 */
	public boolean isEmpty () {
		//TODO:  Needs to return true when empty and false otherwise
		return ((front == null) && (back == null));
	}


	/**
	 * Returns the element at the head of the queue
	 */
	public T peek () throws NoSuchElementException {
		//System.out.println("FRONT " + (front.toString()));
		//System.out.println("BACK " + (back.toString()));
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return front.getElement();
	}

	/**
	 * Removes the front element of the queue
	 */
	public void dequeue () throws NoSuchElementException {
		//Dequeue code is neede here
		if (!isEmpty()) {
			if (front.getNext() == null) {
				back = null;
			}
			front = front.getNext();
		} else {
			throw new NoSuchElementException();
		}
	}

	/**
	 * Puts an element on the back of the queue.
	 */
	public void enqueue (T element) {
		//Enqueue code is needed here
		QueueElement<T> newElement = new QueueElement<>(element, back);
		if (isEmpty()) {
			front = newElement;
		} else {
			back.setNext(newElement);
		}
		back = newElement;
		back.setNext(null);
	}

	/**
	 * Method to print the full contents of the queue in order from head to tail.
	 */
	public void print () {
		//Code to print the code is needed here
		QueueElement<T> thisElement = front;
		while (thisElement != null) {
			System.out.println(thisElement.getElement());
			thisElement = thisElement.getNext();
		}
		//System.out.println("DONE!");
	}
}
