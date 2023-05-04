public class Adaptor {
    public static void main(String[] args) {

        MallardDuck duck = new MallardDuck();
        Test(duck);

        WildTurkey turkey = new WildTurkey();
        turkey.gobble();
        turkey.fly();

        Duck turkeyAdapter = new TurkeyAdaptor(turkey);
        Test(turkeyAdapter);
    }

    static void Test(Duck d) {
        d.quack();
        d.fly();
    }
}

interface Duck {
    public void quack();
    public void fly();
}

class MallardDuck implements Duck {
    public void quack() {
        System.out.println("Quack");
    }
    public void fly() {
        System.out.println("I'm flying duck");
    }
}

interface Turkey {
    public void gobble();
    public void fly();
}

class WildTurkey implements Turkey {
    public void gobble() {
        System.out.println("Gobble");
    }
    public void fly(){
        System.out.println("I'm flying turkey");
    }
}

class TurkeyAdaptor implements Duck {
    Turkey turkey;
    
    TurkeyAdaptor(Turkey t) {
        turkey = t;
    }
    public void quack(){
        turkey.gobble();
    }
    public void fly() {
        for (int i = 0; i < 5; i++) {
            turkey.fly();
        }
    }
}
