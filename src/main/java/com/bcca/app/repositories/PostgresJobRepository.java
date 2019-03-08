package com.bcca.app.repositories;


import com.bcca.app.forms.JobForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class PostgresJobRepository implements com.bcca.app.repositories.Repository<JobForm> {
    private JdbcTemplate jdbc;

    @Autowired
    public PostgresJobRepository(JdbcTemplate jdtemplate) {
        jdbc = jdtemplate;
    }

    public void save(JobForm job) {
        jdbc.update("INSERT INTO postings (name, company, position, location, \"desc\", exp, industry, date, benefits, logo, qualifications) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
                job.getName(), job.getCompany(), job.getPosition(), job.getLocation(), job.getDesc(), job.getExp(), job.getIndustry(), new Date(), job.getBenefits(), job.getLogo(), job.getQualifications());
    }

    public List<JobForm> findAll() {
        return jdbc.query("SELECT id, name, company, position, location, \"desc\", exp, industry, date, benefits, logo, qualifications FROM postings ORDER BY date DESC", this::mapRowToJob);
    }

    public Optional<JobForm> findById(Integer id) {
        return Optional.ofNullable(jdbc.queryForObject("SELECT id, name, company, position, location, \"desc\", exp, industry, date, benefits, logo, qualifications FROM postings WHERE id = ?", this::mapRowToJob, id));
    }

    public JobForm mapRowToJob(ResultSet row, int rowNum) throws SQLException {
        return new JobForm(
                row.getInt("id"),
                row.getString("name"),
                row.getString("company"),
                row.getString("position"),
                row.getString("location"),
                row.getString("desc"),
                row.getString("exp"),
                row.getString("industry"),
                row.getDate("date"),
                row.getString("benefits"),
                row.getString("logo"),
                row.getString("qualifications")
        );
    }

}
