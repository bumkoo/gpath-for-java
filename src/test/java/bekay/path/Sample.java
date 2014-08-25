package bekay.path;

import java.util.ArrayList;
import java.util.List;

public class Sample {
	private int 	a ;
	public int 		b;
	private String 	c;
	private List 	d;  
	private Sample2 e;  
	
	public Sample() {
		a =  0;
		b =  0;
		c = "init";
		d  = new ArrayList();
		d.add("first");
		d.add("second");
		e = new Sample2() ; 
	}	
	
	public void setC ( String d) {
		this.c = c;
	}
	
	public String getC ( ) {
		return this.d + " with geter";
		
	}


}
