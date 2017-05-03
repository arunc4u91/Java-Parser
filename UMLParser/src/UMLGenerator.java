import java.io.FileInputStream;
import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;

import japa.parser.ast.body.TypeDeclaration;

public class UMLGenerator {
	private static final int BUFFER_SIZE = 4096;
	public static List<String> list_obj = new ArrayList<>();
	public static List<String> interface_list = new ArrayList<>();
	String zipFilePath;
	String destDirectory;
	public static  StringBuilder sb;
	public UMLGenerator(String path) {
		this.zipFilePath =  path;//"C:\\Users\\arunc\\Desktop\\Test4.zip";
		path = path.replace("\\Test4.zip", "");
		this.destDirectory = path+"\\out";//"C:\\Users\\arunc\\Desktop\\input";
		this.sb = new StringBuilder();
		
	}
	public void unzip() throws IOException {
		File destDir = new File(this.destDirectory);
		if (!destDir.exists()) {
			destDir.mkdir();
		}

		ZipInputStream zipIn = new ZipInputStream(new FileInputStream(this.zipFilePath));

		ZipEntry entry = zipIn.getNextEntry();

		// iterates over entries in the zip file
		while (entry != null) {
			String filePath = this.destDirectory + "//" + entry.getName();
			if (!entry.isDirectory()) {
				// if the entry is a file, extracts it
				extractFile(zipIn, filePath);
			} else {
				// if the entry is a directory, make the directory
				File dir = new File(filePath);
				dir.mkdir();
			}
			zipIn.closeEntry();
			entry = zipIn.getNextEntry();
		}
		zipIn.close();
	}
	
	private void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
		byte[] bytesIn = new byte[BUFFER_SIZE];
		int read = 0;
		while ((read = zipIn.read(bytesIn)) != -1) {
			bos.write(bytesIn, 0, read);
		}
		bos.close();
	}
	
	private void extract(){
		try {
			this.unzip();
			
		} catch (Exception ex) {
			// some errors occurred
			ex.printStackTrace();
		}
	}
	
	public String getDest(){
		return this.destDirectory;
	}
	
	public static void main(String args[]) throws IOException, ParseException{
		
		UMLGenerator unzipper = new UMLGenerator(args[0]);
		unzipper.extract();
		String path = unzipper.getDest();
		//System.out.println(path);
        sb.append("@startuml\n");
        sb.append("skinparam classAttributeIconSize 0\n");
        sb.append("skinparam monochrome true\n");
        File[] fileList = new File(path).listFiles();
        for(int i=0;i<fileList.length;i++){
        	//System.out.println(fileList[i].getPath());
        	String name = fileList[i].getName();
        	list_obj.add(name.replaceAll(".java", ""));
        	list_obj.add("Collection<"+name.replaceAll(".java","")+">");
        }
        
        for(File obj:fileList){
        	if(obj.getName().contains(".java")) {
        		FileInputStream inputFile = new FileInputStream(obj.getAbsolutePath());
        		CompilationUnit compiler = JavaParser.parse(inputFile);
        		String content = compiler.toString();
        		if(content.contains("class"))
        			sb.append("class ");
        		else
        			sb.append("interface ");
        		List types = compiler.getTypes(); 
        		TypeDeclaration typeDec = (TypeDeclaration) types.get(0);
		        String className = typeDec.getName();
		        sb.append(className+"\n");
		        
		        ClassNodes interfaces = new ClassNodes("interfaces",className);
        		interfaces.visit(compiler, null);
        		ClassNodes classes = new ClassNodes("class",className);
        		classes.visit(compiler, null);
        		MethodNodes methods = new MethodNodes(className);
        		methods.visit(compiler,null);
        		ConstructorNodes constructor = new ConstructorNodes(className);
        		constructor.visit(compiler,null);
        		FieldNodes fields = new FieldNodes(className);
        		fields.visit(compiler,null);
        	}
        }
        sb.append("@enduml\n");
        UMLDiagram obj = new UMLDiagram(sb.toString(),unzipper.getDest(),args[1]);
//        //System.out.println(sb.toString());
        
	}
}


