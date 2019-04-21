package Divide_and_Conquer;


//https://codeforces.com/contest/1111/problem/C

import java.util.*;
import java.lang.*;
import java.lang.reflect.Array;
import java.io.*;
import javafx.util.Pair;
import java.util.HashMap;
import java.io.BufferedReader; 
import java.io.FileReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
import java.io.DataInputStream; 
import java.io.FileInputStream; 
import java.math.BigInteger;
import java.math.BigDecimal;
import java.text.DecimalFormat;
public class Creative_Snap_Correct{
    static long gcd(long a,long b)
    {
        if(a==0 || b==0)
        {
            return 0;
        }
        if(a==b)
        {
            return a;
        }
        if(a>b)
        {
            return gcd(a-b,b);
        }
        return gcd(a,b-a);
    }

    static long lcm(long a,long b)
    {
        return (a*b)/gcd(a,b);
    }
    public static int min(int a,int b,int c){
        if(a<b){
            if(a<c)
                return a;
            
            else
                return c;
        }
        else{
            if(b<c)
                return b;
            else
                return c;
        }   
}
    public static int max(int a,int b,int c){
        if(a<b){
            if(b<c)
                return c;
            
            else
                return b;
        }
        else{
            if(a<c)
                return c;
            else
                return a;
        }   
}
    static class InputReader {
 
		private final InputStream stream;
		private final byte[] buf = new byte[8192];
		private int curChar, snumChars;
 
		public InputReader(InputStream st) {
			this.stream = st;
		}
 
		public int read() {
			if (snumChars == -1)
	 			throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}
 
		public int ni() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			int res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
 
		public long nl() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;
			do {
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}
 
		public int[] nia(int n) {
			int a[] = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = ni();
			}
			return a;
		}
 
