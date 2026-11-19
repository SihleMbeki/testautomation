public interface ComputerBuilder {
    void setCpu(String cpu);
    void setGpu(String gpu);
    void setRam(String ram);
    void setStorage(String storage);
    void setPsu(String psu);
    void setCooling(String cooling);
    Computer build();
}
