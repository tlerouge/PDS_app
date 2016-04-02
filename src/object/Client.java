/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import pds_model.PdsDatabase;

/**
 * Release R2
 *
 * @author hubanato
 */
public class Client extends Person {

    /**
     * Constructor This method is used to create a new client
     *
     * @param civility
     * @param name
     * @param firstName
     * @param birthDate
     * @param birthPlace
     * @param sex
     * @param nationality
     * @param number
     * @param street
     * @param add
     * @param cp
     * @param city
     * @param country
     * @param pNumber
     * @param pHome
     * @param pBusiness
     * @param email
     * @param job
     */
    public Client(String civility, String name, String firstName, Date birthDate, String birthPlace, String sex, String nationality, int number, String street, String add, int cp, String city, String country, int pNumber, int pHome, int pBusiness, String email, String job) {

        this.civility = civility;
        this.name = name;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.birthPlace = birthPlace;
        this.sex = sex;
        this.nationality = nationality;

        this.number = number;
        this.Street = street;
        this.Additional = add;
        this.cp = cp;
        this.city = city;
        this.country = country;

        this.phoneNumber = pNumber;
        this.phoneHome = pHome;
        this.phoneBusiness = pBusiness;
        this.email = email;
        this.job = job;
    }

    public Client() {

    }

    /**
     *
     */
    @Override
    public void Consult() {

    }

    /**
     *
     *
     */
    @Override
    public void CreatePerson() {
        try {
            Connection connexion = PdsDatabase.getConnection();
            
            String requeteAddress = "INSERT INTO ADDRESS(NBER,STREET,ADDITIONAL,ZIP_CODE,CITY,COUNTRY) "
                    + "VALUES (?,?,?,?,?,?)";
            PreparedStatement ordre = connexion.prepareStatement(requeteAddress, Statement.RETURN_GENERATED_KEYS);
            //PreparedStatement ordre = connexion.prepareStatement(requeteAddress);

            ordre.setInt(1, number);
            ordre.setString(2, Street);
            ordre.setString(3, Additional);
            ordre.setInt(4, cp);
            ordre.setString(5, city);
            ordre.setString(6, country);

            ordre.executeUpdate();
            System.out.println(requeteAddress);
            
            
            ResultSet rs = ordre.getGeneratedKeys();
            int generatedId = 0;
            if(rs.next()) {            
                //Get the last id
                generatedId = rs.getInt(1);
                System.out.println(generatedId);
            }
            
            ordre.close();

            String requeteClient = "INSERT INTO PERSON(ID_ADR,CIVILITY,FIRST_NAME,NAME,SEX,BIRTH_DATE,BIRTH_PLACE,NATIONALITY,PHONE_HOME,PHONE_MOBIL,EMAIL,JOB,PHONE_BUSINESS) "
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ordre2 = connexion.prepareStatement(requeteClient);

            ordre2.setInt(1, generatedId);
            ordre2.setString(2, civility);
            ordre2.setString(3, firstName);
            ordre2.setString(4, name);
            ordre2.setString(5, sex);
            ordre2.setDate(6, birthDate);
            ordre2.setString(7, birthPlace);
            ordre2.setString(8, nationality);
            ordre2.setInt(9, phoneHome);
            ordre2.setInt(10, phoneNumber);
            ordre2.setString(11, email);
            ordre2.setString(12, job);
            ordre2.setInt(13, phoneBusiness);

            ordre2.executeUpdate();
            System.out.println(requeteClient);
            ordre2.close();

            connexion.close();

        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     *
     */
    @Override
    public void UpdatePerson() {

    }

    /**
     *
     * @param id
     */
    @Override
    public void DeletePerson(int id) {

    }

}
