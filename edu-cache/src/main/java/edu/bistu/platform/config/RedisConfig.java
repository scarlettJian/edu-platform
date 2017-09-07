package edu.bistu.platform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
@PropertySource(value = "classpath:redis.properties", ignoreResourceNotFound = true)
public class RedisConfig {

    @Value("${redis.host}")
    private String hostName;

    @Value("${redis.port}")
    private int port;

    @Bean
    public JedisPoolConfig getJedisPoolConfig() {
        JedisPoolConfig pool = new JedisPoolConfig();
        pool.setTestOnBorrow(true);
        pool.setMinIdle(1);
        return pool;
    }

    @Bean
    public JedisConnectionFactory getJedisConnectionFactory() {
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory(getJedisPoolConfig());
        connectionFactory.setHostName(hostName);
        connectionFactory.setPort(port);
        return connectionFactory;
    }

    @Bean
    public RedisTemplate<?, ?> getRedisTemplate() {
        RedisTemplate<?, ?> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(getJedisConnectionFactory());
        return redisTemplate;
    }
}
