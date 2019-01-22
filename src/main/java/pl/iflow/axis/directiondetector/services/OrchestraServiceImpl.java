package pl.iflow.axis.directiondetector.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class OrchestraServiceImpl implements OrchestraService {



    @Autowired
    RestTemplate restTemplate ;

    @Autowired
    HttpHeaders headers;


    @Override
    public void createVisitCall(String branchId, String entryPointId, String servicePointId, String serviceId) {

        try {
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setExpires(0);

            headers.setCacheControl("private, no-store, max-age=0");

            String requestJson = "{\"services\":[5]}";
            HttpEntity<String> param = new HttpEntity<>(requestJson, headers);

            restTemplate.exchange("http://localhost:8080/rest/entrypoint/branches/2/entryPoints/1/visits/", HttpMethod.POST,  param, String.class);
        }
        catch (Exception e)
        {
            System.out.print(e);
        }

    }

    @Override
    public void callAndEndCall(String branchId, String entryPointId, String servicePointId, String serviceId) {
        System.out.print("SERVICE CALL AND END CALL");
    }

}
