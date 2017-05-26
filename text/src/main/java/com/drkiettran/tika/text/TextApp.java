package com.drkiettran.tika.text;

import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.Tika;
import org.apache.tika.exception.TikaException;

public class TextApp {

	public String parseToString(InputStream is) throws IOException, TikaException {
		Tika tika = new Tika();
		return tika.parseToString(is);
	}

}
