package test;
import Sesion2B.Empleado;
import Sesion2B.TipoEmpleado;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpleadoTest {
	
	private Empleado empleado = new Empleado();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
    public void testCalculoNominaBrutaVendedorSinPrimaSinHoras() {
        // Ventas < 1000 (Límite inferior)
        float resultado = empleado.calculoNominaBruta(TipoEmpleado.Vendedor, 999.99f, 0);
        assertEquals(2000.0f, resultado, 0.01f);
    }
	
	@Test
    public void testCalculoNominaBrutaVendedorPrima100LimiteInferior() {
        // Ventas == 1000 (Límite de prima de 100€)
        float resultado = empleado.calculoNominaBruta(TipoEmpleado.Vendedor, 1000.00f, 0);
        assertEquals(2100.0f, resultado, 0.01f);
    }
	
	@Test
    public void testCalculoNominaBrutaVendedorPrima100LimiteSuperior() {
        // Ventas justo debajo de 1500 (1499.99€)
        float resultado = empleado.calculoNominaBruta(TipoEmpleado.Vendedor, 1499.99f, 0);
        assertEquals(2100.0f, resultado, 0.01f);
    }
	
	@Test
    public void testCalculoNominaBrutaEncargadoPrima200LimiteInferior() {
        // Ventas == 1500 (Límite de prima de 200€) + Encargado
        float resultado = empleado.calculoNominaBruta(TipoEmpleado.Encargado, 1500.00f, 0);
        assertEquals(2700.0f, resultado, 0.01f);
    }
	
	@Test
    public void testCalculoNominaBrutaVendedorConHorasExtra() {
        // Vendedor, ventas >= 1500, 3 horas extra (3 * 30 = 90€)
        float resultado = empleado.calculoNominaBruta(TipoEmpleado.Vendedor, 1500.00f, 3);
        assertEquals(2290.0f, resultado, 0.01f);
    }
	
	@Test
    public void testCalculoNominaNetaSinRetencionLimiteSuperior() {
        // Nómina bruta < 2100 -> 0% retención
        float resultado = empleado.calculoNominaNeta(2099.99f);
        assertEquals(2099.99f, resultado, 0.01f);
    }
	
	@Test
    public void testCalculoNominaNetaRetencion15LimiteInferior() {
        // Nómina bruta == 2100 -> 15% retención (2100 * 0.85 = 1785)
        float resultado = empleado.calculoNominaNeta(2100.00f);
        assertEquals(1785.00f, resultado, 0.01f);
    }
	
	@Test
    public void testCalculoNominaNetaRetencion15LimiteSuperior() {
        // Nómina bruta justo debajo de 2500 (2499.99f) -> 15% retención
        float resultado = empleado.calculoNominaNeta(2499.99f);
        assertEquals(2124.99f, resultado, 0.01f);
    }
	
	@Test
    public void testCalculoNominaNetaRetencion18LimiteInferior() {
        // Nómina bruta == 2500 -> 18% retención (2500 * 0.82 = 2050)
        float resultado = empleado.calculoNominaNeta(2500.00f);
        assertEquals(2050.00f, resultado, 0.01f);
    }

}
