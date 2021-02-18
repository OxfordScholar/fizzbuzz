public class FruitFactory {
    public Fruit getFruit(String colour)
    {
        if (colour.equals("yellow"))
        {
            return new Banana();
        }
        if (colour.equals("orange"))
        {
            return new Orange();
        }
        if (colour.equals("green") || colour.equals("pink"))
        {
            return new Watermelon();
        }
        return null;
    }
}
