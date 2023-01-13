import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    @Test
    public void testFindTickets() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, "SVO", "LED", 200, 60);
        Ticket ticket2 = new Ticket(2, "SVO", "LED", 100, 60);
        Ticket ticket3 = new Ticket(3, "SVO", "CSY", 200, 90);
        Ticket ticket4 = new Ticket(4, "SVO", "LED", 400, 60);
        Ticket ticket5 = new Ticket(5, "CSY", "LED", 800, 90);
        Ticket ticket6 = new Ticket(6, "SVO", "LED", 200, 60 );
        Ticket ticket7 = new Ticket(7, "VKO", "DME", 300, 20);
        Ticket ticket8 = new Ticket(8, "SVO", "LED", 500, 60);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket2, ticket1, ticket6,ticket4, ticket8};
        Ticket[] actual = manager.findAll("SVO", "LED");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testFindReturnTickets() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, "SVO", "LED", 200, 60);
        Ticket ticket2 = new Ticket(2, "SVO", "LED", 100, 60);
        Ticket ticket3 = new Ticket(3, "LED", "SVO", 200, 90);
        Ticket ticket4 = new Ticket(4, "SVO", "LED", 400, 60);
        Ticket ticket5 = new Ticket(5, "LED", "SVO", 800, 90);
        Ticket ticket6 = new Ticket(6, "SVO", "LED", 200, 60 );
        Ticket ticket7 = new Ticket(7, "LED", "SVO", 300, 20);
        Ticket ticket8 = new Ticket(8, "SVO", "LED", 500, 60);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {ticket3, ticket7, ticket5};
        Ticket[] actual = manager.findAll("LED", "SVO");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testFindTicketsNoResult() {
        TicketRepository repo = new TicketRepository();
        TicketManager manager = new TicketManager(repo);

        Ticket ticket1 = new Ticket(1, "SVO", "LED", 200, 60);
        Ticket ticket2 = new Ticket(2, "SVO", "LED", 100, 60);
        Ticket ticket3 = new Ticket(3, "SVO", "CSY", 200, 90);
        Ticket ticket4 = new Ticket(4, "SVO", "LED", 400, 60);
        Ticket ticket5 = new Ticket(5, "CSY", "LED", 800, 90);
        Ticket ticket6 = new Ticket(6, "SVO", "LED", 200, 60 );
        Ticket ticket7 = new Ticket(7, "VKO", "DME", 300, 20);
        Ticket ticket8 = new Ticket(8, "SVO", "LED", 500, 60);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("LED", "SVO");

        Assertions.assertArrayEquals(expected, actual);

    }

}