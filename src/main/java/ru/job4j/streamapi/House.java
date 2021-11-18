package ru.job4j.streamapi;

public class House {
    private String kitchen;
    private String bedroom;
    private String livingroom;
    private String bathroom;
    private String toilet;
    private int square;

    static class Builder {
        private String kitchen;
        private String bedroom;
        private String livingroom;
        private String bathroom;
        private String toilet;
        private int square;

        Builder builderKitchen(String kitchen) {
            this.kitchen = kitchen;
            return this;
        }

        Builder builderBedroom(String bedroom) {
            this.bedroom = bedroom;
            return this;
        }

        Builder builderLivingroom(String livingroom) {
            this.livingroom = livingroom;
            return this;
        }

        Builder builderBathroom(String bathroom) {
            this.bathroom = bathroom;
            return this;
        }

        Builder builderToilet(String toilet) {
            this.toilet = toilet;
            return this;
        }

        Builder builderSquare(int square) {
            this.square = square;
            return this;
        }

        House build() {
            House house = new House();
            house.kitchen = kitchen;
            house.bathroom = bathroom;
            house.bedroom = bedroom;
            house.livingroom = livingroom;
            house.toilet = toilet;
            house.square = square;
            return house;
        }
    }

    @Override
    public String toString() {
        return "House{"
                + "kitchen='" + kitchen + '\''
                + ", bedroom='" + bedroom + '\''
                + ", livingroom='" + livingroom + '\''
                + ", bathroom='" + bathroom + '\''
                + ", toilet='" + toilet + '\''
                + ", square=" + square
                + '}';
    }

    public static void main(String[] args) {
        House house = new Builder()
                .builderBathroom("ванная")
                .builderKitchen("кухня")
                .builderSquare(100)
                .build();

        House houseOne = new Builder()
                .builderBathroom("ванная")
                .builderKitchen("кухня")
                .builderLivingroom("хол")
                .builderSquare(200)
                .build();

        System.out.println(house);
        System.out.println(houseOne);
    }
}
