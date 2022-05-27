package br.ufrn.imd;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class ProcessadorPagamentosTest {

    @Test
    void existsProcessadorPagamentos() throws ClassNotFoundException {
        Class<?> clazzProcessador = Class.forName("br.ufrn.imd.ProcessadorPagamentos");
        assertNotNull(clazzProcessador);
    }

    @Test
    void existsMethodProcessar() throws ClassNotFoundException, NoSuchMethodException {
        Class<?> clazzProcessador = Class.forName("br.ufrn.imd.ProcessadorPagamentos");
        Class<?> clazzMethod = Class.forName("java.util.Collection");
        Method methodProcessarPagamento = clazzProcessador.getMethod("processarPagamento", clazzMethod);
        assertNotNull(methodProcessarPagamento);
    }

    @Test
    void onlyPix() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazzProcessador = Class.forName("br.ufrn.imd.ProcessadorPagamentos");
        Object processadorInstance = clazzProcessador.getDeclaredConstructor().newInstance();
        Class<?> clazzMethod = Class.forName("java.util.Collection");
        Method methodProcessarPagamento = clazzProcessador.getMethod("processarPagamento", clazzMethod);
        Collection pagamentos = new ArrayList();
        Class<?> clazzFuncionario = Class.forName("br.ufrn.imd.Pix");
        var pix = clazzFuncionario.getDeclaredConstructor().newInstance();
        pagamentos.add(pix);
        boolean result = (boolean) methodProcessarPagamento.invoke(processadorInstance, pagamentos);
        assertTrue(result);
    }

    @Test
    void onlyCartao() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazzProcessador = Class.forName("br.ufrn.imd.ProcessadorPagamentos");
        Object processadorInstance = clazzProcessador.getDeclaredConstructor().newInstance();
        Class<?> clazzMethod = Class.forName("java.util.Collection");
        Method methodProcessarPagamento = clazzProcessador.getMethod("processarPagamento", clazzMethod);
        Collection pagamentos = new ArrayList();
        Class<?> clazzFuncionario = Class.forName("br.ufrn.imd.Cartao");
        var pix = clazzFuncionario.getDeclaredConstructor().newInstance();
        pagamentos.add(pix);
        boolean result = (boolean) methodProcessarPagamento.invoke(processadorInstance, pagamentos);
        assertFalse(result);
    }

    @Test
    void pixAndCartao() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazzProcessador = Class.forName("br.ufrn.imd.ProcessadorPagamentos");
        Object processadorInstance = clazzProcessador.getDeclaredConstructor().newInstance();
        Class<?> clazzMethod = Class.forName("java.util.Collection");
        Method methodProcessarPagamento = clazzProcessador.getMethod("processarPagamento", clazzMethod);
        Collection pagamentos = new ArrayList();
        var cartao = Class.forName("br.ufrn.imd.Cartao").getDeclaredConstructor().newInstance();
        var pix = Class.forName("br.ufrn.imd.Pix").getDeclaredConstructor().newInstance();
        pagamentos.add(cartao);
        pagamentos.add(pix);
        boolean result = (boolean) methodProcessarPagamento.invoke(processadorInstance, pagamentos);
        assertFalse(result);
    }

    @Test
    void variosCartoes() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazzProcessador = Class.forName("br.ufrn.imd.ProcessadorPagamentos");
        Object processadorInstance = clazzProcessador.getDeclaredConstructor().newInstance();
        Class<?> clazzMethod = Class.forName("java.util.Collection");
        Method methodProcessarPagamento = clazzProcessador.getMethod("processarPagamento", clazzMethod);
        Collection pagamentos = new ArrayList();
        pagamentos.add(Class.forName("br.ufrn.imd.Cartao").getDeclaredConstructor().newInstance());
        pagamentos.add(Class.forName("br.ufrn.imd.Cartao").getDeclaredConstructor().newInstance());
        boolean result = (boolean) methodProcessarPagamento.invoke(processadorInstance, pagamentos);
        assertFalse(result);
    }

    @Test
    void variosPix() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> clazzProcessador = Class.forName("br.ufrn.imd.ProcessadorPagamentos");
        Object processadorInstance = clazzProcessador.getDeclaredConstructor().newInstance();
        Class<?> clazzMethod = Class.forName("java.util.Collection");
        Method methodProcessarPagamento = clazzProcessador.getMethod("processarPagamento", clazzMethod);
        Collection pagamentos = new ArrayList();
        pagamentos.add(Class.forName("br.ufrn.imd.Pix").getDeclaredConstructor().newInstance());
        pagamentos.add(Class.forName("br.ufrn.imd.Pix").getDeclaredConstructor().newInstance());
        boolean result = (boolean) methodProcessarPagamento.invoke(processadorInstance, pagamentos);
        assertTrue(true);
    }


}