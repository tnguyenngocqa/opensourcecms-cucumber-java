package managers;

import dataProviders.ConfigFileReader;
import dataProviders.ExtentReportConfigReader;

public class FileReaderManager {

    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigFileReader configFileReader;
    private static ExtentReportConfigReader extentReportConfigReader;

    private FileReaderManager() {
    }

    public static FileReaderManager getInstance() {
        return fileReaderManager;
    }

    public ConfigFileReader getConfigReader() {
        return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
    }

    public ExtentReportConfigReader getExtentReportConfigReader() {
        return (extentReportConfigReader == null) ? new ExtentReportConfigReader() : extentReportConfigReader;
    }
}
