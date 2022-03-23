
public class quickSortAndPartition{
	
	public static int partition(int[] numbers, int lowIndex,int highIndex){
		int midpoint = lowIndex +(highIndex-lowIndex) /2;
		int pivot = numbers[midpoint];
		
		boolean done= false;
		while(!done) {
			while(numbers[lowIndex] <pivot) {
				lowIndex +=1;
				
			}
			
			while(pivot < numbers[highIndex]) {
				highIndex  -= 1;
			}
			
			if(lowIndex >= highIndex) {
				done=true;
			}
			else {
				int temp =numbers[lowIndex];
				numbers[lowIndex] = numbers[highIndex];
				numbers[highIndex] = temp;
				
				lowIndex +=1;
				highIndex -=1;
			}
		}
		
		System.out.println(pivot);
		for(int i=0; i< numbers.length; i++) {
			System.out.print(numbers[i]+ ",");
		}
//		System.out.print(numbers);
		return highIndex;
	}

	public static void main(String[] args) {
		int numbers[]= {35, 30, 20, 24, 79, 97, 95, 52, 50};
		
		partition(numbers,4,8);
		

	}

}
