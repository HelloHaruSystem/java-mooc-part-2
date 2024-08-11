package com.finnishparties;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.*;

public class DataSet {
    private Map<String, Map<Integer, Double>> partyData;

    public DataSet() {
        this.partyData = new HashMap<>();
    }

    public Map<String, Map<Integer, Double>> getPartyData() {
        return partyData;
    }

    public void loadData(String filename) {
        List<Integer> yearList = new ArrayList();
        Map<String, Map<Integer, Double>> data = new HashMap<>();

        try {
            Scanner scanner = new Scanner(new File(String.valueOf(Paths.get(filename))));

            String lineReader = scanner.nextLine();
            String[] firstLineParts = lineReader.split("\t");
            for (int i = 1; i < firstLineParts.length; i++) {
                yearList.add(Integer.valueOf(firstLineParts[i]));
            }

            while (scanner.hasNextLine()) {

                lineReader = scanner.nextLine();
                String[] parts = lineReader.split("\t");

                String partyName = parts[0];
                HashMap<Integer, Double> supportValues = new HashMap();

                for (int i = 1; i < parts.length; i++) {
                    if (!parts[i].equals("-")) {
                        int year = yearList.get(i - 1);
                        double supportNumber = Double.valueOf(parts[i]);
                        supportValues.put(year, supportNumber);
                    }
                }

                data.put(partyName, supportValues);
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);

        }

        this.partyData = data;
    }

}
