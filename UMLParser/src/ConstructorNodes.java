import japa.parser.ast.body.*;
import japa.parser.ast.visitor.*;
public class ConstructorNodes extends VoidVisitorAdapter {
	private String classname;
	public ConstructorNodes(String className) {
		this.classname = className;
	}
	
	@Override
	public void visit(ConstructorDeclaration obj, Object arg){
		String test = UMLGenerator.sb.toString();
		String variables = null;
		if(obj.getParameters()!=null){
			for(Parameter i : obj.getParameters()){
				if(variables!=null)
					variables = variables+","+i.toString();
				else
					variables = i.toString();
				String temp = i.getType().toString();
				if(UMLGenerator.list_obj.contains(temp)){
					String str = temp+"<.. "+this.classname+":uses\n";
					if(!test.contains(str)&&UMLGenerator.interface_list.contains(temp)&&!UMLGenerator.interface_list.contains(this.classname))
						UMLGenerator.sb.append(str);
				}
			}
			UMLGenerator.sb.append(this.classname+" : "+"+"+obj.getName()+"("+variables+")\n");
		}
		else
			UMLGenerator.sb.append(this.classname+" : "+"+"+obj.getName()+"()\n");
		
		
	
	}
}
