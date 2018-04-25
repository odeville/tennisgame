package odeville.tennisgame.model;

import java.util.Objects;

public class Player {

	private final String name;

	public Player(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Player) {
			Player other = (Player) obj;
			return Objects.equals(this.name, other.name);
		}
		return false;
	}

	@Override
	public String toString() {
		return name;
	}

}
