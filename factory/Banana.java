public class Banana implements Fruit
{
    
    @Override
    public void juice()
    {
        System.out.println("We have Banana juice! Yuck.");
    }

    @Override
    public void sayColour()
    {
        System.out.println("I am yellow.");
    }

    @Override
    public void about()
    {
        System.out.println("Peel me and eat. Don't leave out in the sun. Throw away when brown");
    }
}
