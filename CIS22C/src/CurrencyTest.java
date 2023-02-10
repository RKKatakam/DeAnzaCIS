import static org.junit.jupiter.api.Assertions.*;

class CurrencyTest {

    @org.junit.jupiter.api.Test
    void getWholePart() {
        Currency currency = new Soum(10.43);
        assertEquals(10, currency.getWholePart());

        currency = new Krone(18.63);
        assertEquals(18, currency.getWholePart());
    }

    @org.junit.jupiter.api.Test
    void getFractionalPart() {
        Currency currency = new Soum(10.43);
        assertEquals(43, currency.getFractionalPart());

        currency = new Krone(18.63);
        assertEquals(63, currency.getFractionalPart());
    }

    @org.junit.jupiter.api.Test
    void add() {
        Currency currency = new Soum(1.12);
        currency.add(new Soum(1.12));

        assertEquals(2, currency.getWholePart());
        assertEquals(24, currency.getFractionalPart());

        assertThrows(IllegalArgumentException.class, () -> {
            currency.add(new Krone(1.12));
        });
    }

    @org.junit.jupiter.api.Test
    void subtract() {
        Currency currency = new Soum(2.24);
        currency.subtract(new Soum(1.12));

        assertEquals(1, currency.getWholePart());
        assertEquals(12, currency.getFractionalPart());

        assertThrows(IllegalArgumentException.class, () -> {
            currency.subtract(new Krone(1.12));
        });

        assertThrows(IllegalArgumentException.class, () -> {
            currency.subtract(new Soum(2.24));
        });

    }

    @org.junit.jupiter.api.Test
    void isEquals() {
        assertThrows(IllegalArgumentException.class, () -> {
            Currency currency = new Soum(1.12);
            currency.isEquals(new Krone(1.12));
        });

        assertTrue(new Soum(1.12).isEquals(new Soum(1.12)));
        assertFalse(new Soum(1.12).isEquals(new Soum(1.13)));
    }
}