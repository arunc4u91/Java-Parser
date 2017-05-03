import java.util.*;
import japa.parser.ast.body.*;
import japa.parser.ast.stmt.*;
import japa.parser.ast.visitor.*;
public class MethodNodes extends VoidVisitorAdapter{
	private String classname;
	public MethodNodes(String className) {
		// TODO Auto-generated constructor stub
		this.classname = className;
	}
	

	@Override
	public void visit(MethodDeclaration obj, Object arg){
		
		String test = UMLGenerator.sb.toString();		
		String variables = "";
		if(obj.getParameters()!=null){
			for(Parameter parameter : obj.getParameters()){
				if(variables != "")
					variables = variables + "," + parameter.toString(); 
				else
					variables = parameter.toString();
				String temp = parameter.toString();
				if(UMLGenerator.list_obj.contains(temp)){
					String a = temp+"<.. "+this.classname+":uses";
					if(!test.contains(a)&&UMLGenerator.interface_list.contains(temp)&&UMLGenerator.interface_list.contains(this.classname))
						UMLGenerator.sb.append(a+"\n");
								
				}
			}
		}
		
			
		if(obj.getModifiers()==1||obj.getModifiers()==1025){		
			String b = this.classname+" : "+ "+" + obj.getName()+"("+variables+"):"+obj.getType()+"\n";
			UMLGenerator.sb.append(b);
			
		}
		
		
	}
	
}
