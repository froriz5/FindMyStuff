package edu.gatech.oad.fullhouse.findmystuff.client;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import edu.gatech.oad.fullhouse.findmystuff.model.Settings;

/**
 * A simple client to manipulate a REST resource on a server
 * 
 * @author thejenix
 *
 * @param <T>
 */
public class RESTClient<T> {

//    public static void main(String[] args) {
//        //test code
//        Settings.instance().setServerUrl("http://localhost:3000");
//        RESTClient client = new RESTClient(User.class);
//        client.list();
//        User user = new User();
//        user.setUsername("jrosalia");
//        user.setPassword("wouldntyouliketoknow");
//        
//        client.create(user);
//        
//        client.list();
//    }
//
    private Class<T> objectClass;
    private String query;

    public RESTClient(Class<T> objectClass) {
        this(objectClass, getDefaultQueryName(objectClass));
        
    }

    private static String getDefaultQueryName(Class<?> clazz) {
        String name = clazz.getSimpleName();
        StringBuilder builder = new StringBuilder();
        for (int ii = 0; ii < name.length(); ii++) {
            char chr = name.charAt(ii);
            
            if ((chr & 0x20) == 0) {
                if (builder.length() > 0) {
                    builder.append('_');
                }
                
                builder.append((char)((int)chr | 0x20));
            } else {
                builder.append(chr);
            }
        }
        builder.append("s");
        return builder.toString();
    }

    public RESTClient(Class<T> objectClass, String query) {
        this.objectClass = objectClass;
        this.query       = query;
    }

    public T get(long id) {
        String json = doGet(id);
        Gson gson = new Gson();
        return gson.fromJson(json, this.objectClass);
    }

    public List<T> list() {
        String json = doGet(null);
        Gson gson = new Gson();
        T[] array = (T[]) Array.newInstance(objectClass, 0);
        T[] objects = (T[]) gson.fromJson(json, array.getClass());
        return Arrays.asList(objects);
    }

    public void create(T obj) {
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        doPost("create", json);
    }

    public void update(T obj, long id) {
        throw new UnsupportedOperationException("NYI");
    }

    public void destroy(T obj) {
        throw new UnsupportedOperationException("NYI");
    }

    private String doGet(Long id) {
        HttpURLConnection connection = null;
        try {
            String urlStr = Settings.instance().getServerUrl() + "/" + query + (id != null ? ("/" + id.toString()) : "") + ".json";
            URL url = new URL(urlStr);
//            String message = new String("{\"id\":1, \"regId\":\"" + regId
//                    + "\"}");
            connection = (HttpURLConnection) url.openConnection();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                return inputStreamToString(connection.getInputStream());
            } else {
                throw new IOException("Http response: " + responseCode);
            }
//            connection.setDoOutput(true);
//            connection.setRequestMethod("POST");
//            connection.setRequestProperty("Content-Length",
//                    Integer.toString(message.length()));
//            connection.setRequestProperty("Content-Type", "application/json");
//            connection.getOutputStream().write(message.getBytes());
//            connection.connect();
//            connection.getResponseCode();
            // this.retries = 0;
        } catch (IOException ex) {
            // this.retries++;
            // if (this.retries >= 5) {
            throw new RuntimeException(ex);
            // }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
    
    private String inputStreamToString(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int bytes = 0;
        
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while ((bytes = inputStream.read(buffer)) > 0) {
            baos.write(buffer, 0, bytes);
        }
        return baos.toString();
    }

    private void doPost(String cmd, String json) {
        HttpURLConnection connection = null;
        try {
            URL url = new URL(Settings.instance().getServerUrl() + "/" + query);
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Length",
                    Integer.toString(json.length()));
            connection.setRequestProperty("Content-Type", "application/json");
            connection.getOutputStream().write(json.getBytes());
            connection.connect();
            connection.getResponseCode();
            // this.retries = 0;
        } catch (IOException ex) {
            // this.retries++;
            // if (this.retries >= 5) {
            throw new RuntimeException(ex);
            // }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
