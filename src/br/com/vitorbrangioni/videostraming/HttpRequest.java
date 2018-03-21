package br.com.vitorbrangioni.videostraming;

import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONObject;

/**
 * Http Request class
 * 
 * @author vitorbrangioni
 */
public class HttpRequest {
	
	private HttpRequest() {
	}

	public static JSONObject request(String url, Map<String, String> headers, Map<String, String> body) {
		HttpClient httpClient = HttpClientBuilder.create().build();
		JSONObject jsonObject = new JSONObject(body);
		JSONObject jsonReponse = null;
		
		try {
			HttpPost request = new HttpPost(url);
			StringEntity params = new StringEntity(jsonObject.toString());

			for (Map.Entry<String, String> header : headers.entrySet()) {
				request.addHeader(header.getKey(), header.getValue());
			}
			request.setEntity(params);
			HttpResponse response = httpClient.execute(request);
			jsonReponse = new JSONObject(new BasicResponseHandler().handleResponse(response));

		} catch (Exception ex) {
			System.out.println("Http Request error");
		}
		return jsonReponse;
	}
}