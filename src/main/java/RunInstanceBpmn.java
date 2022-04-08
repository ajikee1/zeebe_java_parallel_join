// https://docs.camunda.io/docs/0.26/components/clients/java-client/get-started/
// https://github.com/camunda-cloud/camunda-cloud-get-started/tree/main/java

import io.camunda.zeebe.client.ZeebeClient;
import io.camunda.zeebe.client.api.response.ProcessInstanceEvent;

public class RunInstanceBpmn {

    public static void main(String[] args) {

        ZeebeClient client = ZeebeClient.newClientBuilder().usePlaintext().build();

        // Start an instance
        for (int i = 0; i < 1; i++) {
            client.newCreateInstanceCommand()
                    .bpmnProcessId("parallel_join")
                    .latestVersion()
                    .send()
                    .join();
        }



    }

}
