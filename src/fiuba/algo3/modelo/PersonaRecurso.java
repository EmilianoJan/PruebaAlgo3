package fiuba.algo3.modelo;

public class PersonaRecurso {
	private String nombre;
	
	public void establecerNombre (String nombrar){
		this.nombre = nombrar;
	}
	public String obtenerNombre (){
		return (this.nombre);
	}
	
    @Override
    public boolean equals(Object object) // sobre-escribimos el método equals a fin de ser empleado por las listas.
    {
        boolean sameSame = false;
        
        if (object != null && object instanceof PersonaRecurso)
        {
            sameSame = this.nombre == ((PersonaRecurso) object).obtenerNombre();
        }

        return sameSame;
    }

}
