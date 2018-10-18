package com.example.boot;

import io.prometheus.client.Counter;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {
	
	private static final Counter appCounter = Counter
			.build()
			.name("app_counter")
			.help("app_counter")
			.labelNames("section", "project")
			.register();
	
    @RequestMapping("/counter/{section}/{project}")
    public String counter(@PathVariable String section, @PathVariable String project) {
    	appCounter.labels(section, project).inc();
        return String.format("Increased count: %s %s", section, project);
    }
    
}
