package com.bemach.aep.verifier.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * You can run this test at the command line as follows:
 * 
 * mvn clean -Dtest=com.bemach.aep.verifier.util.NetworkInfoTest test
 * 
 * @author ktran
 *
 */
public class NetworkInfo {

	private String ipAddress = null;
	private SocketException exception;
	private List<String> ips = new ArrayList<String>();
	
	public List<String> getIpAddresses() {
		try {
			Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
			while (nis.hasMoreElements()) {
				NetworkInterface ni = (NetworkInterface)nis.nextElement();
				Enumeration<InetAddress> ias = ni.getInetAddresses();
				while (ias.hasMoreElements()) {
					InetAddress ia = ias.nextElement();
					ips .add(ia.getHostAddress());
				}
			}
		} catch (SocketException e) {
			exception = e;
		}
		
		return ips;
	}

	/**
	 * Runs like this:
	 * 
	 * 	java -cp ./verifier-0.1.jar com.bemach.aep.verifier.util.NetworkInfo
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		NetworkInfo ni = new NetworkInfo();
		List<String> ips = ni.getIpAddresses();
		for (String ip: ips) {
			System.out.println("ip: " + ip);
		}
	}
}
