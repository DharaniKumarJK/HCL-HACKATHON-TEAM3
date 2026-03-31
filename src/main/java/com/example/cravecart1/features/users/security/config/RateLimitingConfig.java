package com.example.cravecart1.features.users.security.config;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;

@Component
public class RateLimitingConfig {

    private final Map<String, Bucket> buckets = new ConcurrentHashMap<>();

    public Bucket resolveBucket(String key) {
        return buckets.computeIfAbsent(key, this::newBucket);
    }

    @SuppressWarnings({"unused", "deprecation"})
    private Bucket newBucket(String key) {
        Bandwidth limit = Bandwidth.simple(5, Duration.ofMinutes(1));
        return Bucket.builder().addLimit(limit).build();
    }
}
