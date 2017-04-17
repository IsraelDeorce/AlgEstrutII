package Heap;

public class App {
	
	public static void main(String args[]) {
		Heap h = new Heap();
		int[] vetor = h.getHeap();
		
		h.put(5);		
		h.put(1);		
		h.put(2);		
		h.put(3);		
		h.put(8);		
		h.put(7);		
		h.put(4);	
				
		for(int i = 0; i < vetor.length; i++) {
			System.out.print(vetor[i]);
		}	
		
		for(int i = 0; i < vetor.length; i++) {				
			while(h.get()!=-1){
				System.out.println();
				for(int j = 0; j < vetor.length; j++) {
					System.out.print(vetor[j]);
				}
			}
		}
		
		
	}

}
