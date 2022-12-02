package fi.tuni.roadwatch;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class SavedDataLogic {

    private static final ObjectMapper jsonMapper = new ObjectMapper();


    /**
    * Constructor for SavedDataLogic, used for setting up jsonMapper
     */
    public SavedDataLogic() {
        jsonMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        jsonMapper.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
        jsonMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        jsonMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }


    /**
     * @param fileName name of the file to be written to
     * @param weatherData WeatherData object
     */
    public void writeWeatherData(String fileName, WeatherData weatherData) throws IOException {
        jsonMapper.writeValue(new File(fileName + ".xml"), weatherData);
    }

    /**
     * @param fileName name of the file to be read from
     * @param weatherDataMinMaxAvg WeatherDataMinMaxAvg object
     */
    public void writeWeatherDataMinMaxAvg(String fileName, WeatherDataMinMaxAvg weatherDataMinMaxAvg) throws IOException {
        jsonMapper.writeValue(new File(fileName + ".xml"), weatherDataMinMaxAvg);
    }

    /**
     * @param fileName name of the file to be written to
     * @param maintenance Maintenance object
     */
    // TODO: Check writing of multiple days
    public void writeMaintenance(String fileName, Maintenance maintenance) throws IOException {
        jsonMapper.writeValue(new File(fileName + ".json"), maintenance);
    }

    /**
     * @param fileName name of the file to be written to
     * @param roadData RoadData object
     */
    public void writeRoadData(String fileName, RoadData roadData) throws IOException {
        jsonMapper.writeValue(new File(fileName + ".json"), roadData);
    }

    /**
     * @param fileName       name of the file to be written to
     * @param trafficMessage TrafficMessage object
     */
    public void writeTrafficMessage(String fileName, TrafficMessage trafficMessage) throws IOException {
        jsonMapper.writeValue(new File(fileName + ".json"), trafficMessage);
    }

    /**
     * @param file name of the file to be read from
     * @return WeatherData object
     */
    public WeatherData readWeatherData(File file) throws IOException {
        return jsonMapper.readValue(new File(file + ".json"), WeatherData.class);
    }

    /**
     * @param file name of the file to be read from
     * @return WeatherDataMinMaxAvg object
     */
    public WeatherDataMinMaxAvg readWeatherDataMinMaxAvg(File file) throws IOException {
        return jsonMapper.readValue(new File(file + ".json"), WeatherDataMinMaxAvg.class);
    }

    /**
     * @param file name of the file to be read from
     * @return Maintenance object
     */
    public RoadData readRoadData(File file) throws IOException {
        return jsonMapper.readValue(file, RoadData.class);
    }

    /**
     * @param file name of the file to be read from
     * @return TrafficMessage object
     */
    public TrafficMessage readTrafficMessage(File file) throws IOException {
        return jsonMapper.readValue(file, TrafficMessage.class);
    }

    /**
     * @param file name of the file to be read from
     * @return Maintenance object
     */

    public Maintenance readMaintenance(File file) throws IOException {
        return jsonMapper.readValue(file, Maintenance.class);
    }

    /**
     * Writes preferences to json when closing the program
     * @param fileName name of the file to be read from
     */
    public void writePreferences(String fileName, Map<String,String> preferences) throws IOException {
        jsonMapper.writeValue(new File(fileName), preferences);
    }

    /**
     * Reads preferences from json when opening the program
     * @param fileName name of the file to be read from
     */
    public Map<String,String> readPreferences(String fileName) throws IOException {
        Preferences preferences = jsonMapper.readValue(new File(fileName), Preferences.class);
        return preferences.getPreferencesAsMap();
    }


    /**
     * Data class for reading/writing of preferences to/from json
     */
    public static class Preferences {
        private String weatherPreference;
        private String conditionPreference;
        private String maintenancePreference;
        private String locationPreference;

        @JsonProperty("weatherPreference")
        public String getWeatherPreference() {
            return weatherPreference;
        }
        public void setWeatherPreference(String weatherPreference) {
            this.weatherPreference = weatherPreference;
        }

        @JsonProperty("conditionPreference")
        public String getConditionPreference() {
            return conditionPreference;
        }
        public void setConditionPreference(String conditionPreference) {
            this.conditionPreference = conditionPreference;
        }

        @JsonProperty("maintenancePreference")
        public String getMaintenancePreference() {
            return maintenancePreference;
        }
        public void setMaintenancePreference(String maintenancePreference) {
            this.maintenancePreference = maintenancePreference;
        }

        @JsonProperty("locationPreference")
        public String getLocationPreference() {
            return locationPreference;
        }
        public void setLocationPreference(String locationPreference) {
            this.locationPreference = locationPreference;
        }

        public Map<String, String> getPreferencesAsMap() {
            return Map.of("weatherPreference", weatherPreference,
                    "conditionPreference", conditionPreference,
                    "maintenancePreference", maintenancePreference,
                        "locationPreference", locationPreference);
        }
    }
}
