package Sorting;

public class Merge {
	
	public interface Comparable<Item>
	{
	 public int compareTo(Item that);
	}
	
	public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi)
	{
		assert isSorted(a, lo, hi);
		assert isSorted(a, mid+1, hi);
		
		for (int k = lo; k < hi; k++)
		{
			aux[k] = a[k];
		}
		
		int i = lo;
		int j = mid + 1;
		
		for (int k = lo; k <= hi; k++)
		{
			if (i > mid)
			{
				a[k] = aux[j++];
			}
			else if (j > hi)
			{
				a[k] = aux[i++];
			}
			else if (less(aux[i], aux[j]))
			{
				a[k] = aux[i++];
			}
			else
			{
				a[k] = aux[j++];
			}
		}
		
		assert isSorted(a, lo, hi);
	}
	
	public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi)
	{
		if (hi <= lo) return;
//		if (hi <= lo + CUTOFF - 1)
//		{
//			Insertion.sort(a, lo, hi);
//		}
		int mid = lo + (hi - lo)/2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
//		if (!less(a[mid+1], a[mid]))
//		{
//			return;
//		}
		merge(a, aux, lo, mid, hi);
	}
	
	public static void sort(Comparable[] a)
	{
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length-1);
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	private static boolean isSorted(Comparable[] a, int i, int j)
	{
		for (int k = i; k <=j; k++)
		{
			if (less(a[k], a[k-1]))
			{
				return false;
			}
		}
		return true;
	}
}
