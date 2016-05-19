package lecture3;

import java.util.Iterator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	DoubleLinkedList <Integer> dLList = new DoubleLinkedList<Integer>((1));
    	Iterator<Node<Integer>> iterator = dLList.iterator();
    	//Заполняем
    	dLList.add(2);
    	dLList.add(10);
    	dLList.add(13);
    	dLList.add(17);
    	dLList.add(65);
    	for(Node<Integer> node : dLList) {
    		System.out.println( node.getT());
  		}
    	System.out.println("list size = "+dLList.size());
    	//Сортируем
    	dLList.coctailSort();    	    	
    	if(iterator.hasNext()) {
    		iterator.next();
    	}
    	for(Node<Integer> node : dLList) {
    		System.out.println( node.getT());
    		}
    	System.out.println("list size = "+dLList.size());
    	//Удалили нулевой
    	dLList.removeElementByIndex(0);
    	for(Node<Integer> node : dLList) {
    		System.out.println( node.getT());
  		}
    	System.out.println("list size = "+dLList.size());
    	//Добавили назад
    	dLList.addElementByIndex(0,0);
    	for(Node<Integer> node : dLList) {
    		System.out.println( node.getT());
  		}
    	System.out.println("list size = "+dLList.size());
    	
    }
}