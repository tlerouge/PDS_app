/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pds_control;

import pds_model.PdsDatabase;
import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Nadia Randria
 */
public class PdsDatabaseTest {
    
    public PdsDatabaseTest() {
    }

    @Test
    public void testGetConnection() throws Exception {
        System.out.println("getConnection");
        Connection result = PdsDatabase.getConnection();
        assertNotNull(result);
    }
    
}
