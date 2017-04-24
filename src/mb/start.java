package mb;

import java.util.Scanner;

public class start {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);

		List myList = new List();
		
		int n;
		do{
			n = nextInput(reader);		
			if(n < 0)
				break;
			Pos currentPosition = myList.front();
			Int tmpValue = new Int();
			tmpValue.value = n;	
			myList = myList.insert(currentPosition, tmpValue);
			myList.print();
		}while(true);
		System.out.println("Sie haben folgende Liste eingegeben:\n");
		myList.print();
		
		System.out.print("Möchten Sie eine Zahl löschen? (J/N) ");
		char o  = reader.next().toLowerCase().charAt(0);

		if(o == 'j'){
			delNumber(reader, myList);
			do{
				System.out.print("Noch eine Zahl löschen (J/N)? ");
				o  = reader.next().toLowerCase().charAt(0);
				if(o== 'n')
					break;
				delNumber(reader, myList);
			}while(true);
		}
		
		
		System.out.println("Ihre Liste:\n");
		myList.print();
		
		reader.close();
		System.out.println("End Program");

	}
	
	private static int nextInput(Scanner reader){

		System.out.print("Bitte geben Sie eine Zahl ein: ");
		int n = reader.nextInt();
		System.out.println("Sie haben " + n + " eingegeben");
		
		return n;
	}
	
	private static void delNumber(Scanner reader, List myList){
		System.out.print("Welche Zahl löschen? ");
		int m = reader.nextInt();

		Pos q = myList.find(new ElemTest(){
			public boolean check(Elem le){
				boolean check = (((Int)le).value) == m;
				return check;
			}
		});
		if(q != null)
		myList.delete(q);
		else{
			System.out.println("Fehler, Wert nicht vorhanden.");
		}
		myList.print();
	}
}
