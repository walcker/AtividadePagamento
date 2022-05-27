package br.ufrn.imd;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class PixTest {

    @Test
    void existsPix() throws ClassNotFoundException {
        Class<?> clazzFuncionario = Class.forName("br.ufrn.imd.Pix");
        assertNotNull(clazzFuncionario);
    }

    @Test
    void existsMethodDebitar() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazzPix = Class.forName("br.ufrn.imd.Pix");
        Method method = clazzPix.getMethod("debitar");
        assertNotNull(method);
    }

    @Test
    void existsMethodEstornar() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazzPix = Class.forName("br.ufrn.imd.Pix");
        Method method = clazzPix.getMethod("estornar");
        assertNotNull(method);
    }

    @Test
    void debitar() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<?> calzzCartao = Class.forName("br.ufrn.imd.Pix");
        Object cartaoInstance = calzzCartao.getDeclaredConstructor().newInstance();
        Method methodProcessarPagamento = calzzCartao.getMethod("debitar");
        boolean result = (boolean) methodProcessarPagamento.invoke(cartaoInstance);
        assertTrue(result);
    }

    @Test
    void estornar() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<?> calzzCartao = Class.forName("br.ufrn.imd.Pix");
        Object cartaoInstance = calzzCartao.getDeclaredConstructor().newInstance();
        Method methodProcessarPagamento = calzzCartao.getMethod("estornar");
        methodProcessarPagamento.invoke(cartaoInstance);
    }

}