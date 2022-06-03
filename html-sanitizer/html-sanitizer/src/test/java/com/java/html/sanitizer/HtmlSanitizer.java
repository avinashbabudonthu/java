package com.java.html.sanitizer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HtmlSanitizer {

	private String readFileUsingFilesAndRelativePath() throws IOException {
		List<String> allLines = Files.readAllLines(Paths.get("src/main/resources/html/2.html"));
		// allLines.stream().forEach(System.out::println);
		String fileContent = allLines.stream().collect(Collectors.joining());
		return fileContent;
	}

	/**
	 * Documentation: https://github.com/OWASP/java-html-sanitizer
	 * 
	 * Please note that the elements "a", "font", "img", "input" and "span" need to be explicitly whitelisted 
	 * using the allowWithoutAttributes() method if you want them to be allowed through the filter when 
	 * these elements do not include any attributes
	 * 
	 */
	@SneakyThrows
	@Test
	public void sanitize() {
		String htmlContent = readFileUsingFilesAndRelativePath();
		log.info("{}", htmlContent);

		// @formatter:off
		PolicyFactory policyFactory = new HtmlPolicyBuilder()
				.allowElements("html", "body", "ul", "li", "a", "h1", "img")
				.allowWithoutAttributes("img")
				.allowAttributes("href").onElements("a")
				.allowAttributes("style").globally()
				.allowAttributes("class").globally()
				.allowAttributes("class")
					.matching(
						(String elementName, String attributeName, String value) -> {
				              // Return value for the attribute or null to drop.
							if("class".equalsIgnoreCase(attributeName) && "navbar".equalsIgnoreCase(value)) {
								return value;
							}else {
								return null;
							}
				            }).globally()
				.toFactory();
		// @formatter:on

		String safeHtml = policyFactory.sanitize(htmlContent);
		log.info("{}", safeHtml);
	}
}