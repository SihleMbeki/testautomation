public class StandardComputerBuilder implements ComputerBuilder {
    private String cpu, gpu, ram, storage, psu, cooling;
    public void setCpu(String value) { cpu = value; }
    public void setGpu(String value) { gpu = value; }
    public void setRam(String value) { ram = value; }
    public void setStorage(String value) { storage = value; }
    public void setPsu(String value) { psu = value; }
    public void setCooling(String value) { cooling = value; }
    public Computer build() {
        if (cpu == null || gpu == null || ram == null || storage == null || psu == null || cooling == null)
            throw new IllegalStateException("Every computer part must be selected.");
        return new Computer(cpu, gpu, ram, storage, psu, cooling);
    }
}
