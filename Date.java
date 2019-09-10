package Sorting;

public class Date implements Comparable<Date>
{
	private final int month, date, year;
	
	public Date(int m, int d, int y)
	{
		month = m;
		date = d;
		year = y;
	}
	
	public int compareTo(Date that)
	{
		if (this.year < that.year) return -1;
		if (this.year > that.year) return 1;
		if (this.month < that.month) return -1;
		if (this.month > that.month) return 1;
		if (this.date < that.date) return -1;
		if (this.date > this.date) return 1;
		return 0;
	}
}
