package modelo;

public class Usuario {

		// atributos
		private Long id;
		private String nombre;
		private String correo;
		private String password;
		private Double peso;
		private Double altura;
		private String deporte;
		
		
		public Usuario() {
			super();
		}
		// constructor sin id
		public Usuario(String nombre, String correo, String password, Double peso, Double altura, String deporte) {
			super();
			this.nombre = nombre;
			this.correo = correo;
			this.password = password;
			this.peso = peso;
			this.altura = altura;
			this.deporte = deporte;
		}

		// GETTERS AND SETTERS
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getCorreo() {
			return correo;
		}

		public void setCorreo(String correo) {
			this.correo = correo;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Double getPeso() {
			return peso;
		}

		public void setPeso(Double peso) {
			this.peso = peso;
		}

		public Double getAltura() {
			return altura;
		}

		public void setAltura(Double altura) {
			this.altura = altura;
		}

		public String getDeporte() {
			return deporte;
		}

		public void setDeporte(String deporte) {
			this.deporte = deporte;
		}

		// TO STRING 
		@Override
		public String toString() {
			return "Usuario [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", password=" + password
					+ ", peso=" + peso + ", altura=" + altura + ", deporte=" + deporte + "]";
		}
}
