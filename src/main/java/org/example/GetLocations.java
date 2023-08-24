package org.example;

import java.util.HashMap;
import java.util.Scanner;

public class GetLocations {
    private static final String places = """
            road,at the end of the road, W: hill, E:well house,S:valley,N:forest
            hill,on top of hill with a view in all directions,N:forest, E:road
            well house,inside a well house for a small spring,W:road,N:lake,S:stream
            valley,in a forest valley beside a tumbling stream,N:road,W:hill,E:stream
            forest,at the edge of a thick dark forest,S:road,E:lake
            lake,by an alpine lake surrounded by wildflowers,W:forest,S:well house
            stream,near a stream with a rocky bed,W:valley, N:well house
            """;

    public static HashMap<String, AdventureGame.Location> getLocations() {
        Scanner scanner = new Scanner(places);
        String[] temp;
        HashMap<String, AdventureGame.Location> locations = new HashMap<>();
        HashMap<AdventureGame.Direction, String> nextPlaces = new HashMap<>();

        while(scanner.hasNext()) {
            nextPlaces.clear();
            temp = scanner.nextLine().split("\\s*,\\s*");
            if(temp.length > 2) {
                for(int i = 2; i < temp.length; i++) {
                    switch(temp[i].split(":")[0]) {
                        case "W" -> nextPlaces.put(AdventureGame.Direction.WEST, temp[i].split("\\s*:\\s*")[1]);
                        case "S" -> nextPlaces.put(AdventureGame.Direction.SOUTH, temp[i].split("\\s*:\\s*")[1]);
                        case "N" -> nextPlaces.put(AdventureGame.Direction.NORTH, temp[i].split("\\s*:\\s*")[1]);
                        case "E" -> nextPlaces.put(AdventureGame.Direction.EAST, temp[i].split("\\s*:\\s*")[1]);
                    }
                }
            }
            locations.put(temp[0].toLowerCase(), new AdventureGame.Location(temp[0],temp[1],new HashMap<AdventureGame.Direction, String>(nextPlaces)));
        }

        return locations;
    }
}
