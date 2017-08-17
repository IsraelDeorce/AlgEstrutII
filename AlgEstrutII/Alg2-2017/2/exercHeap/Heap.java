package exercHeap;

// Heap.java
public class Heap {

	private int v[];
	private int size;

	public Heap() {
		size = 1;
		v = new int[100];
		v[1] = 0;
	}
	/*
	 * //COMECANDO DO 0 private int left ( int i ) { return 2 * i + 1; } private
	 * int right ( int i ) { return 2 * i + 2; } private int parent ( int i ) {
	 * return (i-1) / 2; }
	 */

	private int left(int i) {
		return 2 * i;
	}

	private int right(int i) {
		return 2 * i + 1;
	}

	private int parent(int i) {
		return i / 2;
	}

	private void swim(int k) {
		while (k > 1 && v[k / 2] < v[k]) {
			System.out.println("Swap " + v[k] + " with " + v[k / 2] + " " + k);
			int tmp = v[k];
			v[k] = v[k / 2];
			v[k / 2] = tmp;
			k = k / 2;
		}
	}

	public void put(int data) {
		v[size] = data;
		swim(size);
		size++;
	}

	private void sink(int k) {
		while (2 * k <= size) {
			int j = 2 * k;
			if (j < size && v[j] < v[j + 1])
				j++;
			if (v[k] >= v[j])
				break;
			int tmp = v[k];
			v[k] = v[j];
			v[j] = tmp;
			k = j;
		}
	}

	public int get() {
		if (size == 1)
			throw new UnsupportedOperationException("Heap vazio!");
		int res = v[1];
		v[1] = v[--size];
		sink(1);
		return res;
	}

	private void print(int b, int elem, int sp) {
		int i, j;

		System.out.println("");
		for (j = 0; j < size; j++)
			System.out.print(v[j] + " ");
		System.out.println("");

		while (true) {
			for (j = 0; j <= sp / 2; j++)
				System.out.print(" ");
			for (i = b; i < b + elem; i++) {
				if (i == size)
					return;
				System.out.print(v[i]);
				for (j = 0; j < sp; j++)
					System.out.print(" ");
			}
			System.out.println("");
			b = b + elem;
			elem = 2 * elem;
			sp = sp / 2;
		}
	}

	public void print() {
		System.out.println("");
		print(1, 1, 32);
		System.out.println("");
	}

	public int[] getVector() {
		return v;
	}

	public void sort() {
		int n = v.length;
		for (int k = n/2; k >= 1; k--)
			sink(k);
		while (n > 1)
		{
			int aux = v[1];
			v[1] = v[n-1];
			n--;
			v[n] = aux;
			
			sink(1);
		}
   }
}