		public String rs() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}
 
		public String nextLine() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isEndOfLine(c));
			return res.toString();
		}
 
		public boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
 
		private boolean isEndOfLine(int c) {
			return c == '\n' || c == '\r' || c == -1;
		}
 
	}
    static abstract class MultiSetImpl<ValueType, MapType extends Map<ValueType, Integer>> implements MultiSet<ValueType> {
        protected final MapType map;
        protected int size;
        protected int distinctCount;

        protected MultiSetImpl(MapType map) {
            this.map = map;
            this.size = 0;
        }

        public void add(ValueType value) {
            int count = getCount(value);
            if (count == 0) ++distinctCount;
            map.put(value, count + 1);
            ++size;
        }

        public boolean remove(ValueType value) {
            int count = getCount(value);
            if (count == 0) return false;

            if (count == 1) map.remove(value);
            else map.put(value, count - 1);
            if (count == 1) --distinctCount;
            --size;
            return true;
        }

        public int getCount(ValueType value) {
            Integer count = map.get(value);
            return (count == null ? 0 : count);
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (ValueType key : map.keySet()) {
                stringBuilder.append("[" + key.toString() + " " + map.get(key).toString() + "] ");
            }
            return stringBuilder.toString();
        }

    }

    static interface MultiSet<ValueType> {
    }

    static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar;
        private int pnumChars;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        private int pread() {
            if (pnumChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= pnumChars) {
                curChar = 0;
                try {
                    pnumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (pnumChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = pread();
            while (isSpaceChar(c))
                c = pread();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = pread();
            }
            int res = 0;
            do {
                if (c == ',') {
                    c = pread();
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = pread();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

    }

    static class HashMultiSet<ValueType> extends MultiSetImpl<ValueType, Map<ValueType, Integer>> {
        public HashMultiSet(Map<ValueType, Integer> map) {
            super(map);
        }

    }

  static long modInverse(long a, long m){
      long num=m;
      long x=1;
      long power=a;
      while(num>0){
          if(num%2==1){
              x=(x*power)%mod;
          }
         num=num/2;
         power=(power*power)%mod;
         
      }
      return x;
  }
  static long mod=1000000007;
  public static long fact[]=new long[1000005];
  
   public static void findFact(){
         fact[0]=1;
         for(int i=1;i<=1000000;i++){
             fact[i]=(i*fact[i-1])%mod;
         }
     }
  
public static long nCr(int n,int r){
    return (fact[n]*modInverse((fact[r]*fact[n-r])%mod,1000000005))%mod;
}
public static long nPr(int n,int r){
    return (fact[n]*modInverse(fact[n-r],1000000005))%mod;
}
public static int stack[]=new int[200000];
public static int top=-1;
public static void push(int item){
    stack[++top]=item;
} 
public static int pop(){
    return stack[top--];
}
 public static int TwoDpartition(int arr[][], int low, int high,int n) 
    { 
        int pivot = Math.abs(arr[high][0]-arr[high][1]);  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than or 
            // equal to pivot 
            if (Math.abs(arr[j][0]-arr[j][1]) <= pivot&&arr[j][0]<=arr[j][1]) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp1 = arr[i][0]; 
                int temp2=arr[i][1];
                arr[i][0] = arr[j][0];
                 arr[i][1] = arr[j][1]; 
                arr[j][0] = temp1;
                arr[j][1]=temp2;
            }
            else if (n-arr[j][0]+arr[j][1] <= pivot&&arr[j][0]<arr[j][1]) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp1 = arr[i][0]; 
                int temp2=arr[i][1];
                arr[i][0] = arr[j][0];
                 arr[i][1] = arr[j][1]; 
                arr[j][0] = temp1;
                arr[j][1]=temp2;
            }
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp1 = arr[i+1][0];
        int temp2 = arr[i+1][1];
        arr[i+1][0] = arr[high][0];
        arr[i+1][1] = arr[high][1];
        arr[high][0] = temp1; 
        arr[high][1] = temp2; 
        return i+1; 
    } 
    public static void TwoDsort(int arr[][], int low, int high,int n) 
    { 
        if (low < high) 
        { 
            
            int pi = TwoDpartition(arr, low, high,n);
            TwoDsort(arr, low, pi-1,n); 
            TwoDsort(arr, pi+1, high,n); 
        } 
    } 

public static void merge(int arr[], int l, int m, int r){ 
        int n1 = m - l + 1; 
        int n2 = r - m; 
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
        for (int i=0; i<n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = arr[m + 1+ j]; 
        int i = 0, j = 0; 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                //ind[k][0]=i;
               // ind[k][1]=dish[i];
               // ind[k][2]=L[i];
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
               // ind[k][0]=j;
               // ind[k][1]=dish[j];
               // ind[k][2]=R[j];
                j++; 
            } 
            k++; 
        } 
        while (i < n1) 
        { 
            arr[k] = L[i];
           // ind[k][0]=i;
           // ind[k][1]=dish[i];
           // ind[k][2]=L[i];
            i++; 
            k++; 
        } 
        while (j < n2) 
        { 
            arr[k] = R[j];
          //  ind[k][0]=j;
          //  ind[k][1]=dish[j];
          //  ind[k][2]=R[i];
            j++; 
            k++; 
        } 
    } 
    public static void sort(int arr[], int l, int r) 
    { 
        if (l < r) 
        { 
            int m = (l+r)/2; 
            sort(arr, l, m); 
            sort(arr , m+1, r); 
            merge(arr, l, m, r); 
        } 
    }
    
    

    static PrintWriter w = new PrintWriter(System.out);
//     public static int avenger(int arr[],int l,int r,int num,int k){
//         int mid=(r-l)/2;
//         int index=0;
//         if(l>=r)
//             index= r;
//         else{
//             
//             if(arr[mid]==num){
//             index= mid;
//             }
//            else if(arr[mid]>num){
//                if(arr[mid]>num&&mid!=0&&arr[mid-1]<num)
//                    index=mid-1;
//                else
//                   index=avenger(arr,l,mid-1,num,k);
//            }
//            else{
//                 if(arr[mid]<num&&mid!=k-1&&arr[mid+1]>num)
//                    index= mid;
//                else
//                   index=avenger(arr,mid+1,r,num,k);
//            }
//         }
//        return index;
//     }
    public static int searchlow(int x,int arr[]) {
		int lo=0, hi=arr.length-1;
		int res=Integer.MIN_VALUE;
		while(lo<=hi){
	        int mid = (lo+hi)/2;
	        if(arr[mid]==x){
	            res = mid;
	            hi = mid - 1;
	        }
	        else if(arr[mid]>x){
	            hi = mid - 1;
	        }
	        else{
	            lo = mid + 1;
	        }
	    }
	    return res==Integer.MIN_VALUE?lo:res;
	}
	public static int searchhigh(int x,int arr[]) {
		int lo=0, hi=arr.length-1;
		int res=Integer.MIN_VALUE;
		while(lo<=hi){
	        int mid = (lo+hi)/2;
	        if(arr[mid]==x){
	            res = mid;
	            lo=mid+1;
	        }
	        else if(arr[mid]>x){
	            hi = mid - 1;
	        }
	        else{
	            lo = mid + 1;
	        }
	    }
	    return res==Integer.MIN_VALUE?hi:res;
	}
	public static long ct(int l, int r,int arr[]) {
		int lo=searchlow(l,arr), hi=searchhigh(r,arr);
		return hi-lo+1;
	}
    
    
    
     public static long minValue(int arr[],int l,int r,int k,int A,int B){
//         int avenger=0;
//        int mid=(l+r)/2;
//        int i= Arrays.binarySearch(arr,(int)l);
//        int j=Arrays.binarySearch(arr,(int)r);
//        //int i=avenger(arr,0,k-1,l,k);
//        // int j=avenger(arr,0,k-1,r,k);
//        if(i<0){
//            i*=-1;
//            i=i-1;
//        }
//        if(j<0){
//            j*=-1;
//            j=j-2;
//        }
        long avenger=ct(l,r,arr);
        int mid=(l+r)/2;
        long res=0;
            if(avenger!=0)
                res =(long)B*(r-l+1)*avenger;
            else
                res= A;
            if(l==r)
                return res;
            if(avenger==0)
                return res;
            long b=(long)minValue(arr,l,mid,k,A,B);
            long c=(long)minValue(arr,mid+1,r,k,A,B);
            long d=b+c;
            long answer= Math.min(res,d);
            return answer;
             
          
         
         
    }
    
    public static void main(String[] args) throws IOException {   
        InputReader sc=new InputReader(System.in);
        //DecimalFormat df=new DecimalFormat("0.00000000000000000000");
        //BigInteger b,max=BigInteger.ZERO;
        //Scanner sc=new Scanner(System.in);
       // HashMultiSet<Integer> multiSet = new HashMultiSet<>(new HashMap<>());      
       //findFact();
       int n=sc.ni();
        int k=sc.ni();
       int A=sc.ni();
        int B=sc.ni();
       
        int arr[]=new int[k]; 
        int i=0;
        for(i=0;i<k;i++){
            arr[i]=sc.ni();
           arr[i]--;
       }
        sort(arr,0,k-1);
       long ans=(long)minValue(arr,0,(int)Math.pow(2,n)-1,k,A,B);
        w.println(ans);
       // avenger(arr,0,k-1,7,k);
       w.close();
    }  
    
}
