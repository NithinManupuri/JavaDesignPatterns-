
interface Vehicle {
    void drive();
}

class TwoWheeler implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a two-wheeler");
    }
}

class FourWheeler implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving a four-wheeler");
    }
}

interface VehicleFactory {
    Vehicle createVehicle();
}

class TwoWheelerFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new TwoWheeler();
    }
}

class FourWheelerFactory implements VehicleFactory {
    @Override
    public Vehicle createVehicle() {
        return new FourWheeler();
    }
}

interface BrandFactory {
    VehicleFactory createVehicleFactory();
}

class HondaFactory implements BrandFactory {
    @Override
    public VehicleFactory createVehicleFactory() {
        return new TwoWheelerFactory(); 
    }
}

class ToyotaFactory implements BrandFactory {
    @Override
    public VehicleFactory createVehicleFactory() {
        return new FourWheelerFactory(); 
    }
}


public class Client {
    public static void main(String[] args) {
        // Create a brand factory
        BrandFactory hondaFactory = new HondaFactory();
        // Create a vehicle factory based on brand
        VehicleFactory vehicleFactory = hondaFactory.createVehicleFactory();
        // Create a vehicle
        Vehicle vehicle = vehicleFactory.createVehicle();
        // Drive the vehicle
        vehicle.drive(); 
    }
}
