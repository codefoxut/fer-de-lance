public class ExampleSingleton {
    private static ExampleSingleton uniqueInstance = null;
    public int x;
    private ExampleSingleton(){
        x = 10;
    }

    public static ExampleSingleton getInstance() {
        if ( uniqueInstance == null) {
            uniqueInstance = new ExampleSingleton();
        }
        return uniqueInstance;
    }
}