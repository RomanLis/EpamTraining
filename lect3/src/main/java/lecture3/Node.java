package lecture3;

//@SuppressWarnings("rawtypes")
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