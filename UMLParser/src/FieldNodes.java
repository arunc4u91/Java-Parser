import japa.parser.ast.body.*;
import japa.parser.ast.visitor.VoidVisitorAdapter;
public class FieldNodes extends VoidVisitorAdapter{
	String classname;
	public FieldNodes(String className) {
		// TODO Auto-generated constructor stub
		this.classname = className;
	}

    @Override
    public void visit(FieldDeclaration obj, Object arg) {
    	int no;
    	String test = UMLGenerator.sb.toString();
    	boolean collection = false;
    	boolean first = false;
    	String str = obj.getType().toString();
    	if(UMLGenerator.list_obj.contains(str)){
    		String src = "";
    		String rep = "";
    		if(str.contains("Collection")){
    			no = UMLGenerator.list_obj.indexOf(str)-1;
    			collection = true;
    		}
    		else
    			no = UMLGenerator.list_obj.indexOf(str);
    		if(test.contains(" "+UMLGenerator.list_obj.get(no)+" - \"1\" " + this.classname)&& collection==false){
    			 src = UMLGenerator.list_obj.get(no)+" - \"1\" "+this.classname;
    			 rep = UMLGenerator.list_obj.get(no)+"\"1\" - \"1\" " + this.classname;
    			 first = true; 
    		}
    		else if(test.contains(" "+UMLGenerator.list_obj.get(no)+" - \"1\" " + this.classname)&& collection==true){
    		     src = UMLGenerator.list_obj.get(no)+" - \"1\" "+this.classname;
    			 rep = UMLGenerator.list_obj.get(no)+"\"*\" - \"1\" " + this.classname;	
    			 first = true;
    		}
    		else if(test.contains(UMLGenerator.list_obj.get(no) + " - \"*\" " + this.classname ) && collection == false){
    			 src = UMLGenerator.list_obj.get(no) + " - \"*\" " + this.classname;
    			 rep = UMLGenerator.list_obj.get(no) + "\"1\" - \"*\" " + this.classname;
    			 first = true;
    		}
    		else if(test.contains(UMLGenerator.list_obj.get(no) + " - \"*\" " + this.classname ) && collection == true){
    			 src = UMLGenerator.list_obj.get(no) + " - \"*\" " + this.classname;
    			 rep = UMLGenerator.list_obj.get(no) + "\"*\" - \"*\" " + this.classname;
    			 first = true;
    			
    		}
    		if (first == true){
    			test.replace(src,rep);
    		} else {
    			if(collection==false){
    				test= test+this.classname+ " - \"1\" "  + UMLGenerator.list_obj.get(no) + "\n";
    			}
    			else
    				test = test+this.classname+ " - \"*\" "  + UMLGenerator.list_obj.get(no) + "\n";
    		}
    		
    
    
    	}
    	UMLGenerator.sb.setLength(0);
    	UMLGenerator.sb.append(test);
    	getAttributes(obj,null);
    	
    	
    	
	
    }

	private void getAttributes(FieldDeclaration obj, Object object) {
		String a = obj.toString();
		String test = UMLGenerator.sb.toString();
		String[] attrib = a.split("\\s+");
		if(a.contains("public"))
			attrib[0] = "+";
		else if (a.contains("private")){
			if(test.contains("set"+attrib[2])&&test.contains("get"+attrib[2]))
				attrib[0] = "+";
			else
				attrib[0] = "-";
		}
		else
			return;
		if(attrib.length>2){
			test = test + this.classname+" : " +attrib[0]+" "+attrib[2]+" : "+attrib[1]+"\n";
			attrib[2] = Character.toUpperCase(attrib[2].charAt(0)) + attrib[2].substring(1);
	        String rep1 = "get" + attrib[2];
	        String rep2 = "set" + attrib[2];
	    
	       
	         test = test.replaceAll( ".*"+rep1+".*(\r?\n|\r)?", "" );
	         test = test.replaceAll( ".*"+rep2+".*(\r?\n|\r)?", "" );
	       
		}
		UMLGenerator.sb.setLength(0);
    	UMLGenerator.sb.append(test);
    	super.visit(obj,null);
		
	}	
	
}
