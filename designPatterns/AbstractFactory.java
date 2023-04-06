package designPatterns;

public class AbstractFactory {
    Application MSapp = new Application(new MSFactory());
    Application Appleapp = new Application(null);
}

class Application {
    public Application(UIFactory factory) {
        Window window = factory.createWindow();
        Button buttonCancel = factory.createButton(window, "cancel");
        Button buttonOk = factory.createButton(window, "Ok");
        window.display();
        buttonCancel.activate();
        buttonOk.activate();
    }
}

class MSFactory implements UIFactory {
    MSFactory() {}

    public Window createWindow() {
        return new Window() {
            public void display() { }
        };
    }

    public Button createButton(Window window, String text) {
        return new Button() {
            public void activate() { }
        };
    }    
}

interface UIFactory {
    public Window createWindow();
    public Button createButton(Window window, String text);
}

interface Window {
    public void display();
}
interface Button {
    public void activate();
}