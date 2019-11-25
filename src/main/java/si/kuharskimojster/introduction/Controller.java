package si.kuharskimojster.introduction;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class Controller {

    @Value("${project.members}")
    private List<String> members;

    @Value("${project.description}")
    private String projectDescription;

    @Value("${list.of.endpoints}")
    private List<String> endpoints;

    @Value("${github.links}")
    private List<String> gitLinks;

    @Value("${travis.links}")
    private List<String> travisLinks;

    @Value("${dockerhub.links}")
    private List<String> dockerHubLinks;

    @GetMapping("/health")
    public ResponseEntity<String> getHealth() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @GetMapping("/info")
    public ResponseEntity<ResponseModel> getInfo(){
        ResponseModel responseModel = new ResponseModel(members, projectDescription, endpoints, gitLinks, travisLinks, dockerHubLinks);
        return new ResponseEntity<>(responseModel, HttpStatus.OK);
    }




}
