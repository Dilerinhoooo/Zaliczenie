package Szkola;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Control {
    static final int ENGINE_ON = 0;
    static final int SPEED_UP = 1;
    static final int SPEED_DOWN = 2;
    static final int CHANGE_GEAR_UP = 3;
    static final int CHANGE_GEAR_DOWN = 4;
    static final int ENGINE_OFF = 5;
     Car car = new Car();
    Scanner scanner;
    int option;

    public Control() {
        scanner = new Scanner(System.in);
        option = -1;
    }

    void mainLoop() {
        do {
            checkEngine();
        } while(!car.isEngineOn());

        do {
            if (car.isEngineOn()) {
               carDisplay();
               printOptions();
               readOption();
            }
        } while(option != ENGINE_ON);

    }

    private void checkEngine() {
        System.out.println("0 - Włącz silnik");

        try {
            option = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Podaj cyfrę");
        }
        scanner.nextLine();
        if (option == 0) {
            car.setEngineOn(true);
            car.setEngineSpeed(1000.0);
        }

    }

    private void engineOff() {
        car.setGear(0);
        car.setEngineOn(false);
        car.setSpeed(0.0);
        car.setEngineSpeed(0.0);
        mainLoop();
    }

    private void changeGearUp() {
        if (car.getGear() == -1) {
            car.setGear(car.getGear() + 2);
            car.setEngineSpeed(car.getEngineSpeed() - 500.0);
        } else if (car.getGear() == 5) {
            System.err.println("Nie udało się wrzucić wyższego biegu");
        } else if (car.getGear() == 0) {
            car.setGear(car.getGear() + 1);
        } else {
            car.setGear(car.getGear() + 1);
            car.setEngineSpeed(car.getEngineSpeed() - 500.0);
        }

    }

    private void changeGearDown() {
        if (car.getGear() == 1) {
            car.setGear(car.getGear() - 2);
        } else if (car.getGear() == -1) {
            System.err.println("Nie udało się wrzucić niższego biegu");
        } else {
            car.setGear(car.getGear() - 1);
            car.setEngineSpeed(car.getEngineSpeed() + 500.0);
        }

    }

    private void speedDown() {
        if (car.getSpeed() == 0.0) {
            System.err.println("Nie można mieć minusowej prędkości");
        } else if (car.getEngineSpeed() <= 1000.0) {
            System.err.println("Silnik zgasł");
            engineOff();
        } else {
            car.setSpeed(car.getSpeed() - 10.0);
            car.setEngineSpeed(car.getEngineSpeed() - 500.0);
        }

    }

    private void carDisplay() {
        System.out.println("Prędkość: " + car.getSpeed() + ", Bieg: " + car.getGear() + ", Obroty: " + car.getEngineSpeed());
    }

    private void printOptions() {
        System.out.println("Wybierz opcję: ");
        System.out.println("1 - Przyspiesz");
        System.out.println("2 - Zwolnij");
        System.out.println("3 - Zmień bieg na wyższy");
        System.out.println("4 - Zmień bieg na niższy");
        System.out.println("5 - Wyłącz silnik");
    }

    private void readOption() {
        try {
            this.option = this.scanner.nextInt();
        } catch (InputMismatchException var2) {
            System.err.println("Podaj cyfrę");
        }

        this.scanner.nextLine();
        switch (this.option) {
            case SPEED_UP -> speedUp();
            case SPEED_DOWN -> speedDown();
            case CHANGE_GEAR_UP -> changeGearUp();
            case CHANGE_GEAR_DOWN -> changeGearDown();
            case ENGINE_OFF -> engineOff();
            default -> System.out.println("Nie ma takiej funkcji");
        }

    }

    private void speedUp() {
        rGear();
        Ogear();
        fGear();
        sGear();
        tGear();
        foGear();
        fiGear();
    }

    private void rGear() {
        if (car.getGear() == -1 && car.getSpeed() == 30.0) {
            System.err.println("Auto nie pojedzie szybciej");
        } else if (car.getGear() == -1 && car.getSpeed() < 30.0) {
            speedUpBy10();
        }

    }

    private void Ogear() {
        if (car.getGear() == 0) {
            car.setEngineSpeed(1700.0);
            carDisplay();
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            car.setEngineSpeed(1000.0);
        }

    }

    private void fGear() {
        if (car.getGear() == 1) {
            speedUpBy10();
        }

        if (car.getGear() == 1 && car.getEngineSpeed() >= 2500.0 && car.getEngineSpeed() <= 2900.0) {
            System.err.println("Wrzuć wyższy bieg");
        }

        if (car.getGear() == 1 && car.getEngineSpeed() >= 3000.0) {
            System.err.println("Silnik zgasł");
            engineOff();
        }

    }

    private void sGear() {
        if (car.getGear() == 2) {
            speedUpBy10();
        }

        if (car.getGear() == 2 && car.getEngineSpeed() >= 4000.0 && car.getEngineSpeed() <= 4400.0) {
            System.err.println("Wrzuć wyższy bieg");
        }

        if (car.getGear() == 2 && car.getEngineSpeed() >= 4500.0) {
            System.err.println("Silnik zgasł");
            engineOff();
        }

    }

    private void tGear() {
        if (car.getGear() == 3) {
            speedUpBy10();
        }

        if (car.getGear() == 3 && car.getEngineSpeed() >= 5500.0 && car.getEngineSpeed() <= 5900.0) {
            System.err.println("Wrzuć wyższy bieg");
        }

        if (car.getGear() == 3 && car.getEngineSpeed() >= 6000.0) {
            System.err.println("Silnik zgasł");
            engineOff();
        }

    }

    private void foGear() {
        if (car.getGear() == 4) {
            speedUpBy10();
        }

        if (car.getGear() == 4 && car.getEngineSpeed() >= 7000.0 && car.getEngineSpeed() <= 7400.0) {
            System.err.println("Wrzuć wyższy bieg");
        }

        if (car.getGear() == 4 && car.getEngineSpeed() >= 7500.0) {
            System.err.println("Silnik zgasł");
            engineOff();
        }

    }

    private void fiGear() {
        if (car.getGear() == 5 && car.getSpeed() < 180.0) {
            speedUpBy10();
        } else if (car.getGear() == 5 && car.getSpeed() == 180.0) {
            System.err.println("Auto nie pojedzie szybciej");
        }

    }

    private void speedUpBy10() {
        car.setSpeed(car.getSpeed() + 10.0);
        car.setEngineSpeed(car.getEngineSpeed() + 500.0);
    }
}