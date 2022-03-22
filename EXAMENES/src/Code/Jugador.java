package Code;

public class Jugador {
	Jugador(){
		m_casella = 1;
		m_potTirar = true;
		m_nTornsInactius = 0;
		m_guanyador = false;
	}
	
	public int posicio() { return m_casella; }
	public void mou(int casella) { m_casella = casella; }
	public void guanya() { m_guanyador = true; }
	public boolean esGuanyador() { return m_guanyador; }
	
	public void setInactiu (int nTorns) {
		m_nTornsInactius = nTorns;
		m_potTirar = false;
	}
	public boolean potTirar() {
		boolean potTirar = m_potTirar;
		if (!potTirar) {
			m_nTornsInactius--;
			if (m_nTornsInactius == 0) {
				 m_potTirar = true;
			}
		}
		return m_potTirar;
	}
	
	private int m_casella;
	private boolean m_potTirar;
	private int m_nTornsInactius;
	private boolean m_guanyador;
	
}
