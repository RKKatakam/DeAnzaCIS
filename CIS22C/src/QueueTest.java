import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    public Queue createQueue() throws Exception {
        Queue queue = new Queue();
        queue.enqueue(new Krone(1.0));
        queue.enqueue(new Krone(2.0));
        queue.enqueue(new Krone(3.0));
        queue.enqueue(new Krone(4.0));
        return queue;
    }

    @Test
    void peekFront() throws Exception {
        Queue queue = createQueue();

        assertEquals(1.0, queue.peekFront().getWholePart() + queue.peekFront().getFractionalPart() / 100.0);
    }

    @Test
    void peekRear() throws Exception {
        Queue queue = createQueue();
        assertEquals(4.0, queue.peekRear().getWholePart() + queue.peekRear().getFractionalPart() / 100.0);
    }
}