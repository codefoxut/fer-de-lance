public class FactoryMethodPattern{
    
    public static void main( String[] args) {
        // Example factory pattern
        KnifeFactory factory = new KnifeFactory();
        KnifeStore knifeStore = new KnifeStore(factory);
        Knife steakKnife = knifeStore.orderKnife("steak");
        Knife chefsKnife = knifeStore.orderKnife("chefs");
        System.out.println(steakKnife.type + " got the steak knife.");
        System.out.println(chefsKnife.type + " got the chefs knife.");
    }

}

class Knife {
    public String type;

    public Knife(){
        this.type = "general knife";
    }

    public void sharpen(){
        System.out.println("sharpen the " +  this.type);
    }

    public void polish(){
        System.out.println("Polish the " + this.type);
    }

    public void pack(){
        System.out.println("package the " + type);
    }
    
}

class SteakKnife extends Knife {
    public SteakKnife(){
        this.type = "steak knife";
    }
} 

class ChefsKnife extends Knife {
    public ChefsKnife() {
        this.type = "Chefs Knife";
    }
}

class KnifeFactory {
    public Knife createKnife(String knifeType) {
        Knife knife = null;

        // create knife object.
        if (knifeType.equals("steak")) {
            knife = new SteakKnife();
        } else if (knifeType.equals("chefs")) {
            knife = new ChefsKnife();
        }
        return knife;
    }
}

class KnifeStore {
    private KnifeFactory factory;

    // pass factory to constructor.
    public KnifeStore(KnifeFactory factory){
        this.factory = factory;
    }

    public Knife orderKnife(String knifeType) {
        Knife knife;
        knife = factory.createKnife(knifeType);

        // prepare the knife.
        knife.sharpen();
        knife.polish();
        knife.pack();

        return knife;
    }
}