import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * Created by Administrator on 2016/5/23.
 */
public class HC {
    public static void main(String[] args) throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.iqilu.com");
        CloseableHttpResponse response = httpClient.execute(httpGet);

        try{
            HttpEntity entity = response.getEntity();
            if(entity != null) {
                System.out.print(EntityUtils.toString(entity, "utf-8"));
            }

        } finally {
            httpClient.close();
            response.close();
        }
    }
}
