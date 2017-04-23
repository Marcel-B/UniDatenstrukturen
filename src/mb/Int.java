package mb;

public class Int implements Elem {
	int value;
	public String toString(){
		return new String(Integer.toString(value, 10));
	}
}
