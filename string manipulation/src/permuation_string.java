import java.util.Arrays;

public class permuation_string {

	public permuation_string() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "abc";
		String b = "bca";
		System.out.println(check(a,b));

	}

	private static boolean check(String a, String b) {
		// TODO Auto-generated method stub
		char[] array1 = a.toCharArray();
		char[] array2 = b.toCharArray();
		int[] hash1 = new int[256];
		int[] hash2 = new int[256];
		if (array1.length != array2.length) return false;
		for (int i=0;i<array1.length;i++){
			array1[i]= Character.toLowerCase(array1[i]);
			array2[i]= Character.toLowerCase(array2[i]);
			hash1[array1[i]%256] += 1;
			hash2[array2[i]%256] += 1;
		}
		if (Arrays.equals(hash1,hash2)) return true;
		return false;
	}

}
