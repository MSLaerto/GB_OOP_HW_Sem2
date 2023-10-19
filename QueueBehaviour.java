package sem2;

public interface QueueBehaviour {
    void enqueue(Person person);
    Person dequeue();
    boolean isEmpty();
}
