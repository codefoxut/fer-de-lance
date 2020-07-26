

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("DESIGN PATTERNS");
        System.out.println("DESIGN PATTERNS: SINGLETON PATTERN");
        ExampleSingleton singletonObj1 = ExampleSingleton.getInstance();
        ExampleSingleton singletonObj2 = ExampleSingleton.getInstance();
        // ExampleSingleton singletonObj3 = new ExampleSingleton(); cant call it as no constructor exists in class.
        System.out.println("compare objects "+ singletonObj1.hashCode() + ' '+ singletonObj2.hashCode());
        System.out.println("value of x = " + singletonObj1.x);
        
    }
}
