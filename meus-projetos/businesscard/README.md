# Projeto: Criando um App de cartão de visitas em Kotlin

## Bootcamp Inter Android Developer 

###### (01/08/2021 à 01/11/2021) 

O bootcamp Inter Android Developer faz parte do programa Órbi Academy Techboost, iniciativa da DIO junto ao Órbi Conecta, que até 2022 distribuirá 130 mil bolsas de estudo gratuitas, fortalecendo ainda mais a comunidade tech brasileira.

- Link para o projeto original do instrutor Igor Rotondo Bagliotti: 

  https://github.com/igorbag/Business-Card

- Link para o projeto modificado: 

  https://github.com/danielvillarintegra

[![Linkedin Badge](https://img.shields.io/badge/-Daniel_Villar-blue?style=flat-square&logo=Linkedin&logoColor=white&link=linkedin.com/in/daniel-villar-326477212)](linkedin.com/in/daniel-villar-326477212)   [![Gmail Badge](https://img.shields.io/badge/-danielvillarintegra@gmail.com-c14438?style=flat-square&logo=Gmail&logoColor=white&link=mailto:danielvillarintegra@gmail.com)](mailto:danielvillarintegra@gmail.com)



#### Alterações realizadas:

- O projeto alterado tem as funções de inserir, editar e apagar. E também compartilhar um cartão de visitas através outros aplicativos que estejam no celular do usuário (whatsapp, e-mail etc). 
- Na opção de inserir e editar há um "slider" para o controle das 8 cores disponíveis para o fundo do cartão.
- Como a tela de adicionar cartão e a de editar cartão é a mesma utilizei uma forma de alterar o título da página. Também pode ser usado para alterar o nome do botão e/ou qualquer outra característica do formulário.
- Mantive o projeto original que utiliza o Material design, cardView e recyclerView, MVVM, viewBinding,  listAdapter, LiveData e o room para persistência dos dados, buscando uma organização que almeja "Clean Architecture". 
- Melhorei a parte de tratamento de erros utilizando "try - catch" e "Thread - runOnUiThread" para as tarefas com os banco de dados e utilizei uma progressBar para demostrar visualmente esses processo mais  demorados. 
- Utilizei putExtra e getIntExtra para a comunicação entre a interface principal e a de adicionar cartão.
- Em cada cartão de visita há um menu "more (⁝)" com as opções de compartilhar, editar e apagar. É possível acrescentar facilmente novas funcionalidades nesse menu.
- Existe um mock :) para preencher dados na recyclerView rapidamente ao clicar no título "Cartões de visita" da página principal.

 

#### Possíveis ações futuras:

- Testes unitários, Testes não-funcionai etc . "fun onTest -> { Correções }"
- Implementar upgrade para o banco de dados.
- Personalização de cores e tipos de letras em tempo de execução. 
- Comandos "swipe" para inserir, editar, apagar e compartilhar.
- Barra de busca para encontrar os cartões por qualquer palavra (nome, sobrenome, empresa, telefone etc) 
- Ações para cada dado do cartão, como por exemplo ligar para o telefone e/ou enviar um e-mail.
- Acompanhamento do ciclo de vida.  
- Integração com os contatos do Google.
- Novos designs :😜
- Centralização de dados na nuvem para integração de equipes de trabalho. Ou descentralização de dados 🤔.
- Inserção de sistema push com firebase para informar alterações.


