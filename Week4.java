import java.util.Random;

public class Week4
{
    public static void main(String[] args)
    {
        //generate random numbers
        Random generator = new Random();

        //store 100 boolean values stored in a list
        //boolean[] means that it stores boolean values, while data is the name of the list
        boolean[] data = new boolean[100];
        for(int i = 0; i<100; i++)
        {
            //determines whet
            double r = generator.nextDouble();
            data[i] = (r<0.25);
        }

        //print the boolean value of the data values in 0th and 99th
        System.out.println(data[0]);
        System.out.println(data[99]);

        //to count number of successfull true in the 100 stored boolean values
        int count = 0;
        for (int i=0; i<100; i++)
        {
            if(data[i])
            {
                count++;
            }
        }
        System.out.println("There were " + count + " successes");

        Population p = new Population(100, 0.1, 0.2, 0.3);

        System.out.println(p);

        for(int i = 0; i < 100; i++)
        {
            p.update();

            System.out.println(p);
        }
    }

}

//this is called main file