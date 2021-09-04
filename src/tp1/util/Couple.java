package tp1.util;

import java.util.Objects;

public class Couple<T1, T2> {
    private T1 first;
    private T2 second;

    public Couple(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {
        return first;
    }

    public void setFirst(T1 first) {
        this.first = first;
    }

    public T2 getSecond() {
        return second;
    }

    public void setSecond(T2 second) {
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Couple<?, ?> couple = (Couple<?, ?>) o;
        return Objects.equals(first, couple.first) && Objects.equals(second, couple.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
