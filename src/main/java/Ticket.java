public class Ticket implements Comparable<Ticket> {
    private int id;
    private String from;
    private String to;
    private int price;
    private int during;

    public Ticket(int id, String from, String to, int price, int during) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.price = price;
        this.during = during;
    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getPrice() {
        return price;
    }

    public int getDuring() {
        return during;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.getPrice() < o.getPrice()) {
            return -1;
        } else if (this.getPrice() > o.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }
}
