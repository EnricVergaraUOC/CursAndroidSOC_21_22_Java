package Code;

import java.util.ArrayList;
import java.io.*;

public class Tauler {
	ArrayList<Jugador> players;
	ArrayList<Casella> caselles;
	int m_tornActual;
	
	Tauler(){
		players = null;
		caselles = null;
		m_tornActual = -1;
		
	}
	
	public void Inicialitza(String nomFitxer, int nJugadors) {
		players = new ArrayList<Jugador>();
		for (int i = 0; i < nJugadors; i++) {
			players.add(new Jugador());	
		}
		
		m_tornActual = 0;
		
		BufferedReader in;
		String currentLine = "";
		
		try {
			in = new BufferedReader (new FileReader(nomFitxer));
			while((currentLine = in.readLine()) != null) {
				String[] parts = currentLine.split(" ");
				int position = Integer.parseInt(parts[0]);
				String s_type = parts[1]; 
				Casella.TipusCasella type = getType(s_type);
				Casella newCasella = new Casella();
				newCasella.setPosicio(position);
				newCasella.setTipus(type);
				caselles.add(newCasella);
				
			}
			in.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Casella.TipusCasella getType(String s_type){
		Casella.TipusCasella type = Casella.TipusCasella.NORMAL;
		if (s_type.compareTo("OCA") == 0) {
			type = Casella.TipusCasella.OCA;
		}else if (s_type.compareTo("POU") == 0) {
			type = Casella.TipusCasella.POU;
		}else if (s_type.compareTo("MORT") == 0) {
			type = Casella.TipusCasella.MORT;
		}else if (s_type.compareTo("FINAL") == 0) {
			type = Casella.TipusCasella.FINAL;
		}
		return type;
	}
}
