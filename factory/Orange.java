public class Orange implements Fruit{
    @Override
    public void juice()
    {
        System.out.println("We have Orange juice! Best with pulp.");
    }

    @Override
    public void sayColour()
    {
        System.out.println("I am orange. Duh.");
    }

    @Override
    public void about()
    {
        System.out.println("Peel me and eat. It is an orange.");
    }
}
