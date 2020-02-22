package com.star.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lcx on 2018/10/15.
 */
public class JdbcTest {

    private JdbcTemplate jdbcTemplate;

    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
    }

    @Test
    public void testExcute(){
        jdbcTemplate.execute("select * from passport");
    }

    @Test
    public void testUpdate(){
        String sql = "insert into coin_assets(passport_name, coin_amount, agent_bus_type) VALUES (?,?,?)";
        jdbcTemplate.update(sql, new Object[]{"testjdbc001","8000","1"});
    }

    @Test
    public void testUpdate2(){
        String sql = "update coin_assets set coin_amount = ? where passport_name = ?";
        jdbcTemplate.update(sql, 9000, "testjdbc001");
    }

    @Test
    public void testBatchUpdate(){
        String[] sqls = {"insert into coin_assets(passport_name, coin_amount, agent_bus_type) VALUES (\"testjdbc002\", 8000, 1)", "update coin_assets set coin_amount = 70001 where passport_name = 'testjdbc002'"};
        jdbcTemplate.batchUpdate(sqls);
    }

    @Test
    public void testBatchUpdate2(){
        String sql = "insert into coin_assets(passport_name, coin_amount, agent_bus_type) VALUES (?, ?, ?)";
        List<Object[]> list = new ArrayList<>();
        list.add(new String[]{"testjdbc003", "100", "1"});
        list.add(new String[]{"testjdbc004", "200", "1"});
        jdbcTemplate.batchUpdate(sql, list);
    }

    @Test
    public void testQuerySimple1(){
        String sql = "select count(*) from coin_assets";
        int result = jdbcTemplate.queryForObject(sql, Integer.class);
        System.out.println(result);
    }

    @Test
    public void testQuerySimple2(){
        String sql = "select passport_name from coin_assets where coin_amount > ?";
        List<String> result = jdbcTemplate.queryForList(sql, String.class, 100);
        System.out.println(result);
    }


    @Test
    public void testQueryMap(){
        String sql = "select * from coin_assets where coin_amount = ?";
        Map<String, Object> cointAssets = jdbcTemplate.queryForMap(sql, 4450);
        System.out.println(cointAssets);
    }


    @Test
    public void testQueryList(){
        String sql = "select * from coin_assets where coin_amount > ?";
        List<Map<String, Object>> cointAssets = jdbcTemplate.queryForList(sql, 100);
        System.out.println(cointAssets);
    }

    @Test
    public void testQueryEntity(){
        String sql = "select * from coin_assets where coin_amount = ?";
        CoinAssets coinAssets = jdbcTemplate.queryForObject(sql, new CoinAssetsRowMapper(), 4450);
        System.out.println(coinAssets);
    }


    @Test
    public void testQueryEntityList(){
        String sql = "select * from coin_assets where coin_amount > ?";
        List<CoinAssets> coinAssets = jdbcTemplate.query(sql, new CoinAssetsRowMapper(), 4450);
        System.out.println(coinAssets);
    }

    private class CoinAssetsRowMapper implements RowMapper<CoinAssets>{
        @Override
        public CoinAssets mapRow(ResultSet resultSet, int i) throws SQLException {
            CoinAssets coinAssets = new CoinAssets();
            coinAssets.setCoinAssetsId(resultSet.getInt("coin_assets_id"));
            coinAssets.setPassportName(resultSet.getString("passport_name"));
            coinAssets.setCoinAmount(resultSet.getInt("coin_amount"));
            coinAssets.setAgentBusType(resultSet.getInt("agent_bus_type"));
            System.out.println(resultSet);
            return coinAssets;
        }
    }
}
