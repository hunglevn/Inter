package com.inter.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * Utility for networking operations.
 * 
 * @author Kevin
 *
 */
public class NetworkUtil {
	public static String hostName() {
		Map<String, String> enviorntmentVars = System.getenv();
		String hostName = enviorntmentVars.get("HOSTNAME");
		if (hostName == null) {
			InetAddress ip;
			try {
				ip = InetAddress.getLocalHost();
				hostName = ip.getHostName();
			} catch (UnknownHostException e) {
				hostName = "Unknown";
			}
		}
		return hostName;
	}

}
