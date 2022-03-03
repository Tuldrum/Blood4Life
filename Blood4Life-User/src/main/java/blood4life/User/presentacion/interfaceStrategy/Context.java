package blood4life.User.presentacion.interfaceStrategy;

public class Context {
    private IStrategy strategy;

    public void setStrategy(IStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy() {
        strategy.desplegarInterfaz();
    }
}