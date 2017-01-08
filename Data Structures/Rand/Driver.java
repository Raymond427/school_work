import java.util.Random;
/**
 * Write a description of class Driver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Driver
{
    int num;
    private int [] Rands = new int [50];
    private String [] Columns = {"1-10: |", "11-20: |", "21-30: |", "31-40: |", "41-50: |", "51-60: |", "61-70: |", "71-80: |", "81-90: |", "91-100: |"};
    private int [] Rows = new int [10];
    Random r = new Random();

    public Driver()
    {
        for (int a = 0; a < 50; a++)
        {
            int random = r.nextInt(100) + 1;
            Rands[a] = random;
        }
        for (int a = 0; a < 50; a++)
        {
            num = Rands[a];
            if (num <= 10)
            {
                Rows[0]++;
            }
            else if (num <= 20 && num > 10)
            {
                Rows[1]++;
            }
            else if (num <= 30 && num > 20)
            {
                Rows[2]++;
            }
            else if (num <= 40 && num > 30)
            {
                Rows[3]++;
            }
            else if (num <= 50 && num > 40)
            {
                Rows[4]++;
            }
            else if (num <= 60 && num > 50)
            {
                Rows[5]++;
            }
            else if (num <= 70 && num > 60)
            {
                Rows[6]++;
            }
            else if (num <= 80 && num > 70)
            {
                Rows[7]++;
            }
            else if (num <= 90 && num > 80)
            {
                Rows[8]++;
            }
            else if (num <= 100 && num > 90)
            {
                Rows[9]++;
            }
        }
        for (int b = 0; b < 10; b++)
        {
            System.out.print(Columns[b]);
            for (int c = 0; c < Rows[b]; c++)
            {
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
