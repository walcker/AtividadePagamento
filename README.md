## Atividade

Você recebeu de um arquiteto de software o seguinte modelo para a implementação de um sistema de pagamento de um comércio eletrônico:

![Classes](https://github.com/gustavoleitao/imd0040-atv05/blob/main/src/main/resources/atv5-uml.png?raw=true)

Diante disso, implemente as classes e interfaces desejadas lavando em conta os seguintes pontos:

1. Criar os arquivos no pacote br.ufrn.imd
2. A implementação de debitar de cartão deve sempre retorna falha
3. A implementação de debitar do Pix, deve sempre retornar true

Em seguida crie uma classe chamada `ProcessadorPagamentos`. Essa classe simula o processamento de um pagamento feito com um ou mais métodos de pagamento.

O processador de pagamentos deve iterar sobre os métodos e chamar o método debitar. No entanto, se houver alguma falha, este deve estornar o pagamento daqueles já processados com sucesso.

Ou seja, basta uma falha que todos os outros métodos já debitados anteriores precisam ser estornados.

> Atenção utilize exatamente os mesmos nomes para as classes, atributos e métodos da imagem de referência.

## Testes

O programa possui testes automatizados implementados. Se quiser testar execute o seguinte comando:

```console
$ ./gradlew test
```
