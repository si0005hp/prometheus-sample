package com.example;

import java.io.IOException;

import io.prometheus.client.Counter;
import io.prometheus.client.exporter.HTTPServer;

public class App {
	private static final Counter sampleCounter = Counter
			.build()
			.name("sample_counter")
			.help("sample_counter")
			.register();

	public static void main(String[] args) throws IOException {
		sampleCounter.inc();
		sampleCounter.inc();
		sampleCounter.inc();
		
		@SuppressWarnings("unused")
		HTTPServer server = new HTTPServer(1234);
		
		System.out.println("Server started...");
	}
}
