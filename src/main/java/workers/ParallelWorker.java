package workers;

import io.camunda.zeebe.client.ZeebeClient;

public class ParallelWorker {
    public static void main(String[] args) {

        ZeebeClient client = ZeebeClient.newClientBuilder().numJobWorkerExecutionThreads(5).usePlaintext().build();

        client.newWorker().jobType("parallel-task").handler((jobClient, job) -> {
            int time = (Integer) job.getVariablesAsMap().get("time");

            try {
                Thread.sleep(time * 1000);
                System.out.println("Parallel task that slept for " + time + " seconds");

            } catch (Exception e) {

            }
            jobClient.newCompleteCommand(job.getKey()).send()
                    .whenComplete((result, exception) -> {
                        if (exception == null) {
                        } else {
                        }
                    });
        }).open();


        client.newWorker().jobType("post-parallel-task").handler((jobClient, job) -> {

            System.out.println("Task running after all parallel tasks finished running");

            jobClient.newCompleteCommand(job.getKey()).send()
                    .whenComplete((result, exception) -> {
                        if (exception == null) {
                        } else {
                        }
                    });
        }).open();


    }


}
