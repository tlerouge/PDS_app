/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 *
 * @author Nadia Randria
 */
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
