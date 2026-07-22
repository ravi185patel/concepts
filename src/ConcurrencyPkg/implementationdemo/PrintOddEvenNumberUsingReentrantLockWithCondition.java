package ConcurrencyPkg.implementationdemo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintOddEvenNumberUsingReentrantLockWithCondition{
	
	public int counter;
	public int limit;
	public ReentrantLock reentrantLock;
	public Condition odd,even;
	
	public PrintOddEvenNumberUsingReentrantLockWithCondition(int limit){
		counter=1;
		this.limit = limit;
		reentrantLock = new ReentrantLock();
		odd = reentrantLock.newCondition();
		even = reentrantLock.newCondition();
	}
	
	
	public void printAdd(){
		reentrantLock.lock();
		try{
			while(counter < limit){	
				while(counter%2 == 0){
					odd.await();	
				}			
				System.out.println(Thread.currentThread()+" : "+counter);
				counter++;
				even.signal();
			}
		}catch(InterruptedException ex){
			
		}finally{
			reentrantLock.unlock();
		}
	}
	
	public void printEven(){
		reentrantLock.lock();
		try{
			while(counter < limit){	
				while(counter%2 != 0){
					even.await();
				}
				System.out.println(Thread.currentThread()+" : "+counter);
				counter++;
				odd.signal();
			}		
		}catch(InterruptedException ex){
			
		}finally{
			reentrantLock.unlock();
		}
	}

	public static void main(String[] args) {
		PrintOddEvenNumberUsingReentrantLockWithCondition p = new PrintOddEvenNumberUsingReentrantLockWithCondition(10);
		Thread t=new Thread(()-> p.printAdd(),"Odd");
		Thread t1=new Thread(()-> p.printEven(),"Even");

		t.start();
		t1.start();

	}
}