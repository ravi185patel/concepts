package Java8Demo;

interface Idemo{
	public static String getString() {
		return "static method";
	}
	public default String getStringD() {
		return "default method";
	}
	public default String getStringD2() {
		return "default method 2";
	}
}
interface Idemo2{
	public static String getString() {
		return "static method";
	}
	public default String getStringD() {
		return "default method";
	}
	public default String getStringD2() {
		return "default method 2";
	}
}
class ImpIDemo implements Idemo,Idemo2{
	public String getStringD2() {
		return "default method 2 override";
	}

	@Override
	public String getStringD() {
		return ( Idemo.super.getStringD() +" "+ Idemo2.super.getStringD());
	}
}
public class InterfaceDemo {
	public static void main(String[] args) {
		ImpIDemo demo=new ImpIDemo();
		System.out.println(demo.getStringD());
		System.out.println(demo.getStringD2());
		System.out.println(Idemo.getString());
	}
}
