package br.ufrn.imd;

import org.junit.jupiter.api.Test;

import java.lang.reflect.*;

import static org.junit.jupiter.api.Assertions.*;

class MetodoPagamentoTest {

    @Test
    void existsMetodoPagamento() throws ClassNotFoundException {
        Class<?> clazzFuncionario = Class.forName("br.ufrn.imd.MetodoPagamento");
        assertNotNull(clazzFuncionario);
    }

    @Test
    void metodoPagamentoIsInterface() throws ClassNotFoundException {
        Class<?> clazzFuncionario = Class.forName("br.ufrn.imd.MetodoPagamento");
        assertTrue(Modifier.isInterface(clazzFuncionario.getModifiers()));
        assertNotNull(clazzFuncionario);
    }

    @Test
    void existsMethodDebitar() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazzFuncionario = Class.forName("br.ufrn.imd.MetodoPagamento");
        Method methodCalcular = clazzFuncionario.getDeclaredMethod("debitar");
        assertTrue(Modifier.isAbstract(methodCalcular.getModifiers()));
        assertNotNull(methodCalcular);
        assertEquals(0, methodCalcular.getParameterCount());
        assertEquals("boolean", methodCalcular.getGenericReturnType().getTypeName());
    }

    @Test
    void existsMethodEstornar() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazzFuncionario = Class.forName("br.ufrn.imd.MetodoPagamento");
        Method methodEstornar = clazzFuncionario.getDeclaredMethod("estornar");
        assertNotNull(methodEstornar);
        assertTrue(Modifier.isAbstract(methodEstornar.getModifiers()));
        assertEquals(0, methodEstornar.getParameterCount());
        assertEquals("void", methodEstornar.getGenericReturnType().getTypeName());
    }

}