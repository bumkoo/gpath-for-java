gpath-for-java
==============

Extract object's elements with GPath in JAVA


    Object ele = GPath.read(new Dummy(), "attribObj.attribList[2].attrib5");		
		assertThat ( (Integer)ele , is ( 5 ));
