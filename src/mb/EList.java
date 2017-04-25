package mb;

public class EList {
	EPos head, last;
	
	public EList delete(EPos p){
		EPos q;
		if(isempty()){
			return this;
		}
		else{
			if(eol(p)){
				if(p == head){
					last = null;
					p.succ = null;
				}
				else{
					q = head;
					while(q.succ != p)
						q = q.succ;
					last = q;
					p.succ = null;
				}			
			}
			else{
				q = p.succ;
				if(q == last)
					last = p;
				p.succ = q.succ.succ;
			}
		}	
		return this;		
	}
	
	public boolean isempty(){
		if(last == null)
			return true;
		return false;
	}
	public boolean eol(EPos p){
		return p.succ == null;
	}
}
