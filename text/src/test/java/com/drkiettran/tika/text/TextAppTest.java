package com.drkiettran.tika.text;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;

import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.exception.TikaException;
import org.junit.Test;

public class TextAppTest {
	@Test
	public void given_a_pdf_content_i_should_get_a_main_text() throws IOException, TikaException {
		TextApp textApp = new TextApp();
		String text = null;

		try (InputStream is = TextApp.class.getResourceAsStream("/Tika-examples.pdf")) {
			text = textApp.parseToString(is);
		}

		assertThat(text, not(isEmptyOrNullString()));
		assertThat(text, containsString("This page provides"));
	}
}
