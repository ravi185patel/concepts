package ConcurrencyPkg.implementationdemo;

public class PrintOddEvenNumberUsingSync{
	
	public int counter;
	public int limit;
	
	public PrintOddEvenNumberUsingSync(int limit){
		counter=1;
		this.limit = limit;
	}
	
	
	public synchronized void printAdd(){
		try{
			while(counter < limit){	
				while(counter%2 == 0){
					wait();	
				}
				System.out.println(Thread.currentThread()+" : "+counter);
				counter++;
				notifyAll();
			}
		}catch(InterruptedException ex){
			
		}finally{
			
		}
	}
	
	public synchronized void printEven(){
		try{
			while(counter < limit){	
				while(counter%2 != 0){
					wait();	
				}
				System.out.println(Thread.currentThread()+" : "+counter);
				counter++;
				notifyAll();
			}		
		}catch(InterruptedException ex){
			
		}finally{
			
		}
	}

	public static void main(String[] args) {
		PrintOddEvenNumberUsingSync p = new PrintOddEvenNumberUsingSync(10);
		Thread t=new Thread(()-> p.printAdd(),"Odd");
		Thread t1=new Thread(()-> p.printEven(),"Even");

		t.start();
		t1.start();
	}
	
}