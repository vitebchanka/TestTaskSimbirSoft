package hooks;

import java.io.IOException;

public class CommonMethods {
    public static void runSeleniumGrid() throws IOException, InterruptedException {
        String runHub = "cmd /c start StartHUB.bat";
        String runChromeNode = "cmd /c start ChromeNodeStartWithConfig.bat";
        Runtime runtime = Runtime.getRuntime();
        Process proc = runtime.exec(runHub);
        Process proc2 = runtime.exec(runChromeNode);
        Thread.sleep(10000);
    }
}
