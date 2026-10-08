package Sesion2B;
	
	public class Empleado {
	public float calculoNominaBruta(TipoEmpleado tipo, float ventasMes, float horasExtra) {
		float salarioBase = 0;

        if (tipo == TipoEmpleado.Vendedor) {
            salarioBase = 2000;
        } else if (tipo == TipoEmpleado.Encargado) {
            salarioBase = 2500;
        }

        float prima = 0;
        if (ventasMes >= 1500) {
            prima = 200;
        } else if (ventasMes >= 1000) {
            prima = 100;
        }

        float pagoHorasExtra = horasExtra * 30;

        return salarioBase + prima + pagoHorasExtra;
	}
	
	
	public float calculoNominaNeta(float nominaBruta) {
		float retencion = 0;

        if (nominaBruta >= 2500) {
            retencion = 0.18f;
        } else if (nominaBruta >= 2100) {
            retencion = 0.15f;
        } else {
            retencion = 0.0f;
        }

        return nominaBruta * (1 - retencion);
	}
}
