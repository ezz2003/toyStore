package org.example.toyS;
import java.util.Objects;
public class Toy implements Comparable<Toy>{

    private int toyId;
    private String toyTitle;
    private int toyWinningFrequency;

    public Toy(int toyId, String toyTitle, int toyWinningFrequency) {
        this.toyId = toyId;
        this.toyTitle = toyTitle;
        this.toyWinningFrequency = toyWinningFrequency;
    }

    public int getToyId() {
        return toyId;
    }

    public String getToyTitle() {
        return toyTitle;
    }

    public int getToyWinningFrequency() {
        return toyWinningFrequency;
    }

    public void setToyWinningFrequency(int toyWinningFrequency) {
        this.toyWinningFrequency = toyWinningFrequency;
    }

    public String getInfo() {
        return String.format("ID: %d, Title: %s", toyId, toyTitle);
    }
    public String getAllFields() {
        return String.format("%d,%s,%d", toyId, toyTitle, toyWinningFrequency);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Toy toy = (Toy) o;
        return toyTitle.equals(toy.toyTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(toyTitle);
    }

    @Override
    public int compareTo(Toy o) {

        return Integer.compare(this.toyWinningFrequency, o.toyWinningFrequency);
    }
}
