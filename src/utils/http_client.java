package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class http_client {
	
	public static String sendGetRequest(String url) throws UnsupportedEncodingException, UnsupportedOperationException, IOException {
		HttpGet get = new HttpGet(url);
		resp = client.execute(get);
		entity = resp.getEntity();
		return convertStreamToString(entity.getContent());
	}

	public static String convertStreamToString(InputStream is)
			throws UnsupportedEncodingException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}

	public static void printHexString(byte[] b) {
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			System.out.print("%" + hex.toUpperCase() + "");
		}
		System.out.println("");
	}
	
	private static CloseableHttpClient client = HttpClients.createDefault();
	private static HttpResponse resp;
	private static HttpEntity entity;
}
