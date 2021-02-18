public class Watermelon implements Fruit{
    @Override
    public void juice()
    {
        System.out.println("We have Watermelon juice! Yum.");
    }

    @Override
    public void sayColour()
    {
        System.out.println("I am green on the outside and pink on the inside.");
    }

    @Override
    public void about()
    {
        System.out.println("Best to eat in slices or cubes. White part is yuck. Spit out the black seeds.");
    }
}
