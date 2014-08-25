package bekay.path

import java.util.regex.Matcher

class GPath {
	/*
	 * path1.path2.path3
	 * 
	 * 
	 */
	def static read ( obj, String gpath ) {
		
		def path = gpath.replaceAll(/\.\./, "##")
		List arr  = path.split(/\./)				
		
		arr.inject (obj) { acc, ele ->	
			
			Matcher matcher =  ele =~/(.*)\[(.+)\]/
			// When it's array
			if ( matcher.size() == 1 ) {
			
				
				// Actually it's impossible
				if ( matcher[0][1].size() == 0 ) {
					
					return acc[ matcher[0][2].toInteger() ]
					
				//[Number]	 ex [3]
				} else if (matcher[0][2].isNumber() ){
				
					return acc[ matcher[0][1]][matcher[0][2].toInteger() ]
				}	
				//TODO [Array]  ex [ 3,2,3...]
				
				
				//TODO [Range] ex [2..5]
				
			} else {
							
				return	acc[ele]
			}	
		}	
	}
	
}