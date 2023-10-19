package sem2;

public class Main {
    public static void main(String[] args) {
        Market market = new Market();

        Person person1 = new Person("Person 1", "In Market");
        Person person2 = new Person("Person 2", "In Market");
        Person person3 = new Person("Person 3", "In Market");
        Person person4 = new Person("Person 4", "In Market");
        Person person5 = new Person("Person 5", "In Market");

        market.enterMarket(person1);
        market.enterMarket(person2);
        market.enterMarket(person3);
        market.update();


        market.enterMarket(person4);
        market.enterMarket(person5);
        market.update();

        
        market.printMarket(market);
    }
}