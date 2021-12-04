package Java8Demo;

interface SampleInfo {
    public SampleDemo get(String str);
}

class SampleDemo {
    private String str;

    SampleDemo(String str) {
        this.str = str;
        System.out.println(str);
    }
}

public class DoubleColonDemo {
    public static void main(String[] args) {
        SampleInfo sampleInfo = s -> new SampleDemo(s);
        sampleInfo.get("ravi patel");
        sampleInfo = SampleDemo::new;
        sampleInfo.get("no he is not here");

    }
}
