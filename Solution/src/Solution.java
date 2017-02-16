
public class Solution {
	public int hammingDistance(int x, int y) {
		int z = x ^ y;
		int count=0;
		while (z > 0){
			z = z & z-1;
			count++;
		}
		
		return count;
        
        
    }
	
public int findComplement(int num) {
	
		int temp = num;
		int temp1 = 1;
		while (temp>0){
			
			temp = temp >> 1;
			num = num ^ temp1;
			temp1 = temp1<<1;
		}
	  return num ;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution obj = new Solution();
		System.out.println(obj.hammingDistance(1, 6));
		System.out.println(obj.findComplement(5));
	}

}








       






