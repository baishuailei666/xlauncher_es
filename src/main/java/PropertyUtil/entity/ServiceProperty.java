package PropertyUtil.entity;

public class ServiceProperty {

    private int serId;
    private String serName;
    private String serIp;
    private String serPort;

    public ServiceProperty(){

    }

    public int getSerId() {
        return serId;
    }

    public void setSerId(int serId) {
        this.serId = serId;
    }

    public String getSerName() {
        return serName;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public String getSerIp() {
        return serIp;
    }

    public void setSerIp(String serIp) {
        this.serIp = serIp;
    }

    public String getSerPort() {
        return serPort;
    }

    public void setSerPort(String serPort) {
        this.serPort = serPort;
    }
}
