// Aaron Lemmon
import java.util.Random;

public class RollToTwenty {
	// Testing:
	// 785934 -> 4 4
	//	     4 8
	//	     3 11
	//	     4 15
	//	     6 21
	public static void main(String[] args) {
		Random random;
		if (args.length > 0) {
			random = new Random(Integer.parseInt(args[0]));	
		} else {
			random = new Random();	
		}
		int count = 0;
		while (true) {
			int roll = random.nextInt(6) + 1;
			count += roll;
			System.out.println(roll + " " + count);
			if (count > 20) {
				break;	
			}
		}
	}
}