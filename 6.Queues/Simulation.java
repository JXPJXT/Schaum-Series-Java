import java.util.LinkedList;
import java.util.Random;

public class Simulation {
    private static final int SERVERS = 3;
    private static final int CLIENTS = 20;
    private static final double MEAN_SERVICE_TIME = 25;
    private static final double MEAN_ARRIVAL_TIME = 4;
    private static Queue<Client> queue = new ArrayQueue<>();
    private static ExpRandom randomService = new ExpRandom(MEAN_SERVICE_TIME);
    private static ExpRandom randomArrival = new ExpRandom(MEAN_ARRIVAL_TIME);
    private static Server[] servers = new Server[SERVERS];
    private static Client[] clients = new Client[CLIENTS];

    public Simulation() {
        String fmt = "%-27s %6d%n";
        System.out.printf(fmt, "Number of servers:", SERVERS);
        System.out.printf(fmt, "Number of clients:", CLIENTS);
        System.out.printf(fmt, "Mean service time:", MEAN_SERVICE_TIME);
        System.out.printf(fmt, "Mean interarrival time:", MEAN_ARRIVAL_TIME);

        for (int i = 0; i < SERVERS; i++) {
            servers[i] = new Server(i, MEAN_SERVICE_TIME); // Using fixed mean service time for servers
            System.out.printf("Mean service time for %s: %4.1f%n",
                servers[i], servers[i].getMeanServiceTime());
        }

        int nextArrivalTime = 0;
        for (int t = 0, clientId = 0; clientId < CLIENTS || !queue.isEmpty() || !allServersIdle(); t++) {
            if (clientId < CLIENTS && t == nextArrivalTime) {
                Client client = clients[clientId] = new Client(++clientId, t);
                queue.add(client);
                System.out.println("\tClient queue: " + queue);
                if (clientId < CLIENTS) {
                    nextArrivalTime = t + randomArrival.nextInt();
                }
            }

            for (Server server : servers) {
                if (t == server.getStopTime() && !server.isIdle()) {
                    server.stopServing(t);
                }
                if (server.isIdle() && !queue.isEmpty()) {
                    Client client = queue.remove();
                    System.out.println("\tClient queue: " + queue);
                    server.startServing(client, t);
                }
            }
            if(clientId == CLIENTS && queue.isEmpty() && allServersIdle()){
                break;
            }
        }
    }

    private boolean allServersIdle() {
        for (Server server : servers) {
            if (!server.isIdle()) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Simulation();
    }
}

// Interface for a generic Queue
interface Queue<E> {
    void add(E e);
    E remove();
    boolean isEmpty();
    int size();
}

// Implementation of ArrayQueue using LinkedList for simplicity
class ArrayQueue<E> implements Queue<E> {
    private LinkedList<E> list = new LinkedList<>();

    @Override
    public void add(E e) {
        list.addLast(e);
    }

    @Override
    public E remove() {
        if (isEmpty()) {
            return null;
        }
        return list.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

// Class for generating exponentially distributed random numbers
class ExpRandom {
    private double mean;
    private Random random;

    public ExpRandom(double mean) {
        this.mean = mean;
        this.random = new Random();
    }

    public double nextDouble() {
        return -mean * Math.log(random.nextDouble());
    }

    public int nextInt() {
        return (int) Math.round(nextDouble());
    }
}

class Client {
    private int id;
    private int arrivalTime;
    private int startTime;
    private int stopTime;

    public Client(int id, int arrivalTime) {
        this.id = id;
        this.arrivalTime = arrivalTime;
        System.out.printf("%s arrived at the time %d.%n", this, arrivalTime);
    }

    public void setStart(int time) {
        startTime = time;
    }

    public int getId() {
        return id;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStopTime(int stopTime) {
        this.stopTime = stopTime;
    }

    public int getStopTime() {
        return stopTime;
    }

    @Override
    public String toString() {
        return "#" + id;
    }
}

class Server {
    private Client client;
    private int id;
    private int stopTime = -1;
    private double meanServiceTime;
    private ExpRandom random;

    public Server(int id, double meanServiceTime) {
        this.id = id;
        this.meanServiceTime = meanServiceTime;
        this.random = new ExpRandom(meanServiceTime);
    }

    public double getMeanServiceTime() {
        return meanServiceTime;
    }

    public int getStopTime() {
        return stopTime;
    }

    public boolean isIdle() {
        return client == null;
    }

    public void startServing(Client client, int time) {
        this.client = client;
        this.client.setStart(time);
        this.stopTime = time + random.nextInt();
        this.client.setStopTime(this.stopTime);
        System.out.printf("%s started serving client %s at time %d.%n", this, client, time);
    }

    public void stopServing(int time) {
        System.out.printf("%s stopped serving client %s at the time %d.%n ", this, client, time);
        this.client = null;
        this.stopTime = -1;
    }

    @Override
    public String toString() {
        return "Server" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(id);
    }
}