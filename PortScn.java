import java.util.concurrent.atomic.AtomicInteger;
import java.net.*;
class Counter
{
	AtomicInteger count = new AtomicInteger(0);
	public void increment()
	{
		count.incrementAndGet();
	}
}
public class PortScn
{
	public static void main(String[] args)
	{
		Counter c = new Counter();
		// total ports scanned = 50* 1000
		for(int i=0; i<70; i++)
		{
			Thread temp = new Thread(new Runnable()
			{	public void run()
				{
					Socket s;
					
					for(int i=0; i<1000; i++)
					{
						try
						{	int port = c.count.get();	
							c.increment();
							// specify ip address you want to scan
							s = new Socket("127.0.0.1",port);
						 
							System.out.println(s);
						}catch(Exception e){
						}
						
					}	
				
				}
			});
			temp.run();
	
		}	
	System.out.println("Count "+c.count); 	
}
}
