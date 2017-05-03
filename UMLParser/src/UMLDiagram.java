import java.io.*;
import net.sourceforge.plantuml.*;
public class UMLDiagram {
	public UMLDiagram(String src,String dest_path,String file) throws IOException{
		OutputStream obj = null;
		obj = new FileOutputStream(dest_path+"//"+file);
		SourceStringReader text = new SourceStringReader(src);
		text.generateImage(obj);
	}
}
