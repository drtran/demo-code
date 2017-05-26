package com.drkiettran.tika.text;

import static org.hamcrest.text.IsEmptyString.isEmptyOrNullString;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.io.InputStream;

import org.junit.Test;

public class TextAppTest {
	@Test
	public void given_a_pdf_content_i_should_get_a_main_text() throws IOException {
		TextApp textApp = new TextApp();
		String text = null;

		try (InputStream is = this.getClass().getResourceAsStream("tika.pdf")) {
			text = textApp.parseToString(is);
		}
		assertThat(text, not(isEmptyOrNullString()));
	}
}
