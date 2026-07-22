package ConcurrencyPkg.implementationdemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class PrintOddEvenNumberUsingJava8Feature {

	public int counter,limit;
	public Predicate<Integer> odd = (i)-> i%2 != 0;
	public Predicate<Integer> even = (i)-> i%2 != 0;

	public PrintOddEvenNumberUsingJava8Feature(int limit){
		this.limit = limit;
	}

	public void print(Predicate<Integer> predicate){
		IntStream.range(1,limit).filter(predicate::test).forEach(this::execute);
	}

	public synchronized void execute(int i){
		try {
			wait();
			System.out.println("Thread name :"+Thread.currentThread().getName()+" -- :"+i);
			notify();
		}catch (InterruptedException ex){

		}
		finally {

		}
	}

	public static void main(String[] args) {
		PrintOddEvenNumberUsingJava8Feature p = new PrintOddEvenNumberUsingJava8Feature(10);
		Thread t=new Thread(()-> p.print(p.odd),"Odd");
		Thread t1=new Thread(()-> p.print(p.even),"Even");

		t.start();
		t1.start();

	}
}