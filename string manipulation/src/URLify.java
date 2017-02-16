
public class URLify {

	public URLify() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "Mr John Smith    ";
		char[] word = a.toCharArray();
		int truelength = 13;
		replace(word,truelength);
		
	}

	private static void replace(char[] word, int truelength) {
		// TODO Auto-generated method stub
		int spaces = 0;
		for (int i=0;i<truelength;i++) {
			if(word[i]==' ')
				spaces++;
		}
		int index = truelength+ spaces*2;
		System.out.println(spaces);
		if(truelength < word.length) word[truelength] = '\0';
		System.out.print(word);
		for(int i=truelength-1;i>=0;i--){
			if (word[i]==' '){
				word[index-1]= '0';
				word[index-2]= '2';
				word[index-3]= '%';
				index = index-3;
			}
			else{
				word[index-1]= word[i];
				index--;
			}
		}
		System.out.println(word);
	}

}
