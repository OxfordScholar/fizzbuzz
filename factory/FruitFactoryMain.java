public class FruitFactoryMain {

    public static void main(String[] args)
    {
        FruitFactory ff = new FruitFactory();

        // Testing Orange
        Fruit orange = ff.getFruit("orange");
        orange.about();
        orange.juice();
        orange.sayColour();

        //Testing Banana
        Fruit banana = ff.getFruit("yellow");
        banana.about();
        banana.juice();
        banana.sayColour();

        //Testing Watermelon
        Fruit watermelon = ff.getFruit("green");
        watermelon.sayColour();
        watermelon.about();
        watermelon.juice();
    }
    
}
