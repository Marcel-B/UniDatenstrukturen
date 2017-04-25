package mb;

public class Queue {

	int first = 0;
	int last = 0;
	int size;
	Elem[] a;

	public Queue(int sz) {
		size = sz;
		a = new Elem[size];
	}

	public Elem front() {
		return a[first];
	}

	public Queue enqueue(Elem e) {
		System.out.println("Last: " + last);
		System.out.println("First: " + first);

		if (isempty()) {
			a[last++] = e;
			return this;
		}
		if (last == size) {
			if (first > 0) {
				last = 0;
			} else {
				System.out.println("Kein Platz mehr in der Queue!");
				return this;
			}
		} else if (last == first) {
			System.out.println("Kein Platz mehr in der Queue!");
			return this;
		}
		a[last++] = e;
		return this;
	}

	public Queue dequeue() {
		a[first++] = null;
		if (first == size)
			first = 0;
		return this;
	}

	public boolean isempty() {
		return a[first] == null;
	}

	public void print() {
		int n = first;
		for (int i = 0; i < size; i++) {
			System.out.println("[" + i + "][" + n + "] = " + a[i]);
			n++;
			if (n == size)
				n = 0;

		}
	}
}
