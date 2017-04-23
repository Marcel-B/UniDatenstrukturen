package mb;

public class start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List myList = new List();
		Pos currentPosition = myList.front();
		Int tmpValue = new Int();
		tmpValue.value = 42;
		myList = myList.insert(currentPosition, tmpValue);
		
		
		tmpValue = new Int();
		tmpValue.value = 22;
		
		currentPosition = myList.front();
		
		myList = myList.insert(currentPosition, tmpValue);
		
		System.out.println("Hello World");
		boolean test = myList.bol(currentPosition);
		System.out.println(test);
		
		Pos p = myList.find(new ElemTest(){
			public boolean check(Elem le){
				return (((Int)le).value) == 22;
			}
		});	
	}
}
