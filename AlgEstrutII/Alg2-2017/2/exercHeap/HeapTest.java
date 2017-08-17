package exercHeap;


import java.util.Scanner;

public class HeapTest {

  public static void main( String[] args ) {
    Heap H = new Heap();
    Heap heapMerge = new Heap();
    Heap heapQuick = new Heap();
    Heap heapHeapSort = new Heap();
    

    Scanner input = new Scanner( System.in );

    while ( input.hasNext() ) {
      String temp = input.next();

      if ( temp.equals( "quit" ) ) break;
      if ( temp.equals( "get" ) )  System.out.println( H.get() );
      if ( temp.matches( "[0-9]+" ) ){
    	  H.put( Integer.parseInt( temp ) );
    	  heapMerge.put( Integer.parseInt( temp ) );
    	  heapQuick.put( Integer.parseInt( temp ) );
    	  heapHeapSort.put( Integer.parseInt( temp ) );    	  
      }      
      H.print();      
    }
    
    //MERGESORT
    System.out.println("MergeSort: ");
    Mergesort ms = new Mergesort();
    long startTime = System.currentTimeMillis();
    ms.sort(heapMerge.getVector());    	
    long stopTime = System.currentTimeMillis();
    long elapsedTime = stopTime - startTime;
    System.out.println(elapsedTime);  
    heapMerge.print();
    
    //QUICKSORT
    System.out.println("QUICKSORT: ");
    Quicksort qs = new Quicksort(heapQuick.getVector());
    long startTime2 = System.currentTimeMillis();
    qs.sort();    	
    long stopTime2 = System.currentTimeMillis();
    long elapsedTime2 = stopTime2 - startTime2;
    System.out.println(elapsedTime2);
    heapQuick.print();
    
    //HEAPSORT
    System.out.println("HEAPSORT: ");
    long startTime3 = System.currentTimeMillis();
    heapHeapSort.sort();    	
    long stopTime3 = System.currentTimeMillis();
    long elapsedTime3 = stopTime3 - startTime3;
    System.out.println(elapsedTime3);
    heapHeapSort.print();  
    
  }
}
