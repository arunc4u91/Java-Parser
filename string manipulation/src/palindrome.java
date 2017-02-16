
public class palindrome {

	public palindrome() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "tact coa";
		check(word);
	}

	private static void check(String word) {
		// TODO Auto-generated method stub
		int space = 0;
		char[] chars = word.toCharArray();
		int[] hash = new int[26];
		for(int i=0;i<chars.length;i++){
			if (chars[i]!= ' '){
			int a = chars[i]%26;
			hash[a]+=1;
			}
			else
				space++;
		}
		for (int i=0;i<hash.length;i++)
			System.out.print(hash[i]);
		boolean flag = false;
		for(int i=0;i<hash.length;i++){
			if(hash[i]>2){
				System.out.println("false");
				break;
			}
			else if (hash[i]==1){
				if (flag == true){
					System.out.println("false");
					break;
				}
				else {
					flag = true;
				}
		}
			
		
		
	}
		System.out.println("true");
}
}
