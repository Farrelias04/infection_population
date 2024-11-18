import java.util.Random;

public class Population
{
    //Atributes
    private int size;
    private boolean[] pop;
    private double initial;
    private double recover;
    private double transmit;
    private Random generator;

    public Population(int size, double initial, double recover, double transmit)
    {
        //this.pop stores 'size' number of booleans
        this.size = size;
        this.pop = new boolean[size];
        this.initial = initial;
        this.recover = recover;
        this.transmit = transmit;
        this.generator = new Random();

        //to check the booleans starting form [0], where the loop breaks at the 'size' value
        for(int  i=0; i<size; i++)
        {
            pop[i] = (generator.nextDouble() < initial);
        }
    }

    public int getInfections()
    {
        int count = 0;
        for(int i=0; i<size; i++)
        {
            //since pop list stores boolean, it checks one by one to see if it is true or false,
            //if true, infenction count increases
            if(pop[i])
            {
                count++;
            }
        }
        return count;
    }

    public String toString()
    {
        return(this.getInfections() + " people infected");
    }

    public void update()
    {
        boolean[] newpop = new boolean[size];
        // use newpop to store what happens to each person
        for(int i = 0; i < size; i++)
        {
            if(pop[i])
            {
                newpop[i] = (generator.nextDouble() >= recover);
            }
            else
            {

                /* Really not sure why this thing is here */
                //int j = generator.nextInt(size);

                if(!pop[i])
                {
                    newpop[i] = (generator.nextDouble() < transmit);
                }
                else
                {
                    newpop[i] = false;
                }

            }

        }
        pop = newpop;

    }
}
    
    