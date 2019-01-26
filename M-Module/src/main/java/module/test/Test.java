package module.test;

public class Test implements java.io.Serializable {

    private String code;
    private String name;
    private int calcMode;

    public Test(){}

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalcMode() {
        return calcMode;
    }

    public void setCalcMode(int calcMode) {
        this.calcMode = calcMode;
    }
}
