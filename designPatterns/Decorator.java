public class Decorator {
    public static void main(String[] args) {
        IA a1 = new A_1();
        IA a2 = new A_2();
        B b1 = new B(a1);
        B b2 = new B(a2);
        b1.foo();
        b2.foo();
    }
}

class A {
    void foo(){
        System.out.println("I'm from A!");
    }
}

class A1 extends A {
    @Override
    void foo(){
        System.out.println("I'm from A1!");

    }
}

class A2 extends A {
    @Override
    void foo(){
        System.out.println("I'm from A2!");
    }
}

/* class B extends A1, A2 {
    this is impossible
} */

interface IA {
    void foo();
}

class A_1 implements IA {
    public void foo() {
        System.out.println("I'm from A1!");
    }
}

class A_2 implements IA {
    public void foo() {
        System.out.println("I'm from A2!");
    }
}

class B implements IA {
    IA myA;
    
    B (IA a) {
        myA = a;
    }

    public void foo() {
        myA.foo();
    }
}