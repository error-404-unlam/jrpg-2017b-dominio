package dominio;

/**
 * La clase Asesino es una casta de Personaje. Hereda de la clase Casta y posee dos constructores.
 * El otro constructor, llama al constructor de la clase padre (Casta) pasándole los argumentos
 * recibidos por el constructor hijo y luego inicializa la variable nombreCasta
 */

public class Asesino extends Casta {
/**
 * Energia minima necesario para realizar una habilidad.
 */
	private static final int ENERGIAMINIMA = 10;
/**
 * Bonus de destreza por ser Asesino.
 */
	private static final int BONUSDESTREZA = 5;
/**
 * Bonus al realizar correctamente la habilidad2.
 */
	private static final double AUMENTARPROBEVITAR = 0.15;
	/**
	 * Probabilidad de evitar dano por defecto.
	 */
	private static final double PROBEVITARDANIO = 0.5;

	/**
	 * La clase Asesino es una casta de Personaje. hereda de la clase Casta posee dos constructores.
	 * El otro constructor, llama al constructor de la clase padre (Casta) pasándole los argumentos
	 * recibidos por el constructor hijo y luego inicializa la variable nombreCasta
	 * @param probCrit
	 *            Probabilidad de que el personaje realice un golpe crítico
	 * @param evasion
	 *            Probabilidad de que el personaje evite un golpe crítico
	 * @param danioCrit
	 *            Valor por el cual será multiplicado el golpe básico
	 */

	public Asesino(final double probCrit, final double evasion, final double danioCrit) {
		super(probCrit, evasion, danioCrit);
	}

	/**
	 * El constructor por defecto, llama al constructor por defecto. padre (Casta),
	 * inicializando probabilidadGolpeCritico, probabilidadEvitarDaño, dañoCritico, con valores predeterminados.
	 */
	public Asesino() {
		super();
	}

	/**
	 * Retorna un booleano. Dependiendo de si se realizó exitosamente o no el ataque.
	 * La primera condición para que el ataque pueda realizarse es que el atacante(caster)
	 * posea 10 o más del atributo energia ya que estos se descuentan seguido de comprobar
	 * que los posee, de lo contrario el ataque no será posible y se retornará false De ser
	 * posible el ataque, se llama al método serAtacado() del argumento atacado el cual actuará
	 * de cierta manera dependiendo de que clase sea el argumento atacado
	 * @param caster
	 *            Personaje atacante
	 * @param atacado
	 *            puede recibir como argumento una instancia de Personaje o de
	 *            NPC (NonPlayableCharacter) ya que ambas implementan la interface Peleable
	 * @return retorna si el ataque fue realizado con éxito o no.
	 */
	@Override
	public final boolean habilidad1(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() >= ENERGIAMINIMA) {
			caster.reducirEnergia(ENERGIAMINIMA);
			return (atacado.serAtacado((int) (caster.getAtaque()
					* caster.getCasta().getDanioCritico())) > 0);
		}
		return false;
	}

	/**
	 * Retorna un booleano. Dependiendo de si se realizó exitosamente o no el ataque.
	 * La primera condición para que el ataque pueda realizarse es que el atacante(caster)
	 * posea 10 o más del atributo energia ya que estos se descuentan seguido de comprobar
	 * que los posee, de lo contrario el ataque no será posible y se retornará false
	 * @param caster
	 *            Personaje que realiza el ataque, en este caso no es un ataque si no un aumento en
	 *            las caracteristicas del caster en este caso incrementa el atributo probabilidadEvitarDaño
	 * @param atacado
	 *            no cumple función alguna dentro de este método
	 * @return retorna si el ataque fue realizado con éxito o no.
	 */
	@Override
	public final boolean habilidad2(final Personaje caster, final Peleable atacado) {
		if (caster.getEnergia() >= ENERGIAMINIMA) {
			caster.reducirEnergia(ENERGIAMINIMA);
			if (this.getProbabilidadEvitarDanio() + AUMENTARPROBEVITAR < Asesino.PROBEVITARDANIO) {
				this.aumentarEvitarDanio(AUMENTARPROBEVITAR);
			} else {
				this.setProbabilidadEvitarDanio(PROBEVITARDANIO);
			}
			return true;
		}
		return false;
	}

	/**
	 * Not implemented yet.
	 * @param caster
	 *            Personaje que realiza el ataque.
	 * @param atacado
	 *            .
	 * @return Retorna falso.
	 */
	@Override
	public final boolean habilidad3(final Personaje caster, final Peleable atacado) {
		return false;
	}

	/**
	 * Retorna un entero. Que otorga el bonus de destreza perteneciente a esta casta.
	 * @return Retorna la destreza extra de la casta.
	 */
	@Override
	public final int recibirDestrezaBonus() {
		return BONUSDESTREZA;
	}

	/**
	 * Retorna un entero. Que otorga el bonus de fuerza perteneciente a esta casta.
	 * @return Retorna 0 para esta casta.
	 */
	@Override
	public final int recibirFuerzaBonus() {
		return 0;
	}

	/**
	 * Retorna un entero. Que otorga el bonus de inteligencia perteneciente a esta casta.
	 * @return Retorna 0 para esta casta.
	 */
	@Override
	public final int recibirInteligenciaBonus() {
		return 0;
	}

	/**
	 * Retorna una string con el nombre de la casta.
	 * @return Retorna el nombre de la casta.
	 */
	@Override
	public final String getNombreCasta() {
		return "Asesino";
	}

	/**
	 * Retorna un vector de string. Con los nombres de las habilidades de la casta.
	 * @return Retorna nombres de las habilidades propias de la casta.
	 */
	@Override
	public final String[] getHabilidadesCasta() {
		return new String[] {"Golpe Critico", "Aumentar Evasion", "Robar"};
	}
}
