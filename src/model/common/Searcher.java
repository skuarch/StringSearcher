package model.common;

import model.beans.Station;

/**
 *
 * @author skuarch
 */
public class Searcher extends Thread {

    private Station station = null;
    private String stringToSearch = null;
    private String[] arrayStringToSearch = null;
    private String[] arrayKeywords = null;

    //==========================================================================
    public Searcher(Station station, String stringToSearch) {
        this.station = station;
        this.stringToSearch = stringToSearch;
    } // end Searcher

    //==========================================================================
    @Override
    public void run() {

        String keywords = null;

        try {

            keywords = station.getKeywords() + " " + station.getName() + " " + station.getDescription();
            keywords = keywords.toLowerCase();

            arrayKeywords = keywords.split(" ");
            arrayStringToSearch = stringToSearch.split(" ");

            if (keywords.contains(stringToSearch)) {
                FoundStations.put(station.getId(), station);
            }

            if (arrayStringToSearch.length < 1) {

                return;

            } else {

                for (int i = 0; i < arrayStringToSearch.length; i++) {
                    if (keywords.contains(arrayStringToSearch[i])) {
                        FoundStations.put(station.getId(), station);
                        return;
                    }
                }

                for (int o = 0; o < arrayStringToSearch.length; o++) {
                    for (int i = 0; i < arrayKeywords.length; i++) {
                        if (arrayKeywords[i].equals(arrayStringToSearch[o])) {
                            FoundStations.put(station.getId(), station);
                        }
                    }
                }

                for (int i = 0; i < arrayKeywords.length; i++) {
                    if (searchByLetters(stringToSearch, arrayKeywords[i])) {
                        FoundStations.put(station.getId(), station);
                        break;
                    }
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    } // end run

    //==========================================================================
    private synchronized boolean searchByLetters(String stringToSearch, String keyword) {

        if (keyword == null || keyword == "null" || keyword == "") {
            return false;
        }

        boolean flag = false;
        int letterFound = 0;

        if (stringToSearch.charAt(0) == keyword.charAt(0)) {
            for (int i = 0; i < stringToSearch.length(); i++) {
                for (int o = 0; o < keyword.length(); o++) {
                    if (stringToSearch.charAt(i) == keyword.charAt(o)) {
                        letterFound++;
                    }
                }
            }
        }
        
        if (letterFound >= (stringToSearch.length() / 2) + 1) {            
            flag = true;
        }

        return flag;

    } // end searchByLetters
} // end class