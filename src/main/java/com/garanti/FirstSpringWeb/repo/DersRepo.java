package com.garanti.FirstSpringWeb.repo;

import com.garanti.FirstSpringWeb.Constants;
import com.garanti.FirstSpringWeb.model.Ders;
import com.garanti.FirstSpringWeb.model.DersDTO;
import com.garanti.FirstSpringWeb.model.Konu;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@AllArgsConstructor
public class DersRepo {
    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    public List< Ders > getAll()
    {
        String sql = "select * from BILGE.DERS";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Ders.class));
    }


    public Ders getById(int id)
    {
        String sql = "select * from BILGE.DERS where ID = :ID";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ID", id);
        return namedParameterJdbcTemplate.queryForObject(sql, paramMap, BeanPropertyRowMapper.newInstance(Ders.class));
    }

    public boolean deleteById(int id)
    {
        String sql = "delete from BILGE.DERS where ID = :ID";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("ID", id);
        return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
    }

    public boolean save(Ders ders)
    {

        String sql = "Insert into BILGE.DERS (OGR_ID,KONU_ID) values (:OGR, :KONU)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("OGR", ders.getOGR_ID());
        paramMap.put("KONU",ders.getKONU_ID());
        return namedParameterJdbcTemplate.update(sql, paramMap) == 1;
    }
}
