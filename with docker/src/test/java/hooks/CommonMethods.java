package hooks;

import java.io.IOException;

public class CommonMethods {
    public static void runDockerContainer() throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec("docker-compose up");
        Thread.sleep(10000);
    }

    public static void stopDockerContainer() throws IOException, InterruptedException {
        Process p = Runtime.getRuntime().exec("docker-compose down");
        Thread.sleep(10000);
    }
}
