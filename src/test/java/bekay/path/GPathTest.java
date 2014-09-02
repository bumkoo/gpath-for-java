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
		Object o = GPath.read(new Dummy(), "attrb10");		
		System.err.println(o);
		assertThat ( (Integer)o , is ( new Integer(10) ));
	}
	
	
	@Test
	public void testAttribWithGetter() {
		Object o = GPath.read(new Dummy(), "attribTenWithGetter"); 		
		System.err.println(o);
		System.err.println(o);
		assertThat ( (String)o , is ( "Ten with getter" ));
	}
	
	
	@Test
	public void testPathWithObject() {
		Object o = GPath.read(new Dummy(), "attribObj.attribMap.key1");		
		System.err.println(o);
		assertThat ( (Integer)o , is ( 9 ));
	}
	
	@Test
	public void testPathWithIndex() {
		Object o = GPath.read(new Dummy(), "attribObj.attribList[0]");		
		System.err.println(o);
		assertThat ( (Integer)o , is ( 6 ));
	}
	
	@Test
	public void testPathWhenIndexIsMiddleOfPath() {
		Object o = GPath.read(new Dummy(), "attribObj.attribList[2].attrib5");		
		System.err.println(o);
		assertThat ( (Integer)o , is ( 5 ));
	}
	
	
	public class Dummy {
		private int 	attrb10  =  10;
		private String 	attribTenWithGetter  = "Ten";
		private Dummy2  attribObj = new Dummy2() ; 
						
		public String getAttribTenWithGetter ( ) {
			return this.attribTenWithGetter + " with getter";
			
		}
	}
	
	public class Dummy2 {
		private Map  attribMap ;
		private List attribList ;
		
		public Dummy2() {
			this.attribMap = new HashMap();
			this.attribMap .put("key1", 9);
			
			this.attribList = new ArrayList();
			this.attribList.add(6);
			this.attribList.add("SIX");
			this.attribList.add(new Dummy3());
			
		}
		
	}

	public class Dummy3 {
		private int  attrib5 = 5;
		
	}
	
}
