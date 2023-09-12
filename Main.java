import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) {
		FastScanner fs = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
		T = fs.nextInt();
		outer: for (int tc = 1; tc <= T; tc++) {
			char[] s = fs.next().toCharArray();
			char[] t = fs.next().toCharArray();
			boolean[] present = new boolean[26];
			Arrays.fill(present, false);
			for (char letter : s) {
				present[letter-'a'] = true;
			}
			//impossible case
			for (char letter : t) {
				if (!present[letter-'a']) {
					System.out.println(-1);
					continue outer;
				}
			}
			ArrayList<Integer>[] indices = new ArrayList[26];
			for (int i = 0; i < 26; i++) {
				indices[i] = new ArrayList<>();
			}
			for (int i = 0; i < s.length; i++) {
				indices[s[i]-'a'].add(i);
			}
			int prev = -1, counter = 0;
			for (int i = 0; i < t.length; i++) {
				int low = 0, high = indices[t[i]-'a'].size() - 1;
				int newPrev = -1;
				while (low <= high) {
					int mid = low + (high - low) / 2;
					if (prev < indices[t[i]-'a'].get(mid)) {
						newPrev = indices[t[i]-'a'].get(mid);
						high = mid - 1;
					} else {
						low = mid + 1;
					}
				}
				if (newPrev == -1) {
//					System.out.print("(here)");
					newPrev = indices[t[i]-'a'].get(0);
					counter++;
				}
//				System.out.println(t[i] + " = " + newPrev);
				prev = newPrev;
			}
			//don't forget to add 1 to counter (last group)
			System.out.println(counter + 1);
		}
		out.close();
	}
	
	static final Random rnd = new Random();
	static void shuffleSort(int[] a) { //change this
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int newInd = rnd.nextInt(n);
			int temp = a[newInd]; //change this
			a[newInd] = a[i];
			a[i] = temp;
		}
		Arrays.sort(a);
	}
	
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
		
		String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextInt();
			}
			return a;
		}
		
		long[] readLongArray(int n) {
			long[] a = new long[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextLong();
			}
			return a;
		}
		
		double[] readDoubleArray(int n) {
			double[] a = new double[n];
			for (int i = 0; i < n; i++) {
				a[i] = nextDouble();
			}
			return a;
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				if (st.hasMoreTokens()) {
					str = st.nextToken("\n");
				} else {
					str = br.readLine();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
