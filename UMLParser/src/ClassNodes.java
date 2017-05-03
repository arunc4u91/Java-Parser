import java.util.*;
import japa.parser.ast.body.*;
import japa.parser.ast.type.*;
import japa.parser.ast.visitor.*;

public class ClassNodes extends VoidVisitorAdapter {
	private String mnemonic;
	private String classname;
	public ClassNodes(String mnemonic, String className) {
		// TODO Auto-generated constructor stub
		this.mnemonic = mnemonic;
		this.classname = className;
	}
	
	@Override
	public void visit(ClassOrInterfaceDeclaration decl,Object arg ) {
		
		switch (this.mnemonic) {
		case "interfaces": interfaces(decl,arg); break;
		case "class": classes(decl,arg); break;
		
		}
		
	}

	private void classes(ClassOrInterfaceDeclaration decl, Object arg) {
		LinkedList<ClassOrInterfaceType> obj =  (LinkedList<ClassOrInterfaceType>) decl.getExtends();
		
		if(obj != null)
		{
			
			for(ClassOrInterfaceType i : obj){
				String classes = i.toString();
			    UMLGenerator.sb.append(classes+" "+"<|-- "+this.classname+"\n");
			    
			}
		}
	}

	private void interfaces(ClassOrInterfaceDeclaration decl, Object arg) {
		// TODO Auto-generated method stub
		LinkedList<ClassOrInterfaceType> obj =  (LinkedList<ClassOrInterfaceType>) decl.getImplements();
		
		if(obj != null)
		{
			String test = UMLGenerator.sb.toString();
			for(ClassOrInterfaceType i : obj){
				String interfaces = i.toString();
				String arg0 = interfaces+"<|.. "+this.classname;
				String arg1 = interfaces+"<.. "+this.classname+".uses";
				UMLGenerator.interface_list.add(interfaces);
				if(!test.contains(arg0)&&!test.contains(arg1))
			    UMLGenerator.sb.append(interfaces+" "+"<|.. "+this.classname+"\n");
			    
			}
			
			
		}
		

	}

	
}
