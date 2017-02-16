
public class MergeSort {

	public MergeSort() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {3,8,7,5,2,1,9,6,4};
		int len = 9;
		MergeSort_Recursive(numbers,0,len-1);
		
		}

	private static void MergeSort_Recursive(int[] numbers, int left, int right) {
		// TODO Auto-generated method stub
			int mid;
			if(right>left){
				mid   = (right+left)/2;
				MergeSort_Recursive(numbers,left,mid);
				MergeSort_Recursive(numbers,mid+1,right);
				DoMerge(numbers,left,mid+1,right);
			}
		
	}

	private static void DoMerge(int[] numbers, int left, int mid, int right) {
		// TODO Auto-generated method stub
		int[] temp = new int[25];
		int i,left_end,num_elements,tmp_pos;
		left_end = (mid-1);
		tmp_pos = left;
		num_elements = (right-left+1);
		while((left<=left_end)&&(mid<=right)){
			if(numbers[left]<=numbers[mid])
				temp[tmp_pos++] = numbers[left++];
			else
				temp[tmp_pos++] = numbers[mid++];
			
		}
	}

	}


