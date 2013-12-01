package stringsearcher;

import java.util.ArrayList;
import java.util.Map;
import model.beans.Station;
import model.common.FoundStations;
import model.common.Searcher;
import model.dao.DAO;

/**
 *
 * @author skuarch
 */
public class StringSearcher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String stringToSearch = "blaster";
        ArrayList<Station> stations = null;
        Map chm = FoundStations.getFoundStations();
        Station s = null;

        try {

            stringToSearch = stringToSearch.toLowerCase();
            stations = new DAO().getArrayList(new Station());

            for (Station station : stations) {
                new Thread(new Searcher(station, stringToSearch)).start();
            }

            Thread.sleep(10);
            System.out.println("found stations " + FoundStations.getFoundStations().size());

            for (Object key : chm.keySet()) {                
                System.out.println(chm.get(key));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    } //end main
} // end class
