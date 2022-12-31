package com.garanti.FirstSpringWeb.repo;

import com.garanti.FirstSpringWeb.Constants;
import com.garanti.FirstSpringWeb.model.Ders;
import com.garanti.FirstSpringWeb.model.DersDTO;

import java.sql.*;
import java.util.ArrayList;

public class DersDTORepo
{
    /*public ArrayList< DersDTO > getAll() {
        ArrayList<DersDTO> liste = new ArrayList<>();
        Connection connection = null;
        Statement stmt = null;
        ResultSet result = null;
        try
        {
            connection = Constants.getConnection();
            stmt = connection.createStatement();
            result = stmt.executeQuery("select * from BILGE.DERSDTO");
            while (result.next())
            {
//                DersDTO temp = new Ders(result.getInt("ID"), result.getInt("OGR_ID"), result.getInt("KONU_ID"));
                DersDTO temp = new DersDTO(result.getString("OGRETMEN"), result.getString("KONU") );
                liste.add(temp);
            }
        }
        catch (Exception e)
        {
            liste.clear();
            System.err.println(e.getMessage());
        }
        finally
        {
            try
            {
                result.close();
                stmt.close();
                connection.close();
            }
            catch (SQLException e)
            {
                // throw new mybussinessexception()
            }
        }
        return liste;
    }*/

   /* public boolean save(DersDTO dersDTO)
    {
        boolean result = false;
        Connection connection = null;
        PreparedStatement stmt = null;
        try
        {
            connection = Constants.getConnection();
            stmt = connection.prepareStatement("Insert into BILGE.DERSDTO (OGRERTMEN,KONU) values (?,?)");
            stmt.setString(1, dersDTO.getOGRETMEN());
            stmt.setString(2, dersDTO.getKONU());
            result = stmt.executeUpdate() == 1;
        }
        catch (SQLException e)
        {
            System.err.println("-> " + e.getClass().getName());
            System.err.println(e.getMessage());
        }
        catch (Exception e)
        {
            System.err.println("-> " + e.getClass().getName());
        }
        finally
        {
            try
            {
                stmt.close();
                connection.close();
            }
            catch (Exception e)
            {
            }
        }
        return result;
    }*/
}
