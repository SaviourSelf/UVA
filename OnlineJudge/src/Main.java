import java.util.Scanner;

public class Main {
	
	Scanner scan;
	int a;
	public Main()
	{
		scan = new Scanner(System.in);
		String line = "";
		boolean isNumber = true;
		int count = 0;
		
		while ((line = scan.nextLine()) != null){
			if (isNumber)
			{
				count = Integer.parseInt(line.trim());
				if (count == 0)
					break;
			} else {
				System.out.println(getAnswer(line, count));
			}
			isNumber = !isNumber;
		}
	}
	
	public int getAnswer(String line, int count)
	{
		int localDrug = -1;
		int localRestaurant = -1;
		int minSoFar = Integer.MAX_VALUE;
		char [] charArray = line.toCharArray();
		for (int i = 0; i < count; i++)
		{
			switch(charArray[i])
			{
				case 'R':
					localRestaurant = i;
					break;
				case 'D':
					localDrug = i;
					break;
				case 'Z':
					return 0;
			}
			if (localDrug >= 0 && localRestaurant >= 0)
				minSoFar = Math.min(minSoFar, Math.abs(localDrug-localRestaurant));
		}
		return minSoFar;
	}
	
	public static void main(String...orange)
	{
		new Main();
	}
}
