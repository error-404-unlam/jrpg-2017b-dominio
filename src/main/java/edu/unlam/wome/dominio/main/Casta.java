
package edu.unlam.wome.dominio.main;

import java.io.Serializable;

/**
 * Clase abstracta de la cual heredarán las clases Asesion,Guerrero,Hechicero.
 *  Posee dos contructores, el contructor por defecto (no recibe argumentos),
 *  pondrá los atributos con sus respectivos valores por defecto.
 */
public abstract class Casta implements Serializable {
	/**
	 * Numero que indica probabilidad. Del personaje de realizar un golpe critico.
	 */
	private double probabilidadGolpeCritico;
	/**
	 * Numero que indica probabilidad. Del personaje de evitar un ataque.
	 */
	private double probabilidadEvitarDanio;
	/**
	 * Numero por el cual sera multiplicado el ataque.
	 */
	private double danioCritico;
	/**
	 * Probabilidad de evitar un golpe critico.
	 */
	private static final double PROBEVITARGOLPC = 0.2;
	/**
	 * Probabilidad de evitar recibir dano.
	 */
	private static final double PROBEVITARDANIO = 0.2;
	/**
	 * Numero por el cual sera multiplicado el ataque por defecto.
	 */
	private static final double DANIOCRITICO = 1.5;

	/**
	 * Clase abstracta de la cual heredarán las clases Asesion,Guerrero,Hechicero.
	 *  Posee dos contructores, el contructor por defecto (no recibe argumentos),
	 *  pondrá los atributos con sus respectivos valores por defecto.
	 */
	public Casta() {
		this.probabilidadGolpeCritico = PROBEVITARGOLPC;
		this.probabilidadEvitarDanio = PROBEVITARDANIO;
		this.danioCritico = DANIOCRITICO;
	}

	/**
	 * El constructor asignará a cada atributo, el valor correspondiente que será el que se reciba por argumento.
	 * @param probCrit
	 *            Probabilidad de que el personaje realice un golpe crítico
	 * @param evasion
	 *            Probabilidad de que el personaje evite un golpe crítico
	 * @param danioCrit
	 *            Valor por el cual será multiplicado el golpe básico
	 */
	public Casta(final double probCrit, final double evasion, final double danioCrit) {
		this.probabilidadGolpeCritico = probCrit;
		this.probabilidadEvitarDanio = evasion;
		this.danioCritico = danioCrit;
	}

	/**
	 * Método abstracto que será implementado en Asesino, Guerrero y Hechicero.
	 * @param caster
	 *            Personaje atacante.
	 * @param atacado
	 *            Personaje que recibirá el ataque.
	 * @return Retornará true si el ataque fue realizado exitosamente, false de lo contrario.
	 */
	public abstract boolean habilidad1(Personaje caster, Peleable atacado);

	/**
	 * Método abstracto que será implementado en Asesino, Guerrero y Hechicero.
	 * @return Retorna la fuerza extra de la casta.
	 */
	public abstract int recibirFuerzaBonus();

	/**
	 * Método abstracto que será implementado en Asesino, Guerrero y Hechicero.
	 * @return Retorna la destreza extra de la casta.
	 */
	public abstract int recibirDestrezaBonus();

	/**
	 * Método abstracto que será implementado en Asesino, Guerrero y Hechicero.
	 * @return Retorna la inteligencia extra de la casta.
	 */
	public abstract int recibirInteligenciaBonus();

	/**
	 * Método abstracto que será implementado en Asesino, Guerrero y Hechicero.
	 * @param caster
	 *            Personaje atacante.
	 * @param atacado
	 *            Personaje que recibirá el ataque.
	 * @return Retornará true si el ataque fue realizado exitosamente, false de lo contrario.
	 */
	public abstract boolean habilidad2(Personaje caster, Peleable atacado);

	/**
	 * Método abstracto que será implementado en Asesino, Guerrero y Hechicero.
	 * @param caster
	 *            Personaje atacante.
	 * @param atacado
	 *            Personaje que recibirá el ataque.
	 * @return Retornará true si el ataque fue realizado exitosamente, false de lo contrario.
	 */
	public abstract boolean habilidad3(Personaje caster, Peleable atacado);

	/**
	 * Método abstracto que será implementado en Asesino, Guerrero y Hechicero.
	 * @return Retorna el nombre de la casta.
	 */
	public abstract String getNombreCasta();

	/**
	 * Método abstracto que será implementado en Asesino, Guerrero y Hechicero.
	 * @return Retorna nombres de las habilidades propias de la casta.
	 */
	public abstract String[] getHabilidadesCasta();

	/**
	 * Método abstracto que será implementado en Asesino, Guerrero y Hechicero.
	 * @return Retorna la probabilidad de critico propias de la casta.
	 */
	public final double getProbabilidadGolpeCritico() {
		return probabilidadGolpeCritico;
	}

	/**
	 * Método void que sobreescribe el atributo probabilidadGolpeCritico.
	 * con el valor que se ingresa por parámetro.
	 * @param probabilidadGolpeCritico
	 *            Valor que tendra probabilidadGolpeCritico
	 */
	public final void setProbabilidadGolpeCritico(final double probabilidadGolpeCritico) {
		this.probabilidadGolpeCritico = probabilidadGolpeCritico;
	}

	/**
	 * Método que devuelve la probabilidadEvitarDaño.
	 * @return probabilidadEvitarDaño
	 */
	public final double getProbabilidadEvitarDanio() {
		return probabilidadEvitarDanio;
	}

	/**
	 * Método void que sobreescribe el atributo probabilidadEvitarDaño.
	 * con el valor que se ingresa por parámetro.
	 * @param probabilidadEvitarDanio
	 *            Valor que tendra probabilidadEvitarDaño.
	 */
	public final void setProbabilidadEvitarDanio(final double probabilidadEvitarDanio) {
		this.probabilidadEvitarDanio = probabilidadEvitarDanio;
	}

	/**
	 * Método que devuelve el dañoCritico.
	 * @return dañoCritico
	 */
	public final double getDanioCritico() {
		return danioCritico;
	}

	/**
	 * Método void que sobreescribe el atributo dañoCritico. con el valor que se ingresa por parámetro.
	 * @param danioCritico
	 *            Valor que tendra dañoCritico
	 */
	public final void setDanioCritico(final double danioCritico) {
		this.danioCritico = danioCritico;
	}

	/**
	 * Método void que aumenta el atributo probabilidadEvitarDaño. con el valor que se ingresa por parámetro.
	 * @param bonus
	 *            bonficador de evitar daño
	 */
	public final void aumentarEvitarDanio(final double bonus) {
		this.probabilidadEvitarDanio += bonus;
	}

}