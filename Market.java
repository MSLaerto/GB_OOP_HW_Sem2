package sem2;

import java.util.ArrayList;
import java.util.List;


class Market implements QueueBehaviour, MarketBehaviour {
    private List<Person> queue;

    public Market() {
        queue = new ArrayList<>();
    }

    @Override
    public void enqueue(Person person) {
        queue.add(person);
    }

    @Override
    public Person dequeue() {
        if (!isEmpty()) {
            return queue.remove(0);
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void enterMarket(Person person) {
        person.setStatus("In Market");
        enqueue(person);
    }

    @Override
    public void exitMarket(Person person) {
        person.setStatus("Left Market");
        queue.remove(person);
    }

    @Override
    public void update() {
        for (Person person : queue) {
            if (person.getStatus().equals("In Market")) {
                person.setStatus("Placed Order");
                // Обновление состояния магазина - принятие заказов
            } else if (person.getStatus().equals("Placed Order")) {
                person.setStatus("Order Delivered");
                // Обновление состояния магазина - отдача заказов
            }
        }
    }

    public void printMarket(Market market){
        Person nextPerson = market.dequeue();
        while (nextPerson != null) {
            System.out.println(nextPerson.getName() + " - " + nextPerson.getStatus());
            nextPerson = market.dequeue();
        }    
    }
}
