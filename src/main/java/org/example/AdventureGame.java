package org.example;

import java.util.HashMap;

public class AdventureGame {
    enum Direction {
        EAST, WEST, NORTH, SOUTH
    }
    public static class Location {
        String value;
        String description;

        HashMap<Direction, String> nextPlaces;

        public Location(String value, String description, HashMap<Direction, String> nextPlaces) {
            this.value = value;
            this.description = description;
            this.nextPlaces = nextPlaces;
        }

        public String getValue() {
            return value;
        }

        public String getDescription() {
            return description;
        }

        public HashMap<Direction, String> getNextPlaces() {
            return nextPlaces;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Location location = (Location) o;

            return getValue().equals(location.getValue());
        }

        @Override
        public int hashCode() {
            return getValue().hashCode();
        }
    }

    public static void printLocation(Location location) {
        System.out.println("*** You are standing %s ***".formatted(location.description));
    }

    public static void main(String[] args) {
        var locations = GetLocations.getLocations();

        printLocation(locations.get("hill"));

        return;
    }

}
