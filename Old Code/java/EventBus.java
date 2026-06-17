import java.util.*;
import java.util.function.Consumer;

class EventBus<T> {
    private final List<Consumer<T>> listeners = new ArrayList<>();

    public void subscribe(Consumer<T> listener) {
        listeners.add(listener);
    }

    public void publish(T event) {
        listeners.forEach(l -> l.accept(event));
    }

    public static void main(String[] args) {
        EventBus<String> bus = new EventBus<>();

        bus.subscribe(msg -> System.out.println("Listener1: " + msg));
        bus.subscribe(msg -> System.out.println("Listener2: " + msg));

        bus.publish("Hello Event!");
    }
}
