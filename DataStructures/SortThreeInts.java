// Aaron Lemmon
public class SortThreeInts {
	// Testing:
	// -5, 4, 8 -> -5, 4, 8
	// 8, 4, -5 -> -5, 4, 8
	// 1, 2, 3 -> 1, 2, 3
	// 1, 3, 2 -> 1, 2, 3
	// 2, 1, 3 -> 1, 2, 3
	// 2, 3, 1 -> 1, 2, 3
	// 3, 1, 2 -> 1, 2, 3
	// 3, 2, 1 -> 1, 2, 3
	public static void main(String[] args) {
		int n1 = Integer.parseInt(args[0]);
		int n2 = Integer.parseInt(args[1]);
		int n3 = Integer.parseInt(args[2]);
		if (n1 <= n2 && n2 <= n3) {
			System.out.println(n1);
			System.out.println(n2);
			System.out.println(n3);
		} else if (n1 <= n3 && n3 <= n2) {
			System.out.println(n1);
			System.out.println(n3);
			System.out.println(n2);
		} else if (n2 <= n1 && n1 <= n3) {
			System.out.println(n2);
			System.out.println(n1);
			System.out.println(n3);
		} else if (n2 <= n3 && n3 <= n1) {
			System.out.println(n2);
			System.out.println(n3);
			System.out.println(n1);
		} else if (n3 <= n1 && n1 <= n2) {
			System.out.println(n3);
			System.out.println(n1);
			System.out.println(n2);
		} else {
			System.out.println(n3);
			System.out.println(n2);
			System.out.println(n1);
		}
	}
}