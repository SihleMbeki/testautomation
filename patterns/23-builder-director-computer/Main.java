public class Main {
    public static void main(String[] args) {
        ComputerDirector director = new ComputerDirector();
        System.out.println("Gaming: " + director.buildGaming(new StandardComputerBuilder()));
        System.out.println("Professional: " + director.buildProfessional(new StandardComputerBuilder()));
        System.out.println("Mining: " + director.buildMining(new StandardComputerBuilder()));
        StandardComputerBuilder custom = new StandardComputerBuilder();
        custom.setCpu("Quiet CPU"); custom.setGpu("Entry GPU"); custom.setRam("24 GB");
        custom.setStorage("2 TB SSD"); custom.setPsu("650 W"); custom.setCooling("Air cooling");
        System.out.println("Custom: " + custom.build());
    }
}
