package Heap;

public class Heap {
	
	private int[] v;
	private int size;
	
	public Heap(){
		v = new int[10];
		size = 0;
	}
	
	public int right(int i) {
		return 2 * i + 2;
	}
	
	public int left(int i) {
		return 2 * i + 1;
	}
	
	public int parent(int i) {
		return (i - 1) / 2;
	}
	
	public void put(int data) {
		if(size >= v.length) return;
		v[size] = data;
		sift_up(size);
		size++;
	}
	
	public void sift_up(int pos) {
		if(pos == 0)
			return;
		int pai = parent(pos);
		if(v[pai] < v[pos]){
			int aux = v[pai];
			v[pai] = v[pos];
			v[pos] = aux;
			sift_up(pai);
		}		
	}
	
	public int get(){
		if(size <= 0) {
			return -1;
		}
		int res = v[0];
		v[0] = v[size - 1];
		size--;
		sift_down(0);
		return res;
	}
	
	public void sift_down(int pos){
		int pTroca = pos;
		int pLeft = left(pos);
		int pRight = right(pos);
		
		if(pLeft < size && v[pLeft] > v[pos])
			pTroca = pLeft;
		if(pRight < size && v[pRight] > v[pTroca])
			pTroca = pRight;
		if(pTroca == pos)
			return;
		
		int aux = v[pTroca];
		v[pTroca] = v[pos];
		v[pos] = aux;
		sift_down(pTroca);			
	}
	
	
	//O método fazHeapRuim utiliza o sift_down. 
	//É um método porco do Heap-Sort para ordenar o Heap.
	public void fazHeapRuim(){
		fazHeapRuim(0);
	}	
	public void fazHeapRuim(int pos){
		if(pos>=size) return;
		
		int pTroca = pos;
		int pLeft = left(pos);
		int pRight = right(pos);
		
		fazHeapRuim(pLeft);
		fazHeapRuim(pRight);		
		
		if(pLeft < size && v[pLeft] > v[pos])
			pTroca = pLeft;
		if(pRight < size && v[pRight] > v[pTroca])
			pTroca = pRight;
		if(pTroca == pos)
			return;
		
		int aux = v[pTroca];
		v[pTroca] = v[pos];
		v[pos] = aux;
		
		fazHeapRuim(pTroca);	
	}
	
	
	public void HeapSort(int[] h){
		int metade = (h.length-1)/2;
		heapParteUm(h, metade);
		for(int i = 1; i!=v.length; i++){
			int aux = v[h.length-i];		
			v[h.length-i] = v[0];
			v[0] = aux;
			heapParteDois(0,h.length-i);	
		}
	}
	public void heapParteUm(int[] h, int tamanho){
		while(tamanho >= 0){
			sift_down(h[tamanho]);
			tamanho = tamanho - 1;
		}	
	}
	public void heapParteDois(int pos, int tamanho){
		int pTroca = pos;
		int pLeft = 2 * pos + 1;
		int pRight = 2 * pos + 2;
		
		if(pLeft < tamanho && v[pLeft] > v[pos]){
			pTroca = pLeft;
		}
		if(pRight < tamanho && v[pRight] > v[pLeft]) {
			pTroca = pRight;
		}
		if(pTroca == pos){
			return;
		}
		
		int aux = v[pTroca];
		v[pTroca] = v[pos];
		v[pos] = aux;
		heapParteDois(pTroca, tamanho);		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int[] getHeap(){
		return v;
	}
	
	public int getSize(){
		return size;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
