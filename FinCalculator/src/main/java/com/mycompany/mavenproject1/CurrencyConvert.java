/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import static com.mycompany.mavenproject1.VisualCurrency.getContentOfHTTPPage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Map;

/**
 *
 * @author ilyas
 */
public class CurrencyConvert {
    
    

    
    public static void main(String[] args) {
        
    
        
    }
    
    public static float getСurVal(String link) throws Exception {
        
    String dol = getContentOfHTTPPage(link);
    dol = dol.substring(dol.indexOf("currencies_table_def")+"currencies_table_def".length());
    float usd = 1;
    
    try {
      usd = Float.parseFloat(dol.substring(81, 83)+"."+dol.substring(84, 88));
    } catch (NumberFormatException e) {
    try {
      usd = Float.parseFloat(dol.substring(81, 82)+"."+dol.substring(83, 87));
    } catch (NumberFormatException ex) {
      usd = Float.parseFloat(dol.substring(81, 84)+"."+dol.substring(85, 89));
    }                 
    } 
    
    return usd;
        
    }
    
//    public static float getEUR() throws Exception {
//        
//    String dol = getContentOfHTTPPage("https://www.vbr.ru/banki/kurs-valut/cbrf/eur/3mesaca/");
//    dol = dol.substring(dol.indexOf("currencies_table_def")+"currencies_table_def".length());
//    float eur = Float.parseFloat(dol.substring(81, 83)+"."+dol.substring(84, 88));
//    return eur;
//        
//    }
    
//    public static float getUSD() {
//        
//    String url = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";
//    String result = CurrencyConvert.sendRequest(url, null, null);
//    String result2 = result.substring(result.lastIndexOf("RUR"));
//    float coff =Float.parseFloat(result2.substring(result2.indexOf("\"sale\":\"")+8,result2.indexOf("\"sale\":\"")+8+7));
//    float usdGr =Float.parseFloat(result.substring(result.indexOf("\"sale\":\"")+8,result.indexOf("\"sale\":\"")+8+7));
//    String result3 = result.substring(result.lastIndexOf("EUR"));
//    float eurGr =Float.parseFloat(result3.substring(result3.indexOf("\"sale\":\"")+8,result3.indexOf("\"sale\":\"")+8+7));
//    float usd =usdGr * (1/coff);
//    float eur =eurGr * (1/coff);
//    return usd;
//        
//    }
//    
//    public static float getEUR() {
//        
//    String url = "https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5";
//    String result = CurrencyConvert.sendRequest(url, null, null);
//    String result2 = result.substring(result.lastIndexOf("RUR"));
//    float coff =Float.parseFloat(result2.substring(result2.indexOf("\"sale\":\"")+8,result2.indexOf("\"sale\":\"")+8+7));
//    float usdGr =Float.parseFloat(result.substring(result.indexOf("\"sale\":\"")+8,result.indexOf("\"sale\":\"")+8+7));
//    String result3 = result.substring(result.lastIndexOf("EUR"));
//    float eurGr =Float.parseFloat(result3.substring(result3.indexOf("\"sale\":\"")+8,result3.indexOf("\"sale\":\"")+8+7));
//    float usd =usdGr * (1/coff);
//    float eur =eurGr * (1/coff);
//    return eur;
//        
//    }
    
    public static String getContentOfHTTPPage(String pageAddress) throws Exception {
        StringBuilder sb = new StringBuilder();
        URL pageURL = new URL(pageAddress);
        URLConnection uc = pageURL.openConnection();
        BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        uc.getInputStream()));
        try {
            String inputLine;
            while ((inputLine = br.readLine()) != null) {
                sb.append(inputLine);
            }         
        } finally {
            br.close();
        }
        return sb.toString();
    }
    
    public static String sendRequest(String url, Map<String, String> headers, String request) {
        String result = null;
        HttpURLConnection urlConnection = null;
        try {
            URL requestUrl = new URL(url);
            urlConnection = (HttpURLConnection) requestUrl.openConnection();
            urlConnection.setReadTimeout(20000);
            urlConnection.setConnectTimeout(20000);
            urlConnection.setRequestMethod("GET");

            if (request != null) {
                urlConnection.setDoOutput(true);
                urlConnection.setRequestMethod("POST");
                DataOutputStream outputStream = new DataOutputStream(urlConnection.getOutputStream());
                outputStream.writeBytes(request);
                outputStream.flush();
                outputStream.close();
            }

            if (headers != null) {
                for (Map.Entry<String, String> entry : headers.entrySet()) {
                    urlConnection.addRequestProperty(entry.getKey(), entry.getValue());
                }
            }

            int status = urlConnection.getResponseCode();
            System.out.println("status code:" + status);

            if (status == HttpURLConnection.HTTP_OK) {
                result = getStringFromStream(urlConnection.getInputStream());
            }
        } catch (Exception e) {
            System.out.println("sendRequest failed");
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }
        return result;
    }
    
    private static String getStringFromStream(InputStream inputStream) throws IOException {
        final int BUFFER_SIZE = 4096;
        ByteArrayOutputStream resultStream = new ByteArrayOutputStream(BUFFER_SIZE);
        byte[] buffer = new byte[BUFFER_SIZE];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
            resultStream.write(buffer, 0, length);
        }
        return resultStream.toString("UTF-8");
    }
    
}
