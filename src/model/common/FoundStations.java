package model.common;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import model.beans.Station;

/**
 *
 * @author skuarch
 */
public class FoundStations {

    private static Map<Long, Station> foundStations = new ConcurrentHashMap<>();

    //==========================================================================
    private FoundStations() {
    } // end FoundStations

    synchronized public static void put(Long id, Station station){
        foundStations.put(id, station);
    }
    
    synchronized public static void remove(Long id){
        foundStations.remove(id);
    }    
    
    public static Map<Long, Station> getFoundStations() {
        return foundStations;
    }

    public static void setFoundStations(ConcurrentHashMap<Long, Station> foundStations) {
        FoundStations.foundStations = foundStations;
    }
    
} // end class