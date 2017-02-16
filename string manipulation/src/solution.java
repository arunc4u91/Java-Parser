
public class solution {

	public solution() {
		
	}
	public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        
        	System.out.print(words[0]);
		return sb.toString();
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution a = new solution();
		System.out.println(a.reverseWords("The sky is blue"));
	}

}
