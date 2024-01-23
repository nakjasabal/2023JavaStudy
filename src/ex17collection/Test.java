package ex17collection;

import java.util.Objects;

class X {
	int a;
	String b;
	
	@Override
	public int hashCode() {
		return Objects.hash(a, b);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		X other = (X) obj;
		return a == other.a && Objects.equals(b, other.b);
	}
	
}

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
