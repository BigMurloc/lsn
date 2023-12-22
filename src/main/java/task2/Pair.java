package task2;

import java.util.Objects;

class Pair {

    private final int smaller;
    private final int greater;

    Pair(int a, int b) {
        this.smaller = Math.min(a, b);
        this.greater = Math.max(a, b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return smaller == pair.smaller && greater == pair.greater;
    }

    @Override
    public int hashCode() {
        return Objects.hash(smaller, greater);
    }

    @Override
    public String toString() {
        return smaller + " " + greater;
    }
}
