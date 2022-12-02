package fi.tuni.roadwatch;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Contains maintenance data received from the digiTraffic API
 */
public class Maintenance {

    public Map<String, Integer> tasks;
    public Date date;

    ArrayList<Feature> features;

    @JsonProperty("features")
    public ArrayList<Feature> getFeatures() {
        return this.features; }
    public void setFeatures(ArrayList<Feature> features) {
        this.features = features; }

    /**
     * Sets tasks based on given date
     * @param date
     */
    public void setTasksAndDate(Date date) {
        tasks = new HashMap<>();
        this.date = date;

        assert features != null;
        for(Feature f : features){
            for(String task : f.properties.tasks){
                tasks.compute(task, (key, val) -> {
                    if(val == null){return 1;}return val + 1;
                });
            }
        }
    }

    /**
     * Autogenerated class by Jackson
     */
    public static class Feature{
        Properties properties;
        Geometry geometry;

        @JsonProperty("properties")
        public Properties getProperties() {
            return this.properties; }
        public void setProperties(Properties properties) {
            this.properties = properties; }

        @JsonProperty("geometry")
        public Geometry getGeometry() {
            return this.geometry; }
        public void setGeometry(Geometry geometry) {
            this.geometry = geometry; }

    }

    /**
     * Autogenerated class by Jackson
     */
    public static class Geometry{
        String type;
        ArrayList<ArrayList<Double>> coordinates;

        @JsonProperty("type")
        public String getType() {
            return this.type; }
        public void setType(String type) {
            this.type = type; }

        @JsonProperty("coordinates")
        public ArrayList<ArrayList<Double>> getCoordinates() {
            return this.coordinates; }
        public void setCoordinates(ArrayList<ArrayList<Double>> coordinates) {
            this.coordinates = coordinates; }

    }
    /**
     * Autogenerated class by Jackson
     */
    public static class Properties{

        ArrayList<String> tasks;

        @JsonProperty("tasks")
        public ArrayList<String> getTasks() {
            return this.tasks; }
        public void setTasks(ArrayList<String> tasks) {
            this.tasks = tasks; }

    }

}
