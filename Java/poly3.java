class Rocket {
    public String launch() {
        return "Rocket launched";
    }
}

class RocketA extends Rocket {
    public String launch() {
        return "Rocket A launched with high speed";
    }
}

class RocketB extends Rocket {
    public String launch() {
        return "Rocket B launched with high precision";
    }
}

class RocketC extends Rocket {
    public String launch() {
        return "Rocket C launched with heavy payload";
    } 
}

class Launcher {
    public void launchRocket(Rocket rocket) {
        System.out.println(rocket.launch());
    }
}

public class poly3 {
    public static void main(String[] args) {
        Launcher launcher = new Launcher();

        Rocket rocketA = new RocketA();
        Rocket rocketB = new RocketB();
        Rocket rocketC = new RocketC();

        launcher.launchRocket(rocketA);
        launcher.launchRocket(rocketB);
        launcher.launchRocket(rocketC);
    }
}
