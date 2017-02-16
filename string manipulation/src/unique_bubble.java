
public class unique_bubble {

	public unique_bubble() {
		// TODO Auto-generated constructor stub
	}
	public static boolean check(String str){
		for (int i=0; i<str.length();i++){
			for(int j=i+1;j<str.length();j++){
				if(str.charAt(i)==str.charAt(j))
					return false;
			}
		}
		return true;
		
	}

	public static void main(String[] args) {
		String a = "helo";
		System.out.println(check(a));

	}

}
