public abstract class AbstractCar {
    void startCar(){
        System.out.println("starting the car.");
    }

    abstract void engineProcess();

    abstract void stopEngine();

    void car(){
        startCar();
        engineProcess();
        stopEngine();
    }
}

class AbstractCarImpl extends AbstractCar{
    @Override
    void engineProcess(){
        System.out.println("processing engine.");
    }
    @Override
    void stopEngine(){
        System.out.println("engine stopped.");
    }
}
