# ClienteRest
Desktop: https://github.com/diegodls/ClienteDesk
Servidor: https://github.com/diegodls/ClienteRest
Android: https://github.com/diegodls/ClienteAppREST

Este aplicativo para Android foi desenvolvido como trabalho para faculdade
A finalidade dele é simular as funções REST juntamente com um programa para Windows e Android em uma rede local
Para utiliza-lo você deverá executar este aplicativo, que funcionará como servidor para comunicar-se com o banco de dados e receber os comando dos aplicativos para android e windows, fazendo assim um sistema REST.

Editar este aplicativo (IDE de preferência, utilizei o android NetBeans) e configurar a "URL" deste app para uma rede local (localhost) de sua rede.

Você terá que configurar todos os 3 projetos (ClienteAppREST[Android], ClienteRest[Servidor] e ClienteDesk[Desktop]),criar o banco de dados (postgresql -> Oracle utilizado, ou configure um de sua preferencia no ClienteRest, dados no arquivo "1 - BANCO" ).

NOTA - Biblioteca Maven e PostgreSQL necessárias, ao abrir o projeto, faça os downloads.
