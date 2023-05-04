public class Union {
    
}

class AUB {
    boolean isA() {
        throw new UnsupportedOperationException();
    }
    void op0() {
        throw new UnsupportedOperationException();
    }
    void op1() {
        throw new UnsupportedOperationException();
    }
    void op2() {
        throw new UnsupportedOperationException();
    }
    void op3() {
        throw new UnsupportedOperationException();
    }
}

class A extends AUB {
    @Override
    boolean isA() {
        return true;
    }
    void op0() {}
    void op1() {}
    void op2() {}
}

class B extends AUB {
    @Override
    boolean isA() {
        return false;
    }
    void op0() {}
    void op3() {}
}

interface CUD {
    void op0();
    CI getC();
    DI getD();
}

interface CI extends CUD {
    void op1();
    void op2();
}

interface DI extends CUD {
    void op3();
}

class C implements CI {
    public CI getC() {return this;}
    public DI getD() {return null;}

    public void op0() {}
    public void op1() {}

    public void op2() {}
}

class D implements DI {
    public CI getC() {return null;}
    public DI getD() {return this;}

    public void op0() {}
    public void op3() {}
}