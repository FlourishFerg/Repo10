package com.example.repo10;

public class Repo10 {
    import java.util.*;

    // Enum for travel modes
    enum TravelMode {
        FLIGHT, ACCOMMODATION, TRANSPORT
    }

    // Class representing a travel option
    class TravelOption {
        private String name;
        private double price;
        private TravelMode mode;

        public TravelOption(String name, double price, TravelMode mode) {
            this.name = name;
            this.price = price;
            this.mode = mode;
        }

        // Getters and setters
    }

    // Class representing a user
    class User {
        private String username;
        private String password;
        private List<TravelOption> bookings;

        public User(String username, String password) {
            this.username = username;
            this.password = password;
            this.bookings = new ArrayList<>();
        }

        // Getters and setters

        public void bookTravel(TravelOption option) {
            bookings.add(option);
        }

        public List<TravelOption> getBookings() {
            return bookings;
        }
    }

    // Class representing the Travel Planning and Booking Platform
    public class TravelPlatform {
        private Map<String, User> users;

        public TravelPlatform() {
            this.users = new HashMap<>();
        }

        public void registerUser(String username, String password) {
            users.put(username, new User(username, password));
        }

        public void searchAndBookTravel(String username, TravelOption option) {
            User user = users.get(username);
            if (user != null) {
                user.bookTravel(option);
                System.out.println("Booking successful for user: " + username);
            } else {
                System.out.println("User not found.");
            }
        }

        // Other methods for user authentication, payment processing, etc.

        public static void main(String[] args) {
            TravelPlatform platform = new TravelPlatform();
            platform.registerUser("user1", "password1");
            platform.registerUser("user2", "password2");

            TravelOption flightOption = new TravelOption("Flight to Paris", 500.0, TravelMode.FLIGHT);
            TravelOption hotelOption = new TravelOption("Hotel in Paris", 200.0, TravelMode.ACCOMMODATION);

            platform.searchAndBookTravel("user1", flightOption);
            platform.searchAndBookTravel("user1", hotelOption);

            // Example usage:
            User user1 = platform.users.get("user1");
            if (user1 != null) {
                List<TravelOption> bookings = user1.getBookings();
                for (TravelOption booking : bookings) {
                    System.out.println("Booking: " + booking.getName() + ", Price: $" + booking.getPrice());
                }
            }
        }
    }

}
