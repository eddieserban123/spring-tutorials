package com.example;

import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class JDBCService {

    private final DataSource dataSource;


    public JDBCService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Post> findAll() throws SQLException {
        ResultSet rs = dataSource.getConnection()
                .prepareStatement("select * from post")
                .executeQuery();

        List<Post> posts = new ArrayList<>();
        while (rs.next()) {
            posts.add(new Post(rs.getString("id"),
                    rs.getString("title"),
                    rs.getString("slug"),
                    rs.getDate("date").toLocalDate(),
                    rs.getInt("time_to_read"),
                    rs.getString("tags"),
                    rs.getInt("version")));
        }
        return posts;

    }
}
