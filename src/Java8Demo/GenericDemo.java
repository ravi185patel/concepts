package Java8Demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericDemo {

	public static void main(String[] args) {
		List<? extends Number> lst=new ArrayList<Integer>();
		List<? super Integer> lst1=new ArrayList<Number>();
	}
}
