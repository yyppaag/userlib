package com.xoyogame.net;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

public class HTTPRequest {
	public static String sendPostRequest(String url, Map<String, String> params)throws ClientProtocolException, IOException{ 
		String result = null;
		HttpClient httpClient = null;
		
		httpClient = new DefaultHttpClient();

		HttpPost get = new HttpPost(url);

		// 创建表单参数列表
		List<NameValuePair> qparams = new ArrayList<NameValuePair>();
		Set<String> keys = params.keySet();
		for (String key : keys) {
			qparams.add(new BasicNameValuePair(key, params.get(key)));
		}

		// 填充表单
		get.setEntity(new UrlEncodedFormEntity(qparams, "UTF-8"));

		HttpResponse response = httpClient.execute(get);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			entity = new BufferedHttpEntity(entity);

			InputStream in = entity.getContent();
			byte[] read = new byte[1024];
			byte[] all = new byte[0];
			int num;
			while ((num = in.read(read)) > 0) {
				byte[] temp = new byte[all.length + num];
				System.arraycopy(all, 0, temp, 0, all.length);
				System.arraycopy(read, 0, temp, all.length, num);
				all = temp;
			}
			result = new String(all, "UTF-8");
			if (null != in) {
				in.close();
			}
		}
		get.abort();

		return result;
	}
}