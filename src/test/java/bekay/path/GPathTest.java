package bekay.path;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class GPathTest {

	@Test
	public void testAttrib() {
		Object o = GPath.read(new Dummy(), "a");		
		System.err.println(o);
		assertThat ( (Integer)o , is ( new Integer(10) ));
	}
	
	
	@Test
	public void testGetter() {
		Object o = GPath.read(new Dummy(), "c");		
		System.err.println(o);
		assertThat ( (String)o , is ( "init with getter" ));
	}
	
	
	@Test
	public void testMap() {
		Object o = GPath.read(new Dummy(), "e.map.key1");		
		System.err.println(o);
		assertThat ( (Integer)o , is ( 10 ));
	}
	
	@Test
	public void testList() {
		Object o = GPath.read(new Dummy(), "d[0]");		
		System.err.println(o);
		assertThat ( (String)o , is ( "first" ));
	}
	
	
	public class Dummy {
		private int 	a ;
		private String 	c;
		private List 	d;  
		private Dummy2 e;  
		
		public Dummy() {
			a =  10;
			c = "init";
			d  = new ArrayList();
			d.add("first");
			d.add("second");
			e = new Dummy2() ; 
		}	
		
		public void setC ( String d) {
			this.c = c;
		}
		
		public String getC ( ) {
			return this.c + " with getter";
			
		}
	}
	
	public class Dummy2 {
		private Map map ;
		
		public Dummy2() {
			map = new HashMap();
			map.put("key1", 10);
			map.put("key2", "321");
		}
		
	}

}
