
public class unique_hash {

	public unique_hash() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		String a = "Hhelo";
		System.out.println(check(a));

	}
	private static boolean check(String str) {
		// TODO Auto-generated method stub
		char[] array = str.toCharArray();
		int[] hash = new int[256];
		
		for (int i=0;i<array.length;i++){
			array[i]= Character.toLowerCase(array[i]);
			if(hash[array[i]%26] == 1) {
				return false;
			}
			else {
				hash[array[i]%256] = 1;
			}
			
			
		}
		return true;
	}
}
