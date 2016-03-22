public class Test {
  public static void main(String[] args) {
  	LinkedChainList<Integer> list = new LinkedChainList<Integer>();

  	list.add(2); 
  	list.add(5); 
  	list.add(8); 
  	list.add(11);

  	Object[] array = list.toArray();
 		for (int i=0; i<array.length; i++) {
 			System.out.println("Data: " + array[i]);
 		}

 		Iterator itr = list.getIterator();
 		while(itr.hasNext()) {
       Object element = itr.next();
       System.out.print("Data: " + element);
    }
  }
}