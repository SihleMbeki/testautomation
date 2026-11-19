public class Computer {
    private final String cpu, gpu, ram, storage, psu, cooling;
    public Computer(String cpu, String gpu, String ram, String storage, String psu, String cooling) {
        this.cpu = cpu; this.gpu = gpu; this.ram = ram;
        this.storage = storage; this.psu = psu; this.cooling = cooling;
    }
    public String toString() {
        return "CPU=" + cpu + ", GPU=" + gpu + ", RAM=" + ram + ", storage=" + storage
                + ", PSU=" + psu + ", cooling=" + cooling;
    }
}
