public class ComputerDirector {
    public Computer buildGaming(ComputerBuilder b) {
        b.setCpu("High-speed CPU"); b.setGpu("Gaming GPU"); b.setRam("32 GB");
        b.setStorage("2 TB NVMe"); b.setPsu("850 W"); b.setCooling("Liquid cooling");
        return b.build();
    }
    public Computer buildProfessional(ComputerBuilder b) {
        b.setCpu("Workstation CPU"); b.setGpu("Professional GPU"); b.setRam("64 GB");
        b.setStorage("4 TB NVMe"); b.setPsu("1000 W"); b.setCooling("Quiet air cooling");
        return b.build();
    }
    public Computer buildMining(ComputerBuilder b) {
        b.setCpu("Efficient CPU"); b.setGpu("Mining GPU"); b.setRam("16 GB");
        b.setStorage("1 TB SSD"); b.setPsu("1200 W"); b.setCooling("High-airflow cooling");
        return b.build();
    }
}
