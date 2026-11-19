public class Naive {
    public static void main(String[] args) {
        // Repeating long constructors makes it easy to swap or omit similar part values.
        Computer gaming = new Computer("High-speed CPU", "Gaming GPU", "32 GB",
                "2 TB NVMe", "850 W", "Liquid cooling");
        Computer professional = new Computer("Workstation CPU", "Professional GPU", "64 GB",
                "4 TB NVMe", "1000 W", "Quiet air cooling");
        Computer mining = new Computer("Efficient CPU", "Mining GPU", "16 GB",
                "1 TB SSD", "1200 W", "High-airflow cooling");
        System.out.println("Gaming: " + gaming);
        System.out.println("Professional: " + professional);
        System.out.println("Mining: " + mining);
    }
}
