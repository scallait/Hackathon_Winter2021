
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
public class siteBlocker {
    public void siteBlocker(String url) {

        // Get OS name
        String OS = System.getProperty("os.name").toLowerCase();

        // Use OS name to find correct location of hosts file
        String hostsFile = "";
        if ((OS.indexOf("win") >= 0)) {
            // Doesn't work before Windows 2000
            hostsFile = "C:\\Windows\\System32\\drivers\\etc\\hosts";
        } else if ((OS.indexOf("mac") >= 0)) {
            // Doesn't work before OS X 10.2
            hostsFile = "etc/hosts";
        } else if ((OS.indexOf("nux") >= 0)) {
            hostsFile = "/etc/hosts";
        } else {
            // Handle error when platform is not Windows, Mac, or Linux
            System.err.println("Sorry, but your OS doesn't support blocking.");
            System.exit(0);
        }

        try
        {
            //Actually block site
            Files.write(Paths.get(hostsFile),
                    ("127.0.0.1 " + url).getBytes(),
                    StandardOpenOption.APPEND);

            //Unblock site

       }
        catch (IOException ee)
        {
            System.out.println(ee.toString());
        }

    }
}
