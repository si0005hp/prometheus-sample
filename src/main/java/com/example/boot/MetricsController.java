package com.example.boot;

import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.exporter.common.TextFormat;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics")
public class MetricsController {
	@RequestMapping("/")
	public void metrics(HttpServletRequest req, HttpServletResponse res) throws IOException {
		try (Writer writer = res.getWriter();) {
			TextFormat.write004(writer, CollectorRegistry.defaultRegistry.metricFamilySamples());
			writer.flush();
		}
	}
}
