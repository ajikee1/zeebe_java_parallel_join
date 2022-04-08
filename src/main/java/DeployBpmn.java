import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.DeploymentEvent;

public class DeployBpmn {

    public static void main(String[] args) {

        ZeebeClient client = ZeebeClient.newClientBuilder().usePlaintext().build();

        // Deploy the BPMN file
        DeploymentEvent deploymentEvent = client.newDeployCommand()
                .addResourceFromClasspath("parallel_join.bpmn")
                .send()
                .join();


    }
}
