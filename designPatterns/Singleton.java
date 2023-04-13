package designPatterns;

public class Singleton {
    
    public static final Singleton Inst = new Singleton();

    private Singleton(){}
}

// Singleton with static factory
class Singleton2 {

    private static final Singleton2 Inst = new Singleton2();

    private Singleton2(){}

    public static Singleton2 getInst() {
        return Inst;
    }
}

// Singleton with lazy initialization
// Actually, it is not correct design!
class Singleton3 {
    
    private static Singleton3 Inst = null;

    private Singleton3() {}

    public static Singleton3 getInst() {
        if (Inst == null) {
            // lock Singleton3.class
            synchronized (Singleton3.class) {
                if (Inst == null) {
                    Inst = new Singleton3();
                }
            }
        }
        return Inst;
    }
}

// Correct version with lazy initialization
class Singleton4 {
    private static class ResourceHolder {
        // you don't have to worry about concurrency
        static final Singleton4 Inst = new Singleton4();
    }
    
    private Singleton4() {
        // defending against reflection attack
        if (ResourceHolder.Inst != null) {
            throw new IllegalStateException();
        }
    }

    public static Singleton4 getInst() {
        return ResourceHolder.Inst;
    }
}

// singleton with enum class
enum Singleton5 {
    Inst;
    public static Singleton5 getInst(){
        return Inst;
    }

    int value = 10;

    public int getValue(){
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}