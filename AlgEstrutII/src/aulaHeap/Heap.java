package aulaHeap;

//Heap.java
public class Heap {

	private int v[];
	private int size;

	public Heap() {
		size = 0;
		v = new int[30];
	}

	private int left(int i) {
		return 2 * i + 1;
	}

	private int right(int i) {
		return 2 * i + 2;
	}

	private int parent(int i) {
		return (i - 1) / 2;
	}

	private void sift_up(int pos) {
		if (pos == 0)
			return;

		int pai = parent(pos);

		if (v[pai] < v[pos]) {
			int aux = v[pai];
			v[pai] = v[pos];
			v[pos] = aux;
			sift_up(pai);
		}

	}

	public void put(int data) {
		v[size] = data;
		//sift_up removido para testar o fazHeap!
		//sift_up( size );
		size++;
	}

	private void sift_down(int pos) {
		int ptroca = pos;
		int pLeft = left(pos);
		int pRight = right(pos);

		if (pLeft < size && v[pLeft] > v[pos])
			ptroca = pLeft;
		if (pRight < size && v[pRight] > v[ptroca])
			ptroca = pRight;
		if (ptroca == pos)
			return;

		int aux = v[ptroca];
		v[ptroca] = v[pos];
		v[pos] = aux;
		sift_down(ptroca);
	}

	public int get() {
		int res = v[0];
		v[0] = v[--size];
		sift_down(0);
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

	private void fazHeap(int pos) {

		int ptroca = pos;
		int pLeft = left(pos);
		int pRight = right(pos);

		if (pos >= size)
			return;

		fazHeap(pLeft);
		fazHeap(pRight);

		if (pLeft < size && v[pLeft] > v[pos])
			ptroca = pLeft;
		if (pRight < size && v[pRight] > v[ptroca])
			ptroca = pRight;
		if (ptroca == pos)
			return;

		int aux = v[ptroca];
		v[ptroca] = v[pos];
		v[pos] = aux;

		fazHeap(ptroca);

	}

	public void fazHeap() {
		fazHeap(0);
	}

	public void print() {
		System.out.println("");
		print(0, 1, 64);
		System.out.println("");
	}

}
