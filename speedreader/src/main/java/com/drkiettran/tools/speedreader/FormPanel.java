package com.drkiettran.tools.speedreader;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.apache.tika.exception.TikaException;
import org.xml.sax.SAXException;

import com.drkiettran.tika.text.TextApp;
import com.drkiettran.tools.speedreader.ReaderListener.Command;

/**
 * 
 * @author ktran
 *
 */
public class FormPanel extends JPanel {
	private static final long serialVersionUID = 3506596135223108382L;
	private JLabel fileNameLabel;
	private JTextField fileNameField;
	private JButton loadButton;
	private JButton browserButton;
	private JLabel speedLabel;
	private JTextField speedField;
	private JLabel searchTextLabel;
	private JTextField searchTextField;
	private JButton searchButton;
	private JButton setButton;
	private Integer speedWpm = 200;
	private String fileName;
	private String text;

	public String getText() {
		return text;
	}

	private ReaderListener readerListener;

	public Integer getSpeedWpm() {
		return speedWpm;
	}

	public FormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		fileNameLabel = new JLabel("File Name: ");
		fileNameField = new JTextField(10);
		speedLabel = new JLabel("Speed (wpm): ");
		speedField = new JTextField(10);
		searchTextLabel = new JLabel("Text");
		searchTextField = new JTextField(10);
		speedField.setText("" + speedWpm);

		setButton = new JButton("Set");
		loadButton = new JButton("Load");
		browserButton = new JButton("Browse");
		searchButton = new JButton("Search");

		setButton.addActionListener((ActionEvent actionEvent) -> {
			speedWpm = Integer.valueOf(speedField.getText());
		});

		loadButton.addActionListener((ActionEvent actionEvent) -> {
			fileName = fileNameField.getText();
			TextApp textApp = new TextApp();
			try (InputStream is = new FileInputStream(fileName)) {
				text = textApp.parseToString(is);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TikaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			readerListener.invoke(Command.LOAD);
		});

		browserButton.addActionListener((ActionEvent actionEvent) -> {
			readerListener.invoke(Command.BROWSE);
		});

		searchButton.addActionListener((ActionEvent actionEvent) -> {
			readerListener.invoke(Command.SEARCH);
		});

		Border innerBorder = BorderFactory.createTitledBorder("Configuration");
		Border outterBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outterBorder, innerBorder));

		layoutComponents();
	}

	public String getFileName() {
		return fileName;
	}

	private void layoutComponents() {
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		//// FIRST ROW /////////////
		gc.gridy = 0;

		// Always do the following to avoid future confusion :)
		// Speed
		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(speedLabel, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(speedField, gc);

		//// next row /////////////
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = .2;

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(setButton, gc);

		// Always do the following to avoid future confusion :)
		// File Name
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(fileNameLabel, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(fileNameField, gc);

		//// next row /////////////
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = .2;

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(loadButton, gc);

		//// next row /////////////
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = .2;

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(browserButton, gc);

		// Always do the following to avoid future confusion :)
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(searchTextLabel, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(searchTextField, gc);

		//// next row /////////////
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 5;

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(searchButton, gc);

	}

	public void setReaderListener(ReaderListener readerListener) {
		this.readerListener = readerListener;
	}

	public void setFileName(String selectedFile) {
		fileNameField.setText(selectedFile);
	}

	public String getSearchText() {
		return searchTextField.getText();
	}
}
