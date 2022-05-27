package br.ufrn.imd;

import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

class CartaoTest {

    @Test
    void existsCartao() throws ClassNotFoundException {
        Class<?> clazzFuncionario = Class.forName("br.ufrn.imd.Cartao");
        assertNotNull(clazzFuncionario);
    }

    @Test
    void existsMethodDebitar() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazzPix = Class.forName("br.ufrn.imd.Cartao");
        Method method = clazzPix.getMethod("debitar");
        assertNotNull(method);
    }
    @Test
    void existsMethodEstornar() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazzPix = Class.forName("br.ufrn.imd.Cartao");
        Method method = clazzPix.getMethod("estornar");
        assertNotNull(method);
    }

    @Test
    void debitar() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<?> calzzCartao = Class.forName("br.ufrn.imd.Cartao");
        Object cartaoInstance = calzzCartao.getDeclaredConstructor().newInstance();
        Method methodProcessarPagamento = calzzCartao.getMethod("debitar");
        boolean result = (boolean) methodProcessarPagamento.invoke(cartaoInstance);
        assertFalse(result);
    }

    @Test
    void estornar() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class<?> calzzCartao = Class.forName("br.ufrn.imd.Cartao");
        Object cartaoInstance = calzzCartao.getDeclaredConstructor().newInstance();
        Method methodProcessarPagamento = calzzCartao.getMethod("estornar");
        methodProcessarPagamento.invoke(cartaoInstance);
    }

}