package mb;

public class Stack {
	int size;
	int top = 0;
	Elem[] a;

	public Stack(int sz) {
		size = sz;
		a = new Elem[size];
	}

	public Stack Push(Elem e) {
		if (top == size - 1)
			System.out.println("Kein platz mehr vorhanden!");
		else
			a[top++] = e;
		return this;
	}

	public Stack Pop() {
		if (!isempty()) {
			a[top--] = null;
		} else {
			System.out.println("Kein Element zu löschen vorhanden.");
		}
		return this;
	}

	public Elem top() {
		if (!isempty())
			return a[top];
		else {
			System.out.println("Kein Element auf dem Stack vorhanden.");
		}
		return null;
	}

	public boolean isempty() {
		return a[0] == null;
	}

	public void Print(){
		for(int i = 0; i < size; i++){
			if(a[i] == null)
				System.out.println("[" + i + "] = NULL");
			else{
				System.out.println("["+i+"] = " + a[i]);
			}
		}
	}
}
