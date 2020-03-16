package com.ns.demo.config;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@Configuration
@ConfigurationProperties(prefix = "demo.cache")
public class CacheConfig {

	private Map<String, String> caffeineSpecs;

	public Map<String, String> getCaffeineSpecs() {
		return caffeineSpecs;
	}

	public void setCaffeineSpecs(Map<String, String> caffeineSpecs) {
		this.caffeineSpecs = caffeineSpecs;
	}

	@Bean
	public CacheManager cacheManager() {
		SimpleCacheManager manager = new SimpleCacheManager();
		if (caffeineSpecs != null) {
			List<CaffeineCache> caches = caffeineSpecs.entrySet().stream()
					.map(entry -> buildCache(entry.getKey(), entry.getValue())).collect(Collectors.toList());
			manager.setCaches(caches);
		}
		return manager;
	}

	private CaffeineCache buildCache(String name, String caffeineSpec) {
		Caffeine<Object, Object> caffeineBuilder = Caffeine.from(caffeineSpec);
		return new CaffeineCache(name, caffeineBuilder.build());
	}
}
