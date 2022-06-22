package com.gokhantamkoc.javabootcamp.odevhafta3.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.gokhantamkoc.javabootcamp.odevhafta3.model.Candle;
import com.gokhantamkoc.javabootcamp.odevhafta3.util.TimeUtils;
import com.gokhantamkoc.javabootcamp.odevhafta3.util.chart.CandleStickChart;

public class CryptoDataCSVRepository implements CSVRepository {
	
	private final String COMMA_DELIMITER = ",";

	@Override
	public List<Candle> readCSV(String filename) throws FileNotFoundException, IOException {
		List<Candle> candles = new ArrayList<Candle>();
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filename);
		// Bu alandan itibaren kodunuzu yazabilirsiniz


		DataInputStream dataInputStream=new DataInputStream(inputStream);
		String firstRow = dataInputStream.readLine();
		while (dataInputStream.available()!=0){
			String row = dataInputStream.readLine();
			String[] splitedRow = row.split(COMMA_DELIMITER);
			Candle candle=new Candle(
					Long.parseLong(splitedRow[0]),
					Double.parseDouble(splitedRow[3]),
					Double.parseDouble(splitedRow[4]),
					Double.parseDouble(splitedRow[5]),
					Double.parseDouble(splitedRow[6]),
					Double.parseDouble(splitedRow[7])
			);
			candles.add(candle);
		}

		// Bu alandan sonra kalan kod'a dokunmayiniz.
		return candles;
	}

}
