package lecture3;
import java.util.*;
import java.util.Iterator;

public class DoubleLinkedList  <E extends Comparable<E>> implements Iterable<Node<E>>,TwoWayIterable<Node<E>> {
 
	private Node<E> previous;
	private Node<E> next;
	private Node<E> head;
	private Node<E> tail;
    private int size = 0;
 
    public DoubleLinkedList(E e) {
        this.head = new Node<E>(e);
		tail =  head;
		head.setPrevious(head);
		head.setNext(head);
		size++;
    }
 
    public int size() {
       return this.size;
    }
 
    public boolean isEmpty() {
       return size() == 0;
    }
 
  
    public boolean add(E e) {
    	Node<E> node = new Node<E>(e);
    	if(head == null){
    		head = node;
    		tail =  node;
    		head.setPrevious(node);
    		head.setNext(node);
    	}else {
    		node.setNext(head);
    		node.setPrevious(tail);
    		tail.setNext(node);
    		head.setPrevious(node);
    		tail = node;
    	}
    	size++;
    	return true;
    }
    
	private Node<E> getNodeReferenceByIndex(int index) {
        Node<E> node = null;
        if (!isEmpty() && (index >= 0 && index < size)) {
            node = head;
            for(int i=1; i<=index; i++){
                node = node.getNext();
            }
        }
        return node;
    }
 
    public E getElementByIndex(int index) {
        E element;
        if (index >= 0 && index < size()) {
            element = getNodeReferenceByIndex(index).getT();
        } else throw new IndexOutOfBoundsException();
        return element;
    }
          
    public boolean addElementByIndex(E newElement,int index ) {
    	if (index >= 0 && index < size()) {
    		Node<E> node = new Node<E>(newElement);
    		this.next = getNodeReferenceByIndex(index);
    		this.previous = next.getPrevious();
            node.setNext(next); 
            node.setPrevious(previous);
            previous.setNext(node);
            next.setPrevious(node);
            size++;
            if(index == 0){
            	head = node;
            }else if(index == (size-2)) {
            	tail = next;
            }
        } else throw new IndexOutOfBoundsException();
        return true;
    }
 
    public boolean removeElementByIndex(int index) {
    	if (index >= 0 && index < size()) {
    		this.next = getNodeReferenceByIndex(index).getNext();
    		this.previous = getNodeReferenceByIndex(index).getPrevious();
    		next.setPrevious(getNodeReferenceByIndex(index).getPrevious());
    		previous.setNext(getNodeReferenceByIndex(index).getNext());
    		size--;
            if(index == 0){
            	head = next;
            }else if(index == (size)) {
            	tail = previous;
            }
        } else throw new IndexOutOfBoundsException();
    	return true;
    }
 
    public void coctailSort() {
		if(size>1) {
			int firstUnsortedElement = 0;
    		int lastUnsortedElement = size-1;
    		boolean swapFlag = false;
    		E swapNodeReference = null; 
    	
    		do {
    			for(int i = firstUnsortedElement; i < lastUnsortedElement; i++) {
    				/*if(inputArray[i] > inputArray[i+1])*/
    				if(getNodeReferenceByIndex(i).getT().compareTo(getNodeReferenceByIndex(i+1).getT()) > 0) {

    					swapNodeReference = getNodeReferenceByIndex(i).getT();
    					getNodeReferenceByIndex(i).setT(getNodeReferenceByIndex(i+1).getT());
    					getNodeReferenceByIndex(i+1).setT(swapNodeReference);
    					
    					swapFlag = true;
    				}
    			}
    			lastUnsortedElement--;
    			if(swapFlag == false) { 
    				break;
    			}
    			swapFlag = false;
    			for(int i = lastUnsortedElement; i > firstUnsortedElement; i-- ) {
    				/*if(inputArray[i] < inputArray[i-1])*/ 
    				if(getNodeReferenceByIndex(i).getT().compareTo(getNodeReferenceByIndex(i-1).getT()) < 0) {
    					swapNodeReference = getNodeReferenceByIndex(i).getT();
    					getNodeReferenceByIndex(i).setT(getNodeReferenceByIndex(i-1).getT());
    					getNodeReferenceByIndex(i-1).setT(swapNodeReference);
    					swapFlag = true;
    				}
    			}
    			firstUnsortedElement++;
    		}	while(swapFlag == true);
    	}
    	else {
    		return;
   	 	}
    }
   
    //Constructors
    
    public Iterator<Node<E>> iterator() {
    	return new NodeIterator(this);
    }
    
    public TwoWayIterator<Node<E>> getIterator() {
    	return new MyDoubleLinkedListIterator(this);
    }	
    
    //Inner Classes
    
    private class MyDoubleLinkedListIterator implements TwoWayIterator<Node<E>> {

    	Node<E> thisNode;
    	public MyDoubleLinkedListIterator(DoubleLinkedList<E> inputDoubleLinkedList){
        	thisNode = getNodeReferenceByIndex(0);
        }
		public Node<E> getNext() {
			thisNode = thisNode.getNext();
			return thisNode;
		}

		public Node<E> getPrevious() {
			thisNode = thisNode.getPrevious();
			return thisNode;    	
		}
    }
    
    private class NodeIterator implements Iterator<Node<E>>{
        private int index;
        
        public NodeIterator(DoubleLinkedList<E> inputDoubleLinkedList){
        	this.index = -1;
        }

        public boolean hasNext() {
        	return (index+1 < size() && !isEmpty());
        }

        public Node<E> next() {
            if(hasNext()){
            	 index++;
                 //System.out.println("This is "+ index);
                 return getNodeReferenceByIndex(index);
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }


}