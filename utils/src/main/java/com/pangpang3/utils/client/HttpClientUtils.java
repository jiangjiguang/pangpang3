package com.pangpang3.utils.client;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiangjg on 2017/2/17.
 */
public class HttpClientUtils {
    public static void main(String[] args) {

    }
    public static HttpClientResult executeGet(String url){
        try {
            String resultContent = Request.Get(url)
                    .connectTimeout(5000)
                    .socketTimeout(10000)
                    .execute().returnContent().asString();

            return new HttpClientResult(200,"SUCCESS",resultContent);
        } catch (Exception ex) {
            return new HttpClientResult(503, ExceptionUtils.getStackTrace(ex));
        }
    }
    public static HttpClientResult executeForm(String url, List<NameValuePair> params) {
        try {
            StatusLine status = Request.Post(url)
                    .bodyForm(params, Charset.forName("UTF-8"))
                    .connectTimeout(5000)
                    .socketTimeout(10000)
                    .execute().returnResponse().getStatusLine();
            if (status.getStatusCode() != 200) {
                return new HttpClientResult(status.getStatusCode(), status.getReasonPhrase());
            } else {
                return new HttpClientResult(200, "SUCCESS");
            }
        } catch (Exception ex) {
            return new HttpClientResult(503, ex.toString());
        }
    }

    public static HttpClientResult executePost(String url, String content){
        try {
            HttpEntity httpEntity = new StringEntity(content, ContentType.create("application/json", "UTF-8"));
            Response response = Request.Post(url)
                    .connectTimeout(5000)
                    .socketTimeout(10000)
                    .body(httpEntity)
                    .execute();
            HttpResponse httpResponse = response.returnResponse();
            StatusLine status = httpResponse.getStatusLine();
            HttpEntity httpEntityResponse = httpResponse.getEntity();

            if (status.getStatusCode() != 200) {
                return new HttpClientResult(status.getStatusCode(), status.getReasonPhrase());
            } else {
                return new HttpClientResult(200, "SUCCESS", EntityUtils.toString(httpEntityResponse, Charset.forName("UTF-8")));
            }
        }catch (Exception ex){
            return new HttpClientResult(503, ExceptionUtils.getStackTrace(ex));
        }
    }
}
