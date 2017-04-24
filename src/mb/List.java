package mb;

public class List extends Pos {
	public List(){
		System.out.println("Neue List erstellt");
	}
	public Pos front(){
		return this;
	}
	
	public List insert(Pos p, Elem e){
		Pos q = new Pos();
		q.value = e;
		if(!(eol(p) || isempty())){
			q.pred = p;
			q.succ = p.succ;
			p.succ.pred = q;
			p.succ = q;
		}
		else{
			q.pred = p;
			q.succ = null;
			p.succ = q;
			pred = q;
		}
		return this;
	}
	
	public List concat(List list2){
		if(this.isempty())
			return list2;
		else if(list2.isempty())
			return this;
		else{
			Pos p = this.pred;
			Pos q = list2.next(list2.front());
			p.succ = q;
			q.pred = p;
			this.pred = list2.pred;
			list2.reset();
			return this;
		}
	}
	
	public Pos find(ElemTest test){
		Pos p = this;
		while(!eol(p)){
			p = next(p);
			if(test.check(p.value))
				return p;
		}
		return null;
	}
	
	public Pos next(Pos p){	
	//	if(eol(p.succ))
		//	return null;
		return p.succ;
	}
	
	public Pos pervious(Pos p){
		if(bol(p.pred))
			return null;
		return p.pred;
	}
	
	public List delete(Pos p){
		if(p.succ == null){// Das letzte Element
			p.pred.succ = null;
			this.pred = p.pred;
			return this;
			}

			p.pred.succ = p.succ;
		p.pred = p.succ.pred;		
		return this;
	}
	
	public boolean eol(Pos p){
		return (p.succ == null);
	}
	
	public boolean bol(Pos p){
		return p == this;
	}
	
	public boolean isempty(){
		return this.succ == null;
	}
	
	public void reset(){
		// TODO - Liste löschen
	}
	
	public void print(){
		if(succ == null)
			return;
		Pos now = succ;
		int cnt = 0;
		while(now != null){
			String value = now.value.toString();
			System.out.println("["+cnt++ +"]= " + value);
			now = now.succ;
		}
	}
}
