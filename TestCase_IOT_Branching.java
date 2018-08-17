import java.io.*;
import java.util.*;

/**
 * TestCase_IOT_Branching
 * <p/>
 * The results of assessing this file should be three input/output stack traces with main
 * as the root.  The first trace uses a simple if, the second trace adds a else, the third trace
 * uses a switch statement
 * <p/>
 * Complexity: Moderate
 */
public class TestCase_IOT_Branching {
    public static void main(String[] args) {
        try {
            // simple null check (first trace)
            TestCase_IOT_Branching testCase = new TestCase_IOT_Branching();
            final String source = testCase.getVulnerableSource(args[0]);
            if (source != null) {
                testCase.writeToVulnerableSink1(source);
            }

            // simple if/else (second trace)
            int i = new Random().nextInt(5);
            String source2;
            if (i < 2) {
                source2 = testCase.getVulnerableSource(args[0]);
            } else {
                source2 = "Safe";
            }
            testCase.writeToVulnerableSink2(source2);

            // simple switch (third trace)
            String source3;
            switch (i) {
                case 1:
                    source3 = "fine";
                    break;

                case 2:
                    source3 = "great";
                    break;

                case 3:
                    source3 = testCase.getVulnerableSource(args[0]);
                    break;

                default:
                    source3 = null;
                    break;
            }
            testCase.writeToVulnerableSink3(source3);
        } catch (Exception e) {
        }
    }

    public String getVulnerableSource(String file)
        throws IOException, FileNotFoundException {
        String ret = "";
        if (file != null) {
            FileInputStream fis = new FileInputStream(file);
            byte[] buf = new byte[100];
            fis.read(buf);
            ret = new String(buf);
            fis.close();
            return ret;
        }
        return ret;
    }

    public void writeToVulnerableSink1(String str)
        throws FileNotFoundException {
        if (str.length() > 0) {
            FileOutputStream fos = new FileOutputStream(str);
            PrintWriter writer = new PrintWriter(fos);
            writer.write(str);
        }
    }

    public void writeToVulnerableSink2(String str) throws IOException {
        FileOutputStream fos = new FileOutputStream(str);
        fos.write(str.getBytes());
    }

    public void writeToVulnerableSink3(String str) throws FileNotFoundException {
        FileOutputStream fos = new FileOutputStream(str);
        PrintWriter writer = new PrintWriter(fos);
        writer.write(str);
    }
	

	public void dummyMethod(){int i = 0;}
	
	//add methods with findings here
	
	//add dummy method back here
	
	//insert new comment here
	
	//Insert function with definite vulnerability here
}
