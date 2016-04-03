
package object;

class Address {

    private int idAddress;
    private int number;
    private String Street;
    private String Additional;
    private int cp;
    private String city;
    private String country;

    @Override
    public String toString() {
        return "Address{" + "number=" + number + ", Street=" + Street + ", Additional=" + Additional + ", cp=" + cp + ", city=" + city + ", country=" + country + '}';
    }

}
