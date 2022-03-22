package Code;

import java.util.ArrayList;

public class Casella {
	public enum TipusCasella {
	    NORMAL,
	    OCA,
	    POU,
	    MORT,
	    FINAL
	}
	Casella() {
		m_posicio = 0;
		m_tipus = TipusCasella.NORMAL;
	}
	
	public	void setPosicio(int posicio) { m_posicio = posicio; }
	public void setTipus(TipusCasella tipus) { m_tipus = tipus; }
	public int getPosicio()  { return m_posicio; }
	public boolean esOca() { return (m_tipus == TipusCasella.OCA); }
	public boolean entraJugador(Jugador j, ArrayList<Casella> caselles) {
		boolean conservaTorn = false;
		switch (m_tipus) {
		case FINAL:
			j.guanya();
			break;
		case MORT:
			j.mou(0);
			break;
		case NORMAL:
			//nothing to do.
			break;
		case OCA:
			conservaTorn = true;
			int ocaIndex = -1;
			int i = m_posicio + 1;
			while (ocaIndex == -1 || i < caselles.size()) {
				if (caselles.get(i).esOca()) {
					ocaIndex = i;
				}else {
					i++;
				}
			}
			if (ocaIndex != -1) {
				j.mou(ocaIndex);
			}
			break;
		case POU:
			j.setInactiu(2);
			
			break;
		default:
			//sysout error
			break;
		}
		return conservaTorn;
	}
	private int m_posicio;
	private TipusCasella m_tipus;
}
