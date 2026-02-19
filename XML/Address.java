import annotations.Location;

public class Address{

        @Location(Location.Type.CITY) String city;
        
        @Location(Location.Type.STATE)
        private String state;
        
        @Location(Location.Type.COUNTRY)
        private String country;

        public Address(String city , String state , String country){
            this.city = city;
            this.state = state;
            this.country = country;
        }

        public Address(){}

        @Location(Location.Type.CITY)
        public String getCity(){
            return city;
        }
        
        @Location(Location.Type.STATE)
        public String getState(){
            return state;
        }
        
        @Location(Location.Type.COUNTRY)
        public String getCountry(){
            return country;
        }
    }