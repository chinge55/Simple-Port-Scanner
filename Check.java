import java.io.*;
import java.net.*;

/*
 * The NetworkInterface class's methods are static So, you don't build the instance of the class
 * with "new" as you would with other classes
 * */
public class Check
{
	public static void main(String[] args)
	{
		checkHosts("192.168.100");
	}
	public static void checkHosts(String subnet)
	{
		int timeout = 100;
		for(int i=1; i<255; i++)
		{
			String host = subnet+"."+i;
			try{
				if(InetAddress.getByName(host).isReachable(timeout)){
					System.out.println(host);
					InetAddress ip = InetAddress.getByName(host);
					NetworkInterface network = NetworkInterface.getByInetAddress(ip);
					byte []mac = network.getHardwareAddress();
					String address = null;
					StringBuilder sb = new StringBuilder();
					for(int j=0; j<mac.length; j++)
					{
						sb.append(String.format("%02X%s",mac[j],(j<mac.length-1)?"-":""));
					}
					address = sb.toString();
					System.out.println(address);
				}
			}catch(UnknownHostException e)
			{
			}catch(IOException e){
			}catch(NullPointerException e){}

		}
	}
}
