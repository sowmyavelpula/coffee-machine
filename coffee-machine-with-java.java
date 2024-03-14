package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private int money;

    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.coffeeBeans = 120;
        this.disposableCups = 9;
        this.money = 550;
    }

    public void processInput(String inputStr) {
        switch (inputStr) {
            case "remaining":
                displayRemaining();
                break;
            case "buy":
                buyCoffee();
                break;
            case "fill":
                fillSupplies();
                break;
            case "take":
                takeMoney();
                break;
            case "exit":
                break;
            default:
                System.out.println("Invalid input!");
        }
    }

    private void displayRemaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffeeBeans + " g of coffee beans");
        System.out.println(disposableCups + " disposable cups");
        System.out.println("$" + money + " of money");
    }

    private void buyCoffee() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeType = scanner.nextLine();
        switch (coffeeType) {
            case "1":
                makeCoffee(250, 0, 16, 4);
                break;
            case "2":
                makeCoffee(350, 75, 20, 7);
                break;
            case "3":
                makeCoffee(200, 100, 12, 6);
                break;
            case "back":
                break;
            default:
                System.out.println("Invalid input!");
        }
    }

    private void makeCoffee(int waterNeeded, int milkNeeded, int coffeeBeansNeeded, int cost) {
        if (water >= waterNeeded && milk >= milkNeeded && coffeeBeans >= coffeeBeansNeeded && disposableCups >= 1) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterNeeded;
            milk -= milkNeeded;
            coffeeBeans -= coffeeBeansNeeded;
            disposableCups--;
            money += cost;
        } else {
            System.out.println("Sorry, not enough resources!");
        }
    }

    private void fillSupplies() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        disposableCups += scanner.nextInt();
    }

    private void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public static void main(String[] args) {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.nextLine();
            coffeeMachine.processInput(action);
            if (action.equals("exit")) {
                break;
            }
        }
    }
}
