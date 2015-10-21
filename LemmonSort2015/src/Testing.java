import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Testing {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
//		String input = "0.123456789";
//		int prefixValue = (input.charAt(2) + input.charAt(3) + input.charAt(4) + input.charAt(5) + 8) % 10;
//		System.out.println(prefixValue);
//		long longValue = (9 - prefixValue) * 1000000000L + input.charAt(2) * 100000000L + input.charAt(3) * 10000000L + input.charAt(4) * 1000000L +
//				input.charAt(5) * 100000L + input.charAt(6) * 10000L + input.charAt(7) * 1000L + input.charAt(8) * 100L +
//				input.charAt(9) * 10L + input.charAt(10) - 5333333328L;
//		System.out.println((9 - prefixValue) * 1000000000L + input.charAt(2) * 100000000L);
//		System.out.println(longValue);
//		Class c = String.class;
//		Field fieldGetter = String.class.getDeclaredField("value");
//		fieldGetter.setAccessible(true);
//		String thing = "Hello";
//		final char[] data = (char[]) fieldGetter.get(thing);
//		System.out.println(data[0]);
//		System.out.println(((char[]) fieldGetter.get(thing))[0]);
		int[] stuff = new int[10000];
		for (int i = 0; i < stuff.length; i++) {
			stuff[i] = i;
		}
		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] buckets = (ArrayList<Integer>[]) new ArrayList[10];
		for (int i = 0; i < 10; i++) {
			// make buckets pretty big
			buckets[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < stuff.length; i++) {
			int thing = stuff[i];
			int mod = ((thing % 10) + ((thing / 10) % 10) + ((thing / 100) % 10) + (thing / 1000)) % 10;
			buckets[mod].add(thing);
		}
		
		int index = 0;
		int[] result = new int[10000];
		for (int i = 9; i >= 0; i--) {
			ArrayList<Integer> bucket = buckets[i];
			int bucketSize = bucket.size();
			for (int j = 0; j < bucketSize; j++) {
				result[index++] = bucket.get(j);
			}
		}
		System.out.println(Arrays.toString(result));
	}
}
