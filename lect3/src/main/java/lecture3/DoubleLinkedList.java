package lecture3;
import java.util.*;
import java.util.Iterator;

public class DoubleLinkedList  <E extends Comparable<E>> implements Iterable<E>,TwoWayIterable<E> {
 
	private Node<E> previous;
	private Node<E> next;
	private Node<E> head;
	private Node<E> tail;
    private int size = 0;
    private int modificationCounter =0;
    
    public DoubleLinkedList(E e) {
        this.head = new Node<E>(e);
		tail =  head;
		head.setPrevious(head);
		head.setNext(head);
		size++;
    }
    public DoubleLinkedList(){
    	this.head = new Node<E>();
		tail =  head;
		head.setPrevious(head);
		head.setNext(head);
    }
    
    public int size() {
       return this.size;
    }
 
    public boolean isEmpty() {
       return size() == 0;
    }
 
    public int getModificationCounter() {
    	return this.modificationCounter;
    }
    
    public void incrementModificationCounter() {
    	this.modificationCounter++;
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
    	incrementModificationCounter(); 
    	return true;
    }
    
	private Node<E> getNodeReferenceByIndex(int index) {
        Node<E> node = null;
        if (!isEmpty() && (index >= 0 && index < size)) {
            node = head;
            for(int i=1; i<=index; i++){
                node = node.getNext();
            }
        } else throw new IndexOutOfBoundsException();
        incrementModificationCounter(); 
        return node;
    }
 
    public E getElementByIndex(int index) {
        E element;
        if (index >= 0 && index < size()) {
            element = getNodeReferenceByIndex(index).getT();
        } else throw new IndexOutOfBoundsException();
        incrementModificationCounter(); 
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
    	incrementModificationCounter(); 
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
    	incrementModificationCounter(); 
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
    			if(!swapFlag) { 
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
    		}	while(swapFlag);
    	}
		incrementModificationCounter(); 
    }
   
    //map
      
    public static <F extends Comparable<F>, T extends Comparable<T>> DoubleLinkedList<T> map(DoubleLinkedList<F> from, NodeCast<? super F,? extends T> transformer) {
    	DoubleLinkedList<T> result = null;
        for (F element : from) {
        	if(result == null){
        		result = new DoubleLinkedList<T>(transformer.apply(element));
        	} else {
        		result.add(transformer.apply(element));
        	}
        }       
        return result;
    }
    //Constructors
    
    public Iterator<E> iterator() {
    	return new NodeIterator(this);
    }
    
    public TwoWayIterator<E> getIterator() {
    	return new MyDoubleLinkedListIterator(this);
    }	
    
    //Inner Classes
    
    private class MyDoubleLinkedListIterator implements TwoWayIterator<E> {
    	
    	Node<E> thisNode;
    	private int IteratorModifCounter;
    	
    	public MyDoubleLinkedListIterator(DoubleLinkedList<E> inputDoubleLinkedList){
        	thisNode = getNodeReferenceByIndex(0);
        	this.IteratorModifCounter = getModificationCounter();
        }
		
    	public E getNext() {
    		if(this.IteratorModifCounter == getModificationCounter()) {
    			incrementModificationCounter();
        		this.IteratorModifCounter = getModificationCounter();
    			thisNode = thisNode.getNext();
    			return thisNode.getT();
    		} else throw new ConcurrentModificationException();
		}

		public E getPrevious() {
			if(this.IteratorModifCounter == getModificationCounter()) {
				incrementModificationCounter();
        		this.IteratorModifCounter = getModificationCounter();
				thisNode = thisNode.getPrevious();
				return thisNode.getT();    	
			}else throw new ConcurrentModificationException();
		}
    }
    
    private class NodeIterator implements Iterator<E>{
        private int index;
        private int IteratorModifCounter;
        public NodeIterator(DoubleLinkedList<E> inputDoubleLinkedList){
        	
        	this.IteratorModifCounter = getModificationCounter();
        	this.index = -1;
        }

        public boolean hasNext() {
        	if(this.IteratorModifCounter == getModificationCounter()) {
        		incrementModificationCounter();
        		this.IteratorModifCounter = getModificationCounter();
        		return (index+1 < size() && !isEmpty());
        	} else throw new ConcurrentModificationException("throwed ConcurrentModificationException");
        }

        public E next() {
            if(this.IteratorModifCounter == getModificationCounter()) {
            	if(hasNext()){
            		index++;
            		E retE =getNodeReferenceByIndex(index).getT();
            		incrementModificationCounter();
            		this.IteratorModifCounter = getModificationCounter();
            		return retE;
            	}
            	throw new NoSuchElementException();
            } else throw new ConcurrentModificationException();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public class Node< T > {
   	 
        private Node<T> next;
        private Node<T> previous;
        private T t;
     
        public Node() {
            this.next = null;
            this.previous = null;
        }
        
        public  Node(Node<T> previous) {
            this.previous = previous;
    		this.next = null;
        }
        
        public Node(T inputT) {
        	this.next = null;
        	this.previous = null;
        	this.t = inputT;
        }
     
        public Node<T> getNext() {
            return next;
        }
     
        public void setNext(Node<T> next) {
            this.next = next;
        }
     
        public Node<T> getPrevious() {
            return previous;
        }
     
        public void setPrevious(Node<T> previous) {
            this.previous = previous;
        }
     
        public T getT() {
            return t;
        }
     
        public void setT(T t) {
            this.t = t;
        }
    }

}