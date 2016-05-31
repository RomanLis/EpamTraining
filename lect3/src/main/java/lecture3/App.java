package lecture3;

import java.util.ConcurrentModificationException;

public class App 
{
    public static void main( String[] args )
    {
    	DoubleLinkedList <Integer> dLList = new DoubleLinkedList<Integer>((1));
  
    	//Заполняем
    	dLList.add(2);
    	dLList.add(10);
    	dLList.add(13);
    	dLList.add(17);
    	dLList.add(65);
    	//Получили итератор
      	//Iterator<Integer> iterator = dLList.iterator();
    	//Вывели
      	for(Integer value : dLList) {
    		System.out.println( value);
  		}
    	System.out.println("list size = "+dLList.size());

    	//Сортируем
    	dLList.coctailSort();
    	
    	//Вывели
    	for(Integer value : dLList) {
    		System.out.println( value);
    		}
    	System.out.println("list size = "+dLList.size());
    	
    	//Удалили
    	dLList.removeElementByIndex(0);    	
    	for(Integer value : dLList) {
    		System.out.println(value);
  		}
    	System.out.println("list size = "+dLList.size());
    	
    	//Добавили назад
    	dLList.addElementByIndex(0,0);
    	for(Integer value : dLList) {
    		System.out.println(value);
  		}
    	System.out.println("list size = "+dLList.size());
    	
    	//Анонимный класс
    	NodeCast<Integer,Double> inToDouble = new NodeCast<Integer,Double>() {

			public Double apply(Integer from) {
				double to = from;
				return to;
			}	    	
	    };
	   
	    //Вызов map
	    DoubleLinkedList<Double> doubleList = DoubleLinkedList.map(dLList, inToDouble);
	    
	    //Вывели
	    try {
	    	for(Double value : doubleList) {
	    		System.out.println(value);
	    		//Бросили поймали
	    		doubleList.add(42.0);
	    		//doubleList.addElementByIndex(42.0,100);
	    	}
	    } catch (ConcurrentModificationException exception) {
	    	System.out.println("Catched "+exception);
	    } catch (IndexOutOfBoundsException exception) {
	    	System.out.println("Catched "+exception);
	    }
	    
    }
}