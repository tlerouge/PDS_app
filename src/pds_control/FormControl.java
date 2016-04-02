/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pds_control;

import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;
import object.Client;
import org.jdesktop.swingx.JXDatePicker;

/**
 * Release R2
 *
 * @author hubanato
 */
public class FormControl implements ActionListener {

    //Client
    private Client client;

    private JComboBox civility;
    private JTextField name;
    private JTextField firstName;
    private JXDatePicker birthDate;
    private JTextField birthPlace;
    private JComboBox sex;
    private JComboBox nationality;

    private JTextField nb;
    private JTextField street;
    private JTextField add;
    private JTextField cp;
    private JTextField city;
    private JComboBox country;

    private JTextField pnumber;
    private JTextField phome;
    private JTextField pbusiness;
    private JTextField email;
    private JTextField job;

    //All the buttons
    private JButton btnCreate;
    private JButton btnClear;
    private JButton btnCancel;

    /**
     * Constructor
     *
     * @param civility
     * @param name
     * @param firstName
     * @param date
     * @param birthPlace
     * @param sex
     * @param nationality
     * @param number
     * @param street
     * @param add
     * @param cp
     * @param city
     * @param country
     * @param pnumber
     * @param phome
     * @param pbusiness
     * @param email
     * @param job
     * @param create
     * @param clear
     * @param cancel
     */
    public FormControl(JComboBox civility, JTextField name, JTextField firstName, JXDatePicker date, JTextField birthPlace, JComboBox sex, JComboBox nationality, JTextField number, JTextField street, JTextField add, JTextField cp, JTextField city, JComboBox country, JTextField pnumber, JTextField phome, JTextField pbusiness, JTextField email, JTextField job, JButton create, JButton clear, JButton cancel) {

        this.civility = civility;
        this.name = name;
        this.firstName = firstName;
        this.birthDate = date;
        this.birthPlace = birthPlace;
        this.sex = sex;
        this.nationality = nationality;

        this.nb = number;
        this.street = street;
        this.add = add;
        this.cp = cp;
        this.city = city;
        this.country = country;

        this.pnumber = pnumber;
        this.phome = phome;
        this.pbusiness = pbusiness;
        this.email = email;
        this.job = job;

        this.btnCreate = create;
        this.btnClear = clear;
        this.btnCancel = cancel;
    }

    /**
     * The action that will be performed when one click on a button (create,
     * clear, cancel)
     *
     * @param evt
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();

        if (source == btnCreate) {

            /*System.out.println("Informations sur le client :");
             System.out.println("Civilité : " + civility.getSelectedItem());
             System.out.println("Client : " + name.getText() + " " + firstName.getText());
             System.out.println("Birth Date / Birth Place : " + birthDate.getDate() + ", " + birthPlace.getText());
             System.out.println("Sex : " + sex.getSelectedItem());
             System.out.println("Nationality : " + nationality.getSelectedItem());
             System.out.println("Adresse : " + nb.getText() + " " + street.getText() + ", " + cp.getText() + ", " + city.getText() + ", " + country.getSelectedItem());
             System.out.println("Phone Number : " + pnumber.getText());
             System.out.println("Phone Home : " + phome.getText());
             System.out.println("Phone Business : " + pbusiness.getText());
             System.out.println("Email : " + email.getText());
             System.out.println("Job : " + job.getText());*/
            
            this.client = new Client(civility.getSelectedItem().toString(), name.getText(), firstName.getText(), convertUtilToSql(birthDate.getDate()), birthPlace.getText(), sex.getSelectedItem().toString(), nationality.getSelectedItem().toString(), Integer.parseInt(nb.getText()), street.getText(), add.getText(), Integer.parseInt(cp.getText()), city.getText(), country.getSelectedItem().toString(), Integer.parseInt(pnumber.getText()), Integer.parseInt(phome.getText()), Integer.parseInt(pbusiness.getText()), email.getText(), job.getText());
            client.CreatePerson();

        } else if (source == btnClear) {
            System.out.println("Vous voulez effacer les données saisies");

        } else if (source == btnCancel) {
            System.out.println("Vous voulez annuler la création du client en cours");
        }
    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

}
