class Worker {
    private Worker() {
    }

    public static Worker getWorker() {
        return new Worker();
    }

    protected Printer getPrinter() {
        return new ConsolePrinter();
    }

    public void doWork() {
        Printer log = getPrinter();
        log.debug();
        log.error();
    }
}

interface Printer {
    public void debug();

    public void error();
}

class ConsolePrinter implements Printer {
    ConsolePrinter() {
    }

    public void debug() {

    }

    public void error() {

    }
}

class FilePrinter implements Printer {
    FilePrinter() {
    }

    public void debug() {

    }

    public void error() {

    }
}