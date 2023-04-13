
public class Stocks {
	
	int id;
	String item;
	String name;
	
	public Stocks() {
	}
	
	public Stocks(int id,String item) {
		this.id=id;
		this.item=item;
	}
	
	public Stocks(int id,String item,String name) {
		this.id=id;
		this.item=item;
		this.name=name;
	}
	
	public void printInfo() {
		System.out.println("id:"+id+" item:"+item+" name:"+name);
	}

}
