public class TicketRepository {

    private Ticket[] tickets = new Ticket[0];

    public Ticket[] findAll() {
        return tickets;
    }

    public void add(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tickets.length] = ticket;
        tickets = tmp;
    }

    public void removeById(int id) {
        int indexToCopy = 0;
        Ticket[] tmp = new Ticket[tickets.length - 1];
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[indexToCopy] = ticket;
                indexToCopy++;
            }
            tickets = tmp;
        }
    }
}
