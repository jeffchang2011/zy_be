package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class http_client {
	/*
	public static void main(String[] args) throws ClientProtocolException,
			IOException {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(
				"http://10.134.15.20:8080/sugg/ajaj_json.jsp?key=liudehua&suguuid=0&ip=36.110.147.198&iploc=10.134.107.103&ad_type=1&type=websugg&webfront=websugg&abtestid=7&suid=3&yyid=4&pid=sogou&policyno=7&mfp=8&hs=9&mp=0");
		HttpResponse response = client.execute(get);
		System.out.println(response.getProtocolVersion());
		System.out.println(response.getStatusLine().getStatusCode());
		System.out.println(response.getStatusLine().getReasonPhrase());
		System.out.println(response.getStatusLine().toString());
		HttpEntity entity = response.getEntity();
		System.out.println(convertStreamToString(entity.getContent()));
	}
	*/
	
	public static String send_get_request(String url) throws UnsupportedEncodingException, UnsupportedOperationException, IOException {
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
