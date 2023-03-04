import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

  public Stack createStack() throws Exception {
        Stack stack = new Stack();
        stack.push(new Krone(1.0));
        stack.push(new Krone(2.0));
        stack.push(new Krone(3.0));
        stack.push(new Krone(4.0));
        return stack;
    }

    @Test
    void pop() throws Exception {
        Stack stack = createStack();

        Currency tester = stack.pop();
        assertEquals(4.0, tester.getWholePart() + tester.getFractionalPart() / 100.0);

        tester = stack.pop();
        assertEquals(3.0, tester.getWholePart() + tester.getFractionalPart() / 100.0);

        tester = stack.pop();
        assertEquals(2.0, tester.getWholePart() + tester.getFractionalPart() / 100.0);

        tester = stack.pop();
        assertEquals(1.0, tester.getWholePart() + tester.getFractionalPart() / 100.0);

    }

    @Test
    void peek() throws Exception {
        Stack stack = createStack();

        assertEquals(4.0, stack.peek().getWholePart() + stack.peek().getFractionalPart() / 100.0);

        stack.pop();
        assertEquals(3.0, stack.peek().getWholePart() + stack.peek().getFractionalPart() / 100.0);

        stack.pop();
        assertEquals(2.0, stack.peek().getWholePart() + stack.peek().getFractionalPart() / 100.0);

        stack.pop();
        assertEquals(1.0, stack.peek().getWholePart() + stack.peek().getFractionalPart() / 100.0);
    }
}