Aluno: Alessandro de Lucena Silva
# Reflexão e Discussão

### Quais desafios você encontrou ao testar os métodos?
- A necessidade de sobrescrever os métodos equals e hashCode ao comparar duas instâncias da classe Products foi algo que não estava esperando, mas fez total sentido uma vez que implementei.

### Houve alguma funcionalidade que precisou ser ajustada após criar os testes? Por quê?
- Como dito anteriormente, precisei sobrescrever os métodos equals e hashcode na classe Product, pois quando os testes estavam rodando, eles tentavam comparar se os espaços na memória que referenciavam as intâncias desta classe eram iguais, mas o que eu precisava realmente era comparar suas propriedades e definir se eram ou não os mesmos produtos.

### Como os testes ajudam a garantir a qualidade do software em cenários reais?
- Os testes ajudam em todas as etapas do desenvolvimento de software, primeiro, na definição e garantia de que as funcionalidades criadas seguem os requisitos definidos, segundo na detecção de erros precoce ao desenvolver uma nova funcionalidade e terceiro, garante que ao realizar o deploy da aplicação, as funcionalidades ainda estão funcionando da forma esperada. Ou seja, os testes são como um pedágio que garante que em todas as fases do ciclo de vida da aplicação, a aplicação fará o que é esperado dela, da forma correta.